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
public class ActivityFeb extends AppCompatActivity {
    ToggleButton saveChange ;
    ToggleButton translatebutton;
    EditText febed1;
    EditText febed2;
    EditText febed3;
    EditText febed4;
    EditText febed5;
    EditText febed6;

    String febeditString1="";
    String febeditString2 = "";
    String febeditString3="";
    String febeditString4="";
    String febeditString5="";
    String febeditString6="";
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;
    public static final String FEBFirstthingtodo = "Keyfeb";
    public static final String FEBSecondthingtodo = "Keyfeb2";
    public static final String FEBThirdthingtodo = "Keyfeb3";
    public static final String FEBFourththingtodo = "Keyfeb4";
    public static final String FEBFifththingtodo = "Keyfeb5";
    public static final String FEBSixththingtodo = "Keyfeb6";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feb);//注意为“R.layout.activity_second”
        //the information above is used to show the main menu of febust page.
        saveChange = (ToggleButton)findViewById(R.id.FEBSB);
        //this is the name of the button
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        //in this place I set my 主 preference, 即所有preference的合集 which is also the content we want to save
        febed1  = (EditText)findViewById(R.id.FEB1);
        febed2  = (EditText)findViewById(R.id.FEB2);
        febed3  = (EditText)findViewById(R.id.FEB3);
        febed4  = (EditText)findViewById(R.id.FEB4);
        febed5  = (EditText)findViewById(R.id.FEB5);
        febed6  = (EditText)findViewById(R.id.FEB6);
        //Then I try to give the 文本框 a variable (id)
        String feb1=sharedpreferences.getString(FEBFirstthingtodo, "event1");
        String feb2=sharedpreferences.getString(FEBSecondthingtodo, "event 2");
        String feb3=sharedpreferences.getString(FEBThirdthingtodo, "event 3");
        String feb4=sharedpreferences.getString(FEBFourththingtodo, "event 4");
        String feb5=sharedpreferences.getString(FEBFifththingtodo, "event 5");
        String feb6=sharedpreferences.getString(FEBSixththingtodo, "event 6");

        //I set feb1 as the first thing to do, which is the same as the event I stored last time
        //！！！！！！！！！！！注意这里，我觉得最好的api调用方式是把日期写在defaultvalue这里， 即“emailkey”
        febed1.setText(feb1);
        febed2.setText(feb2);
        febed3.setText(feb3);
        febed4.setText(feb4);
        febed5.setText(feb5);
        febed6.setText(feb6);
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
                    String feb1=sharedpreferences.getString(FEBFirstthingtodo, "emailKey");
                    String feb2=sharedpreferences.getString(FEBSecondthingtodo, "emailKey");
                    String feb3=sharedpreferences.getString(FEBThirdthingtodo, "emailKey");
                    String feb4=sharedpreferences.getString(FEBFourththingtodo, "emailKey");
                    String feb5=sharedpreferences.getString(FEBFifththingtodo, "emailKey");
                    String feb6=sharedpreferences.getString(FEBSixththingtodo, "emailKey");
                    //这个不能删，必须先定义
                    febeditString1 = febed1.getText().toString();
                    febeditString2 = febed2.getText().toString();
                    febeditString3 = febed3.getText().toString();
                    febeditString4 = febed4.getText().toString();
                    febeditString5 = febed5.getText().toString();
                    febeditString6 = febed6.getText().toString();
                    editor.putString(FEBFirstthingtodo, febeditString1);
                    editor.putString(FEBSecondthingtodo, febeditString2);
                    editor.putString(FEBThirdthingtodo, febeditString3);
                    editor.putString(FEBFourththingtodo, febeditString4);
                    editor.putString(FEBFifththingtodo, febeditString5);
                    editor.putString(FEBSixththingtodo, febeditString6);

                    editor.apply();
                    //在sharedpreference保存改变
                    Toast.makeText(ActivityFeb.this,"you have saved the change",Toast.LENGTH_LONG).show();
                    //显示“已经变化”
                    feb1=sharedpreferences.getString(FEBFirstthingtodo, "emailKey");
                    feb2=sharedpreferences.getString(FEBSecondthingtodo, "emailKey");
                    feb3=sharedpreferences.getString(FEBThirdthingtodo, "emailKey");
                    feb4=sharedpreferences.getString(FEBFourththingtodo, "emailKey");
                    feb5=sharedpreferences.getString(FEBFifththingtodo, "emailKey");
                    feb6=sharedpreferences.getString(FEBSixththingtodo, "emailKey");
                    febed1.setText(feb1);
                    febed2.setText(feb2);
                    febed3.setText(feb3);
                    febed4.setText(feb4);
                    febed5.setText(feb5);
                    febed6.setText(feb6);
                    //怎么按都显示正确的东西
                    saveChange.setChecked(true);
                    //“按钮已经关闭”
                } else {
                    saveChange.setChecked(false);
                    Toast.makeText(ActivityFeb.this,"do not hesitate lol",Toast.LENGTH_LONG).show();
                }
            }
        });
        translatebutton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //initialize toggle button
                sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                //get sharedpreferences
                if (isChecked) {
                    String aug1=sharedpreferences.getString(FEBFirstthingtodo, "emailKey");
                    febeditString1 = febed1.getText().toString();
                    //save change in sharedpreference
                    try {
                        new Thread(febed1).execute(febeditString1);
                        new Thread(febed2).execute(febeditString2);
                        new Thread(febed3).execute(febeditString3);
                        new Thread(febed4).execute(febeditString4);
                        new Thread(febed5).execute(febeditString5);
                        new Thread(febed6).execute(febeditString6);
                    } catch (Exception e) {
                        //Log.d( "hi", e.toString());
                        febed1.setText("failed!");
                        febed2.setText("failed!");
                        febed3.setText("failed!");
                        febed4.setText("failed!");
                        febed5.setText("failed!");
                        febed6.setText("failed!");
                    }
                    Toast.makeText(ActivityFeb.this,"you have saved the change",Toast.LENGTH_LONG).show();
                    //display the right text
                    translatebutton.setChecked(true);
                    //“button closed”
                } else {
                    translatebutton.setChecked(false);
                    Toast.makeText(ActivityFeb.this,"do not hesitate lol",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
