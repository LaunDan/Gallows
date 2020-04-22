package gallows.p;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    private View decorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);

        decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        ImageView imgvwSpsoa2 = findViewById(R.id.imageView2);
        Animation animSpsoaLogo2 = AnimationUtils.loadAnimation(this, R.anim.weclome2_sc);
        ImageView imgvwSpsoa1 = findViewById(R.id.imageView);
        Animation animSpsoaLogo1 = AnimationUtils.loadAnimation(this, R.anim.welcome1_sc);
        imgvwSpsoa1.startAnimation(animSpsoaLogo1);
        imgvwSpsoa2.startAnimation(animSpsoaLogo2);
        Thread thrdWlcmscrnDelay = new Thread() {
            public void run() {
                try {
                    sleep(4000);
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    finish();
                }
            }
        };
        thrdWlcmscrnDelay.start();
    }
}
