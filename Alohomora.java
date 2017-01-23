package com.mbm.cse.encarta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



        import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
        import android.widget.RelativeLayout;

public class Alohomora extends AppCompatActivity {
    int flag=1;
    ImageButton but;
    ImageButton round1;
    ImageButton round2;
    RelativeLayout currentlayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alohomora);
        but=(ImageButton)findViewById(R.id.image);
        round1=(ImageButton)findViewById(R.id.button1);
        round2=(ImageButton)findViewById(R.id.button2);
        currentlayout=(RelativeLayout)findViewById(R.id.activity_alohomora);
       // but.setBackgroundResource(android.R.drawable.arrow_up_float);

    }

    public void fab(View view)
    { ((ImageButton) view).setImageResource(android.R.drawable.arrow_up_float);

        if(flag==1)
        {
            round1.setVisibility(View.VISIBLE);
            round2.setVisibility(View.VISIBLE);
            //  currentlayout.setBackgroundColor(Color.LTGRAY);
         //but.setBackgroundResource(android.R.drawable.arrow_down_float);
            ((ImageButton) view).setImageResource(android.R.drawable.arrow_down_float);
            flag=0;
        }
        else if(flag==0)
        {   round1.setVisibility(View.INVISIBLE);
            round2.setVisibility(View.INVISIBLE);
            flag=1;
           // but.setBackgroundResource(android.R.drawable.arrow_up_float);
            ((ImageButton) view).setImageResource(android.R.drawable.arrow_up_float);
        }

    }

    public void level1(View view) {
        Intent hello=new Intent(getApplicationContext(),ScrollingActivity.class);

        startActivity(hello);

    }

    public void level2(View view) {
        Intent hello=new Intent(getApplicationContext(),Signin.class);

        startActivity(hello);
    }
}
