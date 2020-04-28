package gallows.p;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;


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

        zobrazScore();
        nactiAnimaci();
    }

    

}
