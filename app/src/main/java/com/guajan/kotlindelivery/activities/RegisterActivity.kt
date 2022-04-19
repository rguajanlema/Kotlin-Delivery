package com.guajan.kotlindelivery.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
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

    private fun isValidForm(name:String, lastname:String, email:String, phone:String, password:String, repeatpassword:String):Boolean{
        if(name.isBlank() || lastname.isBlank() || phone.isBlank() || password.isBlank() || repeatpassword.isBlank()){
            Toast.makeText(this, "Todos los campos son boligatorios", Toast.LENGTH_LONG).show()
            return false
        }
        if(!email.isEmailValid()){
            Toast.makeText(this, "El email no es valido", Toast.LENGTH_LONG).show()
            return false
        }
        if(password != repeatpassword){
            Toast.makeText(this, "Los passwords no son iguales", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }

    private fun register(){
        val name = edittextName?.text.toString()
        val lastname = edittextLastName?.text.toString()
        val email = edittextEmail?.text.toString()
        val phone= edittextPhone?.text.toString()
        val password = edittextPassword?.text.toString()
        val repeatpassword = edittextRepeatPassword?.text.toString()

        if(isValidForm(name=name, lastname=lastname, email = email, phone=phone, password=password, repeatpassword=repeatpassword)){
            Toast.makeText(this,"El formulario es valido",Toast.LENGTH_LONG).show()
        }

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
    fun String.isEmailValid():Boolean{
        return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }
}