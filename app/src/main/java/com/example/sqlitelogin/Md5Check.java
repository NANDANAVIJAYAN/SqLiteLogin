package com.example.sqlitelogin;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class Md5Check extends AppCompatActivity {
    ListView mListView;
    ArrayAdapter arrayAdapter;
    DBHelper DB;
    Button refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_md5_check);
        DB = new DBHelper(this);
        mListView.setAdapter(arrayAdapter);
    }

}
