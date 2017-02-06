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

public class DetailActivity extends AppCompatActivity {

    private String nama, alamat, kota, jenis, biayaMotor, biayaMotorTambah, biayaMobil, biayaMobilTambah, maxBiayaMotor, maxBiayaMobil, motor, mobil, totalKendaraan, keterangan;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent uhuy = getIntent();
        nama = uhuy.getStringExtra("nama");
        alamat = uhuy.getStringExtra("alamat");
        kota = uhuy.getStringExtra("kota");
        jenis = uhuy.getStringExtra("jenis");
        biayaMotor = uhuy.getStringExtra("biaya_motor");
        biayaMobil = uhuy.getStringExtra("biaya_mobil");
        biayaMotorTambah = uhuy.getStringExtra("biaya_motor_tambah");
        biayaMobilTambah = uhuy.getStringExtra("biaya_mobil_tambah");
        maxBiayaMotor = uhuy.getStringExtra("max_biaya_motor");
        maxBiayaMobil = uhuy.getStringExtra("max_biaya_mobil");
        keterangan = uhuy.getStringExtra("keterangan");
        motor = uhuy.getStringExtra("motor");
        mobil = uhuy.getStringExtra("mobil");
        totalKendaraan = uhuy.getStringExtra("total_kendaraan");


        text = (TextView) findViewById(R.id.deNama);
        text.setText(nama);
        text = (TextView) findViewById(R.id.deAlamat);
        text.setText(alamat);
        text = (TextView) findViewById(R.id.deKota);
        text.setText(kota);
        text = (TextView) findViewById(R.id.deNama);
        text.setText(jenis);
        text = (TextView) findViewById(R.id.deBMotor);
        text.setText(biayaMotor);
        text = (TextView) findViewById(R.id.deBMobil);
        text.setText(biayaMobil);
        text = (TextView) findViewById(R.id.deBMotorT);
        text.setText(biayaMotorTambah);
        text = (TextView) findViewById(R.id.deBMobilT);
        text.setText(biayaMobilTambah);
        text = (TextView) findViewById(R.id.deKeterangan);
        text.setText(keterangan);
        text = (TextView) findViewById(R.id.deMotor);
        text.setText(motor);
        text = (TextView) findViewById(R.id.deMobil);
        text.setText(mobil);
        text = (TextView) findViewById(R.id.deTotal);
        text.setText(totalKendaraan);



    }
}
