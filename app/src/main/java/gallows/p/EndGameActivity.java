package gallows.p;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;




public class EndGameActivity extends AppCompatActivity {

    int endScore;
    int winOrLose;
    String nameOfPlayer = "";
    String wantedWord = "";
    boolean sound = true;


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
        sound = getIntent().getBooleanExtra("SOUND", true);


        showScore();
        loadAnimation();
    }

    private void loadAnimation() {

        ImageView pcs = findViewById(R.id.endPlace);
        if (winOrLose == 0) {
            if (sound) {
                MediaPlayer mp = MediaPlayer.create(this, R.raw.loosegame);
                mp.start();
            }
            pcs.setImageResource(R.drawable.step12);

        } else if (winOrLose == 1) {
            pcs.setImageResource(R.drawable.won3);
            if (sound) {
                MediaPlayer mp = MediaPlayer.create(this, R.raw.wingame);
                mp.start();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Opss, sorry somewhere is error", Toast.LENGTH_LONG).show();
        }
    }

    private void showScore() {
        TextView phs = findViewById(R.id.wantedWordTV);
        phs.setText(wantedWord);

        TextView tws = findViewById(R.id.score);
        tws.setText(String.valueOf(endScore));
    }

    private void saveToTheMemory() {
        SharedPreferences preferences = getSharedPreferences("RESULTS", MODE_PRIVATE);
        String thisScore = preferences.getString("RESULTS", "");

        SharedPreferences.Editor preeditor = preferences.edit();

        preeditor.putString("RESULTS", thisScore + nameOfPlayer + ": " + endScore + "\n");
        preeditor.apply();
        finish();
    }

    public void saveScore(View v) {
        EditText et = findViewById(R.id.name_eT);
        nameOfPlayer = et.getText().toString();
        if (!nameOfPlayer.contains("\n") && nameOfPlayer.length() >= 3) {
            AlertDialog.Builder setdialog = new AlertDialog.Builder(this);
            // creating AlertDialog builder
            setdialog.setCancelable(true);
            /* setCancelable set to act or not [true/false] on click out of dialog */
            setdialog.setMessage("Do you want to save: " + nameOfPlayer + " ?");
            /* setMessage set text of dialog */
            setdialog.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            saveToTheMemory();
                        }
                    });
            setdialog.setNegativeButton("No",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(getApplicationContext(), "Not saved", Toast.LENGTH_LONG).show();
                            dialog.cancel();
                        }
                    });

            AlertDialog startDialog = setdialog.create();
            startDialog.show();

        } else {
            Toast.makeText(getApplicationContext(), "Name must have at least 3 characters..", Toast.LENGTH_LONG).show();
        }
    }

    public void end(View v) {
        finish();
    }

}
