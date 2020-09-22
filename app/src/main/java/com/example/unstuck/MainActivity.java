package com.example.unstuck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private Button appsButton;
    private Switch onOffButton;
    private TextView onOffText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar toolbar = findViewById(R.id.toolbar);
        //buttons
        addToggleButton();
        appsButton = (Button) findViewById(R.id.appsButton);
        appsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openAppsActivity();
            }

        });

    }
    public void openAppsActivity(){
        Intent intent = new Intent(this, AppsActivity.class);
        startActivity(intent);
    }

    public void addToggleButton(){
        onOffButton = (Switch)findViewById(R.id.onOffButton);
        onOffText = (TextView) findViewById(R.id.onOffText);
        onOffButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    onOffText.setText("On");

                }else{
                    onOffText.setText("Off");

                }
            }
        });
    }
}