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
public class ActivityMar extends AppCompatActivity {
    ToggleButton saveChange ;
    ToggleButton translatebutton;
    EditText mared1;
    EditText mared2;
    EditText mared3;
    EditText mared4;
    EditText mared5;
    EditText mared6;

    String mareditString1="";
    String mareditString2 = "";
    String mareditString3="";
    String mareditString4="";
    String mareditString5="";
    String mareditString6="";
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;
    public static final String MARFirstthingtodo = "Keymar";
    public static final String MARSecondthingtodo = "Keymar2";
    public static final String MARThirdthingtodo = "Keymar3";
    public static final String MARFourththingtodo = "Keymar4";
    public static final String MARFifththingtodo = "Keymar5";
    public static final String MARSixththingtodo = "Keymar6";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mar);//注意为“R.layout.activity_second”
        //the information above is used to show the main menu of marust page.
        saveChange = (ToggleButton)findViewById(R.id.MARSB);
        //this is the name of the button
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        //in this place I set my 主 preference, 即所有preference的合集 which is also the content we want to save
        mared1  = (EditText)findViewById(R.id.MAR1);
        mared2  = (EditText)findViewById(R.id.MAR2);
        mared3  = (EditText)findViewById(R.id.MAR3);
        mared4  = (EditText)findViewById(R.id.MAR4);
        mared5  = (EditText)findViewById(R.id.MAR5);
        mared6  = (EditText)findViewById(R.id.MAR6);
        //Then I try to give the 文本框 a variable (id)
        String mar1=sharedpreferences.getString(MARFirstthingtodo, "event 1");
        String mar2=sharedpreferences.getString(MARSecondthingtodo, "event 2");
        String mar3=sharedpreferences.getString(MARThirdthingtodo, "event 3");
        String mar4=sharedpreferences.getString(MARFourththingtodo, "event 4");
        String mar5=sharedpreferences.getString(MARFifththingtodo, "event 5");
        String mar6=sharedpreferences.getString(MARSixththingtodo, "event 6");

        //I set mar1 as the first thing to do, which is the same as the event I stored last time
        //！！！！！！！！！！！注意这里，我觉得最好的api调用方式是把日期写在defaultvalue这里， 即“emailkey”
        mared1.setText(mar1);
        mared2.setText(mar2);
        mared3.setText(mar3);
        mared4.setText(mar4);
        mared5.setText(mar5);
        mared6.setText(mar6);
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
                    String mar1=sharedpreferences.getString(MARFirstthingtodo, "emailKey");
                    String mar2=sharedpreferences.getString(MARSecondthingtodo, "emailKey");
                    String mar3=sharedpreferences.getString(MARThirdthingtodo, "emailKey");
                    String mar4=sharedpreferences.getString(MARFourththingtodo, "emailKey");
                    String mar5=sharedpreferences.getString(MARFifththingtodo, "emailKey");
                    String mar6=sharedpreferences.getString(MARSixththingtodo, "emailKey");
                    //这个不能删，必须先定义
                    mareditString1 = mared1.getText().toString();
                    mareditString2 = mared2.getText().toString();
                    mareditString3 = mared3.getText().toString();
                    mareditString4 = mared4.getText().toString();
                    mareditString5 = mared5.getText().toString();
                    mareditString6 = mared6.getText().toString();
                    editor.putString(MARFirstthingtodo, mareditString1);
                    editor.putString(MARSecondthingtodo, mareditString2);
                    editor.putString(MARThirdthingtodo, mareditString3);
                    editor.putString(MARFourththingtodo, mareditString4);
                    editor.putString(MARFifththingtodo, mareditString5);
                    editor.putString(MARSixththingtodo, mareditString6);

                    editor.apply();
                    //在sharedpreference保存改变
                    Toast.makeText(ActivityMar.this,"you have saved the change",Toast.LENGTH_LONG).show();
                    //显示“已经变化”
                    mar1=sharedpreferences.getString(MARFirstthingtodo, "emailKey");
                    mar2=sharedpreferences.getString(MARSecondthingtodo, "emailKey");
                    mar3=sharedpreferences.getString(MARThirdthingtodo, "emailKey");
                    mar4=sharedpreferences.getString(MARFourththingtodo, "emailKey");
                    mar5=sharedpreferences.getString(MARFifththingtodo, "emailKey");
                    mar6=sharedpreferences.getString(MARSixththingtodo, "emailKey");
                    mared1.setText(mar1);
                    mared2.setText(mar2);
                    mared3.setText(mar3);
                    mared4.setText(mar4);
                    mared5.setText(mar5);
                    mared6.setText(mar6);
                    //怎么按都显示正确的东西
                    saveChange.setChecked(true);
                    //“按钮已经关闭”
                } else {
                    saveChange.setChecked(false);
                    Toast.makeText(ActivityMar.this,"do not hesitate lol",Toast.LENGTH_LONG).show();
                }
            }
        });
        translatebutton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //initialize toggle button
                sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                //get sharedpreferences
                if (isChecked) {
                    String aug1=sharedpreferences.getString(MARFirstthingtodo, "emailKey");
                    mareditString1 = mared1.getText().toString();
                    //save change in sharedpreference
                    try {
                        new Thread(mared1).execute(mareditString1);
                        new Thread(mared2).execute(mareditString2);
                        new Thread(mared3).execute(mareditString3);
                        new Thread(mared4).execute(mareditString4);
                        new Thread(mared5).execute(mareditString5);
                        new Thread(mared6).execute(mareditString6);
                    } catch (Exception e) {
                        //Log.d( "hi", e.toString());
                        mared1.setText("failed!");
                        mared2.setText("failed!");
                        mared3.setText("failed!");
                        mared4.setText("failed!");
                        mared5.setText("failed!");
                        mared6.setText("failed!");
                    }
                    Toast.makeText(ActivityMar.this,"you have saved the change",Toast.LENGTH_LONG).show();
                    //display the right text
                    translatebutton.setChecked(true);
                    //“button closed”
                } else {
                    translatebutton.setChecked(false);
                    Toast.makeText(ActivityMar.this,"do not hesitate lol",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
