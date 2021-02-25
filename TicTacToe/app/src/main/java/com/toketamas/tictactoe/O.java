package com.toketamas.tictactoe;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;


public class O extends XO {

    public O(){}

    public O(PointF start, PointF end, int row, int column, int rowNumber, Paint paint) {
        super(start, end, row, column, rowNumber,paint);
        type="O";
        color=Color.RED;
    }

    private float getRadius(){
        return (end.x-start.x)/3;
    }

    @Override
    void drawMe(Canvas canvas) {
        PointF pointF =new PointF();
        float coordinateX=(start.x+end.x)/2;
        float coordinateY=(start.y+end.y)/2;
        pointF.x=coordinateX;
        pointF.y=coordinateY;
        paint.setColor(Color.RED);
        paint.setStrokeWidth(60 / rowNumber * 3);
        canvas.drawCircle(pointF.x, pointF.y, getRadius(), paint);

    }
}
