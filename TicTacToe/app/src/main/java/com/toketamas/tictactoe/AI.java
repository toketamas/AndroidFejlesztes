package com.toketamas.tictactoe;

import android.graphics.PointF;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.List;

public class AI {
    private List<XO> gameTable;
    private List<Integer> endOfRow;
    private List<Integer> endOfColumn;
    private XO xo;
    private int row;
    private int column;
    private int rownumber;
    private int[] tomb;

    public AI(List<XO> gameTable, List<Integer> endOfRow, List<Integer> endOfColumn, int rowNumber, XO xo) {
        this.gameTable = gameTable;
        this.endOfRow = endOfRow;
        this.endOfColumn = endOfColumn;
        this.xo = xo;
        this.rownumber = rowNumber;
        xo.rowNumber = rowNumber;
        //tesztjelleggel a row és column értéke 0 0!!  az AI nek kell majd kiszámítani a cella helyét  és beállítani a row és column értékét!!!!
        if (gameTable.size() == 0) {
            tomb = randomXY();
            row = tomb[0];
            column = tomb[1];
            setPosition(row, column);
            setCoordinates();
        }
        else
        if (firstStep()) {
            boolean result = true;
            while (result) {
                tomb = randomXY();
                row = tomb[0];
                column = tomb[1];
                result = blankCell(tomb);
                setPosition(row, column);
                setCoordinates();
            }

        }
        else {
            boolean result = true;
            while (result) {
                tomb = randomXY();
                row = tomb[0];
                column = tomb[1];
                result = blankCell(tomb);
                setPosition(row, column);
                setCoordinates();
            }
        }
    }


    private int[] randomXY() {
        int[] value = new int[2];
        value[0] = (int) (Math.random() * rownumber);
        value[1] = (int) (Math.random() * rownumber);
        Log.d("random x y : ", value[0] + " " + value[1]);
        return value;
    }

    private boolean firstStep() {
        boolean value = true;
        for (int i = 0; i < gameTable.size(); i++) {
            if (gameTable.get(i).type == xo.type)
                value = false;
        }
        return value;


    }

    // megvizsgálja hogy a táblában az adott cella üres e ha igen null les az értéke ha nem visszaadja az objektumot ami a cellában van.
    private XO blankCell(int row, int column) {
        for (int i = 0; i < gameTable.size(); i++) {
            if ((gameTable.get(i).row == row) && (gameTable.get(i).column == column)) {
                return gameTable.get(i);
            }
        }
        return null;
    }

    private boolean blankCell(int[] value) {
        for (int i = 0; i < gameTable.size(); i++) {
            if ((gameTable.get(i).row == value[0]) && (gameTable.get(i).column == value[1])) {
                return true;
            }
        }
        return false;
    }

    //beállítja az ai által meghatározott pozíciót
    private void setPosition(int row, int column) {
        xo.row = row;
        xo.column = column;
    }

    //a pozició alapján kiszámítja a és beállítja a koordinátákat   !!!! előszőr a poziciót kell beállítani!!!!!!
    private void setCoordinates() {
        PointF start = new PointF();
        PointF end = new PointF();
        start.x = endOfRow.get(xo.row);
        start.y = endOfColumn.get(xo.column);
        end.x = endOfRow.get(xo.row + 1);
        end.y = endOfColumn.get(xo.column + 1);
        xo.start = start;
        xo.end = end;
    }

    //beállítja a táblán az új objektumot és visszaadja a táblát az új felállással
    public List<XO> nextStep() {
        gameTable.add(xo);
        return gameTable;
    }
}
