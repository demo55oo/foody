package com.demo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.again1.madder
import com.again1.onclick4
import com.again1.sharedsearch4
import com.again1.sharedviewmodel00
import com.demo.foodwe.R
import com.demo.foodwe.homeactivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import com.repository.repository
import kotlinx.android.synthetic.main.fragment_secondfragment.*


class secondfragment : Fragment() {
    private lateinit var mInterstitialAd: InterstitialAd
    private final var TAG = "homeacticity"
    private  lateinit var viewModel: mainviewmodel
    private val myadapter by lazy { madder() }
    private val sharedviewmodel   : sharedviewmodel00 by activityViewModels()
    private val sharedviewmodel2   : sharedsearch4 by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        progressBar4?.visibility = View.GONE

        val repository= repository()
        val viewModelFactory = mainviewmodelfactory(repository)
        viewModel =  ViewModelProvider(this, viewModelFactory).get(mainviewmodel::class.java)

        myadapter.setonclicklistener(object : madder.onitemclicklistener {
            override fun onitemclick(position: Int) {
                sharedviewmodel.savepos(position)
                Log.d("ff",sharedviewmodel.way.toString())
                (activity as homeactivity?)?.makecurrentfragment(onclick4())

            }
        })

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_secondfragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                if (mInterstitialAd.isLoaded) {
                    mInterstitialAd.show()
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.")
                }
                sharedviewmodel2.savepos1(p0.toString())
                viewModel.getpost("public", p0.toString(), "3fc5053a", "60b582cb1535c3eca8cf99235c95f1a5\t")
                progressBar4.visibility = View.VISIBLE

                viewModel.myresponce.observe(viewLifecycleOwner, Observer { responce ->

                    if (responce.isSuccessful) {


                        responce.body()?.let { myadapter.setupdata(it)}

                        Log.d("look", "${responce.body()}  ${responce.code()}")
                        progressBar4.visibility = View.GONE

                    } else {
                        Log.d("err", "ERROR cause $responce ${responce.code()} ")
                    }


                })
                cateigerios1.adapter = myadapter
                cateigerios1.layoutManager = LinearLayoutManager(context)

                return false
            }
            override fun onQueryTextChange(p0: String?): Boolean {
                //Start filtering the list as user start entering the characters
                return false
            }
        })
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        MobileAds.initialize(activity)

        mInterstitialAd = InterstitialAd(activity)
        mInterstitialAd.adUnitId = "ca-app-pub-2341497470012319/3296271315"
        mInterstitialAd.loadAd(AdRequest.Builder().build())

        super.onActivityCreated(savedInstanceState)
    }



}
