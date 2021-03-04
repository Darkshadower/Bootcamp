package com.github.darkshadower.bootcamp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String NAME_MESSAGE = "com.github.darkshadower.bootcamp.NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        // Create the intent to start a new activity
        // Second arguments determines who to deliver the intent
        Intent intent = new Intent(this, GreetingActivity.class);
        EditText editText = (EditText) findViewById(R.id.mainName);
        String message = editText.getText().toString();
        //Adds a value and its id (NAME_MESSAGE) to the intent that can be used by the called activity
        intent.putExtra(NAME_MESSAGE, message);//
        startActivity(intent);//Launch the activity with that intent

    }
}