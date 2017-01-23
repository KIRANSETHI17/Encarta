package com.mbm.cse.encarta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;


public class Flash extends AppCompatActivity {
TextView textv;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        textv=(TextView)findViewById(R.id.textflash);
       // thh=(TextView)findViewById(R.id.thh);
        img=(ImageView)findViewById(R.id.qfid);
        String str=getIntent().getExtras().getString("Black");
        if(str.equals("flash"))
        {
            img.setBackgroundResource(R.drawable.typeone);
            textv.setText(R.string.large_textflash);
           toolbar.setTitle("ACCELERA");
        }
        else if(str.equals("youth"))
        {     img.setBackgroundResource(R.drawable.youthparliament);
            textv.setText(R.string.dummy_contentyouth);
            toolbar.setTitle("YOUTH-PARLIAMENT");
        }
        else if(str.equals("humour"))
        {//getActionBar().setIcon(R.drawable.humourhunter);
            img.setBackgroundResource(R.drawable.humourhunter);
            textv.setText(R.string.dummy_contenthu);
            toolbar.setTitle("MAD ABOUT ADS");
        }

    }
}
