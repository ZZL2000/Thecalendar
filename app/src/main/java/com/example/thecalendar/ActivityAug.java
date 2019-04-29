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
public class ActivityAug extends AppCompatActivity {
    String AUG11;
    List<String> AUG;
    ToggleButton saveChange ;
    EditText ed;
    String editString="";
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;
    public static final String Firstthingtodo = "Key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aug);//注意为“R.layout.activity_second”
        //the information above is used to show the main menu of august page.
        saveChange = (ToggleButton)findViewById(R.id.AUGSB);
        //this is the name of the button
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        //in this place I set my 主 preference, 即所有preference的合集 which is also the content we want to save
        ed  = (EditText)findViewById(R.id.AUG1);
        //Then I try to give the 文本框 a variable (id)
        String aug1=sharedpreferences.getString(Firstthingtodo, "emailKey");
        //I set aug1 as the first thing to do, which is the same as the event I stored last time
        //！！！！！！！！！！！注意这里，我觉得最好的api调用方式是把日期写在defaultvalue这里， 即“emailkey”
        ed.setText(aug1);
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
                    String aug1=sharedpreferences.getString(Firstthingtodo, "emailKey");
                    //这个不能删，必须先定义
                    editString = ed.getText().toString();
                    editor.putString(Firstthingtodo, editString);
                    editor.apply();
                    //在sharedpreference保存改变
                    Toast.makeText(ActivityAug.this,"you have saved the change",Toast.LENGTH_LONG).show();
                    //显示“已经变化”
                    aug1=sharedpreferences.getString(Firstthingtodo, "emailKey");
                    ed.setText(aug1);
                    //怎么按都显示正确的东西
                    saveChange.setChecked(true);
                    //“按钮已经关闭”
                } else {
                    saveChange.setChecked(false);
                    Toast.makeText(ActivityAug.this,"do not hesitate lol",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
