package com.toketamas.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;


public class MainActivity extends AppCompatActivity {
    GraphicView graphicView;
    public static int heightPh= Resources.getSystem().getDisplayMetrics().heightPixels;
    public static int widthPh=Resources.getSystem().getDisplayMetrics().widthPixels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        graphicView=findViewById(R.id.graphicView);
        //graphicView.setForegroundGravity(Gravity.CENTER_HORIZONTAL);
        int ori=this.getResources().getConfiguration().orientation;
    }



}