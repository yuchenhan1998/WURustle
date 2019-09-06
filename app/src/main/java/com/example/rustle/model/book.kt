package com.example.rustle.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.util.*
import kotlin.collections.ArrayList

data class book(@SerializedName("bookname")var bookname:String=""){
    @SerializedName("price") var price=0
    @SerializedName("coursecode")var coursecode:ArrayList<String> =ArrayList()
    @SerializedName("isbn")var isbn=""
    @SerializedName("date")var available_time=""
    @SerializedName("email")var user_email=""
    @SerializedName("username")var username=""
    @SerializedName("imageref")var imageref=""
    @SerializedName("message")var message=""
    @SerializedName("sellerimg")var sellerimg=""



    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as book

        if (bookname != other.bookname) return false
        if (price != other.price) return false
        if (coursecode != other.coursecode) return false
        if (isbn != other.isbn) return false
        if (available_time != other.available_time) return false
        if (user_email != other.user_email) return false
        if (username != other.username) return false
        if (imageref != other.imageref) return false

        return true
    }



}