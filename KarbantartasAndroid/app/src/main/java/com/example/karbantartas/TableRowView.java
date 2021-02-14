package com.example.karbantartas;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;

import androidx.annotation.Nullable;

class TableRowView extends View {

    GridView gridView;
    EditText cell1;
    private EditText cell2;
    private EditText cell3;
    private EditText cell4;
    private EditText cell5;
    private EditText cell6;
    private int width=this.getWidth();
    private int one = width/6;

    public TableRowView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs);
        gridView=new GridView(context);
        gridView.setColumnWidth(one);
        gridView.setNumColumns(6);

        cell1=new EditText(gridView.getContext());
        cell1.setText("Hali");




    }
}
