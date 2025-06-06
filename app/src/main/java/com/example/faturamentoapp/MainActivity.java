package com.example.faturamentoapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private NumberPicker mNumberPickerAno;
    private RadioGroup mRadioGroupAdicionaExclui;
    private EditText mEditTextValor;
    private TextView mTextViewSaldo;
    private Button mButtonConfirma;
    private Button mButtonAdicionarTitulo;
    public static final String ARQUIVO_MEUS_DADOS = "MeusDados";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        mNumberPickerAno = findViewById(R.id.npAno);
        mRadioGroupAdicionaExclui = findViewById(R.id.rgAdicionaExclui);
        mEditTextValor = findViewById(R.id.etValor);
        mTextViewSaldo = findViewById(R.id.tvSaldo);
        mButtonConfirma = findViewById(R.id.btnConfirma);
        mButtonAdicionarTitulo = findViewById(R.id.btnAdicionarTitulo);

        /* @+id/npAno (mNumberPickerAno) */
        mNumberPickerAno.setMinValue(2015);
        mNumberPickerAno.setMaxValue(2025);
        int ano = mNumberPickerAno.getValue();

        /* @+id/rgAdicionaExclui (mRadioGroupAdicionaExclui) */
        int checkedRadioButtonId = mRadioGroupAdicionaExclui.getCheckedRadioButtonId();
        if (checkedRadioButtonId == R.id.rbAdicionar){
            adicionarValor();
        } else if (checkedRadioButtonId == R.id.rbExcluir){
            excluirValor();
        }

        /* @+id/etValor (mEditTextValor) */
        float valor = Float.parseFloat(mEditTextValor.getText().toString());

        /* @+id/tvSaldo (mTextViewSaldo) */
        float saldo = 0;
        mTextViewSaldo.setText(String.format("R$ %f", saldo));

        /* @+id/btnConfirma (mButtonConfirma) */
        mButtonConfirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ano = mNumberPickerAno.getValue();
                float valor = Float.parseFloat(mEditTextValor.getText().toString());

                int checkedRadioButtonId = mRadioGroupAdicionaExclui.getCheckedRadioButtonId();
                if (checkedRadioButtonId == R.id.rbAdicionar){
                    adicionarValor(ano, valor);
                } else if (checkedRadioButtonId == R.id.rbExcluir){
                    excluirValor(ano, valor);
                }
                exibirSaldo(ano);
            }
        });

        /* @+id/btnAdicionarTitulo (mButtonAdicionarTitulo) */
        mButtonAdicionarTitulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), TituloActivity.class);
                startActivity(intent);
            }
        });
    }

    public void adicionarValor(int ano, float valor){
        SharedPreferences sharedPreferences =
                getSharedPreferences(ARQUIVO_MEUS_DADOS, Context.MODE_PRIVATE);
        float valorAtual = sharedPreferences.getFloat(String.valueOf(ano), 0);
        float valorFinal = valorAtual + valor;
        sharedPreferences.edit().putFloat(String.valueOf(ano), valorFinal).apply();
    }
    public void excluirValor(int ano, float valor){
        SharedPreferences sharedPreferences =
                getSharedPreferences(ARQUIVO_MEUS_DADOS, Context.MODE_PRIVATE);
        float valorAtual = sharedPreferences.getFloat(String.valueOf(ano), 0);
        float valorFinal = valorAtual + valor;
        sharedPreferences.edit().putFloat(String.valueOf(ano), valorFinal);
    }
    public void exibirSaldo(int ano){
        SharedPreferences sharedPreferences =
                getSharedPreferences(ARQUIVO_MEUS_DADOS, Context.MODE_PRIVATE);
        float saldo = sharedPreferences.getFloat(String.valueOf(ano), 0);
        mTextViewSaldo.setText(String.format("R$ %f", saldo));
    }

}