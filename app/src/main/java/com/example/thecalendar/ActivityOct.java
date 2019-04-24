package com.example.thecalendar;
import android.widget.EditText;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
/**
 * Created by zzl
 */
public class ActivityOct extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oct);//注意为“R.layout.activity_second”
        String str1 = "";
        EditText EditTextK =(EditText)findViewById(R.id.EditText1);
        str1=EditTextK.getText().toString();
        System.out.println(str1);
    }



}