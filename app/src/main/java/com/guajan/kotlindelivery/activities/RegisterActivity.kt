package com.guajan.kotlindelivery.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.guajan.kotlindelivery.R

class RegisterActivity : AppCompatActivity() {
    val TAG = "RegisterActivity"

    var imageViewGotoLogin: ImageView? = null
    var edittextName: EditText?=null
    var edittextLastName:EditText?=null
    var edittextEmail:EditText?=null
    var edittextPhone:EditText?=null
    var edittextPassword: EditText?=null
    var edittextRepeatPassword: EditText?=null
    var btnRegister:Button?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        imageViewGotoLogin = findViewById(R.id.imageview_go_to_login)
        edittextName = findViewById(R.id.edittext_name)
        edittextLastName = findViewById(R.id.edittext_last_name)
        edittextEmail = findViewById(R.id.edittext_email)
        edittextPhone = findViewById(R.id.edittext_phone)
        edittextPassword = findViewById(R.id.edittext_password)
        edittextRepeatPassword = findViewById(R.id.edittext_repeat_password)

        btnRegister = findViewById(R.id.btn_register)


        imageViewGotoLogin?.setOnClickListener{ goToLogin()}
        btnRegister?.setOnClickListener{ register()}
    }

    private fun register(){
        val name = edittextName?.text.toString()
        val lastname = edittextLastName?.text.toString()
        val email = edittextEmail?.text.toString()
        val phone= edittextPhone?.text.toString()
        val password = edittextPassword?.text.toString()
        val repeatpassword = edittextRepeatPassword?.text.toString()

        Log.d(TAG,"El nombre es: $name")
        Log.d(TAG,"El apellido es: $lastname")
        Log.d(TAG,"El email es: $email")
        Log.d(TAG,"El phone es: $phone")
        Log.d(TAG,"El password es: $password")
        Log.d(TAG,"El repeat password es: $repeatpassword")

    }
    private fun goToLogin(){
        val i = Intent(this,MainActivity::class.java)
        startActivity(i)
    }

}