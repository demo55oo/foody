package com.demo.foodwe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.demo.onclick
import com.demo.secondfragment
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_homeactivity.*

class homeactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homeactivity)

        MobileAds.initialize(this) {}
        val  mAdView = bannerAdView
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
         val frstfrgment = BlankFragment()
        val secondfragment = secondfragment()
        val thirdfrmn = thirdfrgment()
        val frthfgrmt = fourthfragment()
        val fifthfrgm = fifthfrgmnt()
        val onclickfrgmnt = onclick()
        makecurrentfragment(frstfrgment)


        val bottom = findViewById<BottomNavigationView>(R.id.adas)
        bottom.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.f1 ->{makecurrentfragment(frstfrgment)

                }
                R.id.s2 ->{makecurrentfragment(secondfragment)

                }
                R.id.t3 ->{makecurrentfragment(thirdfrmn)


                }
                R.id.f4 ->{makecurrentfragment(frthfgrmt)

                }
            }
           true
        }

    }

     fun makecurrentfragment(fargment:Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frgmtmanaga,fargment)
            commit()
        }

    }


}
