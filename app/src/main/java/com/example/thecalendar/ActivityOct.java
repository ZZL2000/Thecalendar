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
 * Modified  by Xiaohan
 */
public class ActivityOct extends AppCompatActivity {
    ToggleButton saveChange ;
    ToggleButton translatebutton;
    EditText octed1;
    EditText octed2;
    EditText octed3;
    EditText octed4;
    EditText octed5;
    EditText octed6;

    String octeditString1="";
    String octeditString2 = "";
    String octeditString3="";
    String octeditString4="";
    String octeditString5="";
    String octeditString6="";
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;
    public static final String OCTFirstthingtodo = "Keyoct";
    public static final String OCTSecondthingtodo = "Keyoct2";
    public static final String OCTThirdthingtodo = "Keyoct3";
    public static final String OCTFourththingtodo = "Keyoct4";
    public static final String OCTFifththingtodo = "Keyoct5";
    public static final String OCTSixththingtodo = "Keyoct6";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oct);//注意为“R.layout.activity_second”
        //the information above is used to show the main menu of octust page.
        saveChange = (ToggleButton)findViewById(R.id.OCTSB);
        //this is the name of the button
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        //in this place I set my 主 preference, 即所有preference的合集 which is also the content we want to save
        octed1  = (EditText)findViewById(R.id.OCT1);
        octed2  = (EditText)findViewById(R.id.OCT2);
        octed3  = (EditText)findViewById(R.id.OCT3);
        octed4  = (EditText)findViewById(R.id.OCT4);
        octed5  = (EditText)findViewById(R.id.OCT5);
        octed6  = (EditText)findViewById(R.id.OCT6);
        //Then I try to give the 文本框 a variable (id)
        String oct1=sharedpreferences.getString(OCTFirstthingtodo, "event 1");
        String oct2=sharedpreferences.getString(OCTSecondthingtodo, "event 2");
        String oct3=sharedpreferences.getString(OCTThirdthingtodo, "event 3");
        String oct4=sharedpreferences.getString(OCTFourththingtodo, "event 4");
        String oct5=sharedpreferences.getString(OCTFifththingtodo, "event 5");
        String oct6=sharedpreferences.getString(OCTSixththingtodo, "event 6");

        //I set oct1 as the first thing to do, which is the same as the event I stored last time
        //！！！！！！！！！！！注意这里，我觉得最好的api调用方式是把日期写在defaultvalue这里， 即“emailkey”
        octed1.setText(oct1);
        octed2.setText(oct2);
        octed3.setText(oct3);
        octed4.setText(oct4);
        octed5.setText(oct5);
        octed6.setText(oct6);
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
                    String oct1=sharedpreferences.getString(OCTFirstthingtodo, "emailKey");
                    String oct2=sharedpreferences.getString(OCTSecondthingtodo, "emailKey");
                    String oct3=sharedpreferences.getString(OCTThirdthingtodo, "emailKey");
                    String oct4=sharedpreferences.getString(OCTFourththingtodo, "emailKey");
                    String oct5=sharedpreferences.getString(OCTFifththingtodo, "emailKey");
                    String oct6=sharedpreferences.getString(OCTSixththingtodo, "emailKey");
                    //这个不能删，必须先定义
                    octeditString1 = octed1.getText().toString();
                    octeditString2 = octed2.getText().toString();
                    octeditString3 = octed3.getText().toString();
                    octeditString4 = octed4.getText().toString();
                    octeditString5 = octed5.getText().toString();
                    octeditString6 = octed6.getText().toString();
                    editor.putString(OCTFirstthingtodo, octeditString1);
                    editor.putString(OCTSecondthingtodo, octeditString2);
                    editor.putString(OCTThirdthingtodo, octeditString3);
                    editor.putString(OCTFourththingtodo, octeditString4);
                    editor.putString(OCTFifththingtodo, octeditString5);
                    editor.putString(OCTSixththingtodo, octeditString6);

                    editor.apply();
                    //在sharedpreference保存改变
                    Toast.makeText(ActivityOct.this,"you have saved the change",Toast.LENGTH_LONG).show();
                    //显示“已经变化”
                    oct1=sharedpreferences.getString(OCTFirstthingtodo, "emailKey");
                    oct2=sharedpreferences.getString(OCTSecondthingtodo, "emailKey");
                    oct3=sharedpreferences.getString(OCTThirdthingtodo, "emailKey");
                    oct4=sharedpreferences.getString(OCTFourththingtodo, "emailKey");
                    oct5=sharedpreferences.getString(OCTFifththingtodo, "emailKey");
                    oct6=sharedpreferences.getString(OCTSixththingtodo, "emailKey");
                    octed1.setText(oct1);
                    octed2.setText(oct2);
                    octed3.setText(oct3);
                    octed4.setText(oct4);
                    octed5.setText(oct5);
                    octed6.setText(oct6);
                    //怎么按都显示正确的东西
                    saveChange.setChecked(true);
                    //“按钮已经关闭”
                } else {
                    saveChange.setChecked(false);
                    Toast.makeText(ActivityOct.this,"do not hesitate lol",Toast.LENGTH_LONG).show();
                }
            }
        });
        translatebutton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //initialize toggle button
                sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                //get sharedpreferences
                if (isChecked) {
                    String aug1=sharedpreferences.getString(OCTFirstthingtodo, "emailKey");
                    octeditString1 = octed1.getText().toString();
                    //save change in sharedpreference
                    try {
                        new Thread(octed1).execute(octeditString1);
                        new Thread(octed2).execute(octeditString2);
                        new Thread(octed3).execute(octeditString3);
                        new Thread(octed4).execute(octeditString4);
                        new Thread(octed5).execute(octeditString5);
                        new Thread(octed6).execute(octeditString6);
                    } catch (Exception e) {
                        //Log.d( "hi", e.toString());
                        octed1.setText("failed!");
                        octed2.setText("failed!");
                        octed3.setText("failed!");
                        octed4.setText("failed!");
                        octed5.setText("failed!");
                        octed6.setText("failed!");
                    }
                    Toast.makeText(ActivityOct.this,"you have saved the change",Toast.LENGTH_LONG).show();
                    //display the right text
                    translatebutton.setChecked(true);
                    //“button closed”
                } else {
                    translatebutton.setChecked(false);
                    Toast.makeText(ActivityOct.this,"do not hesitate lol",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
