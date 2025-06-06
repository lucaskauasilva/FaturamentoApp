package com.example.faturamentoapp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TituloActivity extends AppCompatActivity {

    private EditText mEditTextNomeFantasia;
    private Button mButtonCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_titulo);

        mEditTextNomeFantasia = findViewById(R.id.etNomeFantasia);
        mButtonCadastrar = findViewById(R.id.btnCadastrar);

        /* @+id/etNomeFantasia (mEditTextNomeFantasia) */ //(à implementar)
        String nomeFantasia = mEditTextNomeFantasia.getText().toString();

        /* @+id/btnCadastrar (mButtonCadastrar) */ //(à implementar)
        mButtonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeFantasia = mEditTextNomeFantasia.getText().toString();

                if (!nomeFantasia.isEmpty()) {
                    getSharedPreferences(MainActivity.ARQUIVO_MEUS_DADOS, Context.MODE_PRIVATE).
                            edit().putString("nomeFantasia", nomeFantasia).apply();
                }
            }
        });
    }
}