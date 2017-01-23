package id.adhaniscuber.parkiryuk;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.bloder.magic.view.MagicButton;
import id.adhaniscuber.parkiryuk.multidex.AppController.R;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener, GoogleMap.OnMapClickListener {

    private Toolbar toolbar;
    public GoogleMap mMap;
    private ProgressDialog loading;
    private  static  String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sendRequestArray();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_about) {
            Intent i = new Intent(MainActivity.this, AboutActivity.class);
            this.startActivity(i);
            return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    public void onMapClick(LatLng latLng) {

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        mMap.animateCamera(CameraUpdateFactory
                .newLatLngZoom(marker.getPosition(),15));
        marker.showInfoWindow();

        return true;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {

            }
        });


        mMap.setOnMarkerClickListener(this);
        mMap.setOnMapClickListener(this);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            return;
        }
        mMap.setMyLocationEnabled(true);
    }

    private void sendRequestArray() {

        String url = "http://parkiryuk.pe.hu/read_alldata.php";
        loading = ProgressDialog.show(this, "Mohon tunggu...", "Mengambil data...", false, false);

        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());

                        try {
                            for (int park = 0; park < response.length(); park++){
                                JSONObject lokasi = (JSONObject) response.get(park);

                                String sNama = lokasi.getString("nama");
                                String sLat = lokasi.getString("latitude");
                                String sLong = lokasi.getString("longitude");

                                //Toast.makeText(MainActivity.this, "" + sNama + sLat + sLong, Toast.LENGTH_SHORT).show();

                                Double flat = Double.parseDouble(sLat);
                                Double flong = Double.parseDouble(sLong);
                                LatLng fixlok = new LatLng(flat, flong);

                                mMap.addMarker(new MarkerOptions()
                                        .title(sNama)
                                        .position(fixlok)
                                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_markerpy)));

                                //Toast.makeText(MainActivity.this, "" + fixlok, Toast.LENGTH_SHORT).show();

                                mMap.animateCamera(CameraUpdateFactory.newLatLng(fixlok));
                                mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),"Errors : " + e.getMessage(),Toast.LENGTH_LONG).show();
                        }
                        loading.dismiss();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error : " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
                loading.dismiss();
            }
        });
        AppController.getInstance().addToRequestQueue(req);
    }
}
