package com.example.lappeapp

import android.graphics.PixelFormat
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.example.lappeview.centrallappe.ItemOnClick
import com.example.lappeview.centrallappe.LappeView
import com.example.lappeview.centrallappe.NotifyingScrollView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}