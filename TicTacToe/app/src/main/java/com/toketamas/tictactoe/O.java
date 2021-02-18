package com.toketamas.tictactoe;

import android.graphics.Color;
import android.graphics.PointF;


public class O extends X {
    public O(O o){
        super();

    };
    public O(PointF start, PointF end) {
        super(start, end);
        color= Color.RED;
        final String type="O";
    }

    public PointF getMiddleOfCircle(){
        PointF pointF =new PointF();
        float coordinateX=(start.x+end.x)/2;
        float coordinateY=(start.y+end.y)/2;
        pointF.x=coordinateX;
        pointF.y=coordinateY;
        return pointF;
    }

    public float getRadius(){
        return (end.x-start.x)/3;
    }
}
