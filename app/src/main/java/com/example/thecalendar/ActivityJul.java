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
public class ActivityJul extends AppCompatActivity {
    ToggleButton saveChange ;
    EditText juled1;
    EditText juled2;
    EditText juled3;
    EditText juled4;
    EditText juled5;
    EditText juled6;

    String juleditString1="";
    String juleditString2 = "";
    String juleditString3="";
    String juleditString4="";
    String juleditString5="";
    String juleditString6="";
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;
    public static final String JULFirstthingtodo = "Keyjul";
    public static final String JULSecondthingtodo = "Keyjul2";
    public static final String JULThirdthingtodo = "Keyjul3";
    public static final String JULFourththingtodo = "Keyjul4";
    public static final String JULFifththingtodo = "Keyjul5";
    public static final String JULSixththingtodo = "Keyjul6";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jul);//注意为“R.layout.activity_second”
        //the information above is used to show the main menu of julust page.
        saveChange = (ToggleButton)findViewById(R.id.JULSB);
        //this is the name of the button
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        //in this place I set my 主 preference, 即所有preference的合集 which is also the content we want to save
        juled1  = (EditText)findViewById(R.id.JUL1);
        juled2  = (EditText)findViewById(R.id.JUL2);
        juled3  = (EditText)findViewById(R.id.JUL3);
        juled4  = (EditText)findViewById(R.id.JUL4);
        juled5  = (EditText)findViewById(R.id.JUL5);
        juled6  = (EditText)findViewById(R.id.JUL6);
        //Then I try to give the 文本框 a variable (id)
        String jul1=sharedpreferences.getString(JULFirstthingtodo, "HE");
        String jul2=sharedpreferences.getString(JULSecondthingtodo, "HEY");
        String jul3=sharedpreferences.getString(JULThirdthingtodo, "HEYY");
        String jul4=sharedpreferences.getString(JULFourththingtodo, "HEYYY");
        String jul5=sharedpreferences.getString(JULFifththingtodo, "HEYYYY");
        String jul6=sharedpreferences.getString(JULSixththingtodo, "HEYYYYY");

        //I set jul1 as the first thing to do, which is the same as the event I stored last time
        //！！！！！！！！！！！注意这里，我觉得最好的api调用方式是把日期写在defaultvalue这里， 即“emailkey”
        juled1.setText(jul1);
        juled2.setText(jul2);
        juled3.setText(jul3);
        juled4.setText(jul4);
        juled5.setText(jul5);
        juled6.setText(jul6);
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
                    String jul1=sharedpreferences.getString(JULFirstthingtodo, "emailKey");
                    String jul2=sharedpreferences.getString(JULSecondthingtodo, "emailKey");
                    String jul3=sharedpreferences.getString(JULThirdthingtodo, "emailKey");
                    String jul4=sharedpreferences.getString(JULFourththingtodo, "emailKey");
                    String jul5=sharedpreferences.getString(JULFifththingtodo, "emailKey");
                    String jul6=sharedpreferences.getString(JULSixththingtodo, "emailKey");
                    //这个不能删，必须先定义
                    juleditString1 = juled1.getText().toString();
                    juleditString2 = juled2.getText().toString();
                    juleditString3 = juled3.getText().toString();
                    juleditString4 = juled4.getText().toString();
                    juleditString5 = juled5.getText().toString();
                    juleditString6 = juled6.getText().toString();
                    editor.putString(JULFirstthingtodo, juleditString1);
                    editor.putString(JULSecondthingtodo, juleditString2);
                    editor.putString(JULThirdthingtodo, juleditString3);
                    editor.putString(JULFourththingtodo, juleditString4);
                    editor.putString(JULFifththingtodo, juleditString5);
                    editor.putString(JULSixththingtodo, juleditString6);

                    editor.apply();
                    //在sharedpreference保存改变
                    Toast.makeText(ActivityJul.this,"you have saved the change",Toast.LENGTH_LONG).show();
                    //显示“已经变化”
                    jul1=sharedpreferences.getString(JULFirstthingtodo, "emailKey");
                    jul2=sharedpreferences.getString(JULSecondthingtodo, "emailKey");
                    jul3=sharedpreferences.getString(JULThirdthingtodo, "emailKey");
                    jul4=sharedpreferences.getString(JULFourththingtodo, "emailKey");
                    jul5=sharedpreferences.getString(JULFifththingtodo, "emailKey");
                    jul6=sharedpreferences.getString(JULSixththingtodo, "emailKey");
                    juled1.setText(jul1);
                    juled2.setText(jul2);
                    juled3.setText(jul3);
                    juled4.setText(jul4);
                    juled5.setText(jul5);
                    juled6.setText(jul6);
                    //怎么按都显示正确的东西
                    saveChange.setChecked(true);
                    //“按钮已经关闭”
                } else {
                    saveChange.setChecked(false);
                    Toast.makeText(ActivityJul.this,"do not hesitate lol",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
