package com.example.davidamador.testaac.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.davidamador.testaac.R
import kotlinx.android.synthetic.main.main_fragment.*

class ApodFragment : Fragment() {

    companion object {
        fun newInstance() = ApodFragment()
    }

    private lateinit var viewModel: ApodViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ApodViewModel::class.java)
        viewModel.init()

        viewModel.apod?.observe(this, Observer{ apod ->
            // update UI
            Glide.with(this).load(apod?.url).into(imageViewApod)
            tv_title.text = apod?.title
            tv_description.text = apod?.explanation
        })


    }

}
