package com.crazywah.window.officesystem

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button

class LoginActivity: Activity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val button = findViewById<Button>(R.id.login_btn)
        button.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                startActivity(Intent())
            }
        })
        val registerButton = findViewById<Button>(R.id.register_btn)
        registerButton.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                startActivity()
            }
        })
    }

}