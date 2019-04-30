package com.example.thecalendar;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;


public final class MainActivity extends AppCompatActivity {
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
    public void onClick2(View view)
    {
        startActivity(new Intent("myActivitymar"));

    }
    public void onClick3(View view)
    {
        startActivity(new Intent("myActivityapr"));

    }
    public void onClick4(View view)
    {
        startActivity(new Intent("myActivitymay"));

    }
    public void onClick5(View view)
    {
        startActivity(new Intent("myActivityjun"));

    }
    public void onClick6(View view)
    {
        startActivity(new Intent("myActivityjul"));

    }
    public void onClick7(View view)
    {
        startActivity(new Intent("myActivityaug"));

    }
    public void onClick8(View view)
    {
        startActivity(new Intent("myActivitysep"));

    }
    public void onClick9(View view)
    {
        startActivity(new Intent("myActivityoct"));

    }
    public void onClick10(View view)
    {
        startActivity(new Intent("myActivitynov"));

    }
    public void onClick11(View view)
    {
        startActivity(new Intent("myActivitydec"));

    }

}
