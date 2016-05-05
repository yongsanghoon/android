package com.example.jacob.connect3;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 0 = yellow
    // 1 = red
    int activePlayer = 0;

    // 1 = played
    // 2 = not played
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void dropIn(View view) {
        ImageView counter = (ImageView) view;  // The specific row and column the user tapped on (represented by "view", which is equal to "counter")
        int tappedCounter = Integer.parseInt(counter.getTag().toString());  // Location of tapped grid space for gameState array
        TextView winnerMsg = (TextView) findViewById(R.id.winnerMessage);
        LinearLayout msgLayout = (LinearLayout) findViewById(R.id.playAgainLayout);

        if(gameState[tappedCounter] == 2) {

            counter.setTranslationY(-1000f); // Set initial location of counter to the top (off-grid)
            gameState[tappedCounter] = activePlayer;  // Keep track of which player is on which part of the grid

            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow);  // Set the src (yellow counter)
                activePlayer = 1;
                gameState[tappedCounter] = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
                gameState[tappedCounter] = 1;
            }
            counter.animate().translationYBy(1000f).rotation(360).setDuration(300);

            // Check if all gameState positions from winningPosition mini-arrays are equal to each other (which means the player won)
            // TO-DO: validate which player has won
            // TO-DO: make play-again button functionality
            for(int[] winningPosition : winningPositions) {
                if(gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2) {
                    msgLayout.setVisibility(View.VISIBLE);
                }
            }
        }
    }
}
