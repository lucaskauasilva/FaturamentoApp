package com.example.faturamentoapp;

import android.os.Bundle;
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

        /* @+id/btnCadastrar (mButtonCadastrar) */ //(à implementar)
    }
}