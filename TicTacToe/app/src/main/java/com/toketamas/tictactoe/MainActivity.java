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


public class MainActivity extends AppCompatActivity {
    GraphicView graphicView;
    public static int heightPh = Resources.getSystem().getDisplayMetrics().heightPixels;
    public static int widthPh = Resources.getSystem().getDisplayMetrics().widthPixels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        graphicView = findViewById(R.id.graphicView);
        //graphicView.setForegroundGravity(Gravity.CENTER_HORIZONTAL);
        int ori = this.getResources().getConfiguration().orientation;


   /* graphicView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("klikk","klikk");
            PointF pointF = new PointF();
            pointF.x = v.getX();
            pointF.y = v.getY();
            //GraphicView.touch(pointF);
            Log.d("point x=", String.valueOf(pointF.x));
            Log.d("point y=", String.valueOf(pointF.y));
        }
    });
*/
    }


    public void onClickBtn(View view){

        Log.d("klikk", "Button click");
    }

    public void onClickView(View v) {
        Log.d("klikk", "klikk");
       PointF pointF = new PointF();



        //GraphicView.touch(pointF);
        Log.d("point x=", ""+v.getTranslationX());
        Log.d("point y=", ""+v.getTranslationY());
    }


}