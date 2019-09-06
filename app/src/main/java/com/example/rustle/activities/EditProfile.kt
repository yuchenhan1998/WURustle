package com.example.rustle.activities

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.content.FileProvider
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.rustle.R
import com.example.rustle.model.App.Companion.firebaseAuth
import com.example.rustle.model.update
import com.example.rustle.model.user
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_edit_profile.*
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class EditProfile : AppCompatActivity() {
    var currentPath: String? = null
    var imageuri: Uri?=null
    val TAKE_PICTURE = 1;
    val SELECT_PICTURE = 2;
    var user_grade=""
    var user_major=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        loaduser()
        val gradespinner: Spinner = findViewById(R.id.grade)
        val grades = getResources().getStringArray(R.array.grades_array)

        ArrayAdapter.createFromResource(
            this,
            R.array.grades_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            gradespinner.adapter = adapter
        }

        gradespinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                user_grade = grades[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }

        val majorspinner: Spinner = findViewById(R.id.major)
        val majors = getResources().getStringArray(R.array.subjects_array)

        ArrayAdapter.createFromResource(
            this,
            R.array.subjects_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            majorspinner.adapter = adapter
        }

        majorspinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                user_major = majors[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }


    }

    override fun onStart() {
        super.onStart()
        back.setOnClickListener{
            finish()
        }
        save.setOnClickListener{
            saveprofile();
        }
        userphoto.setOnClickListener{
            dispatchCameraIntent()
        }

        userphoto.setOnLongClickListener {
            dispatchGalleryIntent()
        }

    }

    fun loaduser(){
        Log.e("email",firebaseAuth!!.currentUser!!.email.toString().trim())
        val db = FirebaseFirestore.getInstance().collection("users")
        db.document(firebaseAuth!!.currentUser!!.uid)
//            .whereEqualTo("email",firebaseAuth!!.currentUser!!.email.toString().trim())
            .get()
            .addOnSuccessListener {document->
                    Log.e("userinfo","${document.data}")
                    var user= user()
                    user.username=document.get("username") as String
                    user.email=document.get("email") as String
                    user.phone=document.get("phone") as String
                    user.photourl=document.get("photourl") as String
                    if(user.photourl!=""){
                        Picasso.with(this).load(user.photourl).into(userphoto)
                    }
                    bookname.setText(user.username)
                    email.setText(user.email)
                    phone.setText(user.phone)
            }

    }

    fun saveprofile(){
        val username=bookname.text.toString()
        val grade=user_grade
        val major=user_major
        val phonenumber=phone.text.toString()
        val userid= firebaseAuth?.currentUser?.uid

        if(!firebaseAuth!!.currentUser!!.isEmailVerified){
            Toast.makeText(this,"Need to verify email first", Toast.LENGTH_SHORT).show()
            return
        }
        val user = firebaseAuth!!.currentUser

        val profileUpdates = UserProfileChangeRequest.Builder()
            .setDisplayName(username)
            .build()

        user?.updateProfile(profileUpdates)
            ?.addOnCompleteListener { task ->
            }
        if(imageuri!=null){
            update.uploaduserimage(imageuri!!)
        }
        val database = FirebaseFirestore.getInstance().collection("users")

        database.document("${userid}").update(
            "username",username,
            "major",major,
            "phone",phonenumber,
            "grade",grade

        )
            .addOnSuccessListener {
                val bookdb=FirebaseFirestore.getInstance().collection("book")
                bookdb
                    .whereEqualTo("email", firebaseAuth!!.currentUser!!.email)
                    .get()
                    .addOnSuccessListener {
                        for (document in it){
                            val booksnap=FirebaseFirestore.getInstance().collection("book").document(document.id)
                            booksnap.update(
                                "username",username
                            )
                        }
                    }

                Toast.makeText(this,"Upload Success", Toast.LENGTH_SHORT).show()
                finish()
            }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TAKE_PICTURE && resultCode == Activity.RESULT_OK){
            try{
                val file= File(currentPath);
                val uri = Uri.fromFile(file);
                userphoto.setImageURI(uri);
                imageuri=uri
            }catch (e: IOException){
                e.printStackTrace();
            }
        }

        if (requestCode == SELECT_PICTURE && resultCode == Activity.RESULT_OK){
            try{
                val uri = data!!.data;
                userphoto.setImageURI(uri);
                imageuri=uri
            }catch (e: IOException){
                e.printStackTrace();
            }
        }
    }

    fun dispatchGalleryIntent():Boolean{
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select image"), SELECT_PICTURE);
        return true
    }

    fun dispatchCameraIntent(){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(packageManager) != null){
            var photoFile: File? = null;
            try{
                photoFile = createImage();
            }catch(e: IOException){
                e.printStackTrace()
            }
            if (photoFile != null){
                var photoUri = FileProvider.getUriForFile(this,
                    "com.example.rustle.fileprovider", photoFile)
                intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                startActivityForResult(intent, TAKE_PICTURE);
            }
        }
    }

    fun createImage(): File {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imageName = "JPEG_" + timeStamp+"_"
        var storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        var image = File.createTempFile(imageName, ".jpg", storageDir)
        currentPath = image.absolutePath;
        return image;
    }
}
