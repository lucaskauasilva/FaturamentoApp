package com.example.faturamentoapp;

import android.os.Bundle;
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

        /* @+id/tvSaldo (mTextViewSaldo) */

        /* @+id/btnConfirma (mButtonConfirma) */

        /* @+id/btnAdicionarTitulo (mButtonAdicionarTitulo) */
    }
}