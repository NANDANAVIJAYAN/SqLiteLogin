package com.example.sqlitelogin;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class dbView extends AppCompatActivity {
    Button mViewBtn;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_view);
        DB = new DBHelper(this);
        mViewBtn = findViewById(R.id.dbviewbtn);


        mViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = (Cursor) DB.getAllUsers();
                if(res.getCount()==0){
                    Toast.makeText(dbView.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Username :"+res.getString(0)+"\n");
                    buffer.append("Password:"+res.getString(1)+"\n");
                    buffer.append("Date:"+res.getString(2)+"\n\n");

                }

                AlertDialog.Builder builder = new AlertDialog.Builder(dbView.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });





    }
}
