package com.example.davidamador.testaac.features.apods

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.davidamador.testaac.R
import kotlinx.android.synthetic.main.main_fragment.*

class ApodListFragment : Fragment() {

    companion object {
        fun newInstance() = ApodListFragment()
    }

    private lateinit var apodListViewModel: ApodListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        apodListViewModel = ViewModelProviders.of(this).get(ApodListViewModel::class.java)
        apodListViewModel.init()

        apodListViewModel.apod?.observe(this, Observer{ apod ->
            // update UI
            Glide.with(this).load(apod?.url).into(imageViewApod)
            tv_title.text = apod?.title
            tv_description.text = apod?.explanation
        })

        apodListViewModel.apodlist?.observe(this, Observer { apodList ->
            val result = apodList?.map { it.title }

            Toast.makeText(context,result.toString(), Toast.LENGTH_LONG).show()
        })


    }

}
