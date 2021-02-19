package com.toketamas.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentProviderClient;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    GraphicView graphicView;
    LinearLayout levelLayout;
    public static int heightPh = Resources.getSystem().getDisplayMetrics().heightPixels;
    public static int widthPh = Resources.getSystem().getDisplayMetrics().widthPixels;
    TextView textLevel;

    String gameLevel="3 X 3";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        graphicView = findViewById(R.id.graphicView);
        levelLayout = findViewById(R.id.levelLayout);
        textLevel = findViewById(R.id.textLevel);
        levelLayout.setEnabled(false);
        int ori = this.getResources().getConfiguration().orientation;
        graphicView.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                PointF pointF = new PointF();
                pointF.x = event.getX();
                pointF.y = event.getY();
                if(pointF.y<graphicView.getWidth()) {
                    textLevel.setText(gameLevel);
                    textLevel.setTextColor(Color.BLUE);
                    levelLayout.setVisibility(View.INVISIBLE);
                }
                graphicView.touch(pointF);
                graphicView.invalidate();
                aI();
                return false;
            }
        });
    }

    public void onClikLevelTxtFields(View view) {
        TextView txt = (TextView) view;
        //rowNumber=txt.getText().toString().substring(0,1);
        int valueX = Integer.parseInt(String.valueOf((txt.getText().charAt(0))));
        int valueY = Integer.parseInt(String.valueOf((txt.getText().charAt(4))));
        graphicView.txtFieldClick(valueX, valueY);
        gameLevel=txt.getText().toString();
    }

    public void onClickBtn(View view) {
        textLevel.setText(R.string.game_level);
        textLevel.setTextColor(Color.GRAY);
        levelLayout.setVisibility(View.VISIBLE);
        graphicView.listO.clear();
        graphicView.listX.clear();
        graphicView.invalidate();
    }
 // a gép lépése
    public void aI(){

    }


}


