package id.adhaniscuber.parkiryuk;

import android.app.Activity;
import android.os.Bundle;

import id.adhaniscuber.parkiryuk.multidex.AppController.R;

/**
 * Created by adhaniscuber on 23/01/17.
 */

public class AboutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_layout);
    }
}
