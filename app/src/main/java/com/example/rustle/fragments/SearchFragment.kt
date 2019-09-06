package com.example.rustle.fragments

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.util.DiffUtil
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.rustle.R
import com.example.rustle.activities.BookDetailActivity
import com.example.rustle.model.GlideApp
import com.example.rustle.model.book
import com.example.rustle.viewmodel.BookViewModel
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.book_preview.view.*
import kotlinx.android.synthetic.main.fragment_home.*
import android.arch.lifecycle.Observer

class SearchFragment:Fragment(){
    private var adapter = BookListAdapter()
    private lateinit var viewModel: BookViewModel
    private var bookList: ArrayList<book> = ArrayList()
    private var subject=""

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = layoutInflater.inflate(R.layout.fragment_home, container, false)

        return view
    }

    override fun onStart() {
        super.onStart()
        var bundle=arguments
        subject=bundle!!.getString("subject")
        Log.e("subject",subject)

        home_list.layoutManager = LinearLayoutManager(context) as RecyclerView.LayoutManager?
        val mDivider = ContextCompat.getDrawable(context!!, R.drawable.divider);
        var decoration= DividerItemDecoration(this.getActivity(), LinearLayout.VERTICAL)
        decoration.setDrawable(mDivider!!)
        home_list.addItemDecoration(decoration)

        viewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)
        val observer = Observer<ArrayList<book>>{
            home_list.adapter = adapter
            val result = DiffUtil.calculateDiff(object : DiffUtil.Callback() {

                override fun areItemsTheSame(p0: Int, p1: Int): Boolean {
                    return bookList[p0].bookname == bookList[p1].bookname && bookList[p0].user_email==bookList[p1].user_email
                }

                override fun getOldListSize(): Int {
                    return bookList.size
                }

                override fun getNewListSize(): Int {
                    if (it == null) {
                        return 0
                    }
                    return it.size
                }

                override fun areContentsTheSame(p0: Int, p1: Int): Boolean {
                    return bookList[p0] == bookList[p1]
                }
            })
//            Log.e("result",result.toString())
            result.dispatchUpdatesTo(adapter)
            bookList = it ?: ArrayList()
//            Log.e("diffutil",bookList[0].price.toString())
        }


        viewModel.getSearchbooklist(subject).observe(this, observer)

//        val rView = view.findViewById<RecyclerView>(R.id.home_list)
//        with(rView){
//            layoutManager = LinearLayoutManager(context)
//            adapter = BookListAdapter()
//        }
    }

//    private fun getOutOfDateBooks(){
//        //TODO: get book from fireBase and return the ones that are out of date shortly
//
//    }

    private fun toActivity(b : book){
        val intent = Intent(context, BookDetailActivity::class.java)
        intent.putExtra(BOOK_NAME,b.bookname)
        intent.putExtra(BOOK_UNTIL,b.available_time)
        intent.putExtra(BOOK_PRICE,b.price)
        intent.putExtra(BOOK_IMAGE,b.imageref)
        intent.putExtra(BOOK_ISBN,b.isbn)
        intent.putExtra(BOOK_EMAIL,b.user_email)
        intent.putExtra(BOOK_SELLER,b.username)
        intent.putExtra(BOOK_MESSAGE,b.message)
        intent.putExtra(BOOK_SELLERIMG,b.sellerimg)

        intent.putStringArrayListExtra(HomeFragment.BOOK_COURSE,b.coursecode)

        startActivity(intent)

    }

    inner class BookListAdapter : RecyclerView.Adapter<BookListAdapter.BookListViewHolder>(){

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BookListViewHolder {
            val view = LayoutInflater.from(p0.context).inflate(R.layout.book_preview,p0,false)
            return BookListViewHolder(view)
        }

        override fun onBindViewHolder(p0: BookListViewHolder, p1: Int) {

            val thisBook = bookList[p1]
            Log.e("thisbook",thisBook.toString())
            if(thisBook.imageref!=""){

                val imageref= FirebaseStorage.getInstance().reference.child(thisBook.imageref)
                GlideApp.with(context!!)
                    .load(imageref)
                    .into(p0.bookCover)
            }

            p0.bookName.text = thisBook.bookname
            p0.bookPrice.text = "Price: "+getString(R.string.book_setPrice,thisBook.price)
//            p0.bookUntil.text = getString(R.string.book_aUntil,thisBook.available_time)
            if(thisBook.coursecode.size>0){
                var temp="subject: "
                for (code in thisBook.coursecode){
                    temp=temp+code+","
                }
                p0.bookClass.text=temp

            }

            p0.row.setOnClickListener { toActivity(thisBook) }

        }

        override fun getItemCount(): Int {
            return bookList.size
        }

        inner class BookListViewHolder(mView : View) : RecyclerView.ViewHolder(mView){
            val bookCover : ImageView = mView.book_cover
            val bookName : TextView = mView.book_name
            val bookPrice : TextView = mView.book_price
            val bookClass : TextView = mView.book_class
//            val bookUntil : TextView = mView.book_until
            val row  = mView
        }
    }

    companion object {
        const val BOOK_NAME = "BOOK_NAME"
        const val BOOK_COURSE = "BOOK_COURSE"
        const val BOOK_IMAGE = "BOOK_IMAGE"
        const val BOOK_UNTIL = "BOOK_UNTIL"
        const val BOOK_PRICE = "BOOK_PRICE"
        const val BOOK_ISBN = "BOOK_ISBN"
        const val BOOK_SELLER = "BOOK_SELLER"
        const val BOOK_EMAIL = "BOOK_EMAIL"
        const val BOOK_MESSAGE="BOOK_MESSAGE"
        const val BOOK_SELLERIMG="BOOK_SELLERIMG"
    }
}