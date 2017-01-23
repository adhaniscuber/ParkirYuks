package id.adhaniscuber.parkiryuk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import id.adhaniscuber.parkiryuk.multidex.AppController.R;

/**
 * Created by adhaniscuber on 23/01/17.
 */

public class SplashActivity extends Activity {

    //splashscreen timer
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        ImageView imageView = (ImageView) findViewById(R.id.logopy);

        // load the animation
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        imageView.setAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);

                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
