package br.com.heiderlopes.android_sensores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirMeusSensores(View v){
        startActivity(new Intent(this, MeusSensoresActivity.class));
    }

    public void abrirAcelerometro(View v) {
        startActivity(new Intent(this, AcelerometroActivity.class));
    }

    public void abrirTTS(View v){
        startActivity(new Intent(this, TTSActivity.class));
    }

    public void abrirSTT(View v){
        startActivity(new Intent(this, STTActivity.class));
    }
}
