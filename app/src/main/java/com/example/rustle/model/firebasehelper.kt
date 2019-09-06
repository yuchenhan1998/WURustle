package com.example.rustle.model

import android.content.Context
import android.net.Uri
import android.util.Log
import android.widget.Toast
import com.example.rustle.activities.SellBookActivity
import com.example.rustle.model.App.Companion.firebaseAuth
import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.google.firebase.storage.StorageMetadata
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import com.google.gson.Gson

import java.net.URL


class update(){
    companion object {
        fun updateuser(user: user, context:Context){
            val db= FirebaseFirestore.getInstance()
            val document=db.collection("users").document("${App.firebaseAuth?.currentUser?.uid}")
            val userData = HashMap<String, Any>()
            userData["email"] = user.email
            userData["username"] = user.username
            userData["major"]=user.major
            userData["photourl"]= user.photourl
            userData["grade"]= user.grade
            userData["phone"]= user.phone

            document
                .set(userData)
                .addOnSuccessListener {
                }
                .addOnFailureListener {
                    Toast.makeText(context, "Failed to write user data", Toast.LENGTH_SHORT).show()
                }
        }

        fun createuser(user: user, context:Context){
            val db= FirebaseFirestore.getInstance()
            val document=db.collection("users").document("${App.firebaseAuth?.currentUser?.uid}")
            val userData = HashMap<String, Any>()
            userData["email"] = user.email
            userData["username"] = user.username
            userData["major"]=user.major
            userData["photourl"]= user.photourl
            userData["grade"]= user.grade
            userData["phone"]= user.phone

            document
                .set(userData, SetOptions.merge())
                .addOnSuccessListener {
                }
                .addOnFailureListener {
                    Toast.makeText(context, "Failed to write user data", Toast.LENGTH_SHORT).show()
                }
        }



        fun uploaduserimage(file:Uri){
            val storage = FirebaseStorage.getInstance()
            var storageRef = storage.reference.child("user")
// Create the file metadata
            val metadata = StorageMetadata.Builder()
                .setContentType("image/jpeg")
                .build()

// Upload file and metadata to the path 'images/mountains.jpg'
            val uploadTask = storageRef.child("${firebaseAuth!!.currentUser!!.uid!!}/userphoto").putFile(file, metadata)

// Listen for state changes, errors, and completion of the upload.
//            uploadTask.addOnProgressListener { taskSnapshot ->
//                val progress = (100.0 * taskSnapshot.bytesTransferred) / taskSnapshot.totalByteCount
//                System.out.println("Upload is $progress% done")
//            }.addOnPausedListener {
//                System.out.println("Upload is paused")
//            }.addOnFailureListener {
//                // Handle unsuccessful uploads
//            }.addOnSuccessListener {
//                // Handle successful uploads on complete
//                // ..
//
//
//            }.addOnCompleteListener{
//
//            }
            val urlTask = uploadTask.continueWithTask(Continuation<UploadTask.TaskSnapshot, Task<Uri>> { task ->
                if (!task.isSuccessful) {
                    task.exception?.let {
                        throw it
                    }
                }
                return@Continuation storageRef.child("${firebaseAuth!!.currentUser!!.uid!!}/userphoto").downloadUrl
            }).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val downloadUri = task.result
                    val database = FirebaseFirestore.getInstance().collection("users")
                    database.document("${firebaseAuth!!.currentUser!!.uid!!}").update(
                        "photourl",downloadUri.toString()
                    )
                    val profileUpdates = UserProfileChangeRequest.Builder()
                        .setPhotoUri(downloadUri)
                        .build()

                    firebaseAuth!!.currentUser?.updateProfile(profileUpdates)
                    val bookdb=FirebaseFirestore.getInstance().collection("book")
                    bookdb
                        .whereEqualTo("email", firebaseAuth!!.currentUser!!.email)
                        .get()
                        .addOnSuccessListener {
                            for (document in it){
                                val booksnap=FirebaseFirestore.getInstance().collection("book").document(document.id)
                                booksnap.update(
                                    "sellerimg",downloadUri.toString()
                                )
                            }
                        }
                } else {
                    // Handle failures
                    // ...
                }
            }
        }



    }

}