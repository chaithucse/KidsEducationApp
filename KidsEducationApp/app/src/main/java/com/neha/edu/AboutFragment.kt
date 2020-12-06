package com.neha.edu

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import com.neha.edu.common.AppUtils.Companion.getPackageVersion
import com.neha.edu.common.AppUtils.Companion.launchAlphabetsApp
import com.neha.edu.common.AppUtils.Companion.launchMultiApp
import com.neha.edu.common.AppUtils.Companion.launchPaintApp
import com.neha.edu.databinding.InfoLayoutBinding

class AboutFragment : Fragment(), View.OnClickListener {
    var interstitial: InterstitialAd? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: InfoLayoutBinding = InfoLayoutBinding.inflate(layoutInflater)
        binding.version.text = "v" + getPackageVersion(requireActivity())
        binding.card1.setOnClickListener(this)
        binding.card2.setOnClickListener(this)
        binding.card3.setOnClickListener(this)

        MobileAds.initialize(requireActivity()) { }

        interstitial = InterstitialAd(requireActivity())
        interstitial?.setAdUnitId("ca-app-pub-9732502342505919/6351806857")
        interstitial?.loadAd(AdRequest.Builder().build())

        return binding.root
    }

    @SuppressLint("NonConstantResourceId")
    override fun onClick(v: View) {
        when (v.id) {
            R.id.card_1 -> {
                launchAlphabetsApp(requireActivity())
            }
            R.id.card_2 -> {
                if (interstitial!!.isLoaded()) {
                    interstitial!!.show()
                }
                launchMultiApp(requireActivity())
            }
            R.id.card_3 -> {
                launchPaintApp(requireActivity())
            }
            else -> {
            }
        }
    }
}