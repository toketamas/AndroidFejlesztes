package com.toketamas.tictactoe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class GraphicView extends View {

    private Paint paintBg;
    private Paint paintInk;
    private float width;
    private float height;
    private int orientation = this.getResources().getConfiguration().orientation;
    private int rowNumber=3;
    private int columnNumber=3;
    private List<Integer> endOfRow;
    private List<Integer> endOfColumn;
    //private static PointF touchedPoint;


    public GraphicView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.d("orientiation=", String.valueOf(orientation));

        setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                PointF pointF = new PointF();
                pointF.x = event.getX();
                pointF.y = event.getY();
               touch(pointF);
               return false;
            }
        });
    }

    public static void touch(PointF pointF){
        Log.d("point x=", String.valueOf(pointF.x));
        Log.d("point y=", String.valueOf(pointF.y));
        //for (int i=0; i<endOf)

    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        setCellCoordinates(canvas);
        int plus = 0;
        paintBg = new Paint();
        paintBg.setColor(R.color.white);
        paintBg.setStyle(Paint.Style.FILL);
        paintBg.setColor(Color.WHITE);
        paintInk = new Paint();
        paintInk.setColor(Color.GRAY);
        paintInk.setStyle(Paint.Style.STROKE);
        paintInk.setStrokeWidth(20);
        if (orientation == 1) {
            portraitOrientation(canvas, 30, paintInk);
        } else {
            landscapeOrientation(canvas);
        }
    }

    private void portraitOrientation(Canvas canvas, int padding, Paint paint) {
        width = this.getWidth();
        canvas.drawColor(Color.WHITE);

        for (int i = 0; i < rowNumber; i++) {
            canvas.drawLine(padding, endOfRow.get(i), width - padding, endOfRow.get(i), paint);
            Log.d("rowEnd=", endOfRow.get(i).toString());
            Log.d("rowEndNum=", String.valueOf(i));
        }
        for (int i = 0; i < rowNumber; i++) {
            canvas.drawLine(endOfColumn.get(i), padding, endOfColumn.get(i), width - padding, paint);
            Log.d("rowEnd=", endOfRow.get(i).toString());
            Log.d("rowEndNum=", String.valueOf(i));
        }



        drawX(canvas, 130, 130, 350, 350, paintInk);
        drawO(canvas, 230, 730, 130, paintInk);
    }

    private void setCellCoordinates(Canvas canvas) {
        int startX = 0;
        int startY = 0;
        int oneRow = 0;
        int oneColumn = canvas.getWidth() / columnNumber;
        endOfRow = new ArrayList<Integer>();
        endOfColumn = new ArrayList<Integer>();
        if (orientation == 1) {
            oneRow = canvas.getWidth() / rowNumber;
            for (int i = 0; i < rowNumber; i++) {
                endOfRow.add(oneRow * i);
                endOfColumn.add(oneColumn * i);
            }
        }

        for (int i = 0; i < rowNumber; i++) {
            endOfRow.add(oneRow * i);
            endOfColumn.add(oneColumn * i);
        }
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



    private void setSymbol(int orientation, boolean symbol) {
        //cellák helyzete, berajzolás a cellába
        //symbol=true: X
        //symbol=false: O

    }

    private void drawO(Canvas canvas, float coordinateX, float coordinateY, float radius, Paint paint) {
//kör kirajzolása
        paint.setColor(Color.RED);
        paint.setStrokeWidth(80);
        canvas.drawCircle(coordinateX, coordinateY, radius, paint);
    }

    private void drawX(Canvas canvas, float left, float top, float right, float bottom, Paint paint) {
//X kirajzolása
        paint.setColor(Color.rgb(29,133,57));
        paint.setStrokeWidth(80);
        canvas.drawLine(left, top, right, bottom, paint);
        canvas.drawLine(right, top, left, bottom, paint);
    }
}