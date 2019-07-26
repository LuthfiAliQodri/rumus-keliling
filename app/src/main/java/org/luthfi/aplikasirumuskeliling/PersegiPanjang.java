package org.luthfi.aplikasirumuskeliling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PersegiPanjang extends AppCompatActivity implements View.OnClickListener {
    private EditText ePanjang;
    private EditText eLebar;
    private Button eTotal;
    private TextView tHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persegi_panjang);

        ePanjang = findViewById(R.id.idpanjang);
        eLebar = findViewById(R.id.idlebar);
        eTotal = findViewById(R.id.submitpersegipanjang);
        tHasil = findViewById(R.id.idouthasilpersegipanjang);

        eTotal.setOnClickListener(this);
        if (savedInstanceState != null) {
            String result = savedInstanceState.getString(STATE_RESULT);
            tHasil.setText(result);
        }
    }
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.submit) ;
            String inputPanjang = ePanjang.getText().toString().trim();
            String inputLebar = eLebar.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if (TextUtils.isEmpty(inputPanjang)) {
                isEmptyFields = true;
                ePanjang.setError("Tidak Boleh Kosong!");
            }
            if (TextUtils.isEmpty(inputLebar)) {
                isEmptyFields = true;
                eLebar.setError("Tidak Boleh Kosong!");
            }

            Double panjang = toDouble(inputPanjang);
            Double lebar = toDouble(inputLebar);

            if (panjang == null) {
                isInvalidDouble = true;
                ePanjang.setError("Nomor Harus Sesuai");
            }
            if (lebar == null) {
                isInvalidDouble = true;
                eLebar.setError("Nomor Harus Sesuai");
            }
            if (!isEmptyFields && !isInvalidDouble) {
                double volume = 2 * (panjang + lebar);
                tHasil.setText(String.valueOf(volume));
            }
        }

            private Double toDouble(String str) {
                try {
                    return Double.valueOf(str);
                }catch (NumberFormatException e) {
                    return null;
                }
            }
            private static final String STATE_RESULT = "state_result";
            @Override
            protected void onSaveInstanceState(Bundle outState){
                super.onSaveInstanceState(outState);
                outState.putString(STATE_RESULT, tHasil.getText().toString());
            }


}
