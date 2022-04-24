package com.again

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.demo.*
import com.demo.adapter.myadapter
import com.demo.foodwe.R
import com.demo.foodwe.homeactivity
import com.repository.repository
import kotlinx.android.synthetic.main.fragment1_blank.*

class BlankFragment1 : Fragment() {
    private val sharedviewmodel   : sharedviewmodel11 by activityViewModels()
    private val sharesearch   : sharedsearch by activityViewModels()
    private val sharesearch2   : sharedsearch2 by activityViewModels()
    private  lateinit var viewModel: mainviewmodel
    private val myadapter1 by lazy { myadapter1() }
     private var search = "chicken"
    override fun onCreate(savedInstanceState: Bundle?) {
         val myadapter by lazy { myadapter() }

        super.onCreate(savedInstanceState)



        myadapter1.setonclicklistener(object : myadapter1.onitemclicklistener {
            override fun onitemclick(position: Int) {
                sharedviewmodel.savepos(position)
                Log.d("ff",sharedviewmodel.way.toString())
                (activity as homeactivity?)?.makecurrentfragment(onclick1())
            }
        })

     }
override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
): View? {
    // Inflate the layout for this fragment
   // return inflater.inflate(R.layout.fragment_blank, container, false)
    val view: View = inflater!!.inflate(R.layout.fragment1_blank, container, false)

    return view

}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        sharesearch.way.observe(viewLifecycleOwner,{way ->
            setset(way)
            sharesearch2.savepos1(way)
            val repository= repository()
            val viewModelFactory = mainviewmodelfactory(repository)
            viewModel =  ViewModelProvider(this, viewModelFactory).get(mainviewmodel::class.java)
            viewModel.getpost("public", search, "3fc5053a", "60b582cb1535c3eca8cf99235c95f1a5\t")
            viewModel.myresponce.observe(viewLifecycleOwner, Observer { responce ->
                if (responce.isSuccessful) {


                    responce.body()?.let { myadapter1.setupdata(it)}

                    Log.d("look", "${responce.body()}  ${responce.code()}")
                    progressBar1.visibility = View.GONE

                } else {
                    Log.d("err", "ERROR cause $responce ${responce.code()} ")
                }


            })
        })

        recycler1.adapter = myadapter1
        recycler1.layoutManager = LinearLayoutManager(context)
        super.onViewCreated(view, savedInstanceState)
    }
 fun setset (l: String){
        search=l

    }
}

   /* override fun onActivityCreated(savedInstanceState: Bundle?) {
        recycler.adapter = myadapter
        recycler.layoutManager = LinearLayoutManager(context)
        super.onActivityCreated(savedInstanceState)




    }



}



*/