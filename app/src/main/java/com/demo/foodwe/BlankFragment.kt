package com.demo.foodwe

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
import com.repository.repository
import kotlinx.android.synthetic.main.fragment_blank.*

class BlankFragment : Fragment() {
    private val sharedviewmodel   : sharedviewmodel by activityViewModels()
    private val sharedviewmodel1  : sharedviewmodel1 by activityViewModels()
    private  lateinit var viewModel: mainviewmodel
    private val myadapter by lazy { myadapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
         val myadapter by lazy { myadapter() }


        super.onCreate(savedInstanceState)
        val repository= repository()
        val viewModelFactory = mainviewmodelfactory(repository)
        viewModel =  ViewModelProvider(this, viewModelFactory).get(mainviewmodel::class.java)
        viewModel.getpost("public", "meat", "3fc5053a", "60b582cb1535c3eca8cf99235c95f1a5\t")


        myadapter.setonclicklistener(object : myadapter.onitemclicklistener {
            override fun onitemclick(position: Int) {
                sharedviewmodel.savepos(position)
                Log.d("ff",sharedviewmodel.way.toString())
                      onclick()
                (activity as homeactivity?)?.makecurrentfragment(onclick())
            }
        })

     }
override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
): View? {
    // Inflate the layout for this fragment
   // return inflater.inflate(R.layout.fragment_blank, container, false)

    val view: View = inflater!!.inflate(R.layout.fragment_blank, container, false)

    return view

}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.myresponce.observe(viewLifecycleOwner, Observer { responce ->
            if (responce.isSuccessful) {
                responce.body().let {
                    if (it != null) {
                        progressBar.visibility = View.GONE
                        sharedviewmodel1.setdetails(it)
                    }
                }
                responce.body()?.let { myadapter.setupdata(it)}
                Log.d("look", "${responce.body()}  ${responce.code()}")

            } else {
                Log.d("err", "ERROR cause $responce ${responce.code()} ")
            }


        })
        recycler.adapter = myadapter
        recycler.layoutManager = LinearLayoutManager(context)
        super.onViewCreated(view, savedInstanceState)
    }}
   /* override fun onActivityCreated(savedInstanceState: Bundle?) {
        recycler.adapter = myadapter
        recycler.layoutManager = LinearLayoutManager(context)
        super.onActivityCreated(savedInstanceState)




    }



}



*/