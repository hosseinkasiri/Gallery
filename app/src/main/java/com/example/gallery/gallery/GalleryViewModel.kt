package com.example.gallery.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gallery.GalleryItem
import com.example.gallery.network.GalleryApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class GalleryViewModel: ViewModel() {

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )
    private val _properties = MutableLiveData<List<GalleryItem>>()
    val properties: LiveData<List<GalleryItem>>
        get() = _properties

    init {

    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    private fun getGalleryProperties(){
        coroutineScope.launch {
            var getPropertiesDeferred = GalleryApi.retrofitService.getProperties()
            try {
                var listResult = getPropertiesDeferred.await()
                _properties.value = listResult
            }catch (e: Exception){
                _properties.value = ArrayList()
            }
        }
    }
}