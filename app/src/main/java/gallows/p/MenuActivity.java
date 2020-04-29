package gallows.p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class MenuActivity extends AppCompatActivity {
    private View decorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_menu);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);



    }

        public void startPlay (View v){
            Intent newActivity = new Intent(this, TopicActivity.class);
            startActivity(newActivity);

        }

        public void printScore (View v){
            Intent newActivity = new Intent(this, ShowScoreActivity.class);
            startActivity(newActivity);

        }

        public void end (View v){
            finish();
        }

}
