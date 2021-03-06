package io.ipfs.kotlin.commands

import io.ipfs.kotlin.IpfsConnection
import io.ipfs.kotlin.model.PeerIdInfo

class PeerId(val ipfs: IpfsConnection) {

    private val peeridAdapter = ipfs.config.moshi.adapter(PeerIdInfo::class.java)

    fun peerId(): PeerIdInfo? {
        val response = ipfs.callCmd("config/Identity.PeerID")
	println("response $response")
	val adapter = peeridAdapter
	println("adapter $adapter")
        return response.use { peeridAdapter.fromJson(it.string()) }
    }

}
