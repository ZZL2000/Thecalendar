package com.example.thecalendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;
import java.util.List;

/**
 * Created by zzl
 * Modified by Xiaohan
 */
public class ActivityDec extends AppCompatActivity {
    ToggleButton saveChange ;
    ToggleButton translatebutton ;
    EditText deced1;
    EditText deced2;
    EditText deced3;
    EditText deced4;
    EditText deced5;
    EditText deced6;

    String deceditString1="";
    String deceditString2 = "";
    String deceditString3="";
    String deceditString4="";
    String deceditString5="";
    String deceditString6="";
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;
    public static final String DECFirstthingtodo = "Keydec";
    public static final String DECSecondthingtodo = "Keydec2";
    public static final String DECThirdthingtodo = "Keydec3";
    public static final String DECFourththingtodo = "Keydec4";
    public static final String DECFifththingtodo = "Keydec5";
    public static final String DECSixththingtodo = "Keydec6";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dec);//注意为“R.layout.activity_second”
        //the information above is used to show the main menu of decust page.
        saveChange = (ToggleButton)findViewById(R.id.DECSB);
        //this is the name of the button
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        //in this place I set my 主 preference, 即所有preference的合集 which is also the content we want to save
        deced1  = (EditText)findViewById(R.id.DEC1);
        deced2  = (EditText)findViewById(R.id.DEC2);
        deced3  = (EditText)findViewById(R.id.DEC3);
        deced4  = (EditText)findViewById(R.id.DEC4);
        deced5  = (EditText)findViewById(R.id.DEC5);
        deced6  = (EditText)findViewById(R.id.DEC6);
        //Then I try to give the 文本框 a variable (id)
        String dec1=sharedpreferences.getString(DECFirstthingtodo, "event 1");
        String dec2=sharedpreferences.getString(DECSecondthingtodo, "event 2");
        String dec3=sharedpreferences.getString(DECThirdthingtodo, "event 3");
        String dec4=sharedpreferences.getString(DECFourththingtodo, "event 4");
        String dec5=sharedpreferences.getString(DECFifththingtodo, "event 5");
        String dec6=sharedpreferences.getString(DECSixththingtodo, "event 6");

        //I set dec1 as the first thing to do, which is the same as the event I stored last time
        //！！！！！！！！！！！注意这里，我觉得最好的api调用方式是把日期写在defaultvalue这里， 即“emailkey”
        deced1.setText(dec1);
        deced2.setText(dec2);
        deced3.setText(dec3);
        deced4.setText(dec4);
        deced5.setText(dec5);
        deced6.setText(dec6);
        // 文本框内容等于保存的第一个events
        saveChange.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            //开始我的按钮
            SharedPreferences.Editor editor = sharedpreferences.edit();
            //初始化sharedpreference
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //初始化toggle button
                sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                //获取sharedpreferences
                if (isChecked) {
                    String dec1=sharedpreferences.getString(DECFirstthingtodo, "emailKey");
                    String dec2=sharedpreferences.getString(DECSecondthingtodo, "emailKey");
                    String dec3=sharedpreferences.getString(DECThirdthingtodo, "emailKey");
                    String dec4=sharedpreferences.getString(DECFourththingtodo, "emailKey");
                    String dec5=sharedpreferences.getString(DECFifththingtodo, "emailKey");
                    String dec6=sharedpreferences.getString(DECSixththingtodo, "emailKey");
                    //这个不能删，必须先定义
                    deceditString1 = deced1.getText().toString();
                    deceditString2 = deced2.getText().toString();
                    deceditString3 = deced3.getText().toString();
                    deceditString4 = deced4.getText().toString();
                    deceditString5 = deced5.getText().toString();
                    deceditString6 = deced6.getText().toString();
                    editor.putString(DECFirstthingtodo, deceditString1);
                    editor.putString(DECSecondthingtodo, deceditString2);
                    editor.putString(DECThirdthingtodo, deceditString3);
                    editor.putString(DECFourththingtodo, deceditString4);
                    editor.putString(DECFifththingtodo, deceditString5);
                    editor.putString(DECSixththingtodo, deceditString6);

                    editor.apply();
                    //在sharedpreference保存改变
                    Toast.makeText(ActivityDec.this,"you have saved the change",Toast.LENGTH_LONG).show();
                    //显示“已经变化”
                    dec1=sharedpreferences.getString(DECFirstthingtodo, "emailKey");
                    dec2=sharedpreferences.getString(DECSecondthingtodo, "emailKey");
                    dec3=sharedpreferences.getString(DECThirdthingtodo, "emailKey");
                    dec4=sharedpreferences.getString(DECFourththingtodo, "emailKey");
                    dec5=sharedpreferences.getString(DECFifththingtodo, "emailKey");
                    dec6=sharedpreferences.getString(DECSixththingtodo, "emailKey");
                    deced1.setText(dec1);
                    deced2.setText(dec2);
                    deced3.setText(dec3);
                    deced4.setText(dec4);
                    deced5.setText(dec5);
                    deced6.setText(dec6);
                    //怎么按都显示正确的东西
                    saveChange.setChecked(true);
                    //“按钮已经关闭”
                } else {
                    saveChange.setChecked(false);
                    Toast.makeText(ActivityDec.this,"do not hesitate lol",Toast.LENGTH_LONG).show();
                }
            }
        });
        translatebutton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //initialize toggle button
                sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                //get sharedpreferences
                if (isChecked) {
                    String aug1=sharedpreferences.getString(DECFirstthingtodo, "emailKey");
                    deceditString1 = deced1.getText().toString();
                    //save change in sharedpreference
                    try {
                        new Thread(deced1).execute(deceditString1);
                        new Thread(deced2).execute(deceditString2);
                        new Thread(deced3).execute(deceditString3);
                        new Thread(deced4).execute(deceditString4);
                        new Thread(deced5).execute(deceditString5);
                        new Thread(deced6).execute(deceditString6);
                    } catch (Exception e) {
                        //Log.d( "hi", e.toString());
                        deced1.setText("failed!");
                        deced2.setText("failed!");
                        deced3.setText("failed!");
                        deced4.setText("failed!");
                        deced5.setText("failed!");
                        deced6.setText("failed!");
                    }
                    Toast.makeText(ActivityDec.this,"you have saved the change",Toast.LENGTH_LONG).show();
                    //display the right text
                    translatebutton.setChecked(true);
                    //“button closed”
                } else {
                    translatebutton.setChecked(false);
                    Toast.makeText(ActivityDec.this,"do not hesitate lol",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
