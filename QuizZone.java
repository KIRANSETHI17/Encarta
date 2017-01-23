package com.mbm.cse.encarta;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

public class QuizZone extends AppCompatActivity {
    ImageButton imageButtonflash, imageButtony;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_zone);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        addListenerOnButton();
        addListenerOnButton1();
        addListenerOnButton2();


    }

    public void addListenerOnButton() {

        imageButtonflash = (ImageButton) findViewById(R.id.imageButtonf);

        imageButtonflash.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent i = new Intent(getApplicationContext(), Flash.class);
                i.putExtra("Black", "flash");
                startActivity(i);

            }

        });
    }

    public void addListenerOnButton1() {

        imageButtony = (ImageButton) findViewById(R.id.imageButtony);

        imageButtony.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent i = new Intent(getApplicationContext(), Flash.class);
                i.putExtra("Black", "youth");
                startActivity(i);

            }

        });
    }

    public void addListenerOnButton2() {

        imageButtony = (ImageButton) findViewById(R.id.imageButtonh);

        imageButtony.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent i = new Intent(getApplicationContext(), Flash.class);
                i.putExtra("Black", "humour");
                startActivity(i);

            }

        });
    }


}