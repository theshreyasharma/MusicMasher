package com.example.musicmasher;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;

public class MoodFinder extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood_finder);

        autoCompleteTextView = findViewById(R.id.autoCompleteText);

        String options[] = {"Sad", "Upbeat", "Angry", "Confident"};
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.option_item, options);

        autoCompleteTextView.setText(arrayAdapter.getItem(0).toString(), false);
        autoCompleteTextView.setAdapter(arrayAdapter);
    }
}
