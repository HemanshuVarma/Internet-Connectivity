package com.varma.hemanshu.internetconnectivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.varma.hemanshu.internetconnectivity.network.InternetManager
import com.varma.hemanshu.internetconnectivity.network.NetworkResult
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //Lazy initialization
    private val internetManager by lazy { InternetManager(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG, "Creating activity")

        internetManager.result.observe(this, Observer<NetworkResult> { result ->
            with(status) {
                setText(result.messageResourceId)
                setTextColor(
                    ContextCompat.getColor(
                        this@MainActivity,
                        result.colorResourceId
                    )
                )
            }
        })
    }

    override fun onStart() {
        super.onStart()
        internetManager.registerCallback()
        Log.i(TAG, "Registering Internet Callback")
    }

    override fun onStop() {
        super.onStop()

        //Unregistering callback to save battery
        internetManager.unregisterCallback()
        Log.w(TAG, "Unregistering Internet Callback")
    }

    companion object {
        const val TAG = "MainActivity"
    }
}