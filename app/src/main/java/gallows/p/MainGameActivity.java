package gallows.p;

import android.content.Intent;
import android.content.pm.ActivityInfo;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



import java.util.Random;

public class MainGameActivity extends AppCompatActivity {

    // todo make apk and realise this app
    private String word = "";
    private int mistakes = 0;

    private int lenghtOfWord = 0;
    private int amountOfExistence = 0;
    private String plenght = "";

    private int score = 10000;
    private int multiplikator = 0;
    private String suhadnute = "";
    private String countedMistake = "";

    private boolean sound = true;

    int topic = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_game);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        topic = getIntent().getIntExtra("CHOSENMETHOD", 1);

        Button soundOff = findViewById(R.id.soundOff);
        soundOff.setVisibility(View.GONE);

        choseWord();
        edit(word);
    }

    private void choseWord() {
        String[] fieldInfo = new String[100];
         TextView nameOfTopic = findViewById(R.id.nameOfTopic);
        int lenghtInfo = 0;
//TODO add new topic and new words
        if (topic == 1) {
            fieldInfo = new String[]{"Prague", "Washington", "Bratislava", "Hongkong", "Tokyo", "Berlin", "Warsaw", "Vienna", "Paris", "Brussels", "Minsk", "Brasilia", "Sofia", "Peking", "Copenhagen", "Helsinki", "Dublin", "Roma", "Jerusalem", "Ottawa", "Havana", "Luxembourg", "Budapest", "Amsterdam", "Oslo", "Lisbon", "Moscow", "Athens", "London", "Madrid", "Bangkok"};
            nameOfTopic.setText("Towns");
        }
        if (topic == 2) {
            fieldInfo = new String[]{"Czechia", "Slovakia", "Germany", "Poland", "Austria", "Australia", "England", "Holland", "China", "Japan", "Russia", "Vietnam", "Italy", "Canada", "Brazil", "India", "Greece", "Croatia", "France", "Ukraine", "Turkey", "Sweden", "Finland", "Norway", "Spain"};
            nameOfTopic.setText("States");
        }
        if (topic == 3) {
            fieldInfo = new String[]{"kangaroo", "monkey", "ribs", "lama", "elephant", "camel", "rhinoceros", "pheasant", "bear", "hen", "sheep", "pig", "goat", "cow", "rooster", "rabbit", "hare", "tiger", "wolf", "squirrel", "frog", "seal", "hedgehog", "ferret", "hamster", "horse", "dog", "cat", "giraffe", "fox", "snake"};
            nameOfTopic.setText("Animals");
        }
        if (topic == 4) {
            fieldInfo = new String[]{"audi", "bmw", "citroen", "dacia", "fiat", "ferrari", "kia", "honda", "škoda", "hyundai", "chevrolet", "jaguar", "jeep", "mazda", "mercedes", "mitsubishi", "nissan", "opel", "peugeot", "porsche", "renault", "rover", "saab", "seat", "subaru", "suzuki", "toyota", "volkswagen", "volvo", "bentley", "bugatti", "cadillac", "lada", "dodge", "infinity", "lancia", "lexus", "maybach", "pagani", "proton", "tatra"};
            nameOfTopic.setText("Cars");
        }
        lenghtInfo = fieldInfo.length;
        Random ranInfo = new Random();
        int losInfo = ranInfo.nextInt(lenghtInfo - 1);
        word = fieldInfo[losInfo];
    }

    private void edit(String chosenWord) {
        TextView[] letters = new TextView[10];
        letters[0] =
        letters[1] = findViewById(R.id.tvp2);
        letters[2] = findViewById(R.id.tvp3);
        letters[3] = findViewById(R.id.tvp4);
        letters[4] = findViewById(R.id.tvp5);
        letters[5] = findViewById(R.id.tvp6);
        letters[6] = findViewById(R.id.tvp7);
        letters[7] = findViewById(R.id.tvp8);
        letters[8] = findViewById(R.id.tvp9);
        letters[9] = findViewById(R.id.tvp10);

        int leng = chosenWord.length();

        for (int i = leng; i < 10; i++) {
            letters[i].setVisibility(View.GONE);
        }
    }

    public void insert(View v) {
        EditText edte = findViewById(R.id.entered);
        String entered = edte.getText().toString().toLowerCase();
        if (entered.length() >= 1) {
            char enteredP = entered.charAt(0);
            edte.setText("");
            if ((enteredP >= 97 && enteredP <= 122) || (enteredP == 283) || (enteredP == 353) || (enteredP == 357) || (enteredP == 269) || (enteredP == 345) || (enteredP == 382) || (enteredP == 253) || (enteredP == 225) || (enteredP == 237) || (enteredP == 233) || (enteredP == 367) || (enteredP == 250) || (enteredP == 243)) {

                for (int i = 0; i < word.length(); i++) {
                    if (word.toLowerCase().charAt(i) == enteredP) {
                        amountOfExistence++;
                        writeCorrect(word.charAt(i), i);
                        scorePlus(enteredP);
                    }
                }

                if (plenght.indexOf(enteredP) == -1) {
                    lenghtOfWord += amountOfExistence;
                    plenght += enteredP;
                }

                if (lenghtOfWord == word.length()) {
                    won();
                }
                if (amountOfExistence == 0) {
                    writeWrong(enteredP);
                    scoreMinus(enteredP);
                }
            } else {
                Toast.makeText(getApplicationContext(), "Entered wrong letter..", Toast.LENGTH_LONG).show();
            }
        }

        amountOfExistence = 0;
    }

    private void writeCorrect(char letter, int position) {
        TextView[] letters = new TextView[10];
        letters[0] = findViewById(R.id.tvp1);
        letters[1] = findViewById(R.id.tvp2);
        letters[2] = findViewById(R.id.tvp3);
        letters[3] = findViewById(R.id.tvp4);
        letters[4] = findViewById(R.id.tvp5);
        letters[5] = findViewById(R.id.tvp6);
        letters[6] = findViewById(R.id.tvp7);
        letters[7] = findViewById(R.id.tvp8);
        letters[8] = findViewById(R.id.tvp9);
        letters[9] = findViewById(R.id.tvp10);

        letters[position].setText(String.valueOf(letter));

    }

    private void writeWrong(char letter) {
        ImageView place = findViewById(R.id.placeForGallows);
        TextView wrong = findViewById(R.id.mistakes);

        String mistake = wrong.getText().toString();

        if (mistake.indexOf(letter) == -1) {
            mistakes++;
            wrong.append(String.valueOf(letter));

            if (mistakes == 1) {
                place.setImageResource(R.drawable.step2);
            } else if (mistakes == 2) {
                place.setImageResource(R.drawable.step3);
            } else if (mistakes == 3) {
                place.setImageResource(R.drawable.step4);
            } else if (mistakes == 4) {
                place.setImageResource(R.drawable.step5);
            } else if (mistakes == 5) {
                place.setImageResource(R.drawable.step6);
            } else if (mistakes == 6) {
                place.setImageResource(R.drawable.step7);
            } else if (mistakes == 7) {
                place.setImageResource(R.drawable.step8);
            } else if (mistakes == 8) {
                place.setImageResource(R.drawable.step9);
            } else if (mistakes == 9) {
                place.setImageResource(R.drawable.step10);
                endOfGame();
            }

        }
    }

    private void scorePlus(char letter) {
        if (suhadnute.indexOf(letter) == -1) {
            if (sound) {
                MediaPlayer mp = MediaPlayer.create(this, R.raw.sucpis);
                mp.start();
            }
            suhadnute += letter;
            multiplikator++;
            score += (500 * multiplikator);
        }
    }

    private void scoreMinus(char letter) {
        if (countedMistake.indexOf(letter) == -1) {
            if (sound) {
                MediaPlayer mp = MediaPlayer.create(this, R.raw.failpis);
                mp.start();
            }
            countedMistake += letter;
            score -= 1000;
            multiplikator = 0;
        }
    }

    private void endOfGame() {
        Intent endGame = new Intent(this, EndGameActivity.class);
        endGame.putExtra("WIN_LOSS", 0);
        endGame.putExtra("ID_VARIABLE", score);
        endGame.putExtra("WORD", word);
        endGame.putExtra("SOUND", sound);
        startActivity(endGame);
        finish();
    }


    private void won() {
        Intent endGame = new Intent(this, EndGameActivity.class);
        endGame.putExtra("WIN_LOSS", 1);
        endGame.putExtra("ID_VARIABLE", score);
        endGame.putExtra("WORD", word);
        endGame.putExtra("SOUND", sound);
        startActivity(endGame);
        finish();
    }

    public void soundSetterOn(View v) {
        Button soundOn = findViewById(R.id.soundOn);
        Button soundOff = findViewById(R.id.soundOff);

        if (sound) {
            soundOn.setVisibility(View.GONE);
            soundOff.setVisibility(View.VISIBLE);
            sound = false;
        }
    }
    public void soundSetterOff(View v) {
        Button soundOn = findViewById(R.id.soundOn);
        Button soundOff = findViewById(R.id.soundOff);

        if (!sound) {
            soundOn.setVisibility(View.VISIBLE);
            soundOff.setVisibility(View.GONE);
            sound = true;
        }
    }
}
