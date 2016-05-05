package com.example.jacob.numbershapes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

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

    class Number {

        int number;

        public boolean isSquare() {
            // Square number is the product of a # multiplied by itself
            //   e.g. 1, 4, 9, 16...

            double squareRoot = Math.sqrt(number);

            // Math.floor gives you the lower number from the given value (e.g. 4.47 --> 4)
            if(squareRoot == Math.floor(squareRoot)) {
                return true;
            }else {
                return false;
            }
        }

        public boolean isTriangular() {
            // Perfect triangle number is 1, 3, 6, 10, 15, etc.
            //   Continuous summation of 1, 2, 3, 4, 5...

            // x will act as the diff. value
            int x = 1;

            // triangularNumber will act as the value for the triangular number
            int triangularNumber = 1;

            while(triangularNumber < number) {
                x++;
                triangularNumber += x;
            }

            if(triangularNumber == number) {
                return true;
            }else {
                return false;
            }
        }
    }

    public void testNumber(View view) {
        EditText input = (EditText) findViewById(R.id.usersNumber);
        String message = "";

        if(input.getText().toString().isEmpty()) {
            message = "Please enter a number.";
        }else {

            //Log.i("User's Number", input.getText().toString());

            Number myNumber = new Number();
            myNumber.number = Integer.parseInt(input.getText().toString());

            if (myNumber.isSquare()) {
                if (myNumber.isTriangular()) {
                    message = myNumber.number + " is both triangular and square!";
                } else {
                    message = myNumber.number + " is square, but not triangular!";
                }
            } else {
                if (myNumber.isTriangular()) {
                    message = myNumber.number + " is triangular, but not square!";
                } else {
                    message = myNumber.number + " is neither square nor triangular!";
                }
            }
        }

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

        //System.out.println(myNumber.isTriangular());
        //System.out.println(myNumber.isSquare());
    }
}
