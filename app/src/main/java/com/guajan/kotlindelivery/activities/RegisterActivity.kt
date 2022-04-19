package com.guajan.kotlindelivery.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.guajan.kotlindelivery.R

class RegisterActivity : AppCompatActivity() {
    var imageViewGotoLogin: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        imageViewGotoLogin = findViewById(R.id.imageview_go_to_login)

        imageViewGotoLogin?.setOnClickListener{ goToLogin()}
    }

    private fun goToLogin(){
        val i = Intent(this,MainActivity::class.java)
        startActivity(i)
    }

}