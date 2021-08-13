package com.example.myposts

import android.content.Context
import android.os.Bundle
import android.provider.CalendarContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Callback

class RvCommentsAdapter(var commentsList: List<display_comments>):RecyclerView.Adapter<CommentsViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.activity_view_comments,parent,false)
        return CommentsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        var currentcomment=commentsList.get(position)
       holder.tvCommentName.text=currentcomment.name
        holder.tvCommentBody.text=currentcomment.body
        holder.tvCommentEmail.text=currentcomment.email
    }

    override fun getItemCount(): Int {
       return commentsList.size
    }
}


class CommentsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    var tvCommentName=itemView.findViewById<TextView>(R.id.tvCommentsName)
    var tvCommentEmail=itemView.findViewById<TextView>(R.id.tvCommentEmail)
    var tvCommentBody=itemView.findViewById<TextView>(R.id.tvCommentBody)

}

