package id.adhaniscuber.parkiryuk;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import id.adhaniscuber.parkiryuk.adapter.CustomListAdapter;
import id.adhaniscuber.parkiryuk.model.ParkirData;
import id.adhaniscuber.parkiryuk.multidex.AppController.R;

/**
 * Created by adhaniscuber on 23/01/17.
 */

public class DaftarparkirActivity extends Activity {

    // Log TAG
    private static final String TAG = DaftarparkirActivity.class.getSimpleName();

    // Parkir JSON URL
    private static final String url = "http://parkiryuk.pe.hu/api.php";
    private ProgressDialog pDialog;
    private List<ParkirData> parkirDataList = new ArrayList<ParkirData>();
    private ListView listView;
    private CustomListAdapter adapter;
    private String sNama, sAlamat, sKota, sJenis, sBiayaMotor, sBiayaMobil, sBiayaMotorTambah, sBiayaMobilTambah, sMaxBiayaMotor, sMaxBiayaMobil, sKeterangan, sMotor, sMobil, sTotalKendaraan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parkirlist_layout);

        listView = (ListView) findViewById(R.id.list);
        adapter = new CustomListAdapter(this, parkirDataList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                sNama = parkirDataList.get(i).getNama();
                sAlamat = parkirDataList.get(i).getAlamat();
                sKota = parkirDataList.get(i).getKota();
                sJenis = parkirDataList.get(i).getJenis();
                sBiayaMotor = parkirDataList.get(i).getBiayaMotor();
                sBiayaMobil = parkirDataList.get(i).getBiayaMobil();
                sBiayaMotorTambah = parkirDataList.get(i).getBiayaMotorTambah();
                sBiayaMobilTambah = parkirDataList.get(i).getBiayaMobilTambah();
                sMaxBiayaMotor = parkirDataList.get(i).getMaxBiayaMotor();
                sMaxBiayaMobil = parkirDataList.get(i).getMaxBiayaMobil();
                sKeterangan = parkirDataList.get(i).getKeterangan();
                sMotor = parkirDataList.get(i).getMotor();
                sMobil = parkirDataList.get(i).getMobil();
                sTotalKendaraan = parkirDataList.get(i).getTotalKendaraan();

                Intent detail = new Intent(DaftarparkirActivity.this, DetailActivity.class);

                detail.putExtra("nama", sNama);
                detail.putExtra("alamat", sAlamat);
                detail.putExtra("kota", sKota);
                detail.putExtra("jenis", sJenis);
                detail.putExtra("biaya_motor", sBiayaMotor);
                detail.putExtra("biaya_mobil", sBiayaMobil);
                detail.putExtra("biaya_motor_tambah", sBiayaMotorTambah);
                detail.putExtra("biaya_mobil_tambah", sBiayaMobilTambah);
                detail.putExtra("max_biaya_motor", sMaxBiayaMotor);
                detail.putExtra("max_biaya_mobil", sMaxBiayaMobil);
                detail.putExtra("keterangan", sKeterangan);
                detail.putExtra("motor", sMotor);
                detail.putExtra("mobil", sMobil);
                detail.putExtra("total_kendaraan", sTotalKendaraan);
                startActivity(detail);
            }
        });

        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();

        // Creating volley request obj
        JsonArrayRequest movieReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        hidePDialog();

                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                ParkirData parkirData = new ParkirData();
                                parkirData.setNama(obj.getString("nama"));
                                parkirData.setAlamat(obj.getString("alamat"));
                                parkirData.setKota(obj.getString("kota"));
                                parkirData.setJenis(obj.getString("jenis"));
                                parkirData.setBiayaMotor(obj.getString("biaya_motor"));
                                parkirData.setBiayaMobil(obj.getString("biaya_mobil"));
                                parkirData.setBiayaMotorTambah(obj.getString("biaya_motor_tambah"));
                                parkirData.setBiayaMobilTambah(obj.getString("biaya_mobil_tambah"));
                                parkirData.setMaxBiayaMotor(obj.getString("max_biaya_motor"));
                                parkirData.setMaxBiayaMobil(obj.getString("max_biaya_mobil"));
                                parkirData.setKeterangan(obj.getString("keterangan"));
                                parkirData.setMotor(obj.getString("motor"));
                                parkirData.setMobil(obj.getString("mobil"));
                                parkirData.setTotalKendaraan(obj.getString("total_kendaraan"));
                                // adding movie to movies array
                                parkirDataList.add(parkirData);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                        // notifying list adapter about data changes
                        // so that it renders the list view with updated data
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                hidePDialog();

            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(movieReq);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
