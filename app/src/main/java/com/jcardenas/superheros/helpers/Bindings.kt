package com.jcardenas.superheros.helpers

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.jcardenas.superheros.R

@BindingAdapter("android:src")
fun imageSrc(imgView: ImageView, url: String?){
        Glide.with(imgView.context)
            .load(url)
            .error(R.drawable.ic_baseline_broken_image_24)
            .placeholder(R.drawable.ic_baseline_image_24)
            .into(imgView)
}