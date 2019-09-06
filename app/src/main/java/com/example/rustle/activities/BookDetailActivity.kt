package com.example.rustle.activities

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.util.Log
import android.widget.Toast
import com.example.rustle.R
import com.example.rustle.fragments.HomeFragment
import com.example.rustle.fragments.HomeFragment.Companion.BOOK_MESSAGE
import com.example.rustle.model.App
import com.example.rustle.model.GlideApp
import com.google.firebase.storage.FirebaseStorage
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_book_detail.*
import kotlinx.android.synthetic.main.activity_sell_book.*
import kotlinx.android.synthetic.main.fragment_account_info.*

class BookDetailActivity : AppCompatActivity() {

    private var bookName : String ? = null
    private var bookPrice : Int = 0
    private var bookUntil : String ? = null
    private var bookIsbn : String ? = null
    private var bookCourse : ArrayList<String>?=null
    private var bookImage : String = ""
    private var sellerEmail : String ? = null
    private var sellerName : String ? = null
    private var bookmessage:String? =null
    private var sellerimg:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)
    }

    override fun onStart() {
        super.onStart()
        bookName = intent.getStringExtra(HomeFragment.BOOK_NAME)
        bookPrice = intent.getIntExtra(HomeFragment.BOOK_PRICE,0)
        bookCourse = (intent.getStringArrayListExtra(HomeFragment.BOOK_COURSE))
        bookUntil = intent.getStringExtra(HomeFragment.BOOK_UNTIL)
        bookIsbn = intent.getStringExtra(HomeFragment.BOOK_ISBN)
        bookImage = intent.getStringExtra(HomeFragment.BOOK_IMAGE)
        sellerName = intent.getStringExtra(HomeFragment.BOOK_SELLER)
        sellerEmail = intent.getStringExtra(HomeFragment.BOOK_EMAIL)
        bookmessage=intent.getStringExtra(HomeFragment.BOOK_MESSAGE)
        sellerimg=intent.getStringExtra(HomeFragment.BOOK_SELLERIMG)
        



        detail_name.text = bookName
        detail_price.text = getString(R.string.book_setPrice,bookPrice)
        var temp="Subject: "
        if(bookCourse!=null){
            for (code in bookCourse as ArrayList<String>){
                temp=temp+code+","

            }
        }

        detail_course.text = temp
        detail_isbn.text = getString(R.string.book_set_ISBN,bookIsbn)
//        detail_until.text = getString(R.string.book_aUntil,bookUntil)
        detail_seller_name.text = sellerName
//        detail_seller_email.text = getString(R.string.seller_set_email,sellerEmail)
        detail_msg.text= "Message: ${bookmessage}"

        if(bookImage!=""){
            val imageRef= FirebaseStorage.getInstance().reference.child(bookImage)
            GlideApp.with(this)
                .load(imageRef)
                .into(detail_image)
        }

        if(sellerimg!=""){
            Picasso.with(this).load(sellerimg).into(detail_seller_icon);
        }


        mark_button.setOnClickListener { markBook() }
        request_button.setOnClickListener {
            val a = sellerEmail
            val b = "Book Request for "+bookName
            val c = "Hi,%0D%0A I would like to buy your "+bookName+" for "+bookPrice+"$."+"\n Can we schedule a time to meet? ";

            val recipient = a!!.trim();
            val subject = b.trim();
            val message = c.trim();


            sendRequest(recipient, subject, message)
        }

        return_button.setOnClickListener{onBackPressed()}
    }

    private fun markBook(){
        //TODO: mark book
    }

    private fun sendRequest(recipient: String, subject: String, message: String){

        val mIntent = Intent(Intent.ACTION_SEND)
        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"

        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient));
        mIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        mIntent.putExtra(Intent.EXTRA_TEXT,message);

        try {
            startActivity(Intent.createChooser(mIntent, "Choose Email Clinet..."))
        }
        catch(e: Exception){
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }

    }
}
