package com.example.davidamador.testaac

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.davidamador.testaac.ui.main.ApodFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ApodFragment.newInstance())
                    .commitNow()
        }
    }

}
