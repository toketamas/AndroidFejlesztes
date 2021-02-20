package com.toketamas.tictactoe;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;

public class X extends XO {

    public X(){}

    public X(PointF start, PointF end, int row, int column, int rowNumber, Paint paint)
    {
        super(start, end, row, column, rowNumber,paint);
        color = Color.rgb(29, 133, 57);
        type = "X";
    }

    @Override
    void drawObject(Canvas canvas) {
        float deg= (float)(60/rowNumber*3);
        paint.setColor(color);
        paint.setStrokeWidth(60 / rowNumber * 3);
        canvas.drawLine(start.x+deg,start.y+deg,end.x-deg,end.y-deg,this.paint);
        canvas.drawLine(start.x+deg,end.y-deg,end.x-deg,start.y+deg,paint);
    }
}
