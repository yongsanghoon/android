package com.example.jacob.animations;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

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

        // Set the box 1000 pixels off the screen to the left once the app starts
        //ImageView meeseeks = (ImageView) findViewById(R.id.meeseeks);
        //meeseeks.setTranslationX(-1000f);
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

    public void fade(View view) {
        ImageView box = (ImageView) findViewById(R.id.box);

        // alpha value determines how transparent the image is
        //   0 = invisible
        //   1 = visible
        //   Below fades the box to invisible over 2 seconds
        box.animate().alpha(0f).setDuration(2000);  // alpha takes a float value; 0f is to specify 0 as a float
    }

    public void crossfade(View view) {
        ImageView box = (ImageView) findViewById(R.id.box);
        ImageView meeseeks = (ImageView) findViewById(R.id.meeseeks);

        box.animate().alpha(0f).setDuration(2000);
        meeseeks.animate().alpha(1f).setDuration(2000);  // Transition meeseeks in
    }

    public void moveBottom(View view) {
        ImageView box = (ImageView) findViewById(R.id.box);

        // translationYBy takes a value of pixels (below moves box by 1000 pixels vertically over 2 secs)
        box.animate().translationYBy(1000f).setDuration(2000);
    }

    public void moveLeft(View view) {
        ImageView box = (ImageView) findViewById(R.id.box);

        // Moves box 1000 pixels to the left (-1000 pixels)
        box.animate().translationXBy(-1000f).setDuration(2000);
    }

    // Moves meeseeks from original possition of -1000 to 1000 (see onCreate method)
    public void leftToRight(View view) {
        ImageView meeseeks = (ImageView) findViewById(R.id.meeseeks);
        meeseeks.animate().translationXBy(1000f).setDuration(2000);
    }

    public void rotation(View view) {
        ImageView box = (ImageView) findViewById(R.id.box);

        // rotation takes a value for angle (in float)
        box.animate().rotation(180f).setDuration(2000);
    }

    public void scale(View view) {
        ImageView box = (ImageView) findViewById(R.id.box);

        // Shrink the box to half its size both vertically (scaleX) and horizontally (scaleY)
        box.animate().scaleX(0.5f).scaleY(0.5f).setDuration(2000);
    }
}
