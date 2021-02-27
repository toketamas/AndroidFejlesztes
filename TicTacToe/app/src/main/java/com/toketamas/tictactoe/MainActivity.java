package com.toketamas.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    GraphicView graphicView;
    LinearLayout levelLayout;
    public static int heightPh = Resources.getSystem().getDisplayMetrics().heightPixels;
    public static int widthPh = Resources.getSystem().getDisplayMetrics().widthPixels;
    TextView textLevel;
    String gameLevel = "3 X 3";
    XO xo;
    //Ez a változó tatalmazza az ellenfél típusát 0=AI 1=másik játékos ezen az eszközön 2=hálózat
    int opponent = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        graphicView = findViewById(R.id.graphicView);
        levelLayout = findViewById(R.id.levelLayout);
        textLevel = findViewById(R.id.textLevel);
        levelLayout.setEnabled(false);
        int ori = this.getResources().getConfiguration().orientation;

        graphicView.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                PointF pointF = new PointF();
                pointF.x = event.getX();
                pointF.y = event.getY();
                if (pointF.y < graphicView.getWidth()) {
                    textLevel.setText(gameLevel);
                    textLevel.setTextColor(Color.BLUE);
                    levelLayout.setVisibility(View.INVISIBLE);
                }
                boolean blank=graphicView.touch(pointF);
                graphicView.invalidate();
                if (graphicView.gameEnd() && blank)
                    opponentNextSteps();
                return false;
            }
        });
    }

    public void onClikLevelTxtFields(View view) {
        TextView txt = (TextView) view;
        int valueX = Integer.parseInt(String.valueOf((txt.getText().charAt(0))));
        int valueY = Integer.parseInt(String.valueOf((txt.getText().charAt(4))));
        graphicView.txtFieldClick(valueX, valueY);
        gameLevel = txt.getText().toString();
    }

    public void onClickBtn(View view) {
        textLevel.setText(R.string.game_level);
        textLevel.setTextColor(Color.GRAY);
        levelLayout.setVisibility(View.VISIBLE);
        graphicView.listXO.clear();
        graphicView.invalidate();
    }

    // a gép lépése
    public void opponentNextSteps() {
        if (opponent == 0) {
            xo = new X(graphicView.paintInk);
            AI ai = new AI(graphicView.listXO, graphicView.endOfRow, graphicView.endOfColumn, graphicView.rowNumber, xo);
            graphicView.listXO = ai.nextStep();
            graphicView.invalidate();

        }
    }


}


