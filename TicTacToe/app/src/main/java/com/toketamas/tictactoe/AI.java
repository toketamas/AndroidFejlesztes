package com.toketamas.tictactoe;

import android.graphics.PointF;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
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
        //tesztjelleggel a row és column értéke véletlen szám!!  az AI nek kell majd kiszámítani a cella helyét  és beállítani a row és column értékét!!!!

        //ha üres a tábla tehát a gép kezd (ilyen eset egyelőre nincs)
        if (gameTable.size() == 0) {
            tomb = randomXY();
            row = tomb[0];
            column = tomb[1];
            setPosition(row, column);
            setCoordinates();
        } else
            //a gép első lépése a játékos első lépése után ez az eset lehet, hogy nem kell majd a késöbbiekben
            if (firstStep()) {

                // step() itt lép
                boolean result = true;
                while (result) {
                    tomb = randomXY();
                    row = tomb[0];
                    column = tomb[1];
                    result = !blankCell(tomb);
                    setPosition(row, column);
                    setCoordinates();
                }

            } else {
                //a gép lépése
               // neighborObject(gameTable(adott eleme)) itt megvizsgálja a szomszédokat
                // step() itt lép
                boolean result = true;
                while (result) {
                    tomb = randomXY();
                    row = tomb[0];
                    column = tomb[1];
                    result = !blankCell(tomb);
                    setPosition(row, column);
                    setCoordinates();
                }
            }
    }


//!!!!!!!!!!!!!!!!**********************PUBLIKUS METÓDUSOK***************************!!!!!!!!!!!!!!

//

    //beállítja a táblán az új objektumot és visszaadja a táblát az új felállással
    public List<XO> nextStep() {
        gameTable.add(xo);
        return gameTable;
    }

    // Megvizsgálja véget ért e a játék, A lista 1. eleme Boolean true--> vége a játéknak, false-->
    // nincs vége, 2. elem Boolean döntetlen? true-->igen false --> nem 3. elem egy CHAR X vagy O amelyik a nyertes;
    public List<Object> winOrLastStep() {
        List<Object> results = new ArrayList<>();


        return results;
    }


//!!!!!!!!!!!!!!!!**********************PRIVÁT METÓDUSOK***************************!!!!!!!!!!!!!!

    //
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

    //Ellenőrzi hogy a kiválasztott cella üres e true ha igen false ha nem
    private boolean blankCell(int[] value) {
        for (int i = 0; i < gameTable.size(); i++) {
            if ((gameTable.get(i).row == value[0]) && (gameTable.get(i).column == value[1])) {
                return false;
            }
        }
        return true;
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


//MEGOLDANDÓ FELADAT

    //  Megvizsgálja a kapott objektum melletti mezőket hogy található e veszélyes vagy bíztató kombináció a kapott objektum közelében visszaadja az érintett koordinátákat egy
    //  listában (PointF) ami mekakadályozza az ellenfél győzelmét vagy hozzásegít a győzelemhez ha nincs ilyen pozició akkor -1,-1 et ad vissza.
    //  A táblaméret alapján kell meghatározni a vizsgált tartományt. Saját objektum megadásánál támadó, ellenfél objektumánál védekező pozició(ha létezik ilyen különbség)

    private void neighborObject(XO xo) {

    }

//MEGOLDANDÓ FELADAT
    // A neighborObject-től kapott lista elemzése és a következő lépés meghatározása ha lehet még lépni.
    // ????ESETLEG MINTÁK HASZNÁLATA ADATBÁZISBÓL????  ezekkel lehetne összevetni a sort oszlopot átlót
    // 1. szint következő lépésben nyer vagy veszít--> 3-as:X_X,_XX,XX_, 4-es:_OOO,O_OO,OO_O,OOO_, 5-ös:_XXXX,X_XXX,XX_XX,XXX_X,XXXX_;
    // 2. szint következő utáni lépésnél nyer vag veszít (3-asnál értelmetlen?)--> 4-es __OO,O__O,OO__, 5-ós __XXX,X__XX,XX__X,XXX__;
    // 3. szint nincs semmi veszély vagy esély úgy helyezze el hogy akadályozza az ellenfelet és vagy lehetőséget adjon egy sor kirakására

    private void step() {


    }


}
