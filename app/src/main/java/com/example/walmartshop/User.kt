package com.example.walmartshop

import java.io.Serializable

data class User(val userName:String, val password:String, val firstName:String,val lastName:String):
    Serializable {


}
