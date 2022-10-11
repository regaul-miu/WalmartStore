package com.example.walmartshop

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var userList = arrayListOf<User>()

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var resultContracts = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result->    if(result.resultCode == Activity.RESULT_OK){
            var dataIntent=result.data?.getSerializableExtra("user")
            var user:User=dataIntent as User
           userList.add(user)
        }
            }

        var user1=User("rafi@miu.edu","123456","rafi","hasan")
        var user2=User("shafi@gmail.com","123456","shafi","Karim")
        var user3=User("doly@yahoo.com","123456","doly","taz")
        var user4=User("poly@gmail.com","123456","poly","begum")
        var user5=User("soma@gmail.com","123456","soma","khanum")

        userList.add(user1)
        userList.add(user2)
        userList.add(user3)
        userList.add(user4)
        userList.add(user5)
        signBtn.setOnClickListener {
            val email=emailInpput.text.toString()
            val password=passInput.text.toString()

            for (i in userList){
                if (email==i.userName && password==i.password){
                    var intent = Intent(this,Shoping_Activity::class.java)
                    intent.putExtra("1",email)
                    startActivity(intent);
                    Toast.makeText(applicationContext,"Account Created Successfully",Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

            }
            Toast.makeText(applicationContext,"User Not found",Toast.LENGTH_SHORT).show()
        }
        button2.setOnClickListener(){
            var intent_create=Intent(this,AccountRegistration::class.java)
            resultContracts.launch(intent_create)
        }
        forgotView.setOnClickListener(){
            var email=emailInpput.text.toString()
            for (i in userList){
                if(email==i.userName){
                    var setIntent=Intent(Intent.ACTION_SENDTO, Uri.parse("mailto"))
                    setIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
                    setIntent.putExtra(Intent.EXTRA_SUBJECT,"Recovered Password")
                    setIntent.putExtra(Intent.EXTRA_TEXT,"Password is: ${i.password}")
                    startActivity(Intent.createChooser(setIntent,"Sending...."))
                    return@setOnClickListener
                }
            }
            Toast.makeText(applicationContext,"User not found",Toast.LENGTH_SHORT).show()
        }
    }

}