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
 * Modified by Xiaohan
 */
public class ActivityApr extends AppCompatActivity {
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
        //the information above is used to show the main menu of august page.
        saveChange = (ToggleButton)findViewById(R.id.APRSB);
        translatebutton = (ToggleButton)findViewById(R.id.APRtranslate);
        //this is the name of the button
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        //in this place I set my main preference, aka the set of all preferences which is also the content we want to save
        ed1  = (EditText)findViewById(R.id.APR1);
        ed2  = (EditText)findViewById(R.id.APR2);
        ed3  = (EditText)findViewById(R.id.APR3);
        ed4  = (EditText)findViewById(R.id.APR4);
        ed5  = (EditText)findViewById(R.id.APR5);
        ed6  = (EditText)findViewById(R.id.APR6);
        //Then I try to give the TextView a variable (id)
        String apr1=sharedpreferences.getString(APRFirstthingtodo, "event 1");
        String apr2=sharedpreferences.getString(APRSecondthingtodo, "event 2");
        String apr3=sharedpreferences.getString(APRThirdthingtodo, "event 3");
        String apr4=sharedpreferences.getString(APRFourththingtodo, "event 4");
        String apr5=sharedpreferences.getString(APRFifththingtodo, "event 5");
        String apr6=sharedpreferences.getString(APRSixththingtodo, "event 6");

        //I set aug1 as the first thing to do, which is the same as the event I stored last time
        ed1.setText(apr1);
        ed2.setText(apr2);
        ed3.setText(apr3);
        ed4.setText(apr4);
        ed5.setText(apr5);
        ed6.setText(apr6);
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
                    String apr1=sharedpreferences.getString(APRFirstthingtodo, "emailKey");
                    String apr2=sharedpreferences.getString(APRSecondthingtodo, "emailKey");
                    String apr3=sharedpreferences.getString(APRThirdthingtodo, "emailKey");
                    String apr4=sharedpreferences.getString(APRFourththingtodo, "emailKey");
                    String apr5=sharedpreferences.getString(APRFifththingtodo, "emailKey");
                    String apr6=sharedpreferences.getString(APRSixththingtodo, "emailKey");
                    //this can't be deleted, must be defined first
                    editString1 = ed1.getText().toString();
                    editString2 = ed2.getText().toString();
                    editString3 = ed3.getText().toString();
                    editString4 = ed4.getText().toString();
                    editString5 = ed5.getText().toString();
                    editString6 = ed6.getText().toString();
                    editor.putString(APRFirstthingtodo, editString1);
                    editor.putString(APRSecondthingtodo, editString2);
                    editor.putString(APRThirdthingtodo, editString3);
                    editor.putString(APRFourththingtodo, editString4);
                    editor.putString(APRFifththingtodo, editString5);
                    editor.putString(APRSixththingtodo, editString6);

                    editor.apply();
                    //save change in sharedpreference
                    Toast.makeText(ActivityApr.this,"you have saved the change",Toast.LENGTH_LONG).show();
                    //display “changed”
                    apr1=sharedpreferences.getString(APRFirstthingtodo, "emailKey");
                    apr2=sharedpreferences.getString(APRSecondthingtodo, "emailKey");
                    apr3=sharedpreferences.getString(APRThirdthingtodo, "emailKey");
                    apr4=sharedpreferences.getString(APRFourththingtodo, "emailKey");
                    apr5=sharedpreferences.getString(APRFifththingtodo, "emailKey");
                    apr6=sharedpreferences.getString(APRSixththingtodo, "emailKey");
                    ed1.setText(apr1);
                    ed2.setText(apr2);
                    ed3.setText(apr3);
                    ed4.setText(apr4);
                    ed5.setText(apr5);
                    ed6.setText(apr6);
                    //display the right text
                    saveChange.setChecked(true);
                    //“button closed”
                } else {
                    saveChange.setChecked(false);
                    Toast.makeText(ActivityApr.this,"do not hesitate lol",Toast.LENGTH_LONG).show();
                }
            }
        });
        translatebutton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //initialize toggle button
                sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                //get sharedpreferences
                if (isChecked) {
                    String apr1=sharedpreferences.getString(APRFirstthingtodo, "emailKey");
                    String apr2=sharedpreferences.getString(APRSecondthingtodo, "emailKey");
                    String apr3=sharedpreferences.getString(APRThirdthingtodo, "emailKey");
                    String apr4=sharedpreferences.getString(APRFourththingtodo, "emailKey");
                    String apr5=sharedpreferences.getString(APRFifththingtodo, "emailKey");
                    String apr6=sharedpreferences.getString(APRSixththingtodo, "emailKey");
                    editString1 = ed1.getText().toString();
                    editString2 = ed2.getText().toString();
                    editString3 = ed3.getText().toString();
                    editString4 = ed4.getText().toString();
                    editString5 = ed5.getText().toString();
                    editString6 = ed6.getText().toString();
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
                    Toast.makeText(ActivityApr.this,"you have saved the change",Toast.LENGTH_LONG).show();
                    //display the right text
                    translatebutton.setChecked(true);
                    //“button closed”
                } else {
                    translatebutton.setChecked(false);
                    Toast.makeText(ActivityApr.this,"do not hesitate lol",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
