package com.example.jacob.higherorlower;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random randomGenerator = new Random();
    int answer;

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

        // Random number between 0 - 100
        answer = randomGenerator.nextInt(11);
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

    public void checkGuess(View view) {
        EditText input = (EditText) findViewById(R.id.guessEditText);
        if(input.getText().toString().matches("")) {
            Toast.makeText(getApplicationContext(), "Please enter a number", Toast.LENGTH_LONG).show();
        }else {
            int guess = Integer.parseInt(input.getText().toString());
            String message = "";

            if(guess > answer) {
                message = "Lower!";
            }else if(guess < answer) {
                message = "Higher!";
            }else{
                message = "Correct! Try again...";
                answer = randomGenerator.nextInt(11);
            }
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

            // Output the answer to check if your code is working
            System.out.println(answer);
        }
    }
}
