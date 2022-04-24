package com.demo.foodwe

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.again.BlankFragment1
import com.again.sharedsearch
import com.demo.adapter.arrayadapter1
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.fragment_thirdfrgment.*


class thirdfrgment : Fragment() {
    private val sharesearch : sharedsearch by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_thirdfrgment, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {

        MobileAds.initialize(this.activity) {}
        val adRequest = AdRequest.Builder().build()
        bannerAdView1.loadAd(adRequest)

        val description = arrayOf<String>(
            "Meat",
            "Chicken",
            "Pasta",
            "Fish",
            "Vegetrian")
        val imageId = arrayOf<Int>(
                R.drawable.kk,R.drawable.yy,R.drawable.opt,
                R.drawable.uutt,R.drawable.opt)

        val myListAdapter = arrayadapter1(context as Activity,description,imageId)
      cateigerios.adapter = myListAdapter
        cateigerios.setOnItemClickListener(){adapterView, view, position, id ->
        val itemAtPos = adapterView.getItemAtPosition(position)
        val itemIdAtPos = adapterView.getItemIdAtPosition(position)
            when(position){
                0 -> {
                    sharesearch.savepos1("meat")
                    (activity as homeactivity?)?.makecurrentfragment(BlankFragment1())

                }
                1 ->{sharesearch.savepos1("chicken")

                    (activity as homeactivity?)?.makecurrentfragment(BlankFragment1()) }
                2 ->{
                    sharesearch.savepos1("pasta")

                    (activity as homeactivity?)?.makecurrentfragment(BlankFragment1())}


                3 ->{sharesearch.savepos1("fish")

                    (activity as homeactivity?)?.makecurrentfragment(BlankFragment1())}

                4 ->{ sharesearch.savepos1("vegetarian")

                    (activity as homeactivity?)?.makecurrentfragment(BlankFragment1())}


            }
               true}
        super.onActivityCreated(savedInstanceState)


    }

    fun setset (l:String){

    }    }
