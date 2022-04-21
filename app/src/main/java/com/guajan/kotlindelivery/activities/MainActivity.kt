package com.guajan.kotlindelivery.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.guajan.kotlindelivery.R
import com.guajan.kotlindelivery.models.ResponseHttp
import com.guajan.kotlindelivery.provider.UserProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    var imageViewGoToRegister: ImageView?=null
    var editTextEmail:EditText?=null
    var editTextPassword:EditText?=null
    var buttonLogin:Button?=null
    var usersProvider = UserProvider()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageViewGoToRegister = findViewById(R.id.imageview_go_to_register)
        editTextEmail = findViewById(R.id.edittext_email)
        editTextPassword = findViewById(R.id.edittext_password)
        buttonLogin = findViewById(R.id.btn_login)

        imageViewGoToRegister?.setOnClickListener{ goToRegister() }
        buttonLogin?.setOnClickListener { login()}
    }


    private fun login(){
        val email = editTextEmail?.text.toString()
        val password = editTextPassword?.text.toString()

        if(isValidForm(email, password)){

            usersProvider.login(email,password)?.enqueue(object: Callback<ResponseHttp>{
                override fun onResponse(
                    call: Call<ResponseHttp>,
                    response: Response<ResponseHttp>
                ) {
                    Log.d("MainActivity","Response: ${response.body()}")

                    if(response.body()?.success == true){
                        Toast.makeText(this@MainActivity, response.body()?.message, Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this@MainActivity, "Los datos no son correctos", Toast.LENGTH_LONG).show()
                    }

                }

                override fun onFailure(call: Call<ResponseHttp>, t: Throwable) {
                    Log.d("MainActivity","Response: ${t.message}")
                    Toast.makeText(this@MainActivity, "Hubo un error ${t.message}", Toast.LENGTH_LONG).show()

                }

            })


        }else{
            Toast.makeText(this, "No es valido", Toast.LENGTH_LONG).show()
        }


        //Log.d("MainActivity", "El password es: $password")
        //Log.d("MainActivity", "El email es: $email")
    }

    fun String.isEmailValid():Boolean{
        return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }
    private fun isValidForm(email:String, password:String):Boolean{
        if(email.isBlank()){
            return false
        }
        if(password.isBlank()){
            return false
        }
        if(!email.isEmailValid()){
            return false
        }
        return true

    }
    private fun goToRegister(){
        val i = Intent(this, RegisterActivity::class.java)
        startActivity(i)
    }
}