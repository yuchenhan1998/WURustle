package com.example.rustle.activities

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat.startActivityForResult
import android.support.v4.content.FileProvider
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.rustle.R
import com.example.rustle.model.App.Companion.firebaseAuth
import com.example.rustle.model.Subjects
import com.example.rustle.model.book
import com.example.rustle.model.update
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageMetadata
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_sell_book.*
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class SellBookActivity : AppCompatActivity() {

    var currentPath: String? = null
    var imageuri:Uri?=null
    val TAKE_PICTURE = 1
    val SELECT_PICTURE = 2
    var school = ""
    var subject = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.rustle.R.layout.activity_sell_book)

//        val schoolspinner: Spinner = this.findViewById(R.id.subject)

//        val schools = getResources().getStringArray(R.array.schools_array)

//        ArrayAdapter.createFromResource(
//            this,
//            R.array.schools_array,
//            android.R.layout.simple_spinner_item
//        ).also { adapter ->
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            schoolspinner.adapter = adapter
//        }
//        schoolspinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
//            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                school = schools[position]
//                secondsinner()
//            }

//            override fun onNothingSelected(parent: AdapterView<*>?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//        }
    }

//    fun secondsinner(){
//        val subjectSpinner: Spinner = findViewById(R.id.course)
//        var currentSubjectList = Subjects().getSubjectsBySchool(school)
//        var subjectAdapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,currentSubjectList)
////        subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        subjectSpinner.adapter = subjectAdapter
//        subjectSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
//            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                if(currentSubjectList!=null) {
//                    subject = currentSubjectList[position]
//                }
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//        }
//    }

    override fun onStart() {
        super.onStart()
        publish.setOnClickListener { publish() }
        cancel.setOnClickListener { finish() }
        userimage.setOnClickListener{
            dispatchCameraIntent()
        }

        userimage.setOnLongClickListener {
            dispatchGalleryIntent()
        }
        //calendar
//        date.setOnClickListener{
//            showcalendar()
//        }

    }

//    fun showcalendar(){
//        val calendar=Calendar.getInstance()
//        val year_=calendar.get(Calendar.YEAR)
//        val month_=calendar.get(Calendar.MONTH)
//        val day_=calendar.get(Calendar.DATE)
//        val popc=DatePickerDialog(this,DatePickerDialog.OnDateSetListener{
//                view, year, month, dayOfMonth ->
//                val monthtext= String.format("%02d", month+1)
//                val daytext=String.format("%02d", dayOfMonth)
//                date.setText(""+year+"-"+monthtext+"-"+daytext)
//
//        },year_,month_,day_)
////        popc.show()
//    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TAKE_PICTURE && resultCode == Activity.RESULT_OK){
            try{
                val file= File(currentPath);
                val uri = Uri.fromFile(file);
                userimage.setImageURI(uri);
                imageuri=uri
            }catch (e: IOException){
                e.printStackTrace();
            }
        }

        if (requestCode == SELECT_PICTURE && resultCode == Activity.RESULT_OK){
            try{
                val uri = data!!.data;
                userimage.setImageURI(uri);
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

    fun createImage(): File{
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imageName = "JPEG_" + timeStamp+"_"
        var storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        var image = File.createTempFile(imageName, ".jpg", storageDir)
        currentPath = image.absolutePath;
        return image;
    }
    private fun publish(){
        //TODO
//        val df = SimpleDateFormat("MM-dd-yyyy")
        var book= book()

        if(bookname.text.toString()==""){
            Toast.makeText(this,"Book name cannot be empty",Toast.LENGTH_SHORT).show()
            return
        }
        if(imageuri!=null){
            book.imageref="user"+"/" + "${firebaseAuth!!.currentUser!!.uid!!}/${bookname}"

        }
        book.user_email= firebaseAuth?.currentUser?.email.toString()
        book.username=firebaseAuth?.currentUser?.displayName.toString()
        book.bookname=bookname.text.toString()
//        if(date.text.toString()=="Available time"){
//            Toast.makeText(this,"Date Invalid",Toast.LENGTH_SHORT).show()
//            return
//        }
//        book.available_time=date.text.toString()
        book.message=message.text.toString()
        book.sellerimg=firebaseAuth?.currentUser?.photoUrl.toString()
//        try{
//            val date_ = LocalDate.parse(date.text.toString(), DateTimeFormatter.ISO_DATE)
//            book.available_time=date.text.toString()
//        }
//        catch (e:java.time.format.DateTimeParseException){
//            Toast.makeText(this,"Date Invalid",Toast.LENGTH_SHORT).show()
//            return
//        }
//        book.course.add(subject)
        val reg="^[A-z]+([0-9]+)".toRegex()

        var temp= coursecode.text.toString().toUpperCase().split(",")
        Log.e("coursecode",temp.toString())
        temp.forEach{
            if(reg.find(it)==null){
                Toast.makeText(this,"Course code invalid",Toast.LENGTH_SHORT).show()
                return
            }
            book.coursecode.add(reg.find(it)?.value.toString())

        }
        if(book.coursecode==null){
            Toast.makeText(this,"Course code invalid",Toast.LENGTH_SHORT).show()
            return
        }

        book.isbn=isbn.text.toString()
        try{
            book.price=Integer.parseInt(price.text.toString())
        }
        catch(e:NumberFormatException){
            Toast.makeText(this,"Price Invalid",Toast.LENGTH_SHORT).show()
            return
        }

        uploadbookinfo(book)
    }

    fun uploadbookinfo(book: book){
        val userid= firebaseAuth?.currentUser?.uid
        if(!firebaseAuth!!.currentUser!!.isEmailVerified){
            Toast.makeText(this,"Need to verify email first",Toast.LENGTH_SHORT).show()
            return
        }
        val database = FirebaseFirestore.getInstance().collection("book")
        val gson = Gson()
        val bookjson = gson.toJson(book)
        val bookmap = gson.fromJson(bookjson, Map::class.java)
        Log.e("bookmap",bookmap.toString())
        database.document("${userid}_${book.bookname}").set(
            bookmap
        )
            .addOnSuccessListener {
                if(imageuri!=null){
                    uploadbookimage(imageuri!!,bookname.text.toString())

                }
                else{
                    Toast.makeText(this,"Upload Success",Toast.LENGTH_SHORT).show()
                    finish()
                }

            }
    }

    fun uploadbookimage(file:Uri,bookname:String){
        val storage = FirebaseStorage.getInstance()
        var storageRef = storage.reference.child("user")
// Create the file metadata
        val metadata = StorageMetadata.Builder()
            .setContentType("image/jpeg")
            .build()

// Upload file and metadata to the path 'images/mountains.jpg'
        val uploadTask = storageRef.child("${firebaseAuth!!.currentUser!!.uid!!}/${bookname}").putFile(file, metadata)

// Listen for state changes, errors, and completion of the upload.
        uploadTask.addOnProgressListener { taskSnapshot ->
            val progress = (100.0 * taskSnapshot.bytesTransferred) / taskSnapshot.totalByteCount
            System.out.println("Upload is $progress% done")
        }.addOnPausedListener {
            System.out.println("Upload is paused")
        }.addOnFailureListener {
            // Handle unsuccessful uploads
        }.addOnSuccessListener {
            // Handle successful uploads on complete
            // ..
        }.addOnCompleteListener{
            Toast.makeText(this,"Upload Success",Toast.LENGTH_SHORT).show()
            finish()
        }
//        return "user"+"/" + "${firebaseAuth!!.currentUser!!.uid!!}/${bookname}"
    }


}
