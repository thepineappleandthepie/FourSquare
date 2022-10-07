package com.example.foursquare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Game extends AppCompatActivity implements View.OnClickListener {


    private Button[][] GameBoard = new Button[3][3];
    private String[][] Move = new String[3][3];
    private int MoveCnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int x = 0; x < 3; x++) {
            for (int c = 0; c < 3; c++) {
                String buttonID = "button" + x + c;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                GameBoard[x][c] = findViewById(resID);
                GameBoard[x][c].setOnClickListener(this);
            }
        }

        Button buttonReset = findViewById(R.id.buttonretry);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onClick(View scr) {
        if (!((Button) scr).getText().toString().equals("")) {
            return;
        }
        if(MoveCnt<2){

        }
        if (MoveCnt%2==0) {
            ((Button) scr).setText("X");
            MoveCnt++;
        } else {
            ((Button) scr).setText("O");
            MoveCnt++;
        }
        if(win_checker()==true){
            Intent intent = new Intent(this, Winner.class);
            startActivity(intent);
        }

    }

    private boolean win_checker() {
        if(board[x][y] == State.Blank){
            board[x][y] = s;
        }
        MoveCnt++;

        //Check End conditions

        //Check Columns
        for(int i = 0; i < n; i++){
            if(board[x][i] != s)
                break;
            if(i == n-1){
                //Report Win(for S)
            }
        }

        //Check Row
        for(int i = 0; i < n; i++){
            if(board[i][y] != s)
                break;
            if(i == n-1){
                //Report Win(for S)
            }
        }

        //Check Diagonal
        if(x == y){
            for(int i = 0; i < n; i++){
                if(board[i][i] != s)
                    break;
                if(i == n-1){
                    //Report Win(for S)
                }
            }
        }

        //Check Anti Diagonal
        if(x + y == n - 1){
            for(int i = 0; i < n; i++){
                if(board[i][(n-1)-i] != s)
                    break;
                if(i == n-1){
                    //Report Win(for S)
                }
            }
        }

        //Check Draw
        if(moveCount == (Math.pow(n, 2) - 1)){
            //Report Draw
        }

        return false;
    }
}