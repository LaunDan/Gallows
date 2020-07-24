package gallows.p;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;


public class ShowScoreActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_show_score);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);


        TextView textview = findViewById(R.id.listOfPlayers);
        SharedPreferences preferences = getSharedPreferences("RESULTS", MODE_PRIVATE);
        String result = preferences.getString("RESULTS", "");

        textview.setText(result);
    }

    public void deleteOfMemory(View v) {
        AlertDialog.Builder nasDialog = new AlertDialog.Builder(this);
        nasDialog.setCancelable(true);
        nasDialog.setMessage("Are you sure you want to delete all results?");
        nasDialog.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        SharedPreferences preferences = getSharedPreferences("RESULTS", MODE_PRIVATE);
                        SharedPreferences.Editor preeditor = preferences.edit();
                        preeditor.putString("RESULTS", "");
                        preeditor.apply();
                        finish();
                    }
                });
        nasDialog.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();

                    }
                });

        AlertDialog startDialog = nasDialog.create();
        startDialog.show();
    }

    public void end(View v) {
        finish();
    }
}
//TODO edit view of score list
