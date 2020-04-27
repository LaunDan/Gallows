package gallows.p;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

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



        topic = getIntent().getIntExtra("ChosenMethod", 1);

        choseWord();
        edit(word);
    }

    private void choseWord() {
        String[] fieldInfo = new String[100];
        int lenghtInfo = 0;

        if (topic == 1) {
            fieldInfo = new String[]{"Prague", "Bratislava", "Washington", "Hongkong", "Tokyo", "Berlin", "Warsaw", "Vienna", "Paris", "Brussels", "Minsk", "Brasilia", "Sofia", "Peking", "Copenhagen", "Helsinki", "Dublin", "Roma", "Jerusalem", "Ottawa", "Havana", "Luxembourg", "Budapest", "Amsterdam", "Oslo", "Lisbon", "Moscow", "Athens", "London", "Madrid", "Bangkok"};
        }
        if (topic == 2) {
            fieldInfo = new String[]{"Czechia", "Slovakia", "Germany", "plzeň", "liberec", "olomouc", "pardubice", "havířov", "zlín", "kladno", "most", "karviná", "opava", "bruntál", "jihlava", "teplice", "kolín", "šumperk", "chomutov", "přerov", "prostějov", "třebíč", "tábor", "třinec", "znojmo", "příbram", "cheb", "orlová", "trutnov", "písek", "vsetín", "hodonín", "sokolov", "bohumín", "beroun", "jičín", "benešov"};
        }
        if (topic == 3) {
            fieldInfo = new String[]{"klokan", "opice", "zebra", "lama", "slon", "hroch", "velbloud", "nosorožec", "bažant", "medvěd", "slepice", "morče", "ovce", "prase", "koza", "kráva", "kohout", "králík", "zajíc", "tygr", "vlk", "veverka", "žába", "tuleň", "ježek", "fredka", "křeček"};
        }
        if (topic == 4) {
            fieldInfo = new String[]{"audi", "bmw", "citroen", "dacia", "fiat", "ferrari", "kia", "honda", "škoda", "hyundai", "chevrolet", "jaguar", "jeep", "mazda", "mercedes", "mitsubishi", "nissan", "opel", "peugeot", "porsche", "renault", "rover", "saab", "seat", "subaru", "suzuki", "toyota", "volkswagen", "volvo", "bentley", "bugatti", "cadillac", "lada", "dodge", "infinity", "lancia", "lexus", "maybach", "pagani", "proton", "tatra", "trabant", "volha", "zastava"};
        }
        lenghtInfo = fieldInfo.length;
        Random ranInfo = new Random();
        int losInfo = ranInfo.nextInt(lenghtInfo - 1);
        word = fieldInfo[losInfo];
    }
}

