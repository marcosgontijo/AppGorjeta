package com.example.aplicativogorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView textPorcentagem;
    private TextView textTotal;
    private TextView textGorjeta;
    private SeekBar seekBarGorjeta;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.editValor);
        textPorcentagem = findViewById(R.id.textPorcentagem);
        textTotal = findViewById(R.id.textTotal);
        textGorjeta = findViewById(R.id.textGorjeta);
        seekBarGorjeta = findViewById(R.id.seekBarGorjeta);

        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                porcentagem = progress;
                textPorcentagem.setText(porcentagem + "%");
                calcular();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void calcular() {

        String valorRecuperado = editValor.getText().toString();

        if (valorRecuperado == null || valorRecuperado.equals("")) {

            Toast.makeText(getApplicationContext(), "Digite o valor da conta primeiro", Toast.LENGTH_LONG).show();
        } else {

            double valorDigitado = Double.parseDouble(valorRecuperado);
            double gorjeta = valorDigitado * (porcentagem / 100);
            double total = gorjeta + valorDigitado;

            textGorjeta.setText("R$ " + gorjeta);
            textTotal.setText("R$ " + total);
        }

    }

}