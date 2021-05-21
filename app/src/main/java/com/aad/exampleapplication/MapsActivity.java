package com.aad.exampleapplication;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Добавление координат мест firebase realtimedatabase (имя точки и широта и долгота
        LatLng gremyachaya_Griva = new LatLng(56.00569155704801, 92.7662883984328);
        mMap.addMarker(new MarkerOptions().position(gremyachaya_Griva).title("Гремячая Грива"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(gremyachaya_Griva));
        mMap.setOnMarkerClickListener(this);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        openAnotherActivity(marker);
        return false;
    }


    public void openAnotherActivity(Marker marker) {
        Intent i = new Intent(MapsActivity.this, MainActivity.class);
        i.putExtra("PlaceName", marker.getTitle());
        Log.d("Taga", i.getStringExtra("PlaceName"));
        startActivity(i);
    }
}