package com.example.gallery

import com.squareup.moshi.Json

data class GalleryItem(@Json(name = "id")val id: String,
                       @Json(name = "title")val caption: String,
                       @Json(name = "url_s")val url: String)