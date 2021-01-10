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

    lateinit var lape: LappeView
    private lateinit var scrollView: NotifyingScrollView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        lape = findViewById(R.id.lappe)
        scrollView = findViewById(R.id.scroll)





        val list: MutableList<String> = arrayListOf()
        list.add("منو")
        list.add("درخواست ها")
        list.add("تماس")
        list.add("درباره ما")
        list.add("خدمات")


        lape.setTitleText(list, R.color.white);
        lape.setFont(ResourcesCompat.getFont(this, R.font.iran_yekan_light))
        lape.setMainColor("#803A50E1")
        lape.setBgTextColor("#0000ff")
        lape.setScrollView(scrollView)
        lape.onClick(ItemOnClick {
            if (lape.alpha != 0.0f)
                Toast.makeText(this, "----> " + it, Toast.LENGTH_SHORT).show()
        })



    }
}