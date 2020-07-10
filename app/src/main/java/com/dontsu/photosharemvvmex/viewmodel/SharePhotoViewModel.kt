package com.dontsu.photosharemvvmex.viewmodel

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharePhotoViewModel: ViewModel() {

    val imageUri = MutableLiveData<Uri>()



}