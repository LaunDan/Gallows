package gallows.p;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Thread.sleep;


public class EndGameActivity extends Activity {

    int endScore;
    int winOrLose;
    String nameOfPlayer = "";
    String wantedWord = "";

    private View decorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);

        decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        endScore = getIntent().getIntExtra("ID_VARIABLE", 0);
        wantedWord = getIntent().getStringExtra("WORD").toUpperCase();
        winOrLose = getIntent().getIntExtra("WIN_LOSS", 2);

        showScore();
        loadAnimation();
    }

    private void loadAnimation() {
        AnimationDrawable anim = new AnimationDrawable();
        ImageView pcs = findViewById(R.id.endPlace);
        if (winOrLose == 0) {
            MediaPlayer mp = MediaPlayer.create(this, R.raw.loosegame);
            mp.start();
            pcs.setImageResource(R.drawable.step10);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                finish();
            }
            pcs.setImageResource(R.drawable.step11);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                finish();
            }
            pcs.setImageResource(R.drawable.step12);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                finish();
            }



        } else if (winOrLose == 1) {
            MediaPlayer mp = MediaPlayer.create(this, R.raw.wingame);
            mp.start();

            pcs.setImageResource(R.drawable.won1);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                finish();
            }

            pcs.setImageResource(R.drawable.won2);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                finish();
            }

            pcs.setImageResource(R.drawable.won3);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                finish();
            }

        } else {
            Toast.makeText(getApplicationContext(), "Opss, sorry somewhere is error", Toast.LENGTH_LONG).show();
        }
    }

    private void showScore() {
        TextView phs = findViewById(R.id.word);
        phs.setText(wantedWord);

        TextView tws = findViewById(R.id.score);
        tws.setText(String.valueOf(endScore));
    }

}
