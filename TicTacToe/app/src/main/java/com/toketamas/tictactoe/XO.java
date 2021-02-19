package com.toketamas.tictactoe;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

abstract class XO {
    protected PointF start;
    protected PointF end;
    protected int row;
    protected int column;
    protected int color;
    protected String type;
    protected Paint paint;
    protected int rowNumber;

   public XO(PointF start, PointF end, int row, int column, int rowNumber,Paint paint) {
        this.start = start;
        this.end = end;
        this.row = row;
        this.column = column;
        this.rowNumber = rowNumber;
        this.paint=paint;
        paint.setStrokeWidth(30);
    }

    public XO() {

    }

    abstract void drawObject(Canvas canvas);


    public void setType(String type) {
        this.type = type;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
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

    public int getRow() {return row; }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
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
