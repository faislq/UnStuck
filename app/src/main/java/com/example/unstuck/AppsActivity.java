package com.example.unstuck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AppsActivity extends AppCompatActivity {
    private Button backButton, reminderButton, shutOffButton, popUpButton;
    private TextView reminderText, shutOffText, popUpText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apps);
    // creating texts and buttons
        //back button to go back into main menu
        backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openAppsActivity();
            }

        });
        //interruption buttons with changeable text
        reminderButton = (Button) findViewById(R.id.reminderButton);
        reminderButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                reminderClick();
            }

        });
        reminderText = (TextView) findViewById(R.id.reminderText);
        shutOffButton = (Button) findViewById(R.id.shutOffButton);
        shutOffButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                shutOffClick();
            }

        });
        shutOffText = (TextView) findViewById(R.id.shutOffText);
        popUpButton = (Button) findViewById(R.id.popUpButton);
        popUpButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                popUpClick();
            }

        });
        popUpText = (TextView) findViewById(R.id.popUpText);





    }
    public void openAppsActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void reminderClick(){
        if (reminderText.getText() == "None"){
            reminderText.setText("Every hour");
        }
        else{
            reminderText.setText("None");
        }
    }

    public void shutOffClick(){
        if (shutOffText.getText() == "Off"){
            shutOffText.setText("On");
        }
        else{
            shutOffText.setText("Off");
        }

    }

    public void popUpClick(){
        if (popUpText.getText() == "None"){
            popUpText.setText("Every hour");
        }
        else{
            popUpText.setText("None");
        }

    }
}