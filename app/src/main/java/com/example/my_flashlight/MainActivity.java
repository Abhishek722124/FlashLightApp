package com.example.my_flashlight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {

ToggleButton toggleButton;
CameraManager cameraManager;
String cameraID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = findViewById(R.id.toggleButtonFlashLight);

        cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try {
            cameraID = cameraManager.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

    }

    public void light_switch(View view){

        if(toggleButton.isChecked()){

            try {
                cameraManager.setTorchMode(cameraID,true);
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }

            Toast.makeText(this, "Flash Light is turned ON", Toast.LENGTH_SHORT).show();

        }
        else {

            try {
                cameraManager.setTorchMode(cameraID,false);
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }

            Toast.makeText(this, "Flash Light is turned OFF", Toast.LENGTH_SHORT).show();

        }

    }

}