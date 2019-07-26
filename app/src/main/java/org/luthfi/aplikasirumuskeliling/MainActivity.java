package org.luthfi.aplikasirumuskeliling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnsegitigaA = findViewById(R.id.btnsegitiga);
        btnsegitigaA.setOnClickListener(this);

        Button btnpersegipanjangA = findViewById(R.id.btnpersegipanjang);
        btnpersegipanjangA.setOnClickListener(this);
    }
    @Override
    public void onClick (View v) {
        switch (v.getId()) {

            case R.id.btnsegitiga:
                Intent moveIntent = new Intent(MainActivity.this, Segitiga.class);
                startActivity(moveIntent);
            break;

            case R.id.btnpersegipanjang:
                Intent moveIntentA = new Intent(MainActivity.this, PersegiPanjang.class);
                startActivity(moveIntentA);
            break;
        }
    }
}
