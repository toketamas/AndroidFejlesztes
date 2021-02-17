package com.toketamas.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentProviderClient;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    GraphicView graphicView;
    public static int heightPh = Resources.getSystem().getDisplayMetrics().heightPixels;
    public static int widthPh = Resources.getSystem().getDisplayMetrics().widthPixels;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        graphicView = findViewById(R.id.graphicView);
        //graphicView.setForegroundGravity(Gravity.CENTER_HORIZONTAL);
        int ori = this.getResources().getConfiguration().orientation;
    }

    public void onClikLevelTxtFields(View view){
        TextView txt = (TextView) view;
        //rowNumber=txt.getText().toString().substring(0,1);
        int valueX=Integer.parseInt(String.valueOf((txt.getText().charAt(0))));
        int valueY=Integer.parseInt(String.valueOf((txt.getText().charAt(4))));
        graphicView.txtFieldClick(valueX,valueY);
    }

    public void onClickBtn(View view){

        Log.d("klikk", "Button click");
    }


    }


