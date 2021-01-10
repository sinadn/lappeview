# LappeView
A great fading menu in Scroll View . This is based on LinearLayoutCompat from [sinadn](http://github.com/sinadn)

![lappeView](https://github.com/sinadn/lappeview/blob/main/example.gif)


# custom color
![lappeView](https://github.com/sinadn/lappeview/blob/main/purple.png)
```
        lape.setTitleText(list, R.color.white);    <---text color
        lape.setMainColor("#864CAF50")
        lape.setBgTextColor("#4CAF50")
```


# custom item
![lappeView](https://github.com/sinadn/lappeview/blob/main/green.png)
```
        val list: MutableList<String> = arrayListOf()
        list.add("home")
        list.add("service")
        list.add("contact us")

        lape.setTitleText(list, R.color.white);
```


# Gradle
```
	dependencies {
	        implementation 'com.github.sinadn:lappeview:8.0.0'
	}
```



```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```



# Usage

### activity_main.xml

```

    <com.example.lappeview.centrallappe.NotifyingScrollView
        android:id="@+id/scroll"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintEnd_toEndOf="parent">

        <androidx.appcompat.widget.LinearLayoutCompat
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical">
            
            
            .....
            

    </com.example.lappeview.centrallappe.NotifyingScrollView>


    <com.example.lappeview.centrallappe.LappeView
        android:id="@+id/lappe"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="10dp"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        />
```




### MainActivity.kt


```
        lape = findViewById(R.id.lappe)
        scrollView = findViewById(R.id.scroll)

        val list: MutableList<String> = arrayListOf()
        list.add("home")
        list.add("service")
        list.add("contact us")

        lape.setTitleText(list, R.color.white);
        lape.setFont(ResourcesCompat.getFont(this, R.font.iran_yekan_bold))
        lape.setMainColor("#864CAF50")
        lape.setBgTextColor("#4CAF50")
        lape.setScrollView(scrollView)
        lape.onClick(ItemOnClick {
            if (lape.alpha != 0.0f)
                Toast.makeText(this, "----> " + it, Toast.LENGTH_SHORT).show()
        })
```





### License
```
Copyright 2021 sinadn

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

