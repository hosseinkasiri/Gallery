package com.example.gallery.network

import com.example.gallery.GalleryItem
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val API = "https://www.flickr.com/services/rest?method=flickr.photos.getRecent&" +
        "api_key=ca0a611993028687e31fcb72a7019baa&format=json&nojsoncallback=1&extras=url_s"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(API)
    .build()

interface FlickrApiService {
    @GET("id/title/url_s")
    fun getProperties(): Deferred<List<GalleryItem>>
}

object GalleryApi {
    val retrofitService : FlickrApiService by lazy { retrofit.create(FlickrApiService::class.java) }
}
