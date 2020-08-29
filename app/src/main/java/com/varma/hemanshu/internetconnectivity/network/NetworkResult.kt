package com.varma.hemanshu.internetconnectivity.network

import com.varma.hemanshu.internetconnectivity.R

enum class NetworkResult(val colorResourceId: Int, val messageResourceId: Int) {

    CONNECTED(R.color.colorConnected, R.string.messageConnected),
    DISCONNECTING(R.color.colorDisconnecting, R.string.messageDisconnecting),
    DISCONNECTED(R.color.colorDisconnected, R.string.messageDisconnected)
}