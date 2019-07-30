package org.luthfi.aplikasirumuskeliling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    int req_code = 1;

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
                Intent data = new Intent(MainActivity.this, Segitiga.class);
                startActivityForResult(data, req_code);
                break;

            case R.id.btnpersegipanjang:
                Intent moveIntentA = new Intent(MainActivity.this, PersegiPanjang.class);
                startActivity(moveIntentA);
            break;

        }
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == req_code){
            if (resultCode == RESULT_OK){
                TextView hasil = findViewById(R.id.view1);
                hasil.setText(data.getData().toString());
                //Toast.maketText(this.data.getData().toString(),Toast.LENGTH_LONG.show();
            }
        }
    }
}
