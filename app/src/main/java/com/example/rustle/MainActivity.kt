package com.example.rustle

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.util.Log
import com.example.rustle.activities.LoginActivity
import com.example.rustle.fragments.AccountInfoFragment
import com.example.rustle.fragments.HomeFragment
import com.example.rustle.fragments.NoConnectionFragment
import com.example.rustle.fragments.SubjectFragment
import com.example.rustle.model.App
import com.example.rustle.model.App.Companion.firebaseAuth
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val AccountActivityresultcode=8000
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                Log.e("home","enter")
                supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_frame,HomeFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_subject -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_frame, SubjectFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_account -> {
                Log.e("account","enter")
                if(App.firebaseAuth==null){
                    firebaseAuth = FirebaseAuth.getInstance()
                }
                if (firebaseAuth != null && firebaseAuth?.currentUser == null) {
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivityForResult(intent,AccountActivityresultcode)
                }
                else{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_frame, AccountInfoFragment(this)).commit()
                    return@OnNavigationItemSelectedListener true
                }

            }
        }
        false
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.e("onresult","enter")
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==AccountActivityresultcode){
            if(firebaseAuth?.currentUser!=null){
                Log.e("accountinfo","enter")
                navigation.menu.getItem(2).setChecked(true)
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_frame, AccountInfoFragment(this)).commit()
            }
            else{
                Log.e("homeinfo","enter")
                navigation.menu.getItem(0).setChecked(true)
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_frame, HomeFragment()).commit()
            }
        }
    }

    override fun onBackPressed() {
        navigation.menu.getItem(0).setChecked(true)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_frame,HomeFragment()).commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        FirebaseApp.initializeApp(this)
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        if (networkInfo == null) {
            Log.e("NETWORK", "not connected")
            ft.add(R.id.fragment_frame, NoConnectionFragment())
            ft.commit()
        }

        navigation.menu.getItem(0).setChecked(true)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_frame,HomeFragment()).commit()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }

//    override fun onResume() {
//        super.onResume()
//        navigation.menu.getItem(0).setChecked(true)
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragment_frame,HomeFragment()).commit()
//    }

}
