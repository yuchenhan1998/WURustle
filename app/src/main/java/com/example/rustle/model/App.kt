package com.example.rustle.model

import android.app.ActionBar
import android.app.Dialog
import android.content.Context
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlin.collections.ArrayList

class App {
    companion object {
        var firebaseAuth: FirebaseAuth? = null
    }
}