package com.varma.hemanshu.internetconnectivity.network

import android.net.ConnectivityManager
import android.net.Network
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.varma.hemanshu.internetconnectivity.network.NetworkResult.*

class InternetCallback : ConnectivityManager.NetworkCallback() {

    val networkResult = MutableLiveData<NetworkResult>()

    override fun onAvailable(network: Network) {
        super.onAvailable(network)
        networkResult.postValue(CONNECTED)
        Log.i(TAG, "Connection Available")
    }

    override fun onLosing(network: Network, maxMsToLive: Int) {
        super.onLosing(network, maxMsToLive)
        networkResult.postValue(DISCONNECTING)
        Log.i(TAG, "Connection Losing")
    }

    override fun onLost(network: Network) {
        super.onLost(network)
        networkResult.postValue(DISCONNECTED)
        Log.i(TAG, "Connection Lost")
    }

    companion object {
        const val TAG = "InternetCallback"
    }
}