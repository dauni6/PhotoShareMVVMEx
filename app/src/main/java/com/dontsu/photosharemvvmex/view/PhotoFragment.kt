package com.dontsu.photosharemvvmex.view

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.dontsu.photosharemvvmex.R
import com.dontsu.photosharemvvmex.model.Photo
import com.dontsu.photosharemvvmex.util.getProgressDrawable
import com.dontsu.photosharemvvmex.util.loadUri
import com.dontsu.photosharemvvmex.viewmodel.SharePhotoViewModel
import kotlinx.android.synthetic.main.fragment_photo.*


class PhotoFragment : Fragment() {

    lateinit var viewModel: SharePhotoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(SharePhotoViewModel::class.java)

        selectBtn.setOnClickListener{
            val intent = Intent(Intent.ACTION_PICK)
            intent.type ="image/*"
            startActivityForResult(intent, 602)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && requestCode == 602) {
            showPhoto(data?.data)
        }
    }

    private fun showPhoto(imageUri: Uri?) {
        imageUri?.let {
            frag_imageView.loadUri(imageUri, getProgressDrawable(frag_imageView.context))
            viewModel.photo.value = Photo(imageUri)
        }
    }

}