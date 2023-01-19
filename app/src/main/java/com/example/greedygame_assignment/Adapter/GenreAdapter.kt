package com.example.greedygame_assignment.Adapter


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.greedygame_assignment.Activity.GenreDetailActivity

import com.example.greedygame_assignment.Model.TagsDetail
import com.example.greedygame_assignment.R

class GenreAdapter: RecyclerView.Adapter<GenreAdapter.MyViewHolder>() {

    private var listData:MutableList<TagsDetail>? = null
    lateinit var context:Context

    fun setListData(context: Context, listData: MutableList<TagsDetail>){
        this.listData=listData
        this.context=context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.genre_view,parent,false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tag_name.text =listData?.get(position)!!.name

        var name:String = listData?.get(position)!!.name

        holder.itemView.setOnClickListener(View.OnClickListener {
            val intent = Intent(context,GenreDetailActivity::class.java)
            intent.putExtra("genreName",name)
            context.startActivity(intent)
        })
    }

    override fun getItemCount(): Int {
        return listData?.size!!
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tag_name: TextView = view.findViewById(R.id.tag_title)


    }
}