package com.again

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.demo.dataclasses.Links
import com.demo.dataclasses.Next
import com.demo.dataclasses.Post1
import com.demo.foodwe.R
import com.demo.mainviewmodel
import com.demo.mainviewmodelfactory
import com.repository.repository
import kotlinx.android.synthetic.main.fragment_onclick.*
import kotlinx.android.synthetic.main.fragment_onclick.editTextTextMultiLine
import kotlinx.android.synthetic.main.fragment_onclick.progressBar2

class onclick1 : Fragment() {
    private val sharedviewmodel   : sharedviewmodel11 by activityViewModels()
    private  lateinit var viewModel: mainviewmodel
    private var m :Int = 0
    private val sharesearch2   : sharedsearch2 by activityViewModels()
    private var w :String = "chicken"
    val n= Next("","")
    val c  = Links(n)
    private var detail = Post1(c,-1,-1, emptyList(),-1)
    val repository= repository()
    val viewModelFactory = mainviewmodelfactory(repository)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =  ViewModelProvider(this, viewModelFactory).get(mainviewmodel::class.java)


        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        sharesearch2.way.observe(viewLifecycleOwner, { wow ->
            sharedviewmodel.way.observe(viewLifecycleOwner,{way ->
                setset(way)
                viewModel.getpost("public", "$wow", "3fc5053a", "60b582cb1535c3eca8cf99235c95f1a5\t")


            })
        } )

        viewModel.myresponce.observe(viewLifecycleOwner, Observer { responce1 ->
            detail = responce1.body()!!
            textView3.text = detail.hits[m].recipe.label
            editTextTextMultiLine.text = detail.hits[m].recipe.ingredientLines.toString()
            textView7.text  = detail.hits[m].recipe.totalNutrients.toString()
            //textView8.text  = "caloriew ${detail.hits[m].recipe.totalNutrients.toString()}"
            Glide.with(this).load(detail.hits[m].recipe.image.toString()).centerCrop().into(imageView2)
            progressBar2.visibility = View.GONE

        })
        return inflater.inflate(R.layout.fragment_onclick, container, false)

    }
fun setset (l:Int){
    m=l


}
fun setset1(k:String){
    w=k


}

}
