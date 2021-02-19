package com.toketamas.tictactoe;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class GraphicView extends View {


    private Paint paintBg;
    private Paint paintInk;
    private float width;
    private float height;
    private int orientation = this.getResources().getConfiguration().orientation;
    private static int rowNumber = 3;
    private static int columnNumber = 3;
    private List<Integer> endOfRow;
    private List<Integer> endOfColumn;
    public List<X> listX=new ArrayList<>();
    public List<O> listO=new ArrayList<O>();
    X array[][]=new X[rowNumber][columnNumber];;
    Canvas canvas;
    //private static PointF touchedPoint;


    public GraphicView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.d("orientiation=", String.valueOf(orientation));
    }

//beállítja a választott táblaméretet
    public void txtFieldClick(int row, int column) {
        rowNumber = row;
        columnNumber = column;
        array=new X[rowNumber][columnNumber];
        invalidate();
    }
//meghatározza a cellát amit megérintett a játékos
    public void touch(PointF pointF) {

        PointF start = new PointF(0, 0);
        PointF end = new PointF(0, 0);
        int row;
        int column;

        for (int i = 0; i < endOfColumn.size() - 1; i++) {
            if (pointF.x > endOfColumn.get(i) && pointF.x < endOfColumn.get(i + 1)) {
                start.x = endOfColumn.get(i);
                end.x = endOfColumn.get(i + 1);
                row=i;
            }
            if (pointF.y > endOfRow.get(i) && pointF.y < endOfRow.get(i + 1)) {
                start.y = endOfRow.get(i);
                end.y = endOfRow.get(i + 1);
                column=i;
            }
        }
        Log.d("koordináták: ", "left: " + start.x + " top: " + start.y + " right: " + end.x + " bottom: " + end.y);
        if(end.y!=0){
            listX.add(new X(start,end));
        }
    }

//rajzolásért felelős függvény
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
        setCellCoordinates();
        paintBg = new Paint();
        paintBg.setColor(R.color.white);
        paintBg.setStyle(Paint.Style.FILL);
        paintBg.setColor(Color.WHITE);
        paintInk = new Paint();
        paintInk.setColor(Color.GRAY);
        paintInk.setStyle(Paint.Style.STROKE);
        paintInk.setStrokeWidth(20);
        if (orientation == 1) {
            portraitOrientation(30, paintInk);
        } else {
            landscapeOrientation();
        }

    }
//játékmező és figurák kirajzolása álló helyzetben
    private void portraitOrientation(int padding, Paint paint) {
        width = this.getWidth();
        canvas.drawColor(Color.WHITE);
        paint.setStrokeWidth(30 / rowNumber * 2);

//sorok kirajzolása
        for (int i = 1; i < rowNumber; i++) {
            canvas.drawLine(padding, endOfRow.get(i), width - padding, endOfRow.get(i), paint);
            Log.d("rowEnd=", endOfRow.get(i).toString());
            Log.d("rowEndNum=", String.valueOf(i));
        }
//oszlopok kirajzolása

        for (int i = 1; i < rowNumber; i++) {
            canvas.drawLine(endOfColumn.get(i), padding, endOfColumn.get(i), width - padding, paint);
            Log.d("rowEnd=", endOfRow.get(i).toString());
            Log.d("rowEndNum=", String.valueOf(i));
        }

//O-k kirajzolása
        if (listO.size() != 0) {
            for (int i = 0; i < listO.size(); i++) {
                O o = listO.get(i);
                paint.setColor(Color.RED);
                paint.setStrokeWidth(60 / rowNumber * 3);
                canvas.drawCircle(o.getMiddleOfCircle().x, o.getMiddleOfCircle().y, o.getRadius(), paintInk);
            }
        }

//X-k kirajzolása
        float deg= (float)(60/rowNumber*3);
        if (listX.size() != 0) {
            for (int i = 0; i < listX.size(); i++) {
                X x = listX.get(i);
                paint.setColor(Color.rgb(29, 133, 57));
                paint.setStrokeWidth(60 / rowNumber * 3);
                canvas.drawLine(x.getStart().x+deg,x.getStart().y+deg,x.getEnd().x-deg,x.getEnd().y-deg,paintInk);
                canvas.drawLine(x.getStart().x+deg,x.getEnd().y-deg,x.getEnd().x-deg,x.getStart().y+deg,paintInk);
            }
        }
    }

//listakészítés a tábla mezőinek kezdő és záró koordinátáiról a választott táblaméret alapján
    private void setCellCoordinates() {
        int oneRow = 0;
        int cSize = canvas.getWidth();
        int oneColumn = cSize / columnNumber;
        endOfRow = new ArrayList<Integer>();
        endOfColumn = new ArrayList<Integer>();
        if (orientation == 1) {
            oneRow = cSize / rowNumber;
            for (int i = 0; i < rowNumber; i++) {
                endOfRow.add(oneRow * i);
                endOfColumn.add(oneColumn * i);
            }
            endOfRow.add(cSize);
            endOfColumn.add(cSize);
        }
        for (int i = 0; i < rowNumber; i++) {
            endOfRow.add(oneRow * i);
            endOfColumn.add(oneColumn * i);
        }
    }
//telefon fekvő helyzet 3x3 rács kirajzolása nem használjuk(az elfordítás tiltva van)
    private void landscapeOrientation() {
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

    }



}