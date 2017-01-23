package com.mbm.cse.encarta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class QuizZard extends AppCompatActivity {
    Button kbc,laby,digi,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_zard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        addListenerOnButton();
        addListenerOnButton1();
        addListenerOnButton2();
        addListenerOnButton3();


    }
    public void addListenerOnButton() {

        kbc=(Button)findViewById(R.id.button2);

        kbc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent i=new Intent(getApplicationContext(),KBC.class);
                startActivity(i);

            }

        });}
    public void addListenerOnButton1() {

        laby=(Button)findViewById(R.id.button3);

        laby.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent i=new Intent(getApplicationContext(),LabyRinth.class);
                i.putExtra("Black", "laby");
                startActivity(i);

            }

        });}
    public void addListenerOnButton2() {

        digi=(Button)findViewById(R.id.button4);
        digi.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent i=new Intent(getApplicationContext(),LabyRinth.class);
                i.putExtra("Black", "digi");
                startActivity(i);

            }

        });}
    public void addListenerOnButton3() {

        b4=(Button)findViewById(R.id.button5);

        b4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent i=new Intent(getApplicationContext(),LabyRinth.class);
                i.putExtra("Black", "quizup");
                startActivity(i);

            }

        });}

}
