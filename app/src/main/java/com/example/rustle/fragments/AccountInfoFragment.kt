package com.example.rustle.fragments

import android.annotation.SuppressLint
import android.app.FragmentManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import com.example.rustle.MainActivity
import com.example.rustle.R
import com.example.rustle.activities.LoginActivity
import com.example.rustle.model.App.Companion.firebaseAuth
import com.example.rustle.model.user
import com.firebase.ui.auth.AuthUI
import kotlinx.android.synthetic.main.fragment_account_info.*
import kotlinx.android.synthetic.main.fragment_account_info.view.*
import android.graphics.Paint.UNDERLINE_TEXT_FLAG
import android.graphics.Color
import android.graphics.Paint
import com.example.rustle.activities.EditProfile
import com.example.rustle.activities.SellBookActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_sell_book.*


@SuppressLint("ValidFragment")
class AccountInfoFragment(context: Context) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(com.example.rustle.R.layout.fragment_account_info, container, false)
    }

    override fun onStart() {
        super.onStart()
        Log.e("fragmentaccount","enter")
        reload_verified()

        if(firebaseAuth?.currentUser?.photoUrl!=null){
            Picasso.with(context).load(firebaseAuth!!.currentUser!!.photoUrl).into(imageView);
        }
        if(firebaseAuth?.currentUser?.displayName!=null){
            user_name.text= firebaseAuth!!.currentUser!!.displayName!!
        }
        if(firebaseAuth?.currentUser?.email!=null){
            user_email_addres.text=firebaseAuth!!.currentUser!!.email!!
        }

        verify_btn.setOnClickListener{
            firebaseAuth?.currentUser?.sendEmailVerification()
        }
        verified.setOnClickListener{
            Log.e("clicktext","enter")
            reload_verified()

        }
        logout.setOnClickListener {
            firebaseAuth!!.signOut()
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }

        sellabook.setOnClickListener {
            if(!firebaseAuth!!.currentUser!!.isEmailVerified){
                Toast.makeText(context,"Need to verify email first",Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(context, SellBookActivity::class.java)
                startActivity(intent)
            }

        }

        editfile.setOnClickListener{
            val intent = Intent(context, EditProfile::class.java)
            startActivity(intent)
        }

        selling.setOnClickListener {
            var bundle=Bundle()
            bundle.putString("email", firebaseAuth!!.currentUser!!.email)
            val fm=activity!!.supportFragmentManager
            val MysellingFragment=MysellingFragment()
            MysellingFragment.arguments=(bundle)
            fm.beginTransaction()
                .replace(R.id.fragment_frame, MysellingFragment).commit()
        }


    }
    private fun reload_verified(){
        firebaseAuth?.currentUser?.reload()!!.addOnSuccessListener {
            verified?.setPaintFlags(0)
            verified?.setTextColor(Color.GRAY)
            verify_btn?.visibility=INVISIBLE
            verified?.text="Verified"
            if(!firebaseAuth!!.currentUser!!.isEmailVerified){
                verified?.setPaintFlags(verified.getPaintFlags() or Paint.UNDERLINE_TEXT_FLAG)
                verified?.setTextColor(Color.BLUE)
                verified?.text="Not Verified"
                verify_btn?.visibility= VISIBLE
            }
        }
    }

}
