package br.com.heiderlopes.android_sensores;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AcelerometroActivity extends AppCompatActivity implements SensorEventListener {

    private TextView tvEixoX;
    private TextView tvEixoY;
    private TextView tvEixoZ;
    private TextView tvDirecao;

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acelerometro);

        tvEixoX = (TextView) findViewById(R.id.tvEixoX);
        tvEixoY = (TextView) findViewById(R.id.tvEixoY);
        tvEixoZ = (TextView) findViewById(R.id.tvEixoZ);
        tvDirecao = (TextView) findViewById(R.id.tvDirecao);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        Float x = event.values[0];
        Float y = event.values[1];
        Float z = event.values[2];

        tvEixoX.setText("Posição X: " + x.intValue() + " Float: " + x);
        tvEixoY.setText("Posição Y: " + y.intValue() + " Float: " + y);
        tvEixoZ.setText("Posição Z: " + z.intValue() + " Float: " + z);

        if(y < 0) { // O dispositivo esta de cabeça pra baixo
            if(x > 0)
                tvDirecao.setText("Virando para ESQUERDA ficando INVERTIDO");
            if(x < 0)
                tvDirecao.setText("Virando para DIREITA ficando INVERTIDO");
        } else {
            if(x > 0)
                tvDirecao.setText("Virando para ESQUERDA ");
            if(x < 0)
                tvDirecao.setText("Virando para DIREITA ");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}
}
