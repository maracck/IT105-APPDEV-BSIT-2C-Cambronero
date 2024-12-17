package com.example.scorekeeper;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
   /* Initialized team score variable */
    private int mScore1;
    private int mScore2;

    /* Variable to hold the score */
    private TextView mScoreText1;
    private TextView mScoreText2;

    /* To protect from unexpected changes */
    static final String STATE_SCORE_1 = "Team 1 Score ";
    static final String STATE_SCORE_2 = "Team 2 Score ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        /* Find the textview using the ID */
        mScoreText1 = (TextView)findViewById(R.id.score1); // score_1 ang nasa module?
        mScoreText2 = (TextView)findViewById(R.id.score2); // score_2 ang nasa module?



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // checks and restores the score if when saved
        if (savedInstanceState != null) {
            // gets the saved score
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1);
            mScore2 = savedInstanceState.getInt(STATE_SCORE_2);

            // set the score to text view
            mScoreText1.setText(String.valueOf(mScore1));
            mScoreText2.setText(String.valueOf(mScore2));

        }

    }

    /* Function that minus score to the team */
    public void decreaseScore(View view) {
        // get the id of the button clicked
        int viewID = view.getId();

        // if the view id is the first team
        if (viewID == R.id.decreaseTeam1) {
            mScore1--;
            mScoreText1.setText(String.valueOf(mScore1)); // to update the text view

        // id the view id is the second team
        } else if (viewID == R.id.decreaseTeam2) {
            mScore2--;
            mScoreText2.setText(String.valueOf(mScore2)); // to update the text view
        }

    }


    /* Function that adds score to the team */
    public void increaseScore(View view) {
        // get the id of the button clicked
        int viewID = view.getId();

        // if the view id is the first team
        if (viewID == R.id.increaseTeam1) {
            mScore1++;
            mScoreText1.setText(String.valueOf(mScore1)); // to update the text view

            // id the view id is the second team
        } else if (viewID == R.id.increaseTeam2) {
            mScore2++;
            mScoreText2.setText(String.valueOf(mScore2)); // to update the text view
        }

    }
    // save the score


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        // change label
        int nightMode = AppCompatDelegate.getDefaultNightMode();

        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }

        // return super.onCreateOptionsMenu(menu); // old code
        return true;
    }

    // Changes the theme to nightmode if pressed
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Checked if clicked
        if (item.getItemId() == R.id.night_mode) {

            // TODO: Get the night mode of the app.
            int nightMode = AppCompatDelegate.getDefaultNightMode();

            // set the theme for the activity after being restarted
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }

            //  the activity is recreated
            recreate();
        }
        return true;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(STATE_SCORE_1, mScore1);
        outState.putInt(STATE_SCORE_2, mScore2);
        super.onSaveInstanceState(outState);
    }



}