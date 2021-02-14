package com.toketamas.tictactoe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class GraphicView extends View {

    Paint paintBg;
    Paint paintInk;
    float width;
    float height;
    int orientation = this.getResources().getConfiguration().orientation;
    Button btnNew;


    public GraphicView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.d("orientiation=", String.valueOf(orientation));

    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onDraw(Canvas canvas) {


        super.onDraw(canvas);
        int plus = 0;
        paintBg = new Paint();
        paintBg.setColor(R.color.white);
        paintBg.setStyle(Paint.Style.FILL);
        paintInk = new Paint();
        paintInk.setColor(R.color.black);
        paintInk.setStyle(Paint.Style.STROKE);
        paintInk.setStrokeWidth(20);
        if (orientation == 1) {
            portraitOrientation(canvas);
        } else {
            landscapeOrientation(canvas);
        }


    }

    private void portraitOrientation(Canvas canvas) {
        width = this.getWidth();
        float one_third_width_size = width / 3;
        canvas.drawLine(30, one_third_width_size, width - 30, one_third_width_size, paintInk);
        canvas.drawLine(30, one_third_width_size * 2, width - 30, one_third_width_size * 2, paintInk);
        canvas.drawLine(one_third_width_size, 30, one_third_width_size, width - 30, paintInk);
        canvas.drawLine(one_third_width_size * 2, 30, one_third_width_size * 2, width - 30, paintInk);
        btnNew=new Button(getContext());
    }

    private void landscapeOrientation(Canvas canvas) {
        height = this.getHeight();
        width = this.getWidth();
        float one_third_height_size = height / 3;
        float one_half_width_size = (width / 2);
        float startPos = (one_half_width_size - height / 2);

        canvas.drawLine(startPos + 30, one_third_height_size, startPos + height - 30, one_third_height_size, paintInk);
        canvas.drawLine(startPos + 30, one_third_height_size * 2, startPos + height - 30, one_third_height_size * 2, paintInk);
        canvas.drawLine(startPos + one_third_height_size, 30, startPos + one_third_height_size, height - 30, paintInk);
        canvas.drawLine(startPos + one_third_height_size * 2, 30, startPos + one_third_height_size * 2, height - 30, paintInk);
    }

}