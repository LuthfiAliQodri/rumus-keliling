package org.luthfi.aplikasirumuskeliling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Segitiga extends AppCompatActivity implements View.OnClickListener {
    private EditText eSisiA;
    private EditText eSisiB;
    private EditText eSisiC;
    private Button eTotal;
    private TextView tHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segitiga);

        eSisiA = findViewById(R.id.ida);
        eSisiB = findViewById(R.id.idb);
        eSisiC = findViewById(R.id.idc);
        eTotal = findViewById(R.id.submit);
        tHasil = findViewById(R.id.thasil);

        eTotal.setOnClickListener(this);
        if (savedInstanceState != null) {
            String result = savedInstanceState.getString(STATE_RESULT);
            tHasil.setText(result);

    }
}

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.submit);
        String inputSisiA = eSisiA.getText().toString().trim();
        String inputSisiB = eSisiB.getText().toString().trim();
        String inputSisiC = eSisiC.getText().toString().trim();

        boolean isEmptyFields = false;
        boolean isInvalidDouble = false;

        if (TextUtils.isEmpty(inputSisiA)) {
            isEmptyFields = true;
            eSisiA.setError("Tidak Boleh Kosong!");
        }if (TextUtils.isEmpty(inputSisiB)) {
            isEmptyFields = true;
            eSisiB.setError("Tidak Boleh Kosong!");
        }if (TextUtils.isEmpty(inputSisiC)) {
            isEmptyFields = true;
            eSisiC.setError("Tidak Boleh Kosong!");
        }

        Double sisia = toDouble (inputSisiA);
        Double sisib = toDouble(inputSisiB);
        Double sisic = toDouble(inputSisiC);

        if (sisia == null) {
            isInvalidDouble = true;
            eSisiA.setError("Nomor Harus Sesuai");
        }if (sisib == null) {
            isInvalidDouble = true;
            eSisiB.setError("Nomor Harus Sesuai");
        }if (sisic == null) {
            isInvalidDouble = true;
            eSisiC.setError("Nomor Harus Sesuai");
        }if (!isEmptyFields && !isInvalidDouble) {
            double volume = sisia + sisib + sisic;
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
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tHasil.getText().toString());
    }
}
