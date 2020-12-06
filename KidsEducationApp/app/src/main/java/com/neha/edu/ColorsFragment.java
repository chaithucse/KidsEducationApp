package com.neha.edu;

import android.content.Context;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.button.MaterialButton;
import com.neha.edu.common.AppUtils;
import com.neha.edu.databinding.FragmentColorBinding;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Created by Chaitanya on 1/18/2015.
 */
public class ColorsFragment extends Fragment {

    InterstitialAd interstitial;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentColorBinding binding = FragmentColorBinding.inflate(getLayoutInflater(), container, false);
        View rootView = binding.getRoot();

        binding.recycleView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        binding.recycleView.setAdapter(new MyAdapter(getActivity(), AppUtils.getColorDetails(), AppUtils.getColors()));

        MobileAds.initialize(requireActivity(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        binding.adView.loadAd(new AdRequest.Builder().build());
        interstitial = new InterstitialAd(rootView.getContext());
        interstitial.setAdUnitId("ca-app-pub-9732502342505919/9305273254");
        interstitial.loadAd(new AdRequest.Builder().build());
        interstitial.show();

        return rootView;
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements TextToSpeech.OnInitListener {
        private final TextToSpeech mTtsEngine;
        Context context;
        List<String> mData;
        List<Integer> mColors;

        public MyAdapter(Context context, List<String> data, List<Integer> colors) {
            this.context = context;
            mTtsEngine = new TextToSpeech(context, this);
            mData = data;
            mColors = colors;
        }

        @Override
        public void onInit(int status) {
            if (status == TextToSpeech.SUCCESS) {
                mTtsEngine.setLanguage(Locale.US);
            }
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private final TextView textView;
            private final MaterialButton button;

            public ViewHolder(View v) {
                super(v);
                textView = (TextView) v.findViewById(R.id.text);
                button = (MaterialButton) v.findViewById(R.id.button);

            }
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, final int position) {
            viewHolder.textView.setText(mData.get(position));
            viewHolder.button.setBackgroundColor(getResources().getColor(mColors.get(position), null));
            viewHolder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mTtsEngine.speak(mData.get(position), TextToSpeech.QUEUE_FLUSH, null);
                }
            });

        }

        @NotNull
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View v = LayoutInflater.
                    from(viewGroup.getContext()).
                    inflate(R.layout.colors_row, viewGroup, false);
            return new ViewHolder(v);
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        public MyAdapter(Context context) {
            this.context = context;
            mTtsEngine = new TextToSpeech(context, this);
        }

        @Override
        public long getItemId(int i) {
            return mColors.get(i);
        }
    }
}
