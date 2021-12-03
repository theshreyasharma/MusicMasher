package com.example.musicmasher;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PlaylistGenerated extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;
//    String finalMood = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist_generated);

        String mood = getIntent().getStringExtra("MOOD");
        String user = getIntent().getStringExtra("USERNAME");

        //set current Mood text
        TextView currentMood = findViewById(R.id.textView13);
        currentMood.setText("Current  Mood: " + mood);

        ArrayList<String> listPass = getIntent().getStringArrayListExtra("LIST");
        String artist1 = getIntent().getStringExtra("ARTIST1");
        String artist2 = getIntent().getStringExtra("ARTIST2");

        TextView textView = (TextView) findViewById(R.id.textView8);
        textView.setText(artist1 + " x " + artist2);

        String[] recap_list = {
                "One Dance - Drake",
                "Power - Kanye West",
                "Hotline Bling - Drake",
                "Monster - Kanye West",
                "Heartless - Kanye West",
                "Energy - Drake"
        };
        ListView lv1 = findViewById(R.id.playlistgenerated);
        ArrayAdapter<String> lv1_arr;
        lv1_arr = new ArrayAdapter<>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                listPass);
        lv1.setAdapter(lv1_arr);

        Button profileButton = findViewById(R.id.profile5);
        profileButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), PFPActivity.class);
                intent.putExtra("MOOD", mood);
                intent.putExtra("USERNAME", user);
                startActivity(intent);
            }
        });
    }
}
