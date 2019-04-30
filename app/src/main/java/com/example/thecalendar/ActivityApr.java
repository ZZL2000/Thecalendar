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
public class ActivityApr extends AppCompatActivity {
    ToggleButton saveChange ;
    EditText apred1;
    EditText apred2;
    EditText apred3;
    EditText apred4;
    EditText apred5;
    EditText apred6;

    String apreditString1="";
    String apreditString2 = "";
    String apreditString3="";
    String apreditString4="";
    String apreditString5="";
    String apreditString6="";
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;
    public static final String APRFirstthingtodo = "Keyapr";
    public static final String APRSecondthingtodo = "Keyapr2";
    public static final String APRThirdthingtodo = "Keyapr3";
    public static final String APRFourththingtodo = "Keyapr4";
    public static final String APRFifththingtodo = "Keyapr5";
    public static final String APRSixththingtodo = "Keyapr6";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apr);//注意为“R.layout.activity_second”
        //the information above is used to show the main menu of aprust page.
        saveChange = (ToggleButton)findViewById(R.id.APRSB);
        //this is the name of the button
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        //in this place I set my 主 preference, 即所有preference的合集 which is also the content we want to save
        apred1  = (EditText)findViewById(R.id.APR1);
        apred2  = (EditText)findViewById(R.id.APR2);
        apred3  = (EditText)findViewById(R.id.APR3);
        apred4  = (EditText)findViewById(R.id.APR4);
        apred5  = (EditText)findViewById(R.id.APR5);
        apred6  = (EditText)findViewById(R.id.APR6);
        //Then I try to give the 文本框 a variable (id)
        String apr1=sharedpreferences.getString(APRFirstthingtodo, "HE");
        String apr2=sharedpreferences.getString(APRSecondthingtodo, "HEY");
        String apr3=sharedpreferences.getString(APRThirdthingtodo, "HEYY");
        String apr4=sharedpreferences.getString(APRFourththingtodo, "HEYYY");
        String apr5=sharedpreferences.getString(APRFifththingtodo, "HEYYYY");
        String apr6=sharedpreferences.getString(APRSixththingtodo, "HEYYYYY");

        //I set apr1 as the first thing to do, which is the same as the event I stored last time
        //！！！！！！！！！！！注意这里，我觉得最好的api调用方式是把日期写在defaultvalue这里， 即“emailkey”
        apred1.setText(apr1);
        apred2.setText(apr2);
        apred3.setText(apr3);
        apred4.setText(apr4);
        apred5.setText(apr5);
        apred6.setText(apr6);
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
                    String apr1=sharedpreferences.getString(APRFirstthingtodo, "emailKey");
                    String apr2=sharedpreferences.getString(APRSecondthingtodo, "emailKey");
                    String apr3=sharedpreferences.getString(APRThirdthingtodo, "emailKey");
                    String apr4=sharedpreferences.getString(APRFourththingtodo, "emailKey");
                    String apr5=sharedpreferences.getString(APRFifththingtodo, "emailKey");
                    String apr6=sharedpreferences.getString(APRSixththingtodo, "emailKey");
                    //这个不能删，必须先定义
                    apreditString1 = apred1.getText().toString();
                    apreditString2 = apred2.getText().toString();
                    apreditString3 = apred3.getText().toString();
                    apreditString4 = apred4.getText().toString();
                    apreditString5 = apred5.getText().toString();
                    apreditString6 = apred6.getText().toString();
                    editor.putString(APRFirstthingtodo, apreditString1);
                    editor.putString(APRSecondthingtodo, apreditString2);
                    editor.putString(APRThirdthingtodo, apreditString3);
                    editor.putString(APRFourththingtodo, apreditString4);
                    editor.putString(APRFifththingtodo, apreditString5);
                    editor.putString(APRSixththingtodo, apreditString6);

                    editor.apply();
                    //在sharedpreference保存改变
                    Toast.makeText(ActivityApr.this,"you have saved the change",Toast.LENGTH_LONG).show();
                    //显示“已经变化”
                    apr1=sharedpreferences.getString(APRFirstthingtodo, "emailKey");
                    apr2=sharedpreferences.getString(APRSecondthingtodo, "emailKey");
                    apr3=sharedpreferences.getString(APRThirdthingtodo, "emailKey");
                    apr4=sharedpreferences.getString(APRFourththingtodo, "emailKey");
                    apr5=sharedpreferences.getString(APRFifththingtodo, "emailKey");
                    apr6=sharedpreferences.getString(APRSixththingtodo, "emailKey");
                    apred1.setText(apr1);
                    apred2.setText(apr2);
                    apred3.setText(apr3);
                    apred4.setText(apr4);
                    apred5.setText(apr5);
                    apred6.setText(apr6);
                    //怎么按都显示正确的东西
                    saveChange.setChecked(true);
                    //“按钮已经关闭”
                } else {
                    saveChange.setChecked(false);
                    Toast.makeText(ActivityApr.this,"do not hesitate lol",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
