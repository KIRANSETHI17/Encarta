package com.mbm.cse.encarta;

import android.graphics.Color;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class TheGauntletActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_gauntlet);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView anishasText = (TextView)findViewById(R.id.anishasText);
        String mes = getIntent().getExtras().getString("com.pro.anisha.message");
        ImageView titleImg = (ImageView)findViewById(R.id.anishasImage);
        if(mes.equals("code_marathon"))
        {
            titleImg.setImageResource(R.drawable.code_marathon);
            anishasText.setText(R.string.code_marathon_text);
            anishasText.setTextColor(Color.parseColor("#000000"));
            getSupportActionBar().setTitle(R.string.title_activity_code_marathon);




        }
        else if(mes.equals("bandit"))
        {
            titleImg.setImageResource(R.drawable.bandit);
            anishasText.setText(R.string.bandit_text);
            getSupportActionBar().setTitle("Bandit");
            anishasText.setTextColor(Color.parseColor("#000000"));

        }
        else if(mes.equals("flex_your_brain"))
        {
            titleImg.setImageResource(R.drawable.flex_your_brain);
            anishasText.setText(R.string.flex_your_brain_text);
            getSupportActionBar().setTitle("Code Mutants");
            anishasText.setTextColor(Color.parseColor("#000000"));

        }
        else if(mes.equals("insomnia"))
        {
            titleImg.setImageResource(R.drawable.insomnia);
            anishasText.setText(R.string.insomnia_text);
            getSupportActionBar().setTitle(R.string.title_activity_insomnia);
            anishasText.setTextColor(Color.parseColor("#000000"));

        }
        else if(mes.equals("python_phreakers"))
        {
            titleImg.setImageResource(R.drawable.python_phreakers);
            anishasText.setText(R.string.python_phreakers_text);
            getSupportActionBar().setTitle(R.string.title_activity_python_phreakers);
            anishasText.setTextColor(Color.parseColor("#000000"));

        }

        else if(mes.equals("webcrats"))
        {
            titleImg.setImageResource(R.drawable.webcrats);
            anishasText.setText(R.string.webcrats_text);
            getSupportActionBar().setTitle(R.string.title_activity_webcrats);
            anishasText.setTextColor(Color.parseColor("#000000"));

        }

        else if(mes.equals("klutzy_code"))
        {
            titleImg.setImageResource(R.drawable.klutzy_code);
            anishasText.setText(R.string.klutzy_code_text);
            getSupportActionBar().setTitle(R.string.title_activity_klutzy_code);
            anishasText.setTextColor(Color.parseColor("#000000"));

        }
        else if(mes.equals("clean_up"))
        {
            titleImg.setImageResource(R.drawable.clean_up);
            anishasText.setText(R.string.clean_up_text);
            getSupportActionBar().setTitle("Clean The Bugs");
            anishasText.setTextColor(Color.parseColor("#000000"));

        }
        else if(mes.equals("the_gauntlet"))
        {
            titleImg.setImageResource(R.drawable.gauntlet);
            titleImg.setFitsSystemWindows(true);
            anishasText.setText(R.string.the_gauntlet_text);
            getSupportActionBar().setTitle(R.string.title_activity_the_gauntlet);
            anishasText.setTextColor(Color.parseColor("#000000"));

        }
        else if(mes.equals("bragging"))
        {
            titleImg.setImageResource(R.drawable.bragging);
            anishasText.setText(R.string.bragging_text);
            getSupportActionBar().setTitle(R.string.title_activity_bragging);
            anishasText.setTextColor(Color.parseColor("#000000"));
            toolbar.setTitleTextColor(Color.parseColor("#2196f3"));

        }
        else if(mes.equals("chaos"))
        {
            titleImg.setImageResource(R.drawable.chaos);
            anishasText.setText(R.string.chaos_text);
            getSupportActionBar().setTitle(R.string.title_activity_chaos);
            anishasText.setTextColor(Color.parseColor("#000000"));

        }



        /*
        titleImg.setImageResource(getIntent().getExtras().getInt("ImageId"));

        ViewGroup layout_anisha = (ViewGroup)findViewById(R.id.layout_anisha);
        layout_anisha.addView(anishasText);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getIntent().getExtras().getString("TitleText"));*/



    }
}
