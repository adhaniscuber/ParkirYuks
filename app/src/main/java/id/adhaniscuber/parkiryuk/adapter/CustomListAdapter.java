package id.adhaniscuber.parkiryuk.adapter;

import id.adhaniscuber.parkiryuk.AppController;
import id.adhaniscuber.parkiryuk.model.ParkirData;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import id.adhaniscuber.parkiryuk.multidex.AppController.R;

/**
 * Created by adhaniscuber on 23/01/17.
 */

public class CustomListAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<ParkirData> parkirList;

    public CustomListAdapter(Activity activity, List<ParkirData> parkirList) {
        this.activity = activity;
        this.parkirList = parkirList;
    }

    @Override
    public int getCount() {
        return parkirList.size();
    }

    @Override
    public Object getItem(int location) {
        return parkirList.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);

        TextView nama = (TextView) convertView.findViewById(R.id.nama);
        TextView jalan = (TextView) convertView.findViewById(R.id.jalan);


        // getting parkir data for the row
        ParkirData p = parkirList.get(position);


        // nama
        nama.setText(p.getNama());

        // jalan
        jalan.setText(p.getKota());

        return convertView;
    }
}
