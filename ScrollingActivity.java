package com.mbm.cse.encarta;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class ScrollingActivity extends AppCompatActivity {
private  CollapsingToolbarLayout coll=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levelone);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       coll=(CollapsingToolbarLayout)findViewById(R.id.toolbar_layout);
        coll.setTitle("LEVEL 1");
       // coll.setCollapsedTitleGravity("center");
       // coll.setCollapsedTitleTextAppearance(R.style.collapsedappbar);
       // coll.setCollapsedTitleTypeface();
        //to be checked after running
       // coll.setContentScrimColor(getResources().getColor(R.color.colorlevel));
       // coll.setStatusBarScrimColor(getResources().getColor(R.color.colorlevel));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
