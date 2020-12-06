package com.neha.edu;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textview.MaterialTextView;
import com.neha.edu.common.AppUtils;
import com.neha.edu.databinding.FragmentLettersNumberBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Locale;

/**
 * Created by Chaitanya on 1/18/2015.
 */
public class NumbersFragment extends Fragment {

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentLettersNumberBinding binding = FragmentLettersNumberBinding.inflate(getLayoutInflater(), container, false);
        View rootView = binding.getRoot();

        binding.recycleView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        binding.recycleView.setAdapter(new CustomAdapter(getActivity(), AppUtils.getNumbers(1)));
        binding.chip1.setChecked(true);

        binding.chipGroup.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(ChipGroup group, int checkedId) {
                if (checkedId == R.id.chip_1) {
                    binding.recycleView.setAdapter(new CustomAdapter(getActivity(), AppUtils.getNumbers(1)));
                } else {
                    binding.recycleView.setAdapter(new CustomAdapter(getActivity(), AppUtils.getNumbers(2)));
                }
            }
        });
        MobileAds.initialize(requireActivity(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        binding.adView.loadAd(new AdRequest.Builder().build());
        return rootView;
    }

    public static class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.VersionViewHolder> implements TextToSpeech.OnInitListener {
        Context context;
        Typeface mLocale;
        private final TextToSpeech mTtsEngine;
        List<Integer> mNewList;
        private final ColorGenerator mColorGenerator = ColorGenerator.MATERIAL;

        public CustomAdapter(Context context, List<Integer> list) {
            this.context = context;
            mTtsEngine = new TextToSpeech(context, this);
            mNewList = list;
        }

        @NotNull
        @Override
        public VersionViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.letters_row, viewGroup, false);
            return new VersionViewHolder(view);
        }

        @Override
        public void onBindViewHolder(VersionViewHolder versionViewHolder, final int i) {
            versionViewHolder.mLetterView.setTypeface(mLocale);
            versionViewHolder.mLetterView.setText(mNewList.get(i).toString());
            versionViewHolder.mLetterView.setTextColor(mColorGenerator.getRandomColor());
            versionViewHolder.mLetterView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mTtsEngine.speak(mNewList.get(i).toString(), TextToSpeech.QUEUE_FLUSH, null);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mNewList.size();
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public void onInit(int status) {
            if (status == TextToSpeech.SUCCESS) {
                mTtsEngine.setLanguage(Locale.US);
            }
        }

        static class VersionViewHolder extends RecyclerView.ViewHolder {
            CardView cardItemLayout;
            MaterialTextView mLetterView;

            public VersionViewHolder(View itemView) {
                super(itemView);
                cardItemLayout = (CardView) itemView.findViewById(R.id.cardlist_item);
                mLetterView = (MaterialTextView) itemView.findViewById(R.id.text);
            }
        }
    }
}
