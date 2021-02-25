package com.toketamas.tictactoe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class GraphicView extends View {


    private Paint paintBg;
    public Paint paintInk;
    private float width;
    private float height;
    private int orientation = this.getResources().getConfiguration().orientation;
    public static int rowNumber = 3;
    private static int columnNumber = 3;
    public List<Integer> endOfRow;
    public List<Integer> endOfColumn;
    public List<XO> listXO = new ArrayList<XO>();
    Canvas canvas;

    public GraphicView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    //beállítja a választott táblaméretet
    public void txtFieldClick(int row, int column) {
        rowNumber = row;
        columnNumber = column;
        invalidate();
    }

    //meghatározza a cellát amit megérintett a játékos
    public void touch(PointF pointF) {
        PointF start = new PointF(0, 0);
        PointF end = new PointF(0, 0);
        int row = 0;
        int column = 0;

        for (int i = 0; i < endOfColumn.size() - 1; i++) {
            if (pointF.x > endOfColumn.get(i) && pointF.x < endOfColumn.get(i + 1)) {
                start.x = endOfColumn.get(i);
                end.x = endOfColumn.get(i + 1);
                row = i;
                Log.d("##row: ", String.valueOf(row));
                break;
            }
        }
        for (int i = 0; i < endOfColumn.size() - 1; i++) {
            if (pointF.y > endOfRow.get(i) && pointF.y < endOfRow.get(i + 1)) {
                start.y = endOfRow.get(i);
                end.y = endOfRow.get(i + 1);
                column = i;
                Log.d("##column: ", String.valueOf(column));
                break;
            }
        }
        XO selected=blankCell(row,column);
        if ((end.y != 0) && (selected==null)) {
            listXO.add(new O(start, end, row, column, rowNumber, paintInk));
        }
        else
            Log.d("nem üres ",row+" , "+column+", "+selected.type);
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

//XO kirajzolása
        if (listXO.size() != 0) {
            for (int i = 0; i < listXO.size(); i++) {
                listXO.get(i).drawMe(canvas);
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

    public XO blankCell(int row,int column){
       for (int i=0;i<listXO.size();i++){
           if((listXO.get(i).row==row) && (listXO.get(i).column==column)){
               return listXO.get(i);
           }
       }
       return null;
    }

    public boolean gameEnd(){
        boolean result=false;
        if(listXO.size()<rowNumber*rowNumber){
            result=true;
        }
        return result;
    }
}