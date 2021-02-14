package com.toketamas.tictactoe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class GraphicView extends View {

    Paint paintBg;
    Paint paintInk;
    float widt;
    float height;
    int orientation =this.getResources().getConfiguration().orientation;



    public GraphicView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.d("orientiation=", String.valueOf(orientation));

    }
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onDraw(Canvas canvas) {



        super.onDraw(canvas);
        int plus=0;
        final float width= (float) (MainActivity.widthPh*0.75);
        final float height=(float) (MainActivity.heightPh*0.75);
       // Log.d("phisical heigt=", String.valueOf(MainActivity.heightPh));
        //Log.d("phisical width=", String.valueOf(MainActivity.widthPh));
       // Log.d("heigt=", String.valueOf(height));
        //Log.d(" width=", String.valueOf(width));
        float one_third_size=width/3;
        float one_height_size=height/3;
        paintBg = new Paint();
        paintBg.setColor(R.color.white);
        paintBg.setStyle(Paint.Style.FILL);
        if(orientation ==1){
            canvas.drawRect((plus+(MainActivity.widthPh-width)/2),width/100,(MainActivity.widthPh+width)/2,width,paintBg);
        }

        else
            plus=0;

        canvas.drawRect((plus+(MainActivity.widthPh-width)/2),width/100,(MainActivity.widthPh+width)/2,width,paintBg);
        //canvas.drawRect(MainActivity.widthPh-width,0,(MainActivity.widthPh-width)/2+width,550,paintBg);
        paintInk=new Paint();
        paintInk.setColor(R.color.black);
        paintInk.setStyle(Paint.Style.STROKE);
        paintInk.setStrokeWidth(20);
        //canvas.drawLine(((getWidth()-width)/2)+30,one_third_size,height,one_height_size,paintInk);
        //canvas.drawLine(30,one_third_size*2,width-40,one_third_size*2,paintInk);
        //canvas.drawLine(one_third_size,40,one_third_size,width-40,paintInk);
        //canvas.drawLine(one_third_size*2,40,one_third_size*2,width-40,paintInk);

    }

    private void portraitOrientation(){

    }

    private void landscapeOrientation(){

    }

}