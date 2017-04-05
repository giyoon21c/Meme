package com.example.android.meme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    /*
    1. store all the data somewhere
        res/values/strings.xml
    2. define the structure of a single row of your listView inside single_row.xml
    3. define the listview inside main layout and reference it in your activity
    4. create your customer adapter that puts the data for each row inside getView.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
