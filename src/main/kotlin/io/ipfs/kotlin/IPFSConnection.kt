package io.ipfs.kotlin

import com.squareup.moshi.JsonAdapter
import io.ipfs.kotlin.model.MessageWithCode

import okhttp3.Request
import okhttp3.ResponseBody

// EA : 18 Feb 2020 : body()!! => body!!

open class IPFSConnection(val config: IPFSConfiguration) {

    var lastError: MessageWithCode? = null

    private val errorAdapter: JsonAdapter<MessageWithCode> by lazy {
        config.moshi.adapter(MessageWithCode::class.java)
    }

    fun callCmd(cmd: String): ResponseBody {
        val request = Request.Builder()
                .url(config.base_url + cmd)
                .build()

	val result = config.okHttpClient.newCall(request).execute().body!! 
        return result
    }

    fun setErrorByJSON(jsonString: String) {
        lastError = errorAdapter.fromJson(jsonString)
    }
}
