package com.neha.edu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.neha.edu.common.AppUtils;
import com.neha.edu.databinding.FragmentMainBinding;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Chaitanya on 1/18/2015.
 */
public class AnimalsFragment extends Fragment {

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentMainBinding binding = FragmentMainBinding.inflate(getLayoutInflater(), container, false);
        View rootView = binding.getRoot();

        GridAdapter adapter = new GridAdapter(requireActivity(), AppUtils.getAnimalImages(), AppUtils.getAnimalNames());
        binding.gridView.setAdapter(adapter);

        MobileAds.initialize(requireActivity(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        binding.adView.loadAd(adRequest);

        return rootView;
    }
}
