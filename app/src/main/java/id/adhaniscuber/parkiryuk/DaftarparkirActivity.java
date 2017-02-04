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
    private static final String url = "http://parkiryuk.pe.hu/read_alldata.php";
    private ProgressDialog pDialog;
    private List<ParkirData> parkirDataList = new ArrayList<ParkirData>();
    private ListView listView;
    private CustomListAdapter adapter;

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
                String nama = parkirDataList.get(i).getNama();
                Intent intent = new Intent(DaftarparkirActivity.this, DetailActivity.class);
                intent.putExtra("nama",nama);
                startActivity(intent);
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
                                parkirData.setJalan(obj.getString("jalan"));
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
