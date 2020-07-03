package com.example.astachanga;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity implements ExampleDialog.ExampleDialogListener {



    public static FragmentManager fragmentManager;
    public Button btnAdd;
    public Button btnRules;
    public static Button btnSpin;
    public static TextView currentPlayer;
    public static TextView currentScore;
    public TextView displayPlayer;
    public TextView displayPlayer2;
    public TextView displayPlayer3;
    public TextView displayPlayer4;
    public static TextView previousPlayer;
    public static String []goti={"A","B","C","D"};
    public static int [][]grid=new int[4][2];
    public static String []Player=new String[4];
    public static int count=0;
    public static String  [][]curgrid=new String[5][5];
    public static int turn=0;
    public static int toss=0;
    public static int previous=-1;
    public static int []countPrevious=new int[11];
    public static Map<Integer,Integer> tossScore=new HashMap<>();
    public static int fl=0;

    //@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        grid[0][0]=2;
        grid[0][1]=0;
        grid[1][0]=4;
        grid[1][1]=2;
        grid[2][0]=2;
        grid[2][1]=4;
        grid[3][0]=0;
        grid[3][1]=2;
        tossScore.put(0,5);
        tossScore.put(1,1);
        tossScore.put(2,2);
        tossScore.put(3,3);
        tossScore.put(4,8);
        tossScore.put(5,10);

        for(int i=0;i<11;i++)
            countPrevious[i]=0;
        setUpView();
        fillGrid();




        fragmentManager=getSupportFragmentManager();



        if(findViewById(R.id.fragment_container)!=null)
        {

            if(savedInstanceState!=null)
            {
                return;
            }

            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

            HomeGridFragment homeGridFragment=new HomeGridFragment();

            fragmentTransaction.add(R.id.fragment_container,homeGridFragment,null);
            fragmentTransaction.commit();
        }


        btnRules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Intent intent=new Intent(MainActivity.this,RulesActivity.class);
                //startActivity(intent);
                //startActivityForResult(intent,100);

                RulesDialog rulesDialog=new RulesDialog();
                rulesDialog.show(getSupportFragmentManager(),"Example");

            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openDialog();


            }
        });

        btnSpin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {


                if(count<1)//Toss without player
                    return;
                if(turn!=previous)
                    currentScore.setText("");

                if(previous==-1)
                {

                    ThreadLocalRandom threadRandom = ThreadLocalRandom.current();

                    turn=(int)threadRandom.nextInt(0, count);
                    if(turn==0)
                        previous=count-1;
                    else
                        previous=turn-1;

                    currentPlayer.setText(Player[turn]);
                    previousPlayer.setText("");
                    return;
                }

                ThreadLocalRandom threadRandom = ThreadLocalRandom.current();

                toss=(int)threadRandom.nextInt(0, 6);
                btnSpin.setText(String.valueOf(tossScore.get(toss)));

                if(currentScore.getText().length()>0)
                currentScore.setText(currentScore.getText()+","+String.valueOf(tossScore.get(toss)));
                else
                    currentScore.setText(String.valueOf(tossScore.get(toss)));



                    //currentScore.setText(String.valueOf(toss));
                //if(turn==0)
                  //  previous=count-1;
                //else
                  // previous=turn-1;
                previous=turn;
                countPrevious[tossScore.get(toss)]++;
                if(toss!=0&&toss!=4&&toss!=5)
                      turn++;
                else if(countPrevious[tossScore.get(toss)]>=3)
                {
                    deleteLatestThree();
                    //btnSpin.setText("SPIN");
                    countPrevious[tossScore.get(toss)]=0;
                    turn++;
                }

                turn=turn%count;
                previousPlayer.setText(Player[previous]);
                currentPlayer.setText(Player[turn]);
                //previous=Player[turn%count];

            }
        });

    }

    public void deleteLatestThree()
    {

        String str=currentScore.getText().toString();

        int loc=0;
        int ct=0;
        for(int i=str.length()-1;i>=0;i--)
        {
            if(str.charAt(i)==',')
                ct++;
            if(ct==3)
            {
                loc=i;
                break;
            }

        }
        currentScore.setText(str.substring(0,loc));
    }

    public void fillGrid()
    {

        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
                curgrid[i][j]=" ";
        }
    }
    @Override
    public void applyTexts(String user) {

        String temp1=user.trim();
        if(temp1.length()==0)
            return;
        if(count<4) {
            curgrid[grid[count][0]][grid[count][1]]=goti[count]+goti[count]+goti[count]+goti[count];
            Player[count++] = user;
            MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new HomeGridFragment(),null).commit();

        }
        String temp="";
        for(int  i=0;i<count;i++)
        {
            temp=temp+Player[i]+"\n";
            if(i==0) {
                displayPlayer.setText(Player[i] + "\t\t\t" + goti[i]);

            }
            else if(i==1) {

                displayPlayer2.setText(Player[i] + "\t\t\t" + goti[i]);
            }
            else if(i==2) {

                displayPlayer3.setText(Player[i] + "\t\t\t" + goti[i]);
            }
            else {
                displayPlayer4.setText(Player[i] + "\t\t\t" + goti[i]);
            }
        }
        /*String htmltext="<h1 style=color:blue;>This is a heading</h1>";


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            displayPlayer.setText(Html.fromHtml(htmltext, Html.FROM_HTML_MODE_COMPACT));
        }
        else {
            displayPlayer.setText(Html.fromHtml(htmltext));
        }
        //displayPlayer.setText(temp);*/
    }
    public void openDialog()
    {

        ExampleDialog exampleDialog=new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(),"Example");

    }
    public void setUpView()
    {
        btnAdd=(Button)findViewById(R.id.addbtn);
        btnRules=(Button)findViewById(R.id.rulesBtn);
        displayPlayer=(TextView)findViewById(R.id.displayPlayer);
        displayPlayer2=(TextView)findViewById(R.id.displayPlayer2);
        displayPlayer3=(TextView)findViewById(R.id.displayPlayer3);
        displayPlayer4=(TextView)findViewById(R.id.displayPlayer4);
        btnSpin=(Button)findViewById(R.id.btnSpin);
        currentPlayer=(TextView)findViewById(R.id.currentPlayer);
        currentScore=(TextView)findViewById(R.id.currentScore);
        previousPlayer=(TextView)findViewById(R.id.previousPlayer);


    }

}