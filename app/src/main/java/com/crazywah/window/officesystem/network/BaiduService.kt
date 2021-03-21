package com.crazywah.window.officesystem.network

import com.google.gson.annotations.SerializedName
import io.reactivex.Single
import retrofit2.http.GET

interface BaiduService {

    @GET("/v3/8c70cd83-879a-4602-8061-87016951e4ec")
    fun getBaiduMainPage(): Single<Data>

}

data class Data(
    @SerializedName("name")
    val name: String
)