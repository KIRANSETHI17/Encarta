package com.mbm.cse.encarta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class LabyRinth extends AppCompatActivity {
ImageView img;
    TextView textv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laby_rinth);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        img=(ImageView)findViewById(R.id.imageView2);
        textv=(TextView)findViewById(R.id.textviewtext);
String str=getIntent().getExtras().getString("Black");
        if(str.equals("laby"))
        {img.setBackgroundResource(R.drawable.labyrinth);
            textv.setText(R.string.laby);
            setTitle("HEAD RUSH");
    }
        else if(str.equals("quizup"))
        {img.setBackgroundResource(R.drawable.quix);
            textv.setText(R.string.quizup);
            setTitle("QUIZ UP");
        }
        else if(str.equals("digi"))
        {img.setBackgroundResource(R.drawable.digitalfortress);
            textv.setText(R.string.digital);
            setTitle("DIGITAL-FORTRESS");
        }


    }}
