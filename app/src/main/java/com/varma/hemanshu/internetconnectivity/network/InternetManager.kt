package com.varma.hemanshu.internetconnectivity.network

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import androidx.lifecycle.LiveData

class InternetManager(
    context: Context,
    private val factory: InternetFactory = InternetFactory(),
    private val callback: InternetCallback = InternetCallback()
) {
    private val connectivityManager =
        context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager

    val result: LiveData<NetworkResult> get() = callback.networkResult


    fun registerCallback() {
        val request = factory.wifiRequest()
        connectivityManager.registerNetworkCallback(request, callback)
    }

    fun unregisterCallback() {
        connectivityManager.unregisterNetworkCallback(callback)
    }
}