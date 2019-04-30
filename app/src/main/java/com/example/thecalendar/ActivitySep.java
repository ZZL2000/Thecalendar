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
public class ActivitySep extends AppCompatActivity {
    ToggleButton saveChange ;
    EditText seped1;
    EditText seped2;
    EditText seped3;
    EditText seped4;
    EditText seped5;
    EditText seped6;

    String sepeditString1="";
    String sepeditString2 = "";
    String sepeditString3="";
    String sepeditString4="";
    String sepeditString5="";
    String sepeditString6="";
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;
    public static final String SEPFirstthingtodo = "Keysep";
    public static final String SEPSecondthingtodo = "Keysep2";
    public static final String SEPThirdthingtodo = "Keysep3";
    public static final String SEPFourththingtodo = "Keysep4";
    public static final String SEPFifththingtodo = "Keysep5";
    public static final String SEPSixththingtodo = "Keysep6";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sep);//注意为“R.layout.activity_second”
        //the information above is used to show the main menu of sepust page.
        saveChange = (ToggleButton)findViewById(R.id.SEPSB);
        //this is the name of the button
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        //in this place I set my 主 preference, 即所有preference的合集 which is also the content we want to save
        seped1  = (EditText)findViewById(R.id.SEP1);
        seped2  = (EditText)findViewById(R.id.SEP2);
        seped3  = (EditText)findViewById(R.id.SEP3);
        seped4  = (EditText)findViewById(R.id.SEP4);
        seped5  = (EditText)findViewById(R.id.SEP5);
        seped6  = (EditText)findViewById(R.id.SEP6);
        //Then I try to give the 文本框 a variable (id)
        String sep1=sharedpreferences.getString(SEPFirstthingtodo, "HE");
        String sep2=sharedpreferences.getString(SEPSecondthingtodo, "HEY");
        String sep3=sharedpreferences.getString(SEPThirdthingtodo, "HEYY");
        String sep4=sharedpreferences.getString(SEPFourththingtodo, "HEYYY");
        String sep5=sharedpreferences.getString(SEPFifththingtodo, "HEYYYY");
        String sep6=sharedpreferences.getString(SEPSixththingtodo, "HEYYYYY");

        //I set sep1 as the first thing to do, which is the same as the event I stored last time
        //！！！！！！！！！！！注意这里，我觉得最好的api调用方式是把日期写在defaultvalue这里， 即“emailkey”
        seped1.setText(sep1);
        seped2.setText(sep2);
        seped3.setText(sep3);
        seped4.setText(sep4);
        seped5.setText(sep5);
        seped6.setText(sep6);
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
                    String sep1=sharedpreferences.getString(SEPFirstthingtodo, "emailKey");
                    String sep2=sharedpreferences.getString(SEPSecondthingtodo, "emailKey");
                    String sep3=sharedpreferences.getString(SEPThirdthingtodo, "emailKey");
                    String sep4=sharedpreferences.getString(SEPFourththingtodo, "emailKey");
                    String sep5=sharedpreferences.getString(SEPFifththingtodo, "emailKey");
                    String sep6=sharedpreferences.getString(SEPSixththingtodo, "emailKey");
                    //这个不能删，必须先定义
                    sepeditString1 = seped1.getText().toString();
                    sepeditString2 = seped2.getText().toString();
                    sepeditString3 = seped3.getText().toString();
                    sepeditString4 = seped4.getText().toString();
                    sepeditString5 = seped5.getText().toString();
                    sepeditString6 = seped6.getText().toString();
                    editor.putString(SEPFirstthingtodo, sepeditString1);
                    editor.putString(SEPSecondthingtodo, sepeditString2);
                    editor.putString(SEPThirdthingtodo, sepeditString3);
                    editor.putString(SEPFourththingtodo, sepeditString4);
                    editor.putString(SEPFifththingtodo, sepeditString5);
                    editor.putString(SEPSixththingtodo, sepeditString6);

                    editor.apply();
                    //在sharedpreference保存改变
                    Toast.makeText(ActivitySep.this,"you have saved the change",Toast.LENGTH_LONG).show();
                    //显示“已经变化”
                    sep1=sharedpreferences.getString(SEPFirstthingtodo, "emailKey");
                    sep2=sharedpreferences.getString(SEPSecondthingtodo, "emailKey");
                    sep3=sharedpreferences.getString(SEPThirdthingtodo, "emailKey");
                    sep4=sharedpreferences.getString(SEPFourththingtodo, "emailKey");
                    sep5=sharedpreferences.getString(SEPFifththingtodo, "emailKey");
                    sep6=sharedpreferences.getString(SEPSixththingtodo, "emailKey");
                    seped1.setText(sep1);
                    seped2.setText(sep2);
                    seped3.setText(sep3);
                    seped4.setText(sep4);
                    seped5.setText(sep5);
                    seped6.setText(sep6);
                    //怎么按都显示正确的东西
                    saveChange.setChecked(true);
                    //“按钮已经关闭”
                } else {
                    saveChange.setChecked(false);
                    Toast.makeText(ActivitySep.this,"do not hesitate lol",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
