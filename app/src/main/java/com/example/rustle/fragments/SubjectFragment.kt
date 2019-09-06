package com.example.rustle.fragments

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.rustle.MainActivity
import com.example.rustle.R
import com.example.rustle.model.Subjects
import kotlinx.android.synthetic.main.fragment_subject_item.view.*


class SubjectFragment : Fragment() {

    private var columnCount = 1

    private val subjectList = Subjects().getSubjects()


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_subject, container, false)

        val rView = view.findViewById<RecyclerView>(R.id.subjects_listview)
        // Set the adapter

        with(rView) {
            layoutManager = when {
                columnCount <= 1 -> LinearLayoutManager(context)
                else -> GridLayoutManager(context, columnCount)
            }
            adapter = SubjectListAdapter()
        }
        return view
    }

    private fun search(subject:String){
        var bundle=Bundle()
        bundle.putString("subject",subject)
        val fm=activity!!.supportFragmentManager
        val SearchFragment=SearchFragment()
        SearchFragment.arguments=(bundle)
        fm.beginTransaction()
            .replace(R.id.fragment_frame, SearchFragment).commit()

    }

    inner class SubjectListAdapter:RecyclerView.Adapter<SubjectListAdapter.SubjectViewHolder>(){

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SubjectViewHolder {
            val view = LayoutInflater.from(p0.context).inflate(R.layout.fragment_subject_item, p0, false)
            return SubjectViewHolder(view)
        }

        override fun onBindViewHolder(p0: SubjectViewHolder, p1: Int) {
            val subject = subjectList[p1]
            p0.subjectName.text = subject
            if(p1 % 2==0){
                p0.row.setBackgroundColor(ContextCompat.getColor(context!!,R.color.list_separator))
            }
            else{
                p0.row.setBackgroundColor(Color.WHITE)
            }
            p0.row.setOnClickListener { search(subject) }
        }

        override fun getItemCount(): Int {
            return subjectList.size
        }



        inner class SubjectViewHolder(mView : View):RecyclerView.ViewHolder(mView){
            val row = mView
            val subjectName : TextView = mView.subject_item

        }
    }




}
