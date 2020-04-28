package gallows.p;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TopicActivity extends AppCompatActivity {
    private View decorView;
    int met;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);

        decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);


    }

    public void play(View v) {
        RadioGroup rg = findViewById(R.id.radioGroup);
        int choosenID = rg.getCheckedRadioButtonId();

        RadioButton choosenRadio = findViewById(choosenID);

        String chosenTopic = choosenRadio.getText().toString();
        Toast.makeText(getApplicationContext(), "Chosen topic: " + chosenTopic, Toast.LENGTH_LONG).show();

        if (chosenTopic.equals("Towns")) met = 1;
        if (chosenTopic.equals("States")) met = 2;
        if (chosenTopic.equals("Animals")) met = 3;
        if (chosenTopic.equals("Cars")) met = 4;

        Intent inte = new Intent(this, MainGameActivity.class);
        inte.putExtra("CHOSENMETHOD", met);
        startActivity(inte);
        finish();
    }
}
