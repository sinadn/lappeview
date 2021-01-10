package com.example.lappeview

import com.example.lappeview.centrallappe.LappeView
import com.example.lappeview.centrallappe.NotifyingScrollView

public class BridgeScroll (lape: LappeView){


    val mOnScrollChangedListener =
        NotifyingScrollView.OnScrollChangedListener { who, l, t, oldl, oldt ->
            val ratio = Math.min(Math.max(t, 0), lape.height).toFloat() / lape.height
            val newAlpha = (ratio * 1.0).toFloat()
            lape.alpha = newAlpha
        }
}