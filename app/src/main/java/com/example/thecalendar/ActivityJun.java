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
public class ActivityJun extends AppCompatActivity {
    ToggleButton saveChange ;
    ToggleButton translatebutton;
    EditText juned1;
    EditText juned2;
    EditText juned3;
    EditText juned4;
    EditText juned5;
    EditText juned6;

    String juneditString1="";
    String juneditString2 = "";
    String juneditString3="";
    String juneditString4="";
    String juneditString5="";
    String juneditString6="";
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;
    public static final String JUNFirstthingtodo = "Keyjun";
    public static final String JUNSecondthingtodo = "Keyjun2";
    public static final String JUNThirdthingtodo = "Keyjun3";
    public static final String JUNFourththingtodo = "Keyjun4";
    public static final String JUNFifththingtodo = "Keyjun5";
    public static final String JUNSixththingtodo = "Keyjun6";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jun);//注意为“R.layout.activity_second”
        //the information above is used to show the main menu of junust page.
        saveChange = (ToggleButton)findViewById(R.id.JUNSB);
        translatebutton = (ToggleButton)findViewById(R.id.JUNtranslate);
        //this is the name of the button
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        //in this place I set my 主 preference, 即所有preference的合集 which is also the content we want to save
        juned1  = (EditText)findViewById(R.id.JUN1);
        juned2  = (EditText)findViewById(R.id.JUN2);
        juned3  = (EditText)findViewById(R.id.JUN3);
        juned4  = (EditText)findViewById(R.id.JUN4);
        juned5  = (EditText)findViewById(R.id.JUN5);
        juned6  = (EditText)findViewById(R.id.JUN6);
        //Then I try to give the 文本框 a variable (id)
        String jun1=sharedpreferences.getString(JUNFirstthingtodo, "event 1");
        String jun2=sharedpreferences.getString(JUNSecondthingtodo, "event 2");
        String jun3=sharedpreferences.getString(JUNThirdthingtodo, "event 3");
        String jun4=sharedpreferences.getString(JUNFourththingtodo, "event 4");
        String jun5=sharedpreferences.getString(JUNFifththingtodo, "event 5");
        String jun6=sharedpreferences.getString(JUNSixththingtodo, "event 6");

        //I set jun1 as the first thing to do, which is the same as the event I stored last time
        //！！！！！！！！！！！注意这里，我觉得最好的api调用方式是把日期写在defaultvalue这里， 即“emailkey”
        juned1.setText(jun1);
        juned2.setText(jun2);
        juned3.setText(jun3);
        juned4.setText(jun4);
        juned5.setText(jun5);
        juned6.setText(jun6);
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
                    String jun1=sharedpreferences.getString(JUNFirstthingtodo, "emailKey");
                    String jun2=sharedpreferences.getString(JUNSecondthingtodo, "emailKey");
                    String jun3=sharedpreferences.getString(JUNThirdthingtodo, "emailKey");
                    String jun4=sharedpreferences.getString(JUNFourththingtodo, "emailKey");
                    String jun5=sharedpreferences.getString(JUNFifththingtodo, "emailKey");
                    String jun6=sharedpreferences.getString(JUNSixththingtodo, "emailKey");
                    //这个不能删，必须先定义
                    juneditString1 = juned1.getText().toString();
                    juneditString2 = juned2.getText().toString();
                    juneditString3 = juned3.getText().toString();
                    juneditString4 = juned4.getText().toString();
                    juneditString5 = juned5.getText().toString();
                    juneditString6 = juned6.getText().toString();
                    editor.putString(JUNFirstthingtodo, juneditString1);
                    editor.putString(JUNSecondthingtodo, juneditString2);
                    editor.putString(JUNThirdthingtodo, juneditString3);
                    editor.putString(JUNFourththingtodo, juneditString4);
                    editor.putString(JUNFifththingtodo, juneditString5);
                    editor.putString(JUNSixththingtodo, juneditString6);

                    editor.apply();
                    //在sharedpreference保存改变
                    Toast.makeText(ActivityJun.this,"you have saved the change",Toast.LENGTH_LONG).show();
                    //显示“已经变化”
                    jun1=sharedpreferences.getString(JUNFirstthingtodo, "emailKey");
                    jun2=sharedpreferences.getString(JUNSecondthingtodo, "emailKey");
                    jun3=sharedpreferences.getString(JUNThirdthingtodo, "emailKey");
                    jun4=sharedpreferences.getString(JUNFourththingtodo, "emailKey");
                    jun5=sharedpreferences.getString(JUNFifththingtodo, "emailKey");
                    jun6=sharedpreferences.getString(JUNSixththingtodo, "emailKey");
                    juned1.setText(jun1);
                    juned2.setText(jun2);
                    juned3.setText(jun3);
                    juned4.setText(jun4);
                    juned5.setText(jun5);
                    juned6.setText(jun6);
                    //怎么按都显示正确的东西
                    saveChange.setChecked(true);
                    //“按钮已经关闭”
                } else {
                    saveChange.setChecked(false);
                    Toast.makeText(ActivityJun.this,"do not hesitate lol",Toast.LENGTH_LONG).show();
                }
            }
        });
        translatebutton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //initialize toggle button
                sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                //get sharedpreferences
                if (isChecked) {
                    String aug1=sharedpreferences.getString(JUNFirstthingtodo, "emailKey");
                    juneditString1 = juned1.getText().toString();
                    juneditString2 = juned2.getText().toString();
                    juneditString3 = juned3.getText().toString();
                    juneditString4 = juned4.getText().toString();
                    juneditString5 = juned5.getText().toString();
                    juneditString6 = juned6.getText().toString();
                    //save change in sharedpreference
                    try {
                        new Thread(juned1).execute(juneditString1);
                        new Thread(juned2).execute(juneditString2);
                        new Thread(juned3).execute(juneditString3);
                        new Thread(juned4).execute(juneditString4);
                        new Thread(juned5).execute(juneditString5);
                        new Thread(juned6).execute(juneditString6);
                    } catch (Exception e) {
                        //Log.d( "hi", e.toString());
                        juned1.setText("failed!");
                        juned2.setText("failed!");
                        juned3.setText("failed!");
                        juned4.setText("failed!");
                        juned5.setText("failed!");
                        juned6.setText("failed!");
                    }
                    Toast.makeText(ActivityJun.this,"you have saved the change",Toast.LENGTH_LONG).show();
                    //display the right text
                    translatebutton.setChecked(true);
                    //“button closed”
                } else {
                    translatebutton.setChecked(false);
                    Toast.makeText(ActivityJun.this,"do not hesitate lol",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
