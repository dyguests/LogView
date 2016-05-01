#LogView

A Log View in Android.to make Tester check log without Developer.

#Usage

1.Bind in Activity.

**use `bind()`method after `setContentView()`**.

```java
public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        ...
        setContentView(R.layout.activity_main);
        LogViewApi.bind(this);
        ...
    }
}
```

2.Use custom `Log` with LogViewApi.

```java
public class Log {
    public static void d(String tag, String msg) {
        android.util.Log.d(tag, msg);
        LogViewApi.d(tag, msg);
    }

    ...
}
```

3.Have fun.

#Proguand

```proguard
-keepclassmembers class com.fanhl.logview.LogViewApi {
   public *;
}
```

#Lincese

Copyright 2016 dyguests

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.