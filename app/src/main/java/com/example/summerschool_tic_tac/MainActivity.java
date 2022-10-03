package com.example.summerschool_tic_tac;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    Button reset;
    TextView playerLabel,androidLabel;
    TextView tv;
    Random rn = new Random();
    int chosen=0;
    String output;

    ArrayList<Integer> Positions =new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
    int max=8;
    int min=0;
    int IndexRandomVal=-1,numChecked;
    int range,randCompSel, randCompSelNewSel,PlayerScore=0,AndroidScore=0;

    int[] randomVals = new int[20];



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerLabel=findViewById(R.id.text_view_p1);
        androidLabel=findViewById(R.id.text_view_p2);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        reset=findViewById(R.id.button_reset);
        setBoard();
        androidLabel.setText("Android : ");
        playerLabel.setText("Player : ");

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBoard();
                setEnable();
            }
        });

            //BUTTON 1 CLICK
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                  ++IndexRandomVal;
                    //Players

                    btn1.setText("X");
                    btn1.setTextColor(Color.parseColor("#00FF00"));
                    for(int i=0;i<Positions.size();++i){
                        if(Positions.get(i)==1){
                            Positions.set(i,50);

                        }
                    }



                    range = max - min + 1;
                    int timesSelected=0;
                    randCompSel = rn.nextInt(range) + 1;
                    randomVals[IndexRandomVal] = randCompSel;

                    boolean stopLoop=false;
                   for(int i=0;i<randomVals.length;i++) {
                       if (randomVals[i] == randCompSel) {
                           ++timesSelected;
                       }


                   }

                   randCompSelNewSel=randCompSel;
                    if (timesSelected == 2)
                    {

                        do {
                            randCompSelNewSel = rn.nextInt(range) + 1;
                        }while(randCompSelNewSel==randCompSel);

                        ++IndexRandomVal;
                        randomVals[IndexRandomVal] = randCompSelNewSel;
                    }


                    Toast.makeText(MainActivity.this, String.valueOf(randCompSelNewSel), Toast.LENGTH_SHORT).show();
                    switch (Positions.get(randCompSelNewSel)) {
                        case 1:
                            btn1.setText("O");
                            btn1.setTextColor(Color.parseColor("#FF0000"));
                            for(int i=0;i<Positions.size();++i){
                                if(Positions.get(i)==1){
                                    Positions.set(i,50);


                                }
                            }
                            btn1.setEnabled(false);
                            break;
                        case 2:
                            btn2.setText("O");
                            btn2.setTextColor(Color.parseColor("#FF0000"));
                            for(int i=0;i<Positions.size();++i){
                                if(Positions.get(i)==2){
                                    Positions.set(i,50);
                                }
                            }
                            btn2.setEnabled(false);
                            break;

                        case 3:
                            btn3.setText("O");
                            btn3.setTextColor(Color.parseColor("#FF0000"));
                            for(int i=0;i<Positions.size();++i){
                                if(Positions.get(i)==3){
                                    Positions.set(i,50);
                                }
                            }
                            btn3.setEnabled(false);
                            break;
                        case 4:
                            btn4.setText("O");
                            btn4.setTextColor(Color.parseColor("#FF0000"));
                            for(int i=0;i<Positions.size();++i){
                                if(Positions.get(i)==4){
                                    Positions.set(i,50);
                                }
                            }
                            btn4.setEnabled(false);
                            break;
                        case 5:
                            btn5.setText("O");
                            btn5.setTextColor(Color.parseColor("#FF0000"));
                            for(int i=0;i<Positions.size();++i){
                                if(Positions.get(i)==5){
                                    Positions.set(i,50);
                                }
                            }
                            btn5.setEnabled(false);
                            break;
                        case 6:
                            btn6.setText("O");
                            btn6.setTextColor(Color.parseColor("#FF0000"));
                            for(int i=0;i<Positions.size();++i){
                                if(Positions.get(i)==6){
                                    Positions.set(i,50);
                                }
                            }
                            btn6.setEnabled(false);
                            break;
                        case 7:
                            btn7.setText("O");
                            btn7.setTextColor(Color.parseColor("#FF0000"));
                            for(int i=0;i<Positions.size();++i){
                                if(Positions.get(i)==7){
                                    Positions.set(i,50);
                                }
                            }
                            btn7.setEnabled(false);
                            break;
                        case 8:
                            btn8.setText("O");
                            btn8.setTextColor(Color.parseColor("#FF0000"));
                            for(int i=0;i<Positions.size();++i){
                                if(Positions.get(i)==8){
                                    Positions.set(i,50);
                                }
                            }
                            btn8.setEnabled(false);
                            break;
                        case 9:
                            btn9.setText("O");
                            btn9.setTextColor(Color.parseColor("#FF0000"));
                            for(int i=0;i<Positions.size();++i){
                                if(Positions.get(i)==9){
                                    Positions.set(i,50);
                                }
                            }
                            btn9.setEnabled(false);
                            break;
                    }

                        btn1.setEnabled(false);
                        PlayerCheck();
                        AndroidCheck();
                    ++numChecked;
                      if(PlayerScore==0 && AndroidScore==0 && numChecked==9){
                          Toast.makeText(MainActivity.this, "IT'S A TIE", Toast.LENGTH_SHORT).show();
                      }


                    }


            });

            //BUTTON 2 CLICK
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ++IndexRandomVal;

                btn2.setText("X");
                btn2.setTextColor(Color.parseColor("#00FF00"));
                for(int i=0;i<Positions.size();++i){
                    if(Positions.get(i)==2){
                        Positions.set(i,50);
                    }
                }
                range = max - min + 1;
                int timesSelected=0;
                randCompSel = rn.nextInt(range) + 1;
                randomVals[IndexRandomVal] = randCompSel;

                boolean stopLoop=false;
                for(int i=0;i<randomVals.length;i++) {
                    if (randomVals[i] == randCompSel) {
                        ++timesSelected;
                    }


                }

                randCompSelNewSel=randCompSel;
                if (timesSelected == 2)
                {

                    do {
                        randCompSelNewSel = rn.nextInt(range) + 1;
                    }while(randCompSelNewSel==randCompSel);

                    ++IndexRandomVal;
                    randomVals[IndexRandomVal] = randCompSelNewSel;
                }


                Toast.makeText(MainActivity.this, String.valueOf(randCompSelNewSel), Toast.LENGTH_SHORT).show();
                switch (Positions.get(randCompSelNewSel)) {
                    case 1:
                        btn1.setText("O");
                        btn1.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==1){
                                Positions.set(i,50);


                            }
                        }
                        btn1.setEnabled(false);
                        break;
                    case 2:
                        btn2.setText("O");
                        btn2.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==2){
                                Positions.set(i,50);
                            }
                        }
                        btn2.setEnabled(false);
                        break;

                    case 3:
                        btn3.setText("O");
                        btn3.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==3){
                                Positions.set(i,50);
                            }
                        }
                        btn3.setEnabled(false);
                        break;
                    case 4:
                        btn4.setText("O");
                        btn4.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==4){
                                Positions.set(i,50);
                            }
                        }
                        btn4.setEnabled(false);
                        break;
                    case 5:
                        btn5.setText("O");
                        btn5.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==5){
                                Positions.set(i,50);
                            }
                        }
                        btn5.setEnabled(false);
                        break;
                    case 6:
                        btn6.setText("O");
                        btn6.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==6){
                                Positions.set(i,50);
                            }
                        }
                        btn6.setEnabled(false);
                        break;
                    case 7:
                        btn7.setText("O");
                        btn7.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==7){
                                Positions.set(i,50);
                            }
                        }
                        btn7.setEnabled(false);
                        break;
                    case 8:
                        btn8.setText("O");
                        btn8.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==8){
                                Positions.set(i,50);
                            }
                        }
                        btn8.setEnabled(false);
                        break;
                    case 9:
                        btn9.setText("O");
                        btn9.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==9){
                                Positions.set(i,50);
                            }
                        }
                        btn9.setEnabled(false);
                        break;
                }

                btn2.setEnabled(false);
                PlayerCheck();
                AndroidCheck();
                ++numChecked;
                if(PlayerScore==0 && AndroidScore==0 && numChecked==9){
                    Toast.makeText(MainActivity.this, "IT'S A TIE", Toast.LENGTH_SHORT).show();
                }


            }
        });

        //BUTTON 3

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ++IndexRandomVal;


                btn3.setText("X");
                btn3.setTextColor(Color.parseColor("#00FF00"));
                for(int i=0;i<Positions.size();++i){
                    if(Positions.get(i)==3){
                        Positions.set(i,50);
                    }
                }
                range = max - min + 1;
                int timesSelected=0;
                randCompSel = rn.nextInt(range) + 1;
                randomVals[IndexRandomVal] = randCompSel;

                boolean stopLoop=false;
                for(int i=0;i<randomVals.length;i++) {
                    if (randomVals[i] == randCompSel) {
                        ++timesSelected;
                    }


                }

                randCompSelNewSel=randCompSel;
                if (timesSelected == 2)
                {

                    do {
                        randCompSelNewSel = rn.nextInt(range) + 1;
                    }while(randCompSelNewSel==randCompSel);

                    ++IndexRandomVal;
                    randomVals[IndexRandomVal] = randCompSelNewSel;
                }


                Toast.makeText(MainActivity.this, String.valueOf(randCompSelNewSel), Toast.LENGTH_SHORT).show();
                switch (Positions.get(randCompSelNewSel)) {
                    case 1:
                        btn1.setText("O");
                        btn1.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==1){
                                Positions.set(i,50);


                            }
                        }
                        btn1.setEnabled(false);
                        break;
                    case 2:
                        btn2.setText("O");
                        btn2.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==2){
                                Positions.set(i,50);
                            }
                        }
                        btn2.setEnabled(false);
                        break;

                    case 3:
                        btn3.setText("O");
                        btn3.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==3){
                                Positions.set(i,50);
                            }
                        }
                        btn3.setEnabled(false);
                        break;
                    case 4:
                        btn4.setText("O");
                        btn4.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==4){
                                Positions.set(i,50);
                            }
                        }
                        btn4.setEnabled(false);
                        break;
                    case 5:
                        btn5.setText("O");
                        btn5.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==5){
                                Positions.set(i,50);
                            }
                        }
                        btn5.setEnabled(false);
                        break;
                    case 6:
                        btn6.setText("O");
                        btn6.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==6){
                                Positions.set(i,50);
                            }
                        }
                        btn6.setEnabled(false);
                        break;
                    case 7:
                        btn7.setText("O");
                        btn7.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==7){
                                Positions.set(i,50);
                            }
                        }
                        btn7.setEnabled(false);
                        break;
                    case 8:
                        btn8.setText("O");
                        btn8.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==8){
                                Positions.set(i,50);
                            }
                        }
                        btn8.setEnabled(false);
                        break;
                    case 9:
                        btn9.setText("O");
                        btn9.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==9){
                                Positions.set(i,50);
                            }
                        }
                        btn9.setEnabled(false);
                        break;
                }
                btn3.setEnabled(false);
                PlayerCheck();
                AndroidCheck();
                ++numChecked;
                if(PlayerScore==0 && AndroidScore==0 && numChecked==9){
                    Toast.makeText(MainActivity.this, "IT'S A TIE", Toast.LENGTH_SHORT).show();
                }


            }
        });


        //BUTTON 4
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ++IndexRandomVal;


                btn4.setText("X");
                btn4.setTextColor(Color.parseColor("#00FF00"));
                for(int i=0;i<Positions.size();++i){
                    if(Positions.get(i)==4){
                        Positions.set(i,50);
                    }
                }
                range = max - min + 1;
                int timesSelected=0;
                randCompSel = rn.nextInt(range) + 1;
                randomVals[IndexRandomVal] = randCompSel;

                boolean stopLoop=false;
                for(int i=0;i<randomVals.length;i++) {
                    if (randomVals[i] == randCompSel) {
                        ++timesSelected;
                    }


                }

                randCompSelNewSel=randCompSel;
                if (timesSelected == 2)
                {

                    do {
                        randCompSelNewSel = rn.nextInt(range) + 1;
                    }while(randCompSelNewSel==randCompSel);

                    ++IndexRandomVal;
                    randomVals[IndexRandomVal] = randCompSelNewSel;
                }


                Toast.makeText(MainActivity.this, String.valueOf(randCompSelNewSel), Toast.LENGTH_SHORT).show();
                switch (Positions.get(randCompSelNewSel)) {
                    case 1:
                        btn1.setText("O");
                        btn1.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==1){
                                Positions.set(i,50);


                            }
                        }
                        btn1.setEnabled(false);
                        break;
                    case 2:
                        btn2.setText("O");
                        btn2.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==2){
                                Positions.set(i,50);
                            }
                        }
                        btn2.setEnabled(false);
                        break;

                    case 3:
                        btn3.setText("O");
                        btn3.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==3){
                                Positions.set(i,50);
                            }
                        }
                        btn3.setEnabled(false);
                        break;
                    case 4:
                        btn4.setText("O");
                        btn4.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==4){
                                Positions.set(i,50);
                            }
                        }
                        btn4.setEnabled(false);
                        break;
                    case 5:
                        btn5.setText("O");
                        btn5.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==5){
                                Positions.set(i,50);
                            }
                        }
                        btn5.setEnabled(false);
                        break;
                    case 6:
                        btn6.setText("O");
                        btn6.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==6){
                                Positions.set(i,50);
                            }
                        }
                        btn6.setEnabled(false);
                        break;
                    case 7:
                        btn7.setText("O");
                        btn7.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==7){
                                Positions.set(i,50);
                            }
                        }
                        btn7.setEnabled(false);
                        break;
                    case 8:
                        btn8.setText("O");
                        btn8.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==8){
                                Positions.set(i,50);
                            }
                        }
                        btn8.setEnabled(false);
                        break;
                    case 9:
                        btn9.setText("O");
                        btn9.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==9){
                                Positions.set(i,50);
                            }
                        }
                        btn9.setEnabled(false);
                        break;
                }
                btn4.setEnabled(false);
                PlayerCheck();
                AndroidCheck();
                ++numChecked;
                if(PlayerScore==0 && AndroidScore==0 && numChecked==9){
                    Toast.makeText(MainActivity.this, "IT'S A TIE", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //BUTTON 5

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ++IndexRandomVal;


                btn5.setText("X");
                btn5.setTextColor(Color.parseColor("#00FF00"));
                for(int i=0;i<Positions.size();++i){
                    if(Positions.get(i)==5){
                        Positions.remove(i);
                    }
                }


                range = max - min + 1;
                int timesSelected=0;
                randCompSel = rn.nextInt(range) + 1;
                randomVals[IndexRandomVal] = randCompSel;

                boolean stopLoop=false;
                for(int i=0;i<randomVals.length;i++) {
                    if (randomVals[i] == randCompSel) {
                        ++timesSelected;
                    }


                }

                randCompSelNewSel=randCompSel;
                if (timesSelected == 2)
                {

                    do {
                        randCompSelNewSel = rn.nextInt(range) + 1;
                    }while(randCompSelNewSel==randCompSel);

                    ++IndexRandomVal;
                    randomVals[IndexRandomVal] = randCompSelNewSel;
                }


                Toast.makeText(MainActivity.this, String.valueOf(randCompSelNewSel), Toast.LENGTH_SHORT).show();
                switch (Positions.get(randCompSelNewSel)) {
                    case 1:
                        btn1.setText("O");
                        btn1.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==1){
                                Positions.set(i,50);


                            }
                        }
                        btn1.setEnabled(false);
                        break;
                    case 2:
                        btn2.setText("O");
                        btn2.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==2){
                                Positions.set(i,50);
                            }
                        }
                        btn2.setEnabled(false);
                        break;

                    case 3:
                        btn3.setText("O");
                        btn3.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==3){
                                Positions.set(i,50);
                            }
                        }
                        btn3.setEnabled(false);
                        break;
                    case 4:
                        btn4.setText("O");
                        btn4.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==4){
                                Positions.set(i,50);
                            }
                        }
                        btn4.setEnabled(false);
                        break;
                    case 5:
                        btn5.setText("O");
                        btn5.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==5){
                                Positions.set(i,50);
                            }
                        }
                        btn5.setEnabled(false);
                        break;
                    case 6:
                        btn6.setText("O");
                        btn6.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==6){
                                Positions.set(i,50);
                            }
                        }
                        btn6.setEnabled(false);
                        break;
                    case 7:
                        btn7.setText("O");
                        btn7.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==7){
                                Positions.set(i,50);
                            }
                        }
                        btn7.setEnabled(false);
                        break;
                    case 8:
                        btn8.setText("O");
                        btn8.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==8){
                                Positions.set(i,50);
                            }
                        }
                        btn8.setEnabled(false);
                        break;
                    case 9:
                        btn9.setText("O");
                        btn9.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==9){
                                Positions.set(i,50);
                            }
                        }
                        btn9.setEnabled(false);
                        break;
                }
                btn5.setEnabled(false);
                PlayerCheck();
                AndroidCheck();
                ++numChecked;
                if(PlayerScore==0 && AndroidScore==0 && numChecked==9){
                    Toast.makeText(MainActivity.this, "IT'S A TIE", Toast.LENGTH_SHORT).show();
                }



            }
        });

        //BUTTON 6
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ++IndexRandomVal;


                btn6.setText("X");
                btn6.setTextColor(Color.parseColor("#00FF00"));
                for(int i=0;i<Positions.size();++i){
                    if(Positions.get(i)==6){
                        Positions.remove(i);
                    }
                }

                range = max - min + 1;
                int timesSelected=0;
                randCompSel = rn.nextInt(range) + 1;
                randomVals[IndexRandomVal] = randCompSel;

                boolean stopLoop=false;
                for(int i=0;i<randomVals.length;i++) {
                    if (randomVals[i] == randCompSel) {
                        ++timesSelected;
                    }


                }

                randCompSelNewSel=randCompSel;
                if (timesSelected == 2)
                {

                    do {
                        randCompSelNewSel = rn.nextInt(range) + 1;
                    }while(randCompSelNewSel==randCompSel);

                    ++IndexRandomVal;
                    randomVals[IndexRandomVal] = randCompSelNewSel;
                }


                Toast.makeText(MainActivity.this, String.valueOf(randCompSelNewSel), Toast.LENGTH_SHORT).show();
                switch (Positions.get(randCompSelNewSel)) {
                    case 1:
                        btn1.setText("O");
                        btn1.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==1){
                                Positions.set(i,50);


                            }
                        }
                        btn1.setEnabled(false);
                        break;
                    case 2:
                        btn2.setText("O");
                        btn2.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==2){
                                Positions.set(i,50);
                            }
                        }
                        btn2.setEnabled(false);
                        break;

                    case 3:
                        btn3.setText("O");
                        btn3.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==3){
                                Positions.set(i,50);
                            }
                        }
                        btn3.setEnabled(false);
                        break;
                    case 4:
                        btn4.setText("O");
                        btn4.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==4){
                                Positions.set(i,50);
                            }
                        }
                        btn4.setEnabled(false);
                        break;
                    case 5:
                        btn5.setText("O");
                        btn5.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==5){
                                Positions.set(i,50);
                            }
                        }
                        btn5.setEnabled(false);
                        break;
                    case 6:
                        btn6.setText("O");
                        btn6.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==6){
                                Positions.set(i,50);
                            }
                        }
                        btn6.setEnabled(false);
                        break;
                    case 7:
                        btn7.setText("O");
                        btn7.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==7){
                                Positions.set(i,50);
                            }
                        }
                        btn7.setEnabled(false);
                        break;
                    case 8:
                        btn8.setText("O");
                        btn8.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==8){
                                Positions.set(i,50);
                            }
                        }
                        btn8.setEnabled(false);
                        break;
                    case 9:
                        btn9.setText("O");
                        btn9.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==9){
                                Positions.set(i,50);
                            }
                        }
                        btn9.setEnabled(false);
                        break;
                }
                btn6.setEnabled(false);
                PlayerCheck();
                AndroidCheck();
                ++numChecked;
                if(PlayerScore==0 && AndroidScore==0 && numChecked==9){
                    Toast.makeText(MainActivity.this, "IT'S A TIE", Toast.LENGTH_SHORT).show();
                }


            }
        });

        //BUTTON 7
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ++IndexRandomVal;

                btn7.setText("X");
                btn7.setTextColor(Color.parseColor("#00FF00"));
                for(int i=0;i<Positions.size();++i){
                    if(Positions.get(i)==7){
                        Positions.remove(i);
                    }
                }

                range = max - min + 1;
                int timesSelected=0;
                randCompSel = rn.nextInt(range) + 1;
                randomVals[IndexRandomVal] = randCompSel;

                boolean stopLoop=false;
                for(int i=0;i<randomVals.length;i++) {
                    if (randomVals[i] == randCompSel) {
                        ++timesSelected;
                    }


                }

                randCompSelNewSel=randCompSel;
                if (timesSelected == 2)
                {

                    do {
                        randCompSelNewSel = rn.nextInt(range) + 1;
                    }while(randCompSelNewSel==randCompSel);

                    ++IndexRandomVal;
                    randomVals[IndexRandomVal] = randCompSelNewSel;
                }


                Toast.makeText(MainActivity.this, String.valueOf(randCompSelNewSel), Toast.LENGTH_SHORT).show();
                switch (Positions.get(randCompSelNewSel)) {
                    case 1:
                        btn1.setText("O");
                        btn1.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==1){
                                Positions.set(i,50);


                            }
                        }
                        btn1.setEnabled(false);
                        break;
                    case 2:
                        btn2.setText("O");
                        btn2.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==2){
                                Positions.set(i,50);
                            }
                        }
                        btn2.setEnabled(false);
                        break;

                    case 3:
                        btn3.setText("O");
                        btn3.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==3){
                                Positions.set(i,50);
                            }
                        }
                        btn3.setEnabled(false);
                        break;
                    case 4:
                        btn4.setText("O");
                        btn4.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==4){
                                Positions.set(i,50);
                            }
                        }
                        btn4.setEnabled(false);
                        break;
                    case 5:
                        btn5.setText("O");
                        btn5.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==5){
                                Positions.set(i,50);
                            }
                        }
                        btn5.setEnabled(false);
                        break;
                    case 6:
                        btn6.setText("O");
                        btn6.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==6){
                                Positions.set(i,50);
                            }
                        }
                        btn6.setEnabled(false);
                        break;
                    case 7:
                        btn7.setText("O");
                        btn7.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==7){
                                Positions.set(i,50);
                            }
                        }
                        btn7.setEnabled(false);
                        break;
                    case 8:
                        btn8.setText("O");
                        btn8.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==8){
                                Positions.set(i,50);
                            }
                        }
                        btn8.setEnabled(false);
                        break;
                    case 9:
                        btn9.setText("O");
                        btn9.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==9){
                                Positions.set(i,50);
                            }
                        }
                        btn9.setEnabled(false);
                        break;
                }
                btn7.setEnabled(false);
                PlayerCheck();
                AndroidCheck();
                ++numChecked;
                if(PlayerScore==0 && AndroidScore==0 && numChecked==9){
                    Toast.makeText(MainActivity.this, "IT'S A TIE", Toast.LENGTH_SHORT).show();
                }


            }
        });

        //BUTTON 8
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ++IndexRandomVal;

                btn8.setText("X");
                btn8.setTextColor(Color.parseColor("#00FF00"));
                for(int i=0;i<Positions.size();++i){
                    if(Positions.get(i)==8){
                        Positions.remove(i);
                    }
                }

                range = max - min + 1;
                int timesSelected=0;
                randCompSel = rn.nextInt(range) + 1;
                randomVals[IndexRandomVal] = randCompSel;

                boolean stopLoop=false;
                for(int i=0;i<randomVals.length;i++) {
                    if (randomVals[i] == randCompSel) {
                        ++timesSelected;
                    }


                }

                randCompSelNewSel=randCompSel;
                if (timesSelected == 2)
                {

                    do {
                        randCompSelNewSel = rn.nextInt(range) + 1;
                    }while(randCompSelNewSel==randCompSel);

                    ++IndexRandomVal;
                    randomVals[IndexRandomVal] = randCompSelNewSel;
                }


                Toast.makeText(MainActivity.this, String.valueOf(randCompSelNewSel), Toast.LENGTH_SHORT).show();
                switch (Positions.get(randCompSelNewSel)) {
                    case 1:
                        btn1.setText("O");
                        btn1.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==1){
                                Positions.set(i,50);


                            }
                        }
                        btn1.setEnabled(false);
                        break;
                    case 2:
                        btn2.setText("O");
                        btn2.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==2){
                                Positions.set(i,50);
                            }
                        }
                        btn2.setEnabled(false);
                        break;

                    case 3:
                        btn3.setText("O");
                        btn3.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==3){
                                Positions.set(i,50);
                            }
                        }
                        btn3.setEnabled(false);
                        break;
                    case 4:
                        btn4.setText("O");
                        btn4.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==4){
                                Positions.set(i,50);
                            }
                        }
                        btn4.setEnabled(false);
                        break;
                    case 5:
                        btn5.setText("O");
                        btn5.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==5){
                                Positions.set(i,50);
                            }
                        }
                        btn5.setEnabled(false);
                        break;
                    case 6:
                        btn6.setText("O");
                        btn6.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==6){
                                Positions.set(i,50);
                            }
                        }
                        btn6.setEnabled(false);
                        break;
                    case 7:
                        btn7.setText("O");
                        btn7.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==7){
                                Positions.set(i,50);
                            }
                        }
                        btn7.setEnabled(false);
                        break;
                    case 8:
                        btn8.setText("O");
                        btn8.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==8){
                                Positions.set(i,50);
                            }
                        }
                        btn8.setEnabled(false);
                        break;
                    case 9:
                        btn9.setText("O");
                        btn9.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==9){
                                Positions.set(i,50);
                            }
                        }
                        btn9.setEnabled(false);
                        break;
                }
                btn8.setEnabled(false);
                PlayerCheck();
                AndroidCheck();

                ++numChecked;
                if(PlayerScore==0 && AndroidScore==0 && numChecked==9){
                    Toast.makeText(MainActivity.this, "IT'S A TIE", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //BUTTON 9
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ++IndexRandomVal;
                btn9.setText("X");
                btn9.setTextColor(Color.parseColor("#00FF00"));
                for(int i=0;i<Positions.size();++i){
                    if(Positions.get(i)==9){
                        Positions.remove(i);
                    }
                }
                range = max - min + 1;
                int timesSelected=0;
                randCompSel = rn.nextInt(range) + 1;
                randomVals[IndexRandomVal] = randCompSel;

                boolean stopLoop=false;
                for(int i=0;i<randomVals.length;i++) {
                    if (randomVals[i] == randCompSel) {
                        ++timesSelected;
                    }


                }

                randCompSelNewSel=randCompSel;
                if (timesSelected == 2)
                {

                    do {
                        randCompSelNewSel = rn.nextInt(range) + 1;
                    }while(randCompSelNewSel==randCompSel);

                    ++IndexRandomVal;
                    randomVals[IndexRandomVal] = randCompSelNewSel;
                }


                Toast.makeText(MainActivity.this, String.valueOf(randCompSelNewSel), Toast.LENGTH_SHORT).show();
                switch (Positions.get(randCompSelNewSel)) {
                    case 1:
                        btn1.setText("O");
                        btn1.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==1){
                                Positions.set(i,50);


                            }
                        }
                        btn1.setEnabled(false);
                        break;
                    case 2:
                        btn2.setText("O");
                        btn2.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==2){
                                Positions.set(i,50);
                            }
                        }
                        btn2.setEnabled(false);
                        break;

                    case 3:
                        btn3.setText("O");
                        btn3.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==3){
                                Positions.set(i,50);
                            }
                        }
                        btn3.setEnabled(false);
                        break;
                    case 4:
                        btn4.setText("O");
                        btn4.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==4){
                                Positions.set(i,50);
                            }
                        }
                        btn4.setEnabled(false);
                        break;
                    case 5:
                        btn5.setText("O");
                        btn5.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==5){
                                Positions.set(i,50);
                            }
                        }
                        btn5.setEnabled(false);
                        break;
                    case 6:
                        btn6.setText("O");
                        btn6.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==6){
                                Positions.set(i,50);
                            }
                        }
                        btn6.setEnabled(false);
                        break;
                    case 7:
                        btn7.setText("O");
                        btn7.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==7){
                                Positions.set(i,50);
                            }
                        }
                        btn7.setEnabled(false);
                        break;
                    case 8:
                        btn8.setText("O");
                        btn8.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==8){
                                Positions.set(i,50);
                            }
                        }
                        btn8.setEnabled(false);
                        break;
                    case 9:
                        btn9.setText("O");
                        btn9.setTextColor(Color.parseColor("#FF0000"));
                        for(int i=0;i<Positions.size();++i){
                            if(Positions.get(i)==9){
                                Positions.set(i,50);
                            }
                        }
                        btn9.setEnabled(false);
                        break;
                }
                btn9.setEnabled(false);
                PlayerCheck();
                AndroidCheck();
                ++numChecked;
                if(PlayerScore==0 && AndroidScore==0 && numChecked==9){
                    Toast.makeText(MainActivity.this, "IT'S A TIE", Toast.LENGTH_SHORT).show();
                }

            }
        });






    }

    public void setBoard()
    {
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
    }

    public void setEnable()
    {
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);
        btn9.setEnabled(true);
    }

    public void PlayerCheck(){
        if(btn1.getText().toString().equals("X") && btn2.getText().toString().equals("X") && btn3.getText().toString().equals("X"))
        {
            Toast.makeText(this, "PLAYER WINS", Toast.LENGTH_SHORT).show();
            PlayerScore++;


        }
        else if(btn4.getText().toString().equals("X") && btn5.getText().toString().equals("X") && btn6.getText().toString().equals("X")){
            Toast.makeText(this, "PLAYER WINS", Toast.LENGTH_SHORT).show();
            PlayerScore++;

        }
        else if(btn7.getText().toString().equals("X") && btn8.getText().toString().equals("X") && btn9.getText().toString().equals("X")){
            Toast.makeText(this, "PLAYER WINS", Toast.LENGTH_SHORT).show();
            PlayerScore++;


        }
        else if(btn3.getText().toString().equals("X") && btn5.getText().toString().equals("X") && btn7.getText().toString().equals("X")){
            Toast.makeText(this, "PLAYER WINS", Toast.LENGTH_SHORT).show();
            PlayerScore++;

        }
        else if(btn1.getText().toString().equals("X") && btn5.getText().toString().equals("X") && btn9.getText().toString().equals("X")){
            Toast.makeText(this, "PLAYER WINS", Toast.LENGTH_SHORT).show();
            PlayerScore++;
        }
        playerLabel.setText("Player: "+String.valueOf(PlayerScore));
        if(PlayerScore==1){

             IndexRandomVal=-1;
           PlayerScore=0;
           AndroidScore=0;
            setEnable();

        }
    }

    public void AndroidCheck(){
        //Android SCORE
        if(btn1.getText().toString().equals("O") && btn2.getText().toString().equals("O") && btn3.getText().toString().equals("O"))
        {
            Toast.makeText(this, "ANDROID WINS", Toast.LENGTH_SHORT).show();
            AndroidScore++;


        }
        else if(btn4.getText().toString().equals("O") && btn5.getText().toString().equals("O") && btn6.getText().toString().equals("O")){
            Toast.makeText(this, "ANDROID WINS", Toast.LENGTH_SHORT).show();
            AndroidScore++;

        }
        else if(btn7.getText().toString().equals("O") && btn8.getText().toString().equals("O") && btn9.getText().toString().equals("O")){
            Toast.makeText(this, "ANDROID WINS", Toast.LENGTH_SHORT).show();
            AndroidScore++;

        }
        else if(btn3.getText().toString().equals("O") && btn5.getText().toString().equals("O") && btn7.getText().toString().equals("O")){
            Toast.makeText(this, "ANDROID WINS", Toast.LENGTH_SHORT).show();
            AndroidScore++;

        }
        else if(btn1.getText().toString().equals("O") && btn5.getText().toString().equals("O") && btn9.getText().toString().equals("O")){
            Toast.makeText(this, "ANDROID WINS", Toast.LENGTH_SHORT).show();
            AndroidScore++;

        }
        androidLabel.setText("Android : "+String.valueOf(AndroidScore));
        if(AndroidScore==1){
            SystemClock.sleep(2000);
            setBoard();
            setEnable();
            IndexRandomVal=-1;
            PlayerScore=0;
            AndroidScore=0;
            Arrays.fill(randomVals, 0);
        }
    }
}