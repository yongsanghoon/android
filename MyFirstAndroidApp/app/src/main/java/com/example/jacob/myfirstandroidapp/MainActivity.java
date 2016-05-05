package com.example.jacob.myfirstandroidapp;

import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

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

    public void clickFunction(View view) {
        // Log information (i) when this function is executed.
        //   Log.i(String tag, String msg)
        //Log.i("Info", "Hello Jacob!");

        // Toast = message for the user
        //   LENGTH_LONG = ~4-5 seconds message is displayed
        //   LENGTH_SHORT = ~2-3 seconds message is displayed
        Toast.makeText(getApplicationContext(), "Hi Jacob!", Toast.LENGTH_LONG).show();

        // Variable for text field.
        //   R = resources
        //   id = id we're searching for
        //   textField = id we gave for the text field
        //Convert the View (textField) --> specific type of EditText (myTextField) by casting
        EditText myTextField = (EditText) findViewById(R.id.textField);

        // Change the image once the button is pressed
        ImageView catImage = (ImageView) findViewById(R.id.catImageView);
        catImage.setImageResource(R.drawable.cat2);

        // Gets the text entered into the text field (myTextField) and converts to string for log.
        Log.i("TextField Value", myTextField.getText().toString());
    }
}
