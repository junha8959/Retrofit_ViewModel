package com.example.retrofit_viewmodel

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofit_viewmodel.app.MyApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

open class BaseActivity : AppCompatActivity(), CoroutineScope {
    lateinit var sPref: SharedPreferences
    lateinit var context: Context
    private lateinit var job: Job

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sPref = getSharedPreferences("Blossom", MODE_PRIVATE)
        context = MyApplication.context()
        job = Job()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

    private fun toast(string: String?) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
    }

    private fun showKeyboard(view: View) {
        //showToast("show Keyboard");
        //LogUtil.i("show Keyboard");
        requestFocus(view)
        Handler().postDelayed({
            val inputMethodManager =
                getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.toggleSoftInput(
                InputMethodManager.SHOW_FORCED,
                InputMethodManager.HIDE_IMPLICIT_ONLY
            )
        }, 50)
    }

    private fun requestFocus(view: View) {
        view.clearFocus()
        view.isFocusableInTouchMode = true
        view.requestFocus()
    }
}
