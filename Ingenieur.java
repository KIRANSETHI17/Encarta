package com.mbm.cse.encarta;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Ingenieur extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingenieur);
    }

    public void blueprint(View view) {
       // AlertDialog.Builder ad=  new AlertDialog.Builder(this);
        final Dialog dialog = new Dialog(this);// Context, this, etc.
        dialog.setTitle(R.string.titblue);
        dialog.setContentView(R.layout.dialog);

        dialog.show();
    }

    public void cktcipher(View view) {
        final Dialog dialog = new Dialog(this);// Context, this, etc.
        dialog.setTitle(R.string.titckt);
        dialog.setContentView(R.layout.diatwo);

        dialog.show();
    }

    public void Linefollowr(View view) {
        final Dialog dialog = new Dialog(this);// Context, this, etc.
        dialog.setTitle(R.string.titline);
        dialog.setContentView(R.layout.diathree);

        dialog.show();
    }
    public void Openhardware(View view) {
        final Dialog dialog = new Dialog(this);// Context, this, etc.
        dialog.setTitle("Open Hardware");
        dialog.setContentView(R.layout.diaopenh);

        dialog.show();
    }
    public void Opensoftware(View view) {
        final Dialog dialog = new Dialog(this);// Context, this, etc.
        dialog.setTitle("Open Software");
        dialog.setContentView(R.layout.diaopens);

        dialog.show();
    }

    public void openDialog() {

    }
}
