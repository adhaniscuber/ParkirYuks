package id.adhaniscuber.parkiryuk;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import id.adhaniscuber.parkiryuk.multidex.AppController.R;

import static com.google.android.gms.maps.model.BitmapDescriptorFactory.fromResource;


/**
 * Created by adhaniscuber on 04/02/17.
 */

public class DetailActivity extends AppCompatActivity implements OnMapReadyCallback {

    private String nama;
    private Double lat, lng;
    private TextView text;
    private GoogleMap mMap;
    private GPSTracker gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map2);
        mapFragment.getMapAsync(this);

        Intent uhuy = getIntent();
        nama = uhuy.getStringExtra("nama");
        lat = uhuy.getDoubleExtra("latitude",0);
        lng = uhuy.getDoubleExtra("longitude",0);

        text = (TextView) findViewById(R.id.detailNama);
        text.setText(nama+" "+lat+" "+lng);



    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setAllGesturesEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(false);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setMapToolbarEnabled(false);

        Intent uhuy = getIntent();
        nama = uhuy.getStringExtra("nama");
        lat = uhuy.getDoubleExtra("latitude",0);
        lng = uhuy.getDoubleExtra("longitude",0);

        LatLng latLng = new LatLng(lat, lng);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));
        mMap.addMarker(new MarkerOptions()
                            .position(latLng)
                            .title(nama)
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_markerpy)))
                            .showInfoWindow();

    }
}
