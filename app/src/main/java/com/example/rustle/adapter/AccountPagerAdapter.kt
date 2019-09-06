//package com.example.cse438.studio6.adapter
//
//import android.content.Context
//import android.support.v4.app.Fragment
//import android.support.v4.app.FragmentManager
//import android.support.v4.app.FragmentPagerAdapter
//
//import com.example.rustle.R
//
//
//class AccountPagerAdapter(private val context: Context, fm: FragmentManager): FragmentPagerAdapter(fm) {
//    override fun getItem(p0: Int): Fragment {
//        return if (p0 == 0) {
//            CreateAccountFragment(context)
//        } else {
//            SignInFragment(context)
//        }
//    }
//
//    override fun getCount(): Int {
//        return 2
//    }
//
//    override fun getPageTitle(position: Int): CharSequence? {
//        return if (position == 0) {
//            context.getString(R.string.create_account)
//        } else {
//            context.getString(R.string.sign_in)
//        }
//    }
//}