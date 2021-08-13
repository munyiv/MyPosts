package com.example.myposts


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("posts")
    fun  getPosts():Call<List<Post>>

    @GET("posts/{id}")
    fun getPostById(@Path("id")PostId:Int):Call<Post>

    @GET("posts/{postId}/comments")
    fun getComments(@Path("postId")id: Int):Call<List<display_comments>>
}