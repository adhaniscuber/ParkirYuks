package id.adhaniscuber.parkiryuk;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
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
    MediaPlayer soundbackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        soundbackground = MediaPlayer.create(this, R.raw.carlock);

        soundbackground.setLooping(false);
        soundbackground.setVolume(1,1);
        soundbackground.start();

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
