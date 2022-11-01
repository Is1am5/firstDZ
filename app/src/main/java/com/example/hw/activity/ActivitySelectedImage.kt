package com.example.hw.activity

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import com.example.hw.MainActivity
import com.example.hw.R
import com.example.hw.adapter.SelectedImageAdapter
import com.example.hw.base.BaseActivity
import com.example.hw.databinding.ActivitySelectedImageBinding
import java.util.*


class ActivitySelectedImage : BaseActivity<ActivitySelectedImageBinding>() {

    private val adapter = SelectedImageAdapter()

    override fun inflateVB(inflater: LayoutInflater): ActivitySelectedImageBinding {
        return ActivitySelectedImageBinding.inflate(inflater)
    }

    override fun initListener() {
        val uri: ArrayList<Uri>? = intent.getParcelableArrayListExtra(MainActivity.KEY_IMG)
        if (uri != null) {
            adapter.addImage(uri)
        }
    }

    override fun initView() {
        binding.selectedRecycler.layoutManager = GridLayoutManager(this@ActivitySelectedImage, 3)
        binding.selectedRecycler.adapter = adapter
    }
}