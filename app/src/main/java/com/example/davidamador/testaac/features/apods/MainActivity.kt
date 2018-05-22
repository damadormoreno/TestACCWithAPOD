package com.example.davidamador.testaac.features.apods

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.davidamador.testaac.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ApodListFragment.newInstance())
                    .commitNow()
        }
    }

}
