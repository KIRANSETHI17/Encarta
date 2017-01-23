package com.mbm.cse.encarta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Signin extends AppCompatActivity {
    EditText user,passwd;
    String team_id="";
    ProgressBar pg;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        user = (EditText) findViewById(R.id.editText1);
        passwd=(EditText) findViewById(R.id.editText2);
        b1=(Button)findViewById(R.id.button);
        team_id=user.getText().toString();
        pg=(ProgressBar)findViewById(R.id.pg);
        pg.setVisibility(View.INVISIBLE);
        //pg = (ProgressBar) findViewById(R.id.progressBar1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Login().execute("http://encarta.csembm.in/android/login.php?team_id="+user.getText().toString()+"&password="+passwd.getText().toString());
               // new Login().execute("http://192.168.43.161/xxx/login.php?team_id="+user.getText().toString()+"&password="+passwd.getText().toString());

            }
        });


    }

    public class Login extends AsyncTask<String, Void, ArrayList<String>> {
        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
            pg.setVisibility(View.VISIBLE);
            // pg.setVisibility(View.VISIBLE);
        }

        @Override
        protected ArrayList<String> doInBackground(String... abc) {
            // TODO Auto-generated method stub
            HttpURLConnection connection=null;
            BufferedReader reader=null;
            try {URL url=new URL(abc[0]);
                connection =(HttpURLConnection)url.openConnection();
                connection.connect();
                InputStream stream=connection.getInputStream();
                reader=new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer=new StringBuffer();
                String line="";
                while((line=reader.readLine())!=null)
                {buffer.append(line);
                }
                String finalJson=buffer.toString();

                ArrayList<String> names=new ArrayList<String>();




                if (finalJson != null) {


                    JSONObject jsonObject = new JSONObject(finalJson);
                    //String status= jsonObject.getString("status");
                    //JSONArray arr=jsonObject.getJSONArray("results");
                    String result=jsonObject.getString("result");
                    names.add(result);
                    String message=jsonObject.getString("message");
                    names.add(message);
                    return names;
                }


            } catch (Exception e) {
                // TODO: handle exception
            }
            return null;
        }

        @Override
        protected void onPostExecute(ArrayList<String> result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);

            pg.setVisibility(View.INVISIBLE);
            if (result != null) {
                int x=Integer.parseInt(result.get(0));

                String msg=result.get(1);
                if(x==1)
                {
                    Intent i=new Intent(getApplicationContext(),Task.class);
                    i.putExtra("key",user.getText().toString());
                    //Toast.makeText(MainActivity.this, " "+user.getText().toString(), Toast.LENGTH_LONG).show();
                    startActivity(i);


                }
                else
                {
                    Toast.makeText(Signin.this, msg, Toast.LENGTH_SHORT).show();
                }


            }
        }
    }

}




