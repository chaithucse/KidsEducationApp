package com.neha.edu

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import com.google.android.material.button.MaterialButton

class HomeFragment : Fragment(R.layout.fragment_home) {
    var interstitial: InterstitialAd? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        MobileAds.initialize(requireActivity()) { }
        val adRequest = AdRequest.Builder().build()
        view.findViewById<AdView>(R.id.adView).loadAd(adRequest)

        interstitial = InterstitialAd(requireActivity())
        interstitial?.setAdUnitId("ca-app-pub-9732502342505919/9444874057")
        interstitial?.loadAd(AdRequest.Builder().build())

        view.findViewById<MaterialButton>(R.id.alphabets).setOnClickListener {
            view.findNavController().navigate(R.id.button_letters)
        }

        view.findViewById<MaterialButton>(R.id.numbers).setOnClickListener {
            view.findNavController().navigate(R.id.button_numbers)
        }

        view.findViewById<MaterialButton>(R.id.shapes).setOnClickListener {
            view.findNavController().navigate(R.id.button_shapes)
        }

        view.findViewById<MaterialButton>(R.id.colors).setOnClickListener {
            view.findNavController().navigate(R.id.button_colors)
        }

        view.findViewById<MaterialButton>(R.id.body).setOnClickListener {
            view.findNavController().navigate(R.id.button_body)
        }

        view.findViewById<MaterialButton>(R.id.veg).setOnClickListener {
            view.findNavController().navigate(R.id.button_vege)
        }

        view.findViewById<MaterialButton>(R.id.fruits).setOnClickListener {
            view.findNavController().navigate(R.id.button_fruits)
        }

        view.findViewById<MaterialButton>(R.id.animals).setOnClickListener {
            if (interstitial!!.isLoaded()) {
                interstitial!!.show()
            }
            view.findNavController().navigate(R.id.button_animals)
        }
    }
}