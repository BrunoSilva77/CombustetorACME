package com.example.combustetoracme;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    EditText edtCarro, edtKMInicial, edtKMFinal, edtLitros, edtMedia;
    TextView txtStatus;
    Spinner spiCombustivel;
    RadioButton rddLigado, rddDesligado;
    Switch swiBagagens;
    Button btnCalcular, btnNovo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtCarro = (EditText) findViewById(R.id.edtCarro);
        edtKMInicial = (EditText) findViewById(R.id.edtKMInicial);
        edtKMFinal = (EditText) findViewById(R.id.edtKMFinal);
        edtLitros = (EditText) findViewById(R.id.edtLitros);
        edtMedia = findViewById(R.id.edtMedia);

        txtStatus = (TextView) findViewById(R.id.txtStatus);

        spiCombustivel = (Spinner) findViewById(R.id.spiCombustivel);

        rddLigado = (RadioButton) findViewById(R.id.rddLigado);
        rddDesligado = (RadioButton) findViewById(R.id.rddDesligado);

        swiBagagens = (Switch) findViewById(R.id.swiBagagens);

        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnNovo = (Button) findViewById(R.id.btnNovo);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int Media;

                String Combustivel = (String) spiCombustivel.getSelectedItem();

                Media = ((Integer.parseInt(edtKMFinal.getText().toString())) - (Integer.parseInt(edtKMInicial.getText().toString()) / Integer.parseInt(edtLitros.getText().toString())));

                if (rddLigado.isChecked()) {
                    Media--;
                }

                if (swiBagagens.isChecked()) {
                    Media--;
                }

                edtMedia.setText(String.valueOf(Media));

                if ("Alcool".equals(Combustivel)) {
                    if (Media >= 7) {
                        txtStatus.setText("Excelente");
                    } else if (Media >= 4) {
                        txtStatus.setText("Normal");
                    } else {
                        txtStatus.setText("Oficina Urgente!!");
                    }
                } else if ("Gasolina".equals(Combustivel)) {
                    if (Media >= 9) {
                        txtStatus.setText("Excelente");
                    } else if (Media >= 7) {
                        txtStatus.setText("Normal");
                    } else {
                        txtStatus.setText("Oficina Urgente!!");
                    }
                } else if ("Tundrilium".equals(Combustivel)) {
                    if (Media >= 85) {
                        txtStatus.setText("Excelente");
                    } else if (Media >= 45) {
                        txtStatus.setText("Normal");
                    } else {
                        txtStatus.setText("Oficina Urgente!!");
                    }
                } else {
                    txtStatus.setText("Selecione um combustivel");
                }
            }
        });

        btnNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                edtCarro.setText("");
                edtKMInicial.setText("");
                edtKMFinal.setText("");
                edtLitros.setText("");

                rddDesligado.setChecked(true);

                swiBagagens.setChecked(false);

                txtStatus.setText("");
                edtMedia.setText("");

                edtCarro.requestFocus();

            }
        });

    }
}