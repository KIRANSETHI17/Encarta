package com.mbm.cse.encarta;

import android.graphics.Color;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    double laty,longy;
    String latitudes,longitudes,team_id;
    int q_id;
    Button hint;
   static int flag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        hint=(Button)findViewById(R.id.button6);
        Bundle b = getIntent().getExtras();
        team_id = b.getString("key1");
        q_id=b.getInt("key2");
        flag=0;




        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.clear();
                flag++;
                Log.d("gir", flag+"");

                flagfun(flag);
               new Hint().execute("http://encarta.csembm.in/android/hint.php?team_id="+team_id+"&q_id="+q_id);
                   // new Hint().execute("http://192.168.43.161//prev/hint.php?team_id="+team_id+"&q_id="+q_id);

                //timer
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        LatLng hint = new LatLng( laty, longy);
                        mMap.addMarker(new MarkerOptions().position(hint).title("Hint for Ques:"));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(hint));
                        mMap.animateCamera( CameraUpdateFactory.zoomTo( 17.0f ) );

                    }
                }, 2000);


              /*  LatLng hint = new LatLng( laty, longy);
                mMap.addMarker(new MarkerOptions().position(hint).title("Hint for Ques:"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(hint));
                mMap.animateCamera( CameraUpdateFactory.zoomTo( 17.0f ) );
*/

                   // Toast.makeText(MapsActivity.this,latitudes+""+longitudes,Toast.LENGTH_SHORT).show();

            }
        });
        //   lat=getIntent().getExtras().getString("lat");
        //longi=getIntent().getExtras().getString("longi");


    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);


//Double latt=Double.parseDouble(lat);
        //Double longg=Double.parseDouble(longi);;
        // Add a marker in Sydney and move the camera
        //LatLng hint = new LatLng(laty, longy);
        //mMap.addMarker(new MarkerOptions().position(hint).title("Pak is here"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(hint));
    }
    public void flagfun(int flag)
    {if(flag>=1)
    hint.setEnabled(false);}
    public class Hint extends AsyncTask<String, Void, ArrayList<String>> {

        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();

            // pg.setVisibility(View.VISIBLE);
        }

        @Override
        protected ArrayList<String> doInBackground(String... abc) {
            // TODO Auto-generated method stub
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            try {
                URL url = new URL(abc[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
                String finalJson = buffer.toString();

                ArrayList<String> hints = new ArrayList<String>();


                if (finalJson != null) {


                    JSONObject jsonObject = new JSONObject(finalJson);
                    //String status= jsonObject.getString("status");
                    //JSONArray arr=jsonObject.getJSONArray("results");
                    String lat = jsonObject.getString("lat");

                    hints.add(lat);
                    String longi =jsonObject.getString("longitude");
                    hints.add(longi);
                    Log.d("Kiranlat",lat);
                    Log.d("Kiranlong",longi);
                    return  hints;
                }


            } catch (Exception e) {
                // TODO: handle exception
            }
            return null;
        }

        // @Override
        protected void onPostExecute(ArrayList<String> result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);


            if (result != null) {
                latitudes=result.get(0);
                Log.d("Kiranlatitudes",latitudes);
                longitudes=result.get(1);
                Log.d("Kiranlongitu",longitudes);
                   //
                try{
                    laty=Double.parseDouble(latitudes);
                    Log.d("Kiranlaty", laty+"hey");
                    longy=Double.parseDouble(longitudes);
                    Log.d("Kiranlongy", longy+"hello");}
                catch(Exception e){
                    // Toast.makeText(MapsActivity.this,""+e,Toast.LENGTH_SHORT).show();
                }

            }
        }


    }
}
