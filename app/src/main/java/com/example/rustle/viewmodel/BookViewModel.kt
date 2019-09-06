package com.example.rustle.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.rustle.model.book
import com.example.rustle.model.course
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.FirebaseFirestore

class BookViewModel(application: Application): AndroidViewModel(application) {
    private val bookList_: MutableLiveData<ArrayList<book>> = MutableLiveData()
    fun getTopbooklist():MutableLiveData<ArrayList<book>>{
        if(bookList_.value==null){
            val db = FirebaseFirestore.getInstance().collection("book")
            db
                .orderBy("price")
                .get()
                .addOnSuccessListener {
                    val booklist: ArrayList<book> = ArrayList()
                    for (document in it) {

                        var book = book(document.get("bookname") as String)
//                    Log.e("document",document.toString())
                        if(document.get("price") is Double){
                            book.price = (document.get("price") as Double).toInt()
                        }
                        else if(document.get("price") is Long){
                            book.price = (document.get("price") as Long).toInt()
                        }

                        if(document.get("coursecode") is ArrayList<*>){
                            book.coursecode = document.get("coursecode") as ArrayList<String>
                        }

                        book.isbn = document.get("isbn") as String
//                        book.available_time = document.get("date") as String
                        book.user_email = document.get("email") as String
                        book.username = document.get("username") as String
                        book.imageref = document.get("imageref") as String
                        if(document.get("sellerimg")!=null){
                            book.sellerimg=document.get("sellerimg") as String
                        }
                        if(document.get("message")!=null){
                            book.message=document.get("message") as String
                        }
                        booklist.add(book)
                    }
                    bookList_.value = booklist
                }
        }

        return bookList_
    }
    fun getSearchbooklist(coursecode:String):MutableLiveData<ArrayList<book>>{
        if(bookList_.value==null){
            val db = FirebaseFirestore.getInstance().collection("book")
            db
                .whereArrayContains("coursecode",coursecode)
                .get()
                .addOnSuccessListener {
                    val booklist: ArrayList<book> = ArrayList()
                    for (document in it) {

                        var book = book(document.get("bookname") as String)
//                    Log.e("document",document.toString())
                        if(document.get("price") is Double){
                            book.price = (document.get("price") as Double).toInt()
                        }
                        else if(document.get("price") is Long){
                            book.price = (document.get("price") as Long).toInt()
                        }
                        if(document.get("coursecode") is ArrayList<*>){
                            book.coursecode = document.get("coursecode") as ArrayList<String>
                        }

                        book.isbn = document.get("isbn") as String
//                        book.available_time = document.get("date") as String
                        book.user_email = document.get("email") as String
                        book.username = document.get("username") as String
                        book.imageref = document.get("imageref") as String
                        if(document.get("sellerimg")!=null){
                            book.sellerimg=document.get("sellerimg") as String
                        }
                        if(document.get("message")!=null){
                            book.message=document.get("message") as String
                        }
                        booklist.add(book)
                    }
                    bookList_.value = booklist
                }
        }

        return bookList_
    }
    fun getSellerbooklist(email:String):MutableLiveData<ArrayList<book>>{
        if(bookList_.value==null){
            val db = FirebaseFirestore.getInstance().collection("book")
            db
                .whereEqualTo("email",email)
                .get()
                .addOnSuccessListener {
                    val booklist: ArrayList<book> = ArrayList()
                    for (document in it) {

                        var book = book(document.get("bookname") as String)
//                    Log.e("document",document.toString())
                        if(document.get("price") is Double){
                            book.price = (document.get("price") as Double).toInt()
                        }
                        else if(document.get("price") is Long){
                            book.price = (document.get("price") as Long).toInt()
                        }
                        if(document.get("coursecode") is ArrayList<*>){
                            book.coursecode = document.get("coursecode") as ArrayList<String>
                        }
                        book.isbn = document.get("isbn") as String
//                        book.available_time = document.get("date") as String
                        book.user_email = document.get("email") as String
                        book.username = document.get("username") as String
                        book.imageref = document.get("imageref") as String
                        if(document.get("sellerimg")!=null){
                            book.sellerimg=document.get("sellerimg") as String
                        }
                        if(document.get("message")!=null){
                            book.message=document.get("message") as String
                        }
                        booklist.add(book)
                    }
                    bookList_.value = booklist
                }
        }

        return bookList_
    }
}