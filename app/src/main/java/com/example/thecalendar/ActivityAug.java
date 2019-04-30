package com.example.thecalendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

/**
 * Created by zzl
 */
public class ActivityAug extends AppCompatActivity {
    ToggleButton saveChange ;
    ToggleButton translatebutton ;
    EditText ed1;
    EditText ed2;
    EditText ed3;
    EditText ed4;
    EditText ed5;
    EditText ed6;

    String editString1="";
    String editString2 = "";
    String editString3="";
    String editString4="";
    String editString5="";
    String editString6="";
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;
    public static final String AUGFirstthingtodo = "Key";
    public static final String AUGSecondthingtodo = "Key2";
    public static final String AUGThirdthingtodo = "Key3";
    public static final String AUGFourththingtodo = "Key4";
    public static final String AUGFifththingtodo = "Key5";
    public static final String AUGSixththingtodo = "Key6";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aug);//注意为“R.layout.activity_second”
        //the information above is used to show the main menu of august page.
        saveChange = (ToggleButton)findViewById(R.id.AUGSB);
        translatebutton = (ToggleButton)findViewById(R.id.AUGtranslate);
        //this is the name of the button
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        //in this place I set my 主 preference, 即所有preference的合集 which is also the content we want to save
        ed1  = (EditText)findViewById(R.id.AUG1);
        ed2  = (EditText)findViewById(R.id.AUG2);
        ed3  = (EditText)findViewById(R.id.AUG3);
        ed4  = (EditText)findViewById(R.id.AUG4);
        ed5  = (EditText)findViewById(R.id.AUG5);
        ed6  = (EditText)findViewById(R.id.AUG6);
        //Then I try to give the 文本框 a variable (id)
        String aug1=sharedpreferences.getString(AUGFirstthingtodo, "event 1");
        String aug2=sharedpreferences.getString(AUGSecondthingtodo, "event 2");
        String aug3=sharedpreferences.getString(AUGThirdthingtodo, "event 3");
        String aug4=sharedpreferences.getString(AUGFourththingtodo, "event 4");
        String aug5=sharedpreferences.getString(AUGFifththingtodo, "event 5");
        String aug6=sharedpreferences.getString(AUGSixththingtodo, "event 6");

        //I set aug1 as the first thing to do, which is the same as the event I stored last time
        //！！！！！！！！！！！注意这里，我觉得最好的api调用方式是把日期写在defaultvalue这里， 即“emailkey”
        ed1.setText(aug1);
        ed2.setText(aug2);
        ed3.setText(aug3);
        ed4.setText(aug4);
        ed5.setText(aug5);
        ed6.setText(aug6);
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
                    String aug1=sharedpreferences.getString(AUGFirstthingtodo, "emailKey");
                    String aug2=sharedpreferences.getString(AUGSecondthingtodo, "emailKey");
                    String aug3=sharedpreferences.getString(AUGThirdthingtodo, "emailKey");
                    String aug4=sharedpreferences.getString(AUGFourththingtodo, "emailKey");
                    String aug5=sharedpreferences.getString(AUGFifththingtodo, "emailKey");
                    String aug6=sharedpreferences.getString(AUGSixththingtodo, "emailKey");
                    //这个不能删，必须先定义
                    editString1 = ed1.getText().toString();
                    editString2 = ed2.getText().toString();
                    editString3 = ed3.getText().toString();
                    editString4 = ed4.getText().toString();
                    editString5 = ed5.getText().toString();
                    editString6 = ed6.getText().toString();
                    editor.putString(AUGFirstthingtodo, editString1);
                    editor.putString(AUGSecondthingtodo, editString2);
                    editor.putString(AUGThirdthingtodo, editString3);
                    editor.putString(AUGFourththingtodo, editString4);
                    editor.putString(AUGFifththingtodo, editString5);
                    editor.putString(AUGSixththingtodo, editString6);

                    editor.apply();
                    //在sharedpreference保存改变
                    Toast.makeText(ActivityAug.this,"you have saved the change",Toast.LENGTH_LONG).show();
                    //显示“已经变化”
                    aug1=sharedpreferences.getString(AUGFirstthingtodo, "emailKey");
                    aug2=sharedpreferences.getString(AUGSecondthingtodo, "emailKey");
                    aug3=sharedpreferences.getString(AUGThirdthingtodo, "emailKey");
                    aug4=sharedpreferences.getString(AUGFourththingtodo, "emailKey");
                    aug5=sharedpreferences.getString(AUGFifththingtodo, "emailKey");
                    aug6=sharedpreferences.getString(AUGSixththingtodo, "emailKey");
                    ed1.setText(aug1);
                    ed2.setText(aug2);
                    ed3.setText(aug3);
                    ed4.setText(aug4);
                    ed5.setText(aug5);
                    ed6.setText(aug6);
                    //怎么按都显示正确的东西
                    saveChange.setChecked(true);
                    //“按钮已经关闭”
                } else {
                    saveChange.setChecked(false);
                    Toast.makeText(ActivityAug.this,"do not hesitate lol",Toast.LENGTH_LONG).show();
                }
            }
        });
        translatebutton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //初始化toggle button
                sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                //获取sharedpreferences
                if (isChecked) {
                    String aug1=sharedpreferences.getString(AUGFirstthingtodo, "emailKey");
                    editString1 = ed1.getText().toString();
                    //在sharedpreference保存改变
                    try {
                        Translate translateRequest = new Translate();
                        String response = translateRequest.Post(aug1);
                        ed1.setText(response);
                    } catch (Exception e) {
                        System.out.println(e.toString());
                        ed1.setText("failed!");
                    }
                    Toast.makeText(ActivityAug.this,"you have saved the change",Toast.LENGTH_LONG).show();
                    //怎么按都显示正确的东西
                    translatebutton.setChecked(true);
                    //“按钮已经关闭”
                } else {
                    translatebutton.setChecked(false);
                    Toast.makeText(ActivityAug.this,"do not hesitate lol",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}