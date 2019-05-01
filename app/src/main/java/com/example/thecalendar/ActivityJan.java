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
public class ActivityJan extends AppCompatActivity {
    ToggleButton saveChange ;
    ToggleButton translatebutton;
    EditText janed1;
    EditText janed2;
    EditText janed3;
    EditText janed4;
    EditText janed5;
    EditText janed6;

    String janeditString1="";
    String janeditString2 = "";
    String janeditString3="";
    String janeditString4="";
    String janeditString5="";
    String janeditString6="";
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;
    public static final String JANFirstthingtodo = "Keyjan";
    public static final String JANSecondthingtodo = "Keyjan2";
    public static final String JANThirdthingtodo = "Keyjan3";
    public static final String JANFourththingtodo = "Keyjan4";
    public static final String JANFifththingtodo = "Keyjan5";
    public static final String JANSixththingtodo = "Keyjan6";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jan);//注意为“R.layout.activity_second”
        //the information above is used to show the main menu of janust page.
        saveChange = (ToggleButton)findViewById(R.id.JANSB);
        //this is the name of the button
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        //in this place I set my 主 preference, 即所有preference的合集 which is also the content we want to save
        janed1  = (EditText)findViewById(R.id.JAN1);
        janed2  = (EditText)findViewById(R.id.JAN2);
        janed3  = (EditText)findViewById(R.id.JAN3);
        janed4  = (EditText)findViewById(R.id.JAN4);
        janed5  = (EditText)findViewById(R.id.JAN5);
        janed6  = (EditText)findViewById(R.id.JAN6);
        //Then I try to give the 文本框 a variable (id)
        String jan1=sharedpreferences.getString(JANFirstthingtodo, "event 1");
        String jan2=sharedpreferences.getString(JANSecondthingtodo, "event 2");
        String jan3=sharedpreferences.getString(JANThirdthingtodo, "event 3");
        String jan4=sharedpreferences.getString(JANFourththingtodo, "event 4");
        String jan5=sharedpreferences.getString(JANFifththingtodo, "event 5");
        String jan6=sharedpreferences.getString(JANSixththingtodo, "event 6");

        //I set jan1 as the first thing to do, which is the same as the event I stored last time
        //！！！！！！！！！！！注意这里，我觉得最好的api调用方式是把日期写在defaultvalue这里， 即“emailkey”
        janed1.setText(jan1);
        janed2.setText(jan2);
        janed3.setText(jan3);
        janed4.setText(jan4);
        janed5.setText(jan5);
        janed6.setText(jan6);
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
                    String jan1=sharedpreferences.getString(JANFirstthingtodo, "emailKey");
                    String jan2=sharedpreferences.getString(JANSecondthingtodo, "emailKey");
                    String jan3=sharedpreferences.getString(JANThirdthingtodo, "emailKey");
                    String jan4=sharedpreferences.getString(JANFourththingtodo, "emailKey");
                    String jan5=sharedpreferences.getString(JANFifththingtodo, "emailKey");
                    String jan6=sharedpreferences.getString(JANSixththingtodo, "emailKey");
                    //这个不能删，必须先定义
                    janeditString1 = janed1.getText().toString();
                    janeditString2 = janed2.getText().toString();
                    janeditString3 = janed3.getText().toString();
                    janeditString4 = janed4.getText().toString();
                    janeditString5 = janed5.getText().toString();
                    janeditString6 = janed6.getText().toString();
                    editor.putString(JANFirstthingtodo, janeditString1);
                    editor.putString(JANSecondthingtodo, janeditString2);
                    editor.putString(JANThirdthingtodo, janeditString3);
                    editor.putString(JANFourththingtodo, janeditString4);
                    editor.putString(JANFifththingtodo, janeditString5);
                    editor.putString(JANSixththingtodo, janeditString6);

                    editor.apply();
                    //在sharedpreference保存改变
                    Toast.makeText(ActivityJan.this,"you have saved the change",Toast.LENGTH_LONG).show();
                    //显示“已经变化”
                    jan1=sharedpreferences.getString(JANFirstthingtodo, "emailKey");
                    jan2=sharedpreferences.getString(JANSecondthingtodo, "emailKey");
                    jan3=sharedpreferences.getString(JANThirdthingtodo, "emailKey");
                    jan4=sharedpreferences.getString(JANFourththingtodo, "emailKey");
                    jan5=sharedpreferences.getString(JANFifththingtodo, "emailKey");
                    jan6=sharedpreferences.getString(JANSixththingtodo, "emailKey");
                    janed1.setText(jan1);
                    janed2.setText(jan2);
                    janed3.setText(jan3);
                    janed4.setText(jan4);
                    janed5.setText(jan5);
                    janed6.setText(jan6);
                    //怎么按都显示正确的东西
                    saveChange.setChecked(true);
                    //“按钮已经关闭”
                } else {
                    saveChange.setChecked(false);
                    Toast.makeText(ActivityJan.this,"do not hesitate lol",Toast.LENGTH_LONG).show();
                }
            }
        });
        translatebutton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //initialize toggle button
                sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                //get sharedpreferences
                if (isChecked) {
                    String aug1=sharedpreferences.getString(JANFirstthingtodo, "emailKey");
                    janeditString1 = janed1.getText().toString();
                    //save change in sharedpreference
                    try {
                        new Thread(janed1).execute(janeditString1);
                        new Thread(janed2).execute(janeditString2);
                        new Thread(janed3).execute(janeditString3);
                        new Thread(janed4).execute(janeditString4);
                        new Thread(janed5).execute(janeditString5);
                        new Thread(janed6).execute(janeditString6);
                    } catch (Exception e) {
                        //Log.d( "hi", e.toString());
                        janed1.setText("failed!");
                        janed2.setText("failed!");
                        janed3.setText("failed!");
                        janed4.setText("failed!");
                        janed5.setText("failed!");
                        janed6.setText("failed!");
                    }
                    Toast.makeText(ActivityJan.this,"you have saved the change",Toast.LENGTH_LONG).show();
                    //display the right text
                    translatebutton.setChecked(true);
                    //“button closed”
                } else {
                    translatebutton.setChecked(false);
                    Toast.makeText(ActivityJan.this,"do not hesitate lol",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
