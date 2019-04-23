package com.example.thecalendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public <T extends View> T findViewById(int id) {
        return super.findViewById(id);
    }
    public void onClick(View view)
    {
        startActivity(new Intent("myActivityjan"));

    }
    public void onClick1(View view)
    {
        startActivity(new Intent("myActivityfeb"));

    }

}
