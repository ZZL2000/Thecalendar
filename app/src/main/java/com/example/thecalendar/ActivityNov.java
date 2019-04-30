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
public class ActivityNov extends AppCompatActivity {
    ToggleButton saveChange ;
    EditText noved1;
    EditText noved2;
    EditText noved3;
    EditText noved4;
    EditText noved5;
    EditText noved6;

    String noveditString1="";
    String noveditString2 = "";
    String noveditString3="";
    String noveditString4="";
    String noveditString5="";
    String noveditString6="";
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;
    public static final String NOVFirstthingtodo = "Keynov";
    public static final String NOVSecondthingtodo = "Keynov2";
    public static final String NOVThirdthingtodo = "Keynov3";
    public static final String NOVFourththingtodo = "Keynov4";
    public static final String NOVFifththingtodo = "Keynov5";
    public static final String NOVSixththingtodo = "Keynov6";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nov);//注意为“R.layout.activity_second”
        //the information above is used to show the main menu of novust page.
        saveChange = (ToggleButton)findViewById(R.id.NOVSB);
        //this is the name of the button
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        //in this place I set my 主 preference, 即所有preference的合集 which is also the content we want to save
        noved1  = (EditText)findViewById(R.id.NOV1);
        noved2  = (EditText)findViewById(R.id.NOV2);
        noved3  = (EditText)findViewById(R.id.NOV3);
        noved4  = (EditText)findViewById(R.id.NOV4);
        noved5  = (EditText)findViewById(R.id.NOV5);
        noved6  = (EditText)findViewById(R.id.NOV6);
        //Then I try to give the 文本框 a variable (id)
        String nov1=sharedpreferences.getString(NOVFirstthingtodo, "HE");
        String nov2=sharedpreferences.getString(NOVSecondthingtodo, "HEY");
        String nov3=sharedpreferences.getString(NOVThirdthingtodo, "HEYY");
        String nov4=sharedpreferences.getString(NOVFourththingtodo, "HEYYY");
        String nov5=sharedpreferences.getString(NOVFifththingtodo, "HEYYYY");
        String nov6=sharedpreferences.getString(NOVSixththingtodo, "HEYYYYY");

        //I set nov1 as the first thing to do, which is the same as the event I stored last time
        //！！！！！！！！！！！注意这里，我觉得最好的api调用方式是把日期写在defaultvalue这里， 即“emailkey”
        noved1.setText(nov1);
        noved2.setText(nov2);
        noved3.setText(nov3);
        noved4.setText(nov4);
        noved5.setText(nov5);
        noved6.setText(nov6);
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
                    String nov1=sharedpreferences.getString(NOVFirstthingtodo, "emailKey");
                    String nov2=sharedpreferences.getString(NOVSecondthingtodo, "emailKey");
                    String nov3=sharedpreferences.getString(NOVThirdthingtodo, "emailKey");
                    String nov4=sharedpreferences.getString(NOVFourththingtodo, "emailKey");
                    String nov5=sharedpreferences.getString(NOVFifththingtodo, "emailKey");
                    String nov6=sharedpreferences.getString(NOVSixththingtodo, "emailKey");
                    //这个不能删，必须先定义
                    noveditString1 = noved1.getText().toString();
                    noveditString2 = noved2.getText().toString();
                    noveditString3 = noved3.getText().toString();
                    noveditString4 = noved4.getText().toString();
                    noveditString5 = noved5.getText().toString();
                    noveditString6 = noved6.getText().toString();
                    editor.putString(NOVFirstthingtodo, noveditString1);
                    editor.putString(NOVSecondthingtodo, noveditString2);
                    editor.putString(NOVThirdthingtodo, noveditString3);
                    editor.putString(NOVFourththingtodo, noveditString4);
                    editor.putString(NOVFifththingtodo, noveditString5);
                    editor.putString(NOVSixththingtodo, noveditString6);

                    editor.apply();
                    //在sharedpreference保存改变
                    Toast.makeText(ActivityNov.this,"you have saved the change",Toast.LENGTH_LONG).show();
                    //显示“已经变化”
                    nov1=sharedpreferences.getString(NOVFirstthingtodo, "emailKey");
                    nov2=sharedpreferences.getString(NOVSecondthingtodo, "emailKey");
                    nov3=sharedpreferences.getString(NOVThirdthingtodo, "emailKey");
                    nov4=sharedpreferences.getString(NOVFourththingtodo, "emailKey");
                    nov5=sharedpreferences.getString(NOVFifththingtodo, "emailKey");
                    nov6=sharedpreferences.getString(NOVSixththingtodo, "emailKey");
                    noved1.setText(nov1);
                    noved2.setText(nov2);
                    noved3.setText(nov3);
                    noved4.setText(nov4);
                    noved5.setText(nov5);
                    noved6.setText(nov6);
                    //怎么按都显示正确的东西
                    saveChange.setChecked(true);
                    //“按钮已经关闭”
                } else {
                    saveChange.setChecked(false);
                    Toast.makeText(ActivityNov.this,"do not hesitate lol",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
