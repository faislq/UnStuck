package com.example.unstuck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.Toolbar;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class MainActivity extends AppCompatActivity {
    private Button appsButton;
    private Switch onOffButton;
    private TextView onOffText, category1, category2, category3, category4;
    PieChart pieChart;

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
        //pie chart
        category1 = findViewById(R.id.category1);
        category2 = findViewById(R.id.category2);
        category3 = findViewById(R.id.category3);
        category4 = findViewById(R.id.category4);
        pieChart = findViewById(R.id.piechart);
        //create pie chart with data
        setChartData();

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
    //set pie chart data
    private void setChartData()
    {

        // Set the percentages


        // Set the data and color to the pie chart
        pieChart.addPieSlice(
                new PieModel(
                        "Unused",
                        50,
                        Color.parseColor("#FFA726")));
        pieChart.addPieSlice(
                new PieModel(
                        "Youtube",
                        20,
                        Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(
                new PieModel(
                        "Reddit",
                        15,
                        Color.parseColor("#EF5350")));
        pieChart.addPieSlice(
                new PieModel(
                        "Others",
                        10,
                        Color.parseColor("#29B6F6")));

        // To animate the pie chart
        pieChart.startAnimation();
    }
}