package com.example.walmartshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_account_registration.*
import kotlinx.android.synthetic.main.activity_main.*

class AccountRegistration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_registration)
        createAccount.setOnClickListener {
            val fname=firstN.text.toString()
            val lname=lastN.text.toString()
            val email=emailAdd.text.toString()
            val pass=passwd.text.toString()

            if(fname.isNotEmpty() && lname.isNotEmpty() && email.isNotEmpty() && pass.isNotEmpty()){
                var tempUser=User(email, pass, fname,lname)
                intent.putExtra("newUser",tempUser)
                setResult(RESULT_OK,intent)
                finish()
            }
            else Toast.makeText(applicationContext,"Please input correct information",Toast.LENGTH_SHORT).show()
        }
    }
}
