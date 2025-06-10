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

    public void adicionarValor(int ano, float valor) {
        SharedPreferences sharedPreferences =
                getSharedPreferences(ARQUIVO_MEUS_DADOS, Context.MODE_PRIVATE);
        float valorAtual = sharedPreferences.getFloat(String.valueOf(ano), 0);
        float valorFinal = valorAtual + valor;
        sharedPreferences.edit().putFloat(String.valueOf(ano), valorFinal).apply();
    }

    public void excluirValor(int ano, float valor) {
        SharedPreferences sharedPreferences =
                getSharedPreferences(ARQUIVO_MEUS_DADOS, Context.MODE_PRIVATE);
        float valorAtual = sharedPreferences.getFloat(String.valueOf(ano), 0);
        float valorFinal = valorAtual - valor;

        if (valorFinal < 0) {
            valorFinal = 0;
        }

        sharedPreferences.edit().putFloat(String.valueOf(ano), valorFinal).apply();
    }

    public void exibirSaldo(int ano) {
        SharedPreferences sharedPreferences =
                getSharedPreferences(ARQUIVO_MEUS_DADOS, Context.MODE_PRIVATE);
        float saldo = sharedPreferences.getFloat(String.valueOf(ano), 0);
        mTextViewSaldo.setText(String.format("R$ %f", saldo));
    }

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

        mNumberPickerAno.setMinValue(2015);
        mNumberPickerAno.setMaxValue(2025);
        mNumberPickerAno.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int valorAntigo, int valorNovo) {
                exibirSaldo(valorNovo);
            }
        });

        mButtonConfirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ano = mNumberPickerAno.getValue();
                float valor = Float.parseFloat(mEditTextValor.getText().toString());

                int checkedRadioButtonId = mRadioGroupAdicionaExclui.getCheckedRadioButtonId();
                if (checkedRadioButtonId == R.id.rbAdicionar) {
                    adicionarValor(ano, valor);
                } else if (checkedRadioButtonId == R.id.rbExcluir) {
                    excluirValor(ano, valor);
                }
                exibirSaldo(ano);
            }
        });

        mButtonAdicionarTitulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), TituloActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_MEUS_DADOS, Context.MODE_PRIVATE);
        String nomeFantasia = sharedPreferences.getString("nomeFantasia", null);
        if(nomeFantasia!=null){
            setTitle(nomeFantasia);
        }
        int ano = mNumberPickerAno.getValue();
        exibirSaldo(ano);
    }

/* (IMPLEMENTAÇÃO NA ORDEM-XML) */
/**
 @+id/npAno (mNumberPickerAno)
 {linhas 71 - 78}
    mNumberPickerAno.setMinValue(2015);
    mNumberPickerAno.setMaxValue(2025);
 {linha 83}
    int ano = mNumberPickerAno.getValue();
    mNumberPickerAno.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker picker, int valorAntigo, int valorNovo) {
            exibirSaldo(ano);
        }
    });

 @+id/rgAdicionaExclui (mRadioGroupAdicionaExclui)
 {linhas 86 - 92}
    int checkedRadioButtonId = mRadioGroupAdicionaExclui.getCheckedRadioButtonId();
    if (checkedRadioButtonId == R.id.rbAdicionar){
        adicionarValor();
    } else if (checkedRadioButtonId == R.id.rbExcluir){
        excluirValor();
    }
    exibirSaldo(ano);

 @+id/etValor (mEditTextValor)
 {linha 84}
    float valor = Float.parseFloat(mEditTextValor.getText().toString());

 @+id/tvSaldo (mTextViewSaldo)
 {linhas 54 - 55}
    float saldo = 0;
    mTextViewSaldo.setText(String.format("R$ %f", saldo));

 @+id/btnConfirma (mButtonConfirma)
 {linhas 80 - 94}
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

 @+id/btnAdicionarTitulo (mButtonAdicionarTitulo)
 {linhas 96 - 102}
    mButtonAdicionarTitulo.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getBaseContext(), TituloActivity.class);
            startActivity(intent);
        }
    });
 */
}