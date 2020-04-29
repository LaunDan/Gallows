package gallows.p;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TopicActivity extends AppCompatActivity {
    int met;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_topic);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);




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
