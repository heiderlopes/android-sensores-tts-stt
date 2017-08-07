package br.com.heiderlopes.android_sensores;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MeusSensoresActivity extends AppCompatActivity {

    private ListView listaSensores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_sensores);

        listaSensores = (ListView) findViewById(R.id.listaSensores);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getListNomeSensores());

        listaSensores.setAdapter(adapter);
    }

    private String[] getListNomeSensores() {
        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        String[] lista = new String[sensorList.size()];
        for (int i = 0; i < sensorList.size(); i++) {
            lista[i] = sensorList.get(i).getName();
        }
        return lista;
    }
}
