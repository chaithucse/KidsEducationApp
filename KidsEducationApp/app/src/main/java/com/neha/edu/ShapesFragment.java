package com.neha.edu;

import android.content.Context;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.neha.edu.common.AppUtils;
import com.neha.edu.databinding.FragmentColorBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Locale;

/**
 * Created by Chaitanya on 1/18/2015.
 */
public class ShapesFragment extends Fragment {

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentColorBinding binding = FragmentColorBinding.inflate(getLayoutInflater(), container, false);
        View rootView = binding.getRoot();
        binding.recycleView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        binding.recycleView.setAdapter(new MyAdapter(getActivity(), AppUtils.getShapesDetails(), AppUtils.getShapes()));

        MobileAds.initialize(requireActivity(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        binding.adView.loadAd(adRequest);

        return rootView;
    }

    public static class MyAdapter extends RecyclerView.Adapter<MyAdapter.VersionViewHolder> implements TextToSpeech.OnInitListener {
        private final List<String> mDataSet;
        private final TextToSpeech mTtsEngine;
        List<Integer> mDrawablesIds;

        public MyAdapter(Context context, List<String> dataSet, List<Integer> drawables) {
            mDataSet = dataSet;
            mDrawablesIds = drawables;
            mTtsEngine = new TextToSpeech(context, this);
        }

        @Override
        public void onInit(int status) {
            if (status == TextToSpeech.SUCCESS) {
                mTtsEngine.setLanguage(Locale.US);
            }
        }

        @Override
        public void onBindViewHolder(VersionViewHolder viewHolder, final int position) {
            viewHolder.mLetterView.setImageResource(mDrawablesIds.get(position));
            viewHolder.mTextView.setText(mDataSet.get(position));
            viewHolder.mLetterView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mTtsEngine.speak(mDataSet.get(position), TextToSpeech.QUEUE_FLUSH, null);
                }
            });
        }

        @NotNull
        @Override
        public VersionViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType
        ) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vehicles_row, viewGroup, false);
            return new VersionViewHolder(view);
        }

        static class VersionViewHolder extends RecyclerView.ViewHolder {
            CardView cardItemLayout;
            ImageView mLetterView;
            TextView mTextView;

            public VersionViewHolder(View itemView) {
                super(itemView);
                cardItemLayout = (CardView) itemView.findViewById(R.id.cardlist_item);
                mLetterView = (ImageView) itemView.findViewById(R.id.button);
                mTextView = (TextView) itemView.findViewById(R.id.text);
            }
        }

        @Override
        public int getItemCount() {
            return mDataSet.size();
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }
    }

}
