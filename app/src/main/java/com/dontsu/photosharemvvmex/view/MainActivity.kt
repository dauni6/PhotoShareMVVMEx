package com.dontsu.photosharemvvmex.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dontsu.photosharemvvmex.R
import com.dontsu.photosharemvvmex.databinding.ActivityMainBinding
import com.dontsu.photosharemvvmex.viewmodel.SharePhotoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: SharePhotoViewModel

    private val fragment = PhotoFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this).get(SharePhotoViewModel::class.java)
        binding.viewModel = viewModel

        goToFragment.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).commit()
        }

        /*viewModel.imageUri.observe(this, Observer { uri ->
            //UI update
            binding.imageView.setImageURI(uri)
        })*/

    }


}