package com.crazywah.window.officesystem

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.crazywah.window.officesystem.network.BaiduService
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity: Activity(){

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://run.mocky.io")
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    private val baiduService: BaiduService by lazy { retrofit.create(BaiduService::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val button = findViewById<View>(R.id.login_btn)
        button.setOnClickListener { }
        val registerButton = findViewById<View>(R.id.register_btn)
        registerButton.setOnClickListener {
            val d = baiduService.getBaiduMainPage()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d("ofh", " name = ${it.name}")
                },{
                    Log.e("ofh", "$it")
                })
        }
    }

}