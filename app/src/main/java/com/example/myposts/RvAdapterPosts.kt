package com.example.myposts

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RvAdapterPosts(var context:Context, var postsList: List<Post>):RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        var itemView=LayoutInflater.from(parent.context)
            .inflate(R.layout.text_layout,parent,false)
        return PostViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        var posts= postsList.get(position)
        holder.tvUserId.text= posts.userId.toString()
        holder.tvId.text= posts.id.toString()
        holder.tvTitle.text= posts.title
        holder.tvBody.text=posts.body
        holder.cvPosts.setOnClickListener(){
            var intent = Intent(context,ViewPostActivity::class.java)
            intent.putExtra("POST_ID",posts.id)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return postsList.size
    }

}
class PostViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var tvUserId= itemView.findViewById<TextView>(R.id.tvUserId)
    var tvId= itemView.findViewById<TextView>(R.id.tvId)
    var tvTitle= itemView.findViewById<TextView>(R.id.tvTitle)
    var tvBody= itemView.findViewById<TextView>(R.id.tvBody)
    var cvPosts= itemView.findViewById<CardView>(R.id.cvPosts)
}