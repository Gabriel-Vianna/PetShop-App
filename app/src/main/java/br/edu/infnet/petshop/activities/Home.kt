package br.edu.infnet.petshop.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import br.edu.infnet.petshop.R
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class Home : AppCompatActivity() {
    private var mInterstitialAd: InterstitialAd? = null
    private final var TAG = "HomeActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        MobileAds.initialize(this) {}

        var adRequest = AdRequest.Builder().build()

        InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712", adRequest, object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                Log.d(TAG, adError?.message)
                mInterstitialAd = null
            }

            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                Log.d(TAG, "Ad was loaded.")
                mInterstitialAd = interstitialAd
            }
        })

        mInterstitialAd?.fullScreenContentCallback = object: FullScreenContentCallback() {
            override fun onAdDismissedFullScreenContent() {
                Log.d(TAG, "Ad was dismissed.")
            }

            override fun onAdFailedToShowFullScreenContent(adError: AdError?) {
                Log.d(TAG, "Ad failed to show.")
            }

            override fun onAdShowedFullScreenContent() {
                Log.d(TAG, "Ad showed fullscreen content.")
                mInterstitialAd = null
            }

        }

        var btnServices = findViewById<Button>(R.id.listaServicos)
        var btnAccount = findViewById<Button>(R.id.minhaConta)
        var btnStore = findViewById<Button>(R.id.lojaInfo)

        btnServices.setOnClickListener{
            var serviceActivity = Intent(this, ServicesActivity::class.java)
            startActivity(serviceActivity)
        }

        btnAccount.setOnClickListener{
            var accountActivity = Intent(this, AccountActivity::class.java)
            startActivity(accountActivity)
        }
    }

    fun startAdSense(view: View) {
        if (mInterstitialAd != null) {
            mInterstitialAd?.show(this)
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.")
        }
    }
    private fun alert(stringAlert: String) {
        Toast.makeText(this, stringAlert, Toast.LENGTH_LONG).show()
    }
}