package gallows.p;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainGameActivity extends AppCompatActivity {
    private View decorView;
    private String word = "";
    private int mistake = 0;

    private int lenghtOfWord = 0;
    private int amountOfExistence = 0;
    private String plenght = "";

    private int score = 10000;
    private int multiplikator = 0;
    private String suhadnute = "";
    private String countedMistake = "";

    int topic = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);

        decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        AnimationDrawable animace = new AnimationDrawable();
        ImageView napis = findViewById(R.id.imageView4);

        animace.addFrame(getResources().getDrawable(R.drawable.napis1), 1000);
        animace.addFrame(getResources().getDrawable(R.drawable.napis2), 1000);
        animace.addFrame(getResources().getDrawable(R.drawable.napis3), 1000);
        animace.addFrame(getResources().getDrawable(R.drawable.napis4), 1000);
        animace.addFrame(getResources().getDrawable(R.drawable.napis5), 1000);
        animace.addFrame(getResources().getDrawable(R.drawable.napis6), 1000);
        animace.addFrame(getResources().getDrawable(R.drawable.napis7), 1000);
        animace.addFrame(getResources().getDrawable(R.drawable.napis8), 1000);
        animace.addFrame(getResources().getDrawable(R.drawable.napis9), 1000);
        animace.addFrame(getResources().getDrawable(R.drawable.napis10), 1000);

        napis.setBackgroundDrawable(animace);

        animace.start();

        topic = getIntent().getIntExtra("Chosen method", 1);

        choseword();
        edit(word);
    }
}

