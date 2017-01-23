package com.mbm.cse.encarta;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.google.firebase.messaging.FirebaseMessaging;


public class    EncarTa extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MyFirebaseIIDService";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encar_ta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) toolbar.getLayoutParams();
        params.setScrollFlags(0);




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);


try{
        FirebaseMessaging.getInstance().subscribeToTopic("team");

        FirebaseMessaging.getInstance().subscribeToTopic("team-" + "1");
       /* String token = FirebaseInstanceId.getInstance().getToken();

        // Log and toast
        Log.d("FCM", token);}*/
   }
catch(Exception e)
{

}

    }



    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Quiz) {
            Intent xyz = new Intent(getApplicationContext(), QuizZone.class);


            startActivity(xyz);


            // Handle the camera action
        }

        else if (id == R.id.nav_Alo) {
            Intent xyz = new Intent(getApplicationContext(), Alohomora.class);
            startActivity(xyz);


        } else if (id == R.id.nav_Tech) {
            Intent xyz = new Intent(getApplicationContext(), ScrollingActivityone.class);
            startActivity(xyz);


        }

        else if (id == R.id.nav_Quizone) {
            Intent xyz = new Intent(getApplicationContext(), QuizZard.class);
            startActivity(xyz);


        }

        else if (id == R.id.nav_blue || id==R.id.nav_ckt || id==R.id.nav_line) {
            Intent xyz = new Intent(getApplicationContext(), Ingenieur.class);
            startActivity(xyz);


        }


        else if (id == R.id.nav_Not) {
            Intent xyz = new Intent(getApplicationContext(), Sponsor.class);
            startActivity(xyz);}



        else if (id == R.id.nav_Dev) {
            Intent xyz = new Intent(getApplicationContext(), Developers.class);
            startActivity(xyz);


        }

        else if (id == R.id.nav_Dal || id==R.id.nav_Pic) {
            Intent xyz = new Intent(getApplicationContext(), Specials.class);
            startActivity(xyz);


        }

        else if (id == R.id.nav_cont) {
            Intent xyz = new Intent(getApplicationContext(),Contact.class);
            startActivity(xyz);


        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
