package com.dontsu.photosharemvvmex.viewmodel

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dontsu.photosharemvvmex.model.Photo

class SharePhotoViewModel: ViewModel() {

    val photo = MutableLiveData<Photo>()



}