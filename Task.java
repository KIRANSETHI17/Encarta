package com.mbm.cse.encarta;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;



public class Task extends AppCompatActivity {
    TextView quest, score,rank;
    EditText ans;
    Button submit, hintx, next,scoreb;
    RelativeLayout layout;
    ProgressBar pg;
    int j = 0;
    int k;

    ArrayList<String> ques = new ArrayList<String>();
    ArrayList<Integer> qid = new ArrayList<Integer>();
    String str ;
      TextView mTextField; 

    @Override
    public void onBackPressed()
    {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        layout =(RelativeLayout)findViewById(R.id.activity_task);
        pg=(ProgressBar)findViewById(R.id.pg2);
        quest = (TextView) findViewById(R.id.textView);
        ans = (EditText) findViewById(R.id.editText);
        submit = (Button) findViewById(R.id.button2);
        scoreb = (Button) findViewById(R.id.button3);


        mTextField = (TextView) findViewById(R.id.textView17);
        score = (TextView) findViewById(R.id.textView2);
        rank = (TextView) findViewById(R.id.textView3);
        hintx = (Button) findViewById(R.id.button4);
        next = (Button) findViewById(R.id.button5);
        str = getIntent().getExtras().getString("key");
        next.setEnabled(false);

pg.setVisibility(View.INVISIBLE);
        new CountDownTimer(3600000, 1000) {

            public void onTick(long millisUntilFinished) {
                long x=(millisUntilFinished / 1000);
              if(x<3540)  { long sec=3599-(millisUntilFinished / 1000);
               long secs=sec%60;
                  secs=60-secs;


                  mTextField.setText( "Time Left - "+ millisUntilFinished / (1000*60)+":"+ secs+" mins");}
              else if(x==3540)
                  mTextField.setText( "Time Left - "+ "58"+":"+"60"+" mins");
                else if(x>3540)
              {long sec=3601-(millisUntilFinished / 1000);
                  sec=60-sec;
                  mTextField.setText( "Time Left - "+ millisUntilFinished / (1000*60)+":"+ sec+" mins");
              }


            }


            public void onFinish() {
                mTextField.setText("Time Over!!");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                    finish();
                    }
                }, 10000);
            }
        }.start();







        // Toast.makeText(Task.this, " "+str, Toast.LENGTH_LONG).show();
        new Question().execute("http://encarta.csembm.in/android/quest.php?team_id="+str);
       // new Question().execute("http://192.168.43.161/prev/quest.php?team_id="+str);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next.setBackgroundColor(Color.parseColor("#4682b4"));
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        next.setBackgroundColor(Color.parseColor("#cacfd2"));
                    }
                }, 1000);

                k = j+1;


                quest.setText(ques.get(k));
                submit.setEnabled(true);
                //submit.setVisibility(View.VISIBLE);
                ans.setText("");

                switch(j)
                {case 0:layout.setBackgroundResource(R.drawable.bgone);
                    break;
                    case 1:layout.setBackgroundResource(R.drawable.bgtwo);
                        break;
                    case 2:layout.setBackgroundResource(R.drawable.bgthree);
                        break;
                    case 3:layout.setBackgroundResource(R.drawable.lonf);
                        break;
                    case 4:layout.setBackgroundResource(R.drawable.bgfour);
                        break;
                    case 6:layout.setBackgroundResource(R.drawable.bgfive);
                        break;
                    case 5:layout.setBackgroundResource(R.drawable.bgsix);
                        break;
                    case 7:layout.setBackgroundResource(R.drawable.bgseven);
                        break;
                    case 8:layout.setBackgroundResource(R.drawable.bgeight);
                        break;
                    case 9:layout.setBackgroundResource(R.drawable.bgnine);
                        break;
                    case 10:layout.setBackgroundResource(R.drawable.bgone);
                        break;
                    default :layout.setBackgroundResource(R.drawable.bgtwo);



                }
                j = j + 1;
                next.setEnabled(false);
                //next.setVisibility(View.INVISIBLE);


            }
        });

        scoreb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Toast.makeText(Task.this,"score click",Toast.LENGTH_LONG).show();
                new rank().execute("http://encarta.csembm.in/android/rank.php?team_id="+str);
              //  new rank().execute("http://192.168.43.161//prev/rank.php?team_id="+str);
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(Task.this,""+j,Toast.LENGTH_SHORT).show();
               // next.setVisibility(View.VISIBLE);
                submit.setBackgroundColor(Color.parseColor("#4682b4"));
                // SLEEP 2 SECONDS HERE ...
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        submit.setBackgroundColor(Color.parseColor("#cacfd2"));
                    }
                }, 500);


                if(j>8)
                {Toast.makeText(Task.this,"Game Finished",Toast.LENGTH_LONG).show();
                    new Logout().execute("http://encarta.csembm.in/android/logout.php?team_id="+str);
                    finish();
                }
                 // Toast.makeText(Task.this,qid.get(j)+" "+ans.getText().toString()+" "+str,Toast.LENGTH_LONG).show();
               // new Submit().execute("http://encarta.csembm.in/android/scoreput.php?team_id="+str+"&q_id="+qid.get(j)+"&answer="+ans.getText().toString());
                else
                    new Submit().execute("http://encarta.csembm.in/android/scoreput.php?team_id="+str+"&q_id="+qid.get(j)+"&answer="+ans.getText().toString());
                //new Submit().execute("http://192.168.43.161//prev/scoreput.php?team_id="+str+"&q_id="+qid.get(j)+"&answer="+ans.getText().toString());

            }
        });

        hintx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hintx.setBackgroundColor(Color.parseColor("#4682b4"));// Toast.makeText(Task.this,qid.get(j)+" "+ans.getText().toString()+" "+str,Toast.LENGTH_LONG).show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        hintx.setBackgroundColor(Color.parseColor("#cacfd2"));
                    }
                }, 500);

                Intent i=new Intent(getApplicationContext(),MapsActivity.class);
                Bundle b = new Bundle();


                b.putString("key1", str);
                b.putInt("key2",qid.get(j));
                i.putExtras(b);

                //i.putExtra("lat",latitudes);
                //i.putExtra("longi",longitudes);
                startActivity(i);


            }
        });}











    public class rank extends AsyncTask<String, Void, ArrayList<String>>{

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

                ArrayList<String> ranks = new ArrayList<String>();


                if (finalJson != null) {


                    JSONObject jsonObject = new JSONObject(finalJson);
                    //String status= jsonObject.getString("status");
                    //JSONArray arr=jsonObject.getJSONArray("results");
                    String scoret = jsonObject.getString("score");
                    ranks.add(scoret);
                    String rankt =jsonObject.getString("rank");
                    ranks.add(rankt);

                    return ranks;
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
                score.setText(result.get(1));
                rank.setText(result.get(0));

            }
        }


    }

    public class Submit extends AsyncTask<String, Void, ArrayList<String>> {
        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
            pg.setVisibility(View.VISIBLE);
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

                ArrayList<String> names = new ArrayList<String>();


                if (finalJson != null) {


                    JSONObject jsonObject = new JSONObject(finalJson);
                    //String status= jsonObject.getString("status");
                    //JSONArray arr=jsonObject.getJSONArray("results");
                    String result = jsonObject.getString("result");
                    names.add(result);
                    String message = jsonObject.getString("message");
                    names.add(message);
                    return names;
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

            pg.setVisibility(View.INVISIBLE);
            if (result != null) {
                String msg = result.get(1);
                if (result.get(0).equals("1")) {
                    next.setEnabled(true);
                    submit.setEnabled(false);
                    //next.setVisibility(View.VISIBLE);
                   // submit.setVisibility(View.INVISIBLE);

                    Toast.makeText(Task.this, msg, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Task.this, msg, Toast.LENGTH_SHORT).show();
                    next.setEnabled(false);
                    ans.setText(" ");
                    submit.setEnabled(true);
                }

                //new rank2().execute("http://192.168.43.161//prev/rank.php?team_id="+str);
            }
        }



    }
    public class Question extends AsyncTask<String, Void, ArrayList<String>> {
        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
            // pg.setVisibility(View.VISIBLE);
        }

        @Override
        protected ArrayList<String> doInBackground(String... abc) {
            // TODO Auto-generated method stub
            HttpURLConnection connection = null;
            int i = 0;
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


                if (finalJson != null) {


                    JSONArray arr = new JSONArray(finalJson);
                    for (i = 0; i < arr.length(); i++) {
                        JSONObject finali = arr.getJSONObject(i);
                        String qstion = finali.getString("question");
                        int q_id = finali.getInt("q_id");
                        ques.add(qstion);
                        qid.add(q_id);
                    }
                    return ques;
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


            if (result != null) {

                quest.setText(result.get(0));

            }
        }
    }
    public class Logout extends AsyncTask<String, Void, ArrayList<String>> {
        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
            // pg.setVisibility(View.VISIBLE);
        }

        @Override
        protected ArrayList<String> doInBackground(String... abc) {
            // TODO Auto-generated method stub
            HttpURLConnection connection = null;
            int i = 0;
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



                ArrayList<String> msg = new ArrayList<String>();


                if (finalJson != null) {


                    JSONObject jsonObject = new JSONObject(finalJson);
                    //String status= jsonObject.getString("status");
                    //JSONArray arr=jsonObject.getJSONArray("results");
                    String result = jsonObject.getString("message");
                    msg.add(result);

                    return msg;
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


            if (result != null) {

                Toast.makeText(Task.this,result.get(0),Toast.LENGTH_SHORT).show();

            }
        }
    }

}



