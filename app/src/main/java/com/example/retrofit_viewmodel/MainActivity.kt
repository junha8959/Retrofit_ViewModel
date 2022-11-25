package com.example.retrofit_viewmodel

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit_viewmodel.app.MyApplication

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    lateinit var context : Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = MyApplication.context()

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.getPost1()
        viewModel.getPost2(2)
        viewModel.liveText.observe(this, Observer {
            Log.d("MAIN", it)
            Log.e("MAIN", "MAIN $it")
        })


    }
}