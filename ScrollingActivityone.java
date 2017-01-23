package com.mbm.cse.encarta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;

public class ScrollingActivityone extends AppCompatActivity {

    /*public static final String KEY = "com.pro.anisha.message";*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollingone);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }
    public void codeMarathon(View a)
    {

        Intent abc=new Intent(getApplicationContext(),TheGauntletActivity.class);
        /*abc.putExtra("ImageId",R.drawable.code_marathon);
        abc.putExtra("DescText",R.string.code_marathon_text);
        abc.putExtra("TitleText",R.string.title_activity_code_marathon);*/
        abc.putExtra("com.pro.anisha.message","code_marathon");
        startActivity(abc);
    }
    public void bandit(View a)
    {

        Intent abc=new Intent(getApplicationContext(),TheGauntletActivity.class);
        /*abc.putExtra("ImageId",R.drawable.code_marathon);
        abc.putExtra("DescText",R.string.code_marathon_text);
        abc.putExtra("TitleText",R.string.title_activity_code_marathon);*/
        abc.putExtra("com.pro.anisha.message","bandit");
        startActivity(abc);
    }
    public void flexYourBrain(View a)
    {
        Intent abc=new Intent(getApplicationContext(),TheGauntletActivity.class);
       /* abc.putExtra("ImageId",R.drawable.flex_your_brain);
        abc.putExtra("DescText",R.string.flex_your_brain_text);
        abc.putExtra("TitleText",R.string.title_activity_flex_your_brain);*/
        abc.putExtra("com.pro.anisha.message","flex_your_brain");
        startActivity(abc);
    }
    public void insomnia(View a)
    {
        Intent abc=new Intent(getApplicationContext(),TheGauntletActivity.class);

        abc.putExtra("com.pro.anisha.message","insomnia");
        startActivity(abc);
    }
    public void pythonPhreakers(View a)
    {
        Intent abc=new Intent(getApplicationContext(),TheGauntletActivity.class);

        abc.putExtra("com.pro.anisha.message","python_phreakers");
        startActivity(abc);
    }
    public void klutzyCode(View a)
    {
        Intent abc=new Intent(getApplicationContext(),TheGauntletActivity.class);

        abc.putExtra("com.pro.anisha.message","klutzy_code");
        startActivity(abc);
    }
    public void cleanUp(View a)
    {
        Intent abc=new Intent(getApplicationContext(),TheGauntletActivity.class);

        abc.putExtra("com.pro.anisha.message","clean_up");
        startActivity(abc);
    }
    public void theGauntlet(View a)
    {
        Intent abc=new Intent(getApplicationContext(),TheGauntletActivity.class);

        abc.putExtra("com.pro.anisha.message","the_gauntlet");
        startActivity(abc);
    }
    public void bragging(View a)
    {
        Intent abc=new Intent(getApplicationContext(),TheGauntletActivity.class);

        abc.putExtra("com.pro.anisha.message","bragging");
        startActivity(abc);
    }
    public void chaos(View a)
    {
        Intent abc=new Intent(getApplicationContext(),TheGauntletActivity.class);

        abc.putExtra("com.pro.anisha.message","chaos");
        startActivity(abc);
    }
    public void webcrats(View a)
    {
        Intent abc=new Intent(getApplicationContext(),TheGauntletActivity.class);

        abc.putExtra("com.pro.anisha.message","webcrats");
        startActivity(abc);
    }
}
