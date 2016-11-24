package com.thomaskioko.learningandroid;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Activity demonstrates how to implement maps in Android.
 *
 * @author Thomas Kioko
 */
public class GoogleMapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    // iHub latitude and longitude
    double mLatitude = -1.292066;
    double mLongitude = 36.821946;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_maps);

        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager()
                        .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        // Add a marker
        LatLng sydney = new LatLng(mLatitude, mLongitude);
        googleMap.addMarker(new MarkerOptions().position(sydney)
                .title("Ihub"));

        //Animate camera to position
        CameraPosition cameraPosition = new CameraPosition.Builder().target(
                new LatLng(mLatitude, mLongitude)).zoom(12).build();

        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        //Enable Zoom
        googleMap.getUiSettings().setZoomControlsEnabled(true);

        //Enable Compass
        googleMap.getUiSettings().setCompassEnabled(true);

        //Enable Gestures
        googleMap.getUiSettings().setAllGesturesEnabled(true);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        googleMap.setMyLocationEnabled(true);

    }
}
