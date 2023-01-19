package com.example.greedygame_assignment.Adapter


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.greedygame_assignment.Activity.DetailsActivity
import com.example.greedygame_assignment.Activity.GenreDetailActivity
import com.example.greedygame_assignment.Model.Album
import com.example.greedygame_assignment.Model.AlbumDetail

import com.example.greedygame_assignment.Model.TagsDetail
import com.example.greedygame_assignment.R

class AlbumAdapter: RecyclerView.Adapter<AlbumAdapter.MyViewHolder>() {

    private var listData:MutableList<AlbumDetail>? = null
    lateinit var context:Context

    fun setListData(context: Context, listData: MutableList<AlbumDetail>){
        this.listData=listData
        this.context=context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title_name.text =listData?.get(position)!!.titleName
        holder.desc_name.text =listData?.get(position)!!.artist.artistName


        var image = listData?.get(position)!!.imageList?.get(0)!!.imageUrl

        if (image.equals("")){
            Glide.with(context)
                .load(R.drawable.no_image)
                .into(holder.image)
        }else{
            Glide.with(context)
                .load(image)
                .into(holder.image)
        }


        var name:String = listData?.get(position)!!.titleName

        holder.itemView.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("albumName",name)
            intent.putExtra("artistName",name)
            context.startActivity(intent)
        })
    }

    override fun getItemCount(): Int {
        return listData?.size!!
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val title_name: TextView = view.findViewById(R.id.titleTrack)
        val desc_name: TextView = view.findViewById(R.id.txtDescription)
        val image: ImageView = view.findViewById(R.id.imageView)


    }
}