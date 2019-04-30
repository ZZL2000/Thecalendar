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
 */
public class ActivityMay extends AppCompatActivity {
    ToggleButton saveChange ;
    EditText mayed1;
    EditText mayed2;
    EditText mayed3;
    EditText mayed4;
    EditText mayed5;
    EditText mayed6;

    String mayeditString1="";
    String mayeditString2 = "";
    String mayeditString3="";
    String mayeditString4="";
    String mayeditString5="";
    String mayeditString6="";
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;
    public static final String MAYFirstthingtodo = "Keymay";
    public static final String MAYSecondthingtodo = "Keymay2";
    public static final String MAYThirdthingtodo = "Keymay3";
    public static final String MAYFourththingtodo = "Keymay4";
    public static final String MAYFifththingtodo = "Keymay5";
    public static final String MAYSixththingtodo = "Keymay6";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_may);//注意为“R.layout.activity_second”
        //the information above is used to show the main menu of mayust page.
        saveChange = (ToggleButton)findViewById(R.id.MAYSB);
        //this is the name of the button
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        //in this place I set my 主 preference, 即所有preference的合集 which is also the content we want to save
        mayed1  = (EditText)findViewById(R.id.MAY1);
        mayed2  = (EditText)findViewById(R.id.MAY2);
        mayed3  = (EditText)findViewById(R.id.MAY3);
        mayed4  = (EditText)findViewById(R.id.MAY4);
        mayed5  = (EditText)findViewById(R.id.MAY5);
        mayed6  = (EditText)findViewById(R.id.MAY6);
        //Then I try to give the 文本框 a variable (id)
        String may1=sharedpreferences.getString(MAYFirstthingtodo, "HE");
        String may2=sharedpreferences.getString(MAYSecondthingtodo, "HEY");
        String may3=sharedpreferences.getString(MAYThirdthingtodo, "HEYY");
        String may4=sharedpreferences.getString(MAYFourththingtodo, "HEYYY");
        String may5=sharedpreferences.getString(MAYFifththingtodo, "HEYYYY");
        String may6=sharedpreferences.getString(MAYSixththingtodo, "HEYYYYY");

        //I set may1 as the first thing to do, which is the same as the event I stored last time
        //！！！！！！！！！！！注意这里，我觉得最好的api调用方式是把日期写在defaultvalue这里， 即“emailkey”
        mayed1.setText(may1);
        mayed2.setText(may2);
        mayed3.setText(may3);
        mayed4.setText(may4);
        mayed5.setText(may5);
        mayed6.setText(may6);
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
                    String may1=sharedpreferences.getString(MAYFirstthingtodo, "emailKey");
                    String may2=sharedpreferences.getString(MAYSecondthingtodo, "emailKey");
                    String may3=sharedpreferences.getString(MAYThirdthingtodo, "emailKey");
                    String may4=sharedpreferences.getString(MAYFourththingtodo, "emailKey");
                    String may5=sharedpreferences.getString(MAYFifththingtodo, "emailKey");
                    String may6=sharedpreferences.getString(MAYSixththingtodo, "emailKey");
                    //这个不能删，必须先定义
                    mayeditString1 = mayed1.getText().toString();
                    mayeditString2 = mayed2.getText().toString();
                    mayeditString3 = mayed3.getText().toString();
                    mayeditString4 = mayed4.getText().toString();
                    mayeditString5 = mayed5.getText().toString();
                    mayeditString6 = mayed6.getText().toString();
                    editor.putString(MAYFirstthingtodo, mayeditString1);
                    editor.putString(MAYSecondthingtodo, mayeditString2);
                    editor.putString(MAYThirdthingtodo, mayeditString3);
                    editor.putString(MAYFourththingtodo, mayeditString4);
                    editor.putString(MAYFifththingtodo, mayeditString5);
                    editor.putString(MAYSixththingtodo, mayeditString6);

                    editor.apply();
                    //在sharedpreference保存改变
                    Toast.makeText(ActivityMay.this,"you have saved the change",Toast.LENGTH_LONG).show();
                    //显示“已经变化”
                    may1=sharedpreferences.getString(MAYFirstthingtodo, "emailKey");
                    may2=sharedpreferences.getString(MAYSecondthingtodo, "emailKey");
                    may3=sharedpreferences.getString(MAYThirdthingtodo, "emailKey");
                    may4=sharedpreferences.getString(MAYFourththingtodo, "emailKey");
                    may5=sharedpreferences.getString(MAYFifththingtodo, "emailKey");
                    may6=sharedpreferences.getString(MAYSixththingtodo, "emailKey");
                    mayed1.setText(may1);
                    mayed2.setText(may2);
                    mayed3.setText(may3);
                    mayed4.setText(may4);
                    mayed5.setText(may5);
                    mayed6.setText(may6);
                    //怎么按都显示正确的东西
                    saveChange.setChecked(true);
                    //“按钮已经关闭”
                } else {
                    saveChange.setChecked(false);
                    Toast.makeText(ActivityMay.this,"do not hesitate lol",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
