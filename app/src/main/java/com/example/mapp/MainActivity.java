package com.example.mapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

public class MainActivity extends AppCompatActivity {

    MapView map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Configuration.getInstance().load(getApplicationContext(),
                getSharedPreferences("osm", MODE_PRIVATE));

        setContentView(R.layout.activity_main);

        map = findViewById(R.id.main);

        map.setMultiTouchControls(true);

        GeoPoint point = new GeoPoint(12.9716, 77.5946);

        map.getController().setZoom(15.0);
        map.getController().setCenter(point);

        Marker marker = new Marker(map);
        marker.setPosition(point);
        marker.setTitle("Current Location");
        map.getOverlays().add(marker);
    }
}