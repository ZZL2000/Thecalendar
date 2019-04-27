package com.example.thecalendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ToggleButton;
import android.widget.EditText;
import android.view.MenuItem;
import android.widget.CompoundButton;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import android.widget.ToggleButton;


/**
 * Created by zzl
 */
public class ActivityAug extends AppCompatActivity {
    String AUG11;
    List<String> AUG;
    ToggleButton saveChange ;
    EditText ed;
    String editString="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aug);//注意为“R.layout.activity_second”
        saveChange = (ToggleButton)findViewById(R.id.AUGSB);
        ed  = (EditText)findViewById(R.id.AUG1);
        editString = ed.getText().toString();
        saveChange.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ed.setText("66666");
                    saveChange.setChecked(true);
                } else {
                    ed.setText("666");
                    saveChange.setChecked(false);
                }
            }
        });
    }

}
