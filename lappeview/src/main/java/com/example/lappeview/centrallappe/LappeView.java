package com.example.lappeview.centrallappe;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;


import com.example.lappeview.BridgeScroll;
import com.example.lappeview.R;

import java.util.ArrayList;
import java.util.List;

public class LappeView extends LinearLayoutCompat {

    public static int color;
    public static Context myContext;
    public List<AppCompatButton> appCompatButtons = new ArrayList<>();

    /**
     * @author Sina Dayani
     */

    public LappeView(Context context) {
        super(context);
    }

    public LappeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.LappeView, 0, 0);
        color = a.getColor(R.styleable.LappeView_backgroundColor, getResources().getColor(R.color.white));
        String hexColor = String.format("#%06X", (0xFFFFFF & color));
        setMainColor(hexColor);
        this.setPadding(10, 10, 10, 10);
        this.setAlpha(0.0f);
        myContext = context;
        a.recycle();
    }


    public void setMainColor(String color) {
        Drawable drawable = this.getResources().getDrawable(R.drawable.bg_lappe);
        Drawable wrappedDrawable = DrawableCompat.wrap(drawable);
        int greenColorValue = Color.parseColor(color);
        DrawableCompat.setTint(wrappedDrawable, greenColorValue);
        this.setBackground(drawable);
    }


    public void setBgTextColor(String color) {
        Drawable drawable = this.getResources().getDrawable(R.drawable.bg_lappe);
        Drawable wrappedDrawable = DrawableCompat.wrap(drawable);
        int greenColorValue = Color.parseColor(color);
        DrawableCompat.setTint(wrappedDrawable, greenColorValue);
        for (int y = 0; y < appCompatButtons.size(); y++) {
            appCompatButtons.get(y).setBackground(drawable);
        }
    }



    public void setScrollView(NotifyingScrollView scrollView) {
        scrollView.setOnScrollChangedListener(new BridgeScroll(this).getMOnScrollChangedListener());

    }


    public void setFont(Typeface typeface) {
        try {
            for (int i = 0; i < appCompatButtons.size(); i++) {
                appCompatButtons.get(i).setTypeface(typeface);
            }
        } catch (Exception e) {
            Log.i("fontException", "---> " + e.getMessage());
        }
    }


    public void setTitleText(List<String> strings, int textColor) {

        LayoutParams param = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT,
                0.2f
        );
        param.setMargins(5, 5, 5, 5);
        setOrientation(LinearLayoutCompat.HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);
        this.removeAllViews();


        for (int i = 0; i < strings.size(); i++) {
            AppCompatButton appCompatButton = new AppCompatButton(LappeView.myContext);
            appCompatButton.setGravity(Gravity.CENTER);
            appCompatButton.setText(strings.get(i));
            appCompatButtons.add(appCompatButton);

        }

        for (int j = 0; j < appCompatButtons.size(); j++) {
            appCompatButtons.get(j).setTextColor(ContextCompat.getColor(myContext, textColor));
            appCompatButtons.get(j).setLayoutParams(param);
        }


        for (int j = 0; j < appCompatButtons.size(); j++) {
            this.addView(appCompatButtons.get(j), j);
        }

    }



    public void onClick(ItemOnClick itemOnClick) {
            for (int j = 0; j < appCompatButtons.size(); j++) {
                int finalJ = j;
                BridgeScroll d=new BridgeScroll(this);
                    d.getMOnScrollChangedListener();


                appCompatButtons.get(j).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                             itemOnClick.onClick(finalJ);
                         }
                 });
            }
    }




}
