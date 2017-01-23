package com.mbm.cse.encarta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.widget.Button;
import android.widget.TextView;

public class Contact extends AppCompatActivity {
    TextView mtextView,t2;
    Button b1,b2,b3,b4,b5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mtextView=(TextView)findViewById(R.id.textView8);
        mtextView.setPaintFlags(mtextView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        mtextView.setText("Visit Our Website");

        t2=(TextView)findViewById(R.id.textView7);
        t2.setPaintFlags(t2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        t2.setText("Follow Us on Facebook");

        b1=(Button)findViewById(R.id.button7);
        b1.setPaintFlags(b1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        b1.setText("7791064539");
        b1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub



                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:7791064539"));
                if (ActivityCompat.checkSelfPermission(getBaseContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    startActivity(callIntent);

                }
                startActivity(callIntent);


            }
        });

        b2=(Button)findViewById(R.id.button8);
        b2.setPaintFlags(b2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        b2.setText("7728857856");
        b2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent callIntent=new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:7728857856"));
                if(ActivityCompat.checkSelfPermission(getBaseContext(),Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED)
                {
                    startActivity(callIntent);
                }
                startActivity(callIntent);
            }
        });

        b3=(Button)findViewById(R.id.button);
        b3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                Uri uri = Uri.parse("http://encarta.csembm.in/"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);


            }
        });
        b4=(Button)findViewById(R.id.button6);
        b4.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Uri uri = Uri.parse("https://www.facebook.com"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });



    }

}