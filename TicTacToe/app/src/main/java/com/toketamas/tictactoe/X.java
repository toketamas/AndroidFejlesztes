package com.toketamas.tictactoe;

import android.graphics.Color;
import android.graphics.PointF;

public class X {
    PointF start;
    PointF end;



    final String type="X";


    int color=Color.rgb(29, 133, 57);

    public X(){};

    public X(PointF start, PointF end) {
        this.start = start;
        this.end = end;
    }

    public String getType() {
        return type;
    }

    public PointF getStart() {
        return start;
    }

    public void setStart(PointF start) {
        this.start = start;
    }

    public PointF getEnd() {
        return end;
    }

    public void setEnd(PointF end) {
        this.end = end;
    }
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
