package com.example.retrofit_viewmodel

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit_viewmodel.app.MyApplication
import com.example.retrofit_viewmodel.network.Repository
import org.bumblebeecrew.blossom.Util.CommonUtil
import org.bumblebeecrew.blossom.app.MySharedPreferencesManager
import org.bumblebeecrew.blossom.network.request.RequestLogin

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var viewModelFactory: MainViewModelFactory
    lateinit var context : Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = MyApplication.context()

        viewModelFactory = MainViewModelFactory(Repository())

        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        MySharedPreferencesManager.putString(MyApplication.context(), "fcmToken", "fkMUktPbVkIkhPVcD18J19:APA91bGcaROgzkz8I8EJbG7DbiK6j-zjm-wYqxDjYgbpdtae-vf3xXYAcAwsQf25ZfNlf1LFGRgLYrvnnsVV3Buc3xjITs0hv2TCq2w-Y1nN4eGcrYArpkcIECBrlSArVKiNOh8gJ2F-")

        viewModel.getPost1()
        val requestLogin = RequestLogin("dial8959", CommonUtil().getSha256("ui159159@"), "original", "57470dea5c5e020016f16ce45a3850a48013424a93e82c12b5f1cb4f6ecace0e")
        viewModel.getPost2(requestLogin)

        viewModel.liveText.observe(this, Observer {
            Log.d("MAIN", it)
            Log.e("MAIN", "MAIN $it")
        })


    }
}