package com.example.unstuck;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;


import com.google.android.material.navigation.NavigationView;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Button appsButton;
    private Switch onOffButton;
    private TextView onOffText, category1, category2, category3, category4;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //top bar
        toolbar = findViewById(R.id.bar);
        setSupportActionBar(toolbar);
        //side bar menu
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.openNavDrawer,
                R.string.closeNavDrawer

        );
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}