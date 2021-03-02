package com.example.exportcsv;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    private static SensorManager sensorManager;
    private Sensor sensorA;
    private Sensor sensorG;

    private final float[] accelerometerReading = new float[3];
    private final float[] gyroscopeReading = new float[3];
    StringBuilder data = new StringBuilder();
    int walking=0,running=0,standing=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        sensorA = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorG = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        data.append("accX accY accZ gyroX gyroY gyroZ timestamp Activity");
    }

  /*  @Override
    protected void onResume() {
        super.onResume();


    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
*/
    public void start(View view)
    {
        if (sensorA != null && sensorG != null) {

            sensorManager.registerListener(this, sensorA,
                    10000, 10000);

            sensorManager.registerListener(this, sensorG,
                    10000, 10000);

            if(view.getId()==R.id.walking)
                walking=1;
            else if(view.getId()==R.id.running)
                running=1;
            else if(view.getId()==R.id.standing)
                standing=1;


        }

    }

    public void stop(View view)
    {
        sensorManager.unregisterListener(this);
        walking=0;
        running=0;
        standing=0;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            System.arraycopy(event.values, 0, accelerometerReading,
                    0, accelerometerReading.length);

        }

        if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            System.arraycopy(event.values, 0, gyroscopeReading,
                    0, gyroscopeReading.length);

        }
        if(walking==1)
            data.append("\n"+String.valueOf(accelerometerReading[0])+" "+String.valueOf(accelerometerReading[1])+" "+String.valueOf(accelerometerReading[2])+" "+String.valueOf(gyroscopeReading[0])+" "+String.valueOf(gyroscopeReading[1])+" "+String.valueOf(gyroscopeReading[2])+" "+java.time.LocalTime.now()+" SS");
        else if(running==1)
            data.append("\n"+String.valueOf(accelerometerReading[0])+" "+String.valueOf(accelerometerReading[1])+" "+String.valueOf(accelerometerReading[2])+" "+String.valueOf(gyroscopeReading[0])+" "+String.valueOf(gyroscopeReading[1])+" "+String.valueOf(gyroscopeReading[2])+" "+java.time.LocalTime.now()+" NS");
        else if(standing==1)
            data.append("\n"+String.valueOf(accelerometerReading[0])+" "+String.valueOf(accelerometerReading[1])+" "+String.valueOf(accelerometerReading[2])+" "+String.valueOf(gyroscopeReading[0])+" "+String.valueOf(gyroscopeReading[1])+" "+String.valueOf(gyroscopeReading[2])+" "+java.time.LocalTime.now()+" LS");


        try{
            //saving the file into device
            FileOutputStream out = openFileOutput("data.csv", Context.MODE_PRIVATE);
            out.write((data.toString()).getBytes());
            out.close();

            //exporting
         /*   Context context = getApplicationContext();
            File filelocation = new File(getFilesDir(), "data.csv");
            Uri path = FileProvider.getUriForFile(context, "com.example.exportcsv.fileprovider", filelocation);
            Intent fileIntent = new Intent(Intent.ACTION_SEND);
            fileIntent.setType("text/csv");
            fileIntent.putExtra(Intent.EXTRA_SUBJECT, "Data");
            fileIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            fileIntent.putExtra(Intent.EXTRA_STREAM, path); */
        //    startActivity(Intent.createChooser(fileIntent, "Send mail"));
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }



    public void export(View view){
        //generate data




        try{
            //saving the file into device
           /* FileOutputStream out = openFileOutput("data.csv", Context.MODE_PRIVATE);
            out.write((data.toString()).getBytes());
            out.close();
*/
            //exporting
            Context context = getApplicationContext();
            File filelocation = new File(getFilesDir(), "data.csv");
            Uri path = FileProvider.getUriForFile(context, "com.example.exportcsv.fileprovider", filelocation);
            Intent fileIntent = new Intent(Intent.ACTION_SEND);
            fileIntent.setType("text/csv");
            fileIntent.putExtra(Intent.EXTRA_SUBJECT, "Data");
            fileIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            fileIntent.putExtra(Intent.EXTRA_STREAM, path);
            startActivity(Intent.createChooser(fileIntent, "Send mail"));
        }
        catch(Exception e){
            e.printStackTrace();
        }


    }
}