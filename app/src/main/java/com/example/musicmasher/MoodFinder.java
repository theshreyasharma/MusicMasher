package com.example.musicmasher;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MoodFinder extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood_finder);

        autoCompleteTextView = findViewById(R.id.autoCompleteText);

        String options[] = {"Sad", "Upbeat", "Angry", "Confident"};
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.option_item, options);

        autoCompleteTextView.setText("", false);
        autoCompleteTextView.setAdapter(arrayAdapter);


        final String[] selection = new String[1];
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long rowId) {
                 selection[0] = (String)parent.getItemAtPosition(position);

            }
        });

        Button updateMoodButton = findViewById(R.id.button3);
        updateMoodButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selection[0] != null) {
                    Intent intent = new Intent(view.getContext(), PFPActivity.class);
                    intent.putExtra("MOOD", selection[0]);
                    startActivity(intent);
                } else {
                    new AlertDialog.Builder(view.getContext())
                            .setTitle("Mood not selected!")
                            .setMessage("Please select a mood from the dropdown menu before updating the mood.")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    //idk maybe we autopopultate?
                                }
                            })
                            .setNegativeButton(android.R.string.no, null)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }
            }
        });

        Button profileButton = findViewById(R.id.profile);
        profileButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PFPActivity.class);
                intent.putExtra("MOOD", getIntent().getStringExtra("MOOD"));
                startActivity(intent);
            }
        });


    }
}
