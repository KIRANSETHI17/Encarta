package com.mbm.cse.encarta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;


/**
 * Created by Lenovo on 09-10-2016.
 */

public class Splash extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashh);
       // final ImageView iv=(ImageView)findViewById(R.id.imageView2);
        new CountDownTimer(3000, 1000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                finish();
                Intent i =new Intent(getBaseContext(),EncarTa.class);
                startActivity(i);

            }
        }.start();






    }
}
