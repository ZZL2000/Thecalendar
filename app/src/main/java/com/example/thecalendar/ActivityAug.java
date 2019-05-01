package com.example.thecalendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

/**
 * Created by zzl
 * Modified by Xiaohan. Note : this is the initial monthly activity we started to work with.
 * Detailed java docs and comments are only given in this activity.
 * Other monthly activities follow the same pattern as this one. (Basically copy-paste with only minor changes been made)
 */
public class ActivityAug extends AppCompatActivity {
    //two toggle buttons, one to save changed text, one to translate current text
    ToggleButton saveChange ;
    ToggleButton translatebutton ;
    //EditTexts to store the events in each month
    EditText ed1;
    EditText ed2;
    EditText ed3;
    EditText ed4;
    EditText ed5;
    EditText ed6;
    //Strings to store the events, one for each EditText.
    String editString1="";
    String editString2= "";
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
        //in this place I set my main preference, aka the set of all preferences which is also the content we want to save
        ed1  = (EditText)findViewById(R.id.AUG1);
        ed2  = (EditText)findViewById(R.id.AUG2);
        ed3  = (EditText)findViewById(R.id.AUG3);
        ed4  = (EditText)findViewById(R.id.AUG4);
        ed5  = (EditText)findViewById(R.id.AUG5);
        ed6  = (EditText)findViewById(R.id.AUG6);
        //Then I try to give the TextView a variable (id)
        String aug1=sharedpreferences.getString(AUGFirstthingtodo, "event 1");
        String aug2=sharedpreferences.getString(AUGSecondthingtodo, "event 2");
        String aug3=sharedpreferences.getString(AUGThirdthingtodo, "event 3");
        String aug4=sharedpreferences.getString(AUGFourththingtodo, "event 4");
        String aug5=sharedpreferences.getString(AUGFifththingtodo, "event 5");
        String aug6=sharedpreferences.getString(AUGSixththingtodo, "event 6");

        //I set aug1 as the first thing to do, which is the same as the event I stored last time
        ed1.setText(aug1);
        ed2.setText(aug2);
        ed3.setText(aug3);
        ed4.setText(aug4);
        ed5.setText(aug5);
        ed6.setText(aug6);
        // Text is equal to the first saved event
        saveChange.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            //begin button
            SharedPreferences.Editor editor = sharedpreferences.edit();
            //initialize sharedpreference
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //initialize toggle button
                sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                //get sharedpreferences
                if (isChecked) {
                    String aug1=sharedpreferences.getString(AUGFirstthingtodo, "emailKey");
                    String aug2=sharedpreferences.getString(AUGSecondthingtodo, "emailKey");
                    String aug3=sharedpreferences.getString(AUGThirdthingtodo, "emailKey");
                    String aug4=sharedpreferences.getString(AUGFourththingtodo, "emailKey");
                    String aug5=sharedpreferences.getString(AUGFifththingtodo, "emailKey");
                    String aug6=sharedpreferences.getString(AUGSixththingtodo, "emailKey");
                    //this can't be deleted, must be defined first
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
                    //save change in sharedpreference
                    Toast.makeText(ActivityAug.this,"you have saved the change",Toast.LENGTH_LONG).show();
                    //display “changed”
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
                    //display the right text
                    saveChange.setChecked(true);
                    //“button closed”
                } else {
                    saveChange.setChecked(false);
                    Toast.makeText(ActivityAug.this,"do not hesitate lol",Toast.LENGTH_LONG).show();
                }
            }
        });
        translatebutton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //initialize toggle button
                sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                //get sharedpreferences
                if (isChecked) {
                    String aug1=sharedpreferences.getString(AUGFirstthingtodo, "emailKey");
                    editString1 = ed1.getText().toString();
                    //save change in sharedpreference
                    try {
                        new Thread(ed1).execute(editString1);
                        new Thread(ed2).execute(editString2);
                        new Thread(ed3).execute(editString3);
                        new Thread(ed4).execute(editString4);
                        new Thread(ed5).execute(editString5);
                        new Thread(ed6).execute(editString6);
                    } catch (Exception e) {
                        //Log.d( "hi", e.toString());
                        ed1.setText("failed!");
                        ed2.setText("failed!");
                        ed3.setText("failed!");
                        ed4.setText("failed!");
                        ed5.setText("failed!");
                        ed6.setText("failed!");
                    }
                    Toast.makeText(ActivityAug.this,"you have saved the change",Toast.LENGTH_LONG).show();
                    //display the right text
                    translatebutton.setChecked(true);
                    //“button closed”
                } else {
                    translatebutton.setChecked(false);
                    Toast.makeText(ActivityAug.this,"do not hesitate lol",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}