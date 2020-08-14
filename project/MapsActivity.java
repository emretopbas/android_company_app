package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap map;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment smf = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.mapFragment);
        smf.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        Log.e("x","Map Object Is Ready");
        map = googleMap;

        MarkerOptions mo = new MarkerOptions()
                .title("Apple Computer Inc.")
                .snippet("37.329408, -122.031341")
                .position(new LatLng(37.329408, -122.031341));

        map.addMarker(mo);
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Normal").setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);
        menu.add("Hybrid").setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);
        menu.add("Satellite").setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);
        menu.add("Terrain").setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        String s =item.getTitle().toString();
        if (s.equals("Normal"))     map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        if (s.equals("Hybrid"))     map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        if (s.equals("Satellite"))     map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        if (s.equals("Terrain"))     map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        return super.onOptionsItemSelected(item);
    }
}
