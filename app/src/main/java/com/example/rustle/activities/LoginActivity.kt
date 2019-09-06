package com.example.rustle.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.example.rustle.MainActivity
import com.example.rustle.model.App.Companion.firebaseAuth
import com.example.rustle.model.update
import com.example.rustle.model.user
import com.firebase.ui.auth.AuthMethodPickerLayout
import com.firebase.ui.auth.AuthUI
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import java.util.*


/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : AppCompatActivity() {
    val SIGNIN_REQUEST_CODE = 1000
    lateinit var providers: List<AuthUI.IdpConfig>
    lateinit var gso: GoogleSignInOptions
    lateinit var mGoogleSignInClient: GoogleSignInClient
    val GOOGLE_SIGN_IN: Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
//        setContentView(com.example.rustle.R.layout.activity_login)

//        val googleSignIn = findViewById<View>(R.id.google) as SignInButton
//        googleSignIn.setSize(SignInButton.SIZE_WIDE)
//        gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestIdToken(getString(R.string.default_web_client_id))
//            .requestEmail()
//            .build()
//        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
//        googleSignIn.setOnClickListener { view: View? ->
//            googlesignIn()
//        }
//
//        email_sign_in_button.setOnClickListener {
//            emailsignin()
//        }
    }

    override fun onResume() {
        super.onResume()
        providers= Arrays.asList<AuthUI.IdpConfig>(
            AuthUI.IdpConfig.EmailBuilder().build(),
//            AuthUI.IdpConfig.PhoneBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build()
        )
        showSingInOptions()
    }

    override fun onBackPressed() {
//        val intent=Intent(this,MainActivity::class.java)
//        startActivity(intent)
        finish()
    }

    //    private fun emailsignin(){
//
//    }
//    private fun googlesignIn () {
//        val signInIntent: Intent = mGoogleSignInClient.signInIntent
//        startActivityForResult(signInIntent, GOOGLE_SIGN_IN)
//    }
////
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==SIGNIN_REQUEST_CODE){
            if(resultCode== Activity.RESULT_OK){

//                val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
//                try{
//                    val account: GoogleSignInAccount = task.getResult(ApiException::class.java)!!
//                    firebaseAuthWithGoogle(account!!)
////                    Log.e("accountinfo",account.toString())
//
//
//
//
//                    Toast.makeText(this, account.displayName+" log in", Toast.LENGTH_SHORT).show()
//                }
//                catch (e: ApiException) {
//                    Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
//                }

//                if(firebaseAuth?.currentUser?.providerId=="password"){
                if(!firebaseAuth?.currentUser?.isEmailVerified!!){
                    firebaseAuth?.currentUser?.sendEmailVerification()!!
                        .addOnCompleteListener(){
                            if(it.isSuccessful){
                                Toast.makeText(getApplicationContext(),
                                    "Verification Email Sent To: " + firebaseAuth?.currentUser?.email,
                                    Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(getApplicationContext(),
                                    "Failed To Send Verification Email!",
                                    Toast.LENGTH_SHORT).show();
                            }
                        }
                }
                var user=user()
                user.username= firebaseAuth!!.currentUser!!.displayName!!
                user.email=firebaseAuth!!.currentUser!!.email!!
                if(firebaseAuth!!.currentUser!!.photoUrl!=null){
                    user.photourl=firebaseAuth!!.currentUser!!.photoUrl.toString()
                }
                if(firebaseAuth?.currentUser?.phoneNumber!=null){
                    user.phone=firebaseAuth!!.currentUser!!.phoneNumber!!
                }

                update.createuser(user,this@LoginActivity)

//                Toast.makeText(this,""+App.firebaseAuth!!.currentUser!!+" log in",Toast.LENGTH_SHORT).show()
                finish()
            }
            else{
                finish()
            }
        }
    }
    //    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
//
//        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
//        App.firebaseAuth!!.signInWithCredential(credential)
//            .addOnCompleteListener(this) { task ->
//                if (task.isSuccessful) {
//                    updatefirebase(acct)
//                    // Sign in success, update UI with the signed-in user's information
//                } else {
//                    Toast.makeText(this, task.exception.toString(), Toast.LENGTH_LONG).show()
//                }
//
//                // ...
//            }
//    }
//    private fun updatefirebase(account: GoogleSignInAccount){
//        if(account.email!=null){
//            firebaseAuth!!.currentUser!!.updateEmail(account.email.toString())
//        }
//        user.username=account.displayName!!
//        user.email=account.email!!
//        update.updateuser(user,this@LoginActivity)
//        val profileUpdates = UserProfileChangeRequest.Builder()
//            .setDisplayName(account.displayName)
//            .setPhotoUri(account.photoUrl)
//            .build()
//        firebaseAuth?.currentUser?.updateProfile(profileUpdates)
//            ?.addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    Log.d("firebase update", "User profile updated.")
//                }
//            }
//
//    }
//
//
    private fun showSingInOptions(){
//    val customLayout = AuthMethodPickerLayout.Builder(com.example.rustle.R.layout.activity_login)
//        .setGoogleButtonId(com.example.rustle.R.id.google)
//        .setEmailButtonId(com.example.rustle.R.id.email)
//        .setPhoneButtonId(com.example.rustle.R.id.phone)
//        .build()
        startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder()
//            .setAuthMethodPickerLayout(customLayout)
            .setAvailableProviders(providers)
            .setTheme(com.example.rustle.R.style.GreenTheme)
            .build(),SIGNIN_REQUEST_CODE)

    }

}
