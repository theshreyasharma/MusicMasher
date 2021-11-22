package com.example.musicmasher;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import java.util.HashMap;
public class Mash extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mash);
        ImageView imageRounded= (ImageView) findViewById(R.id.imageLeft);
                imageRounded.setClipToOutline(true);
        if (getIntent().getStringExtra("MOOD") != null) {
            updateCurrentMoodString(true);
        } else {
            updateCurrentMoodString(false);
        }
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.editTextTextPersonName);
        String[] artists = getResources().getStringArray(R.array.artist_array);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, artists);
        textView.setAdapter(adapter);
        AutoCompleteTextView textView2 = (AutoCompleteTextView) findViewById(R.id.editTextTextPersonName2);
        String[] artists2 = getResources().getStringArray(R.array.artist_array);
        ArrayAdapter<String> adapter2 =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, artists2);
        textView2.setAdapter(adapter2);
    }
    public void updateCurrentMoodString(boolean mood) {
        Bundle b=this.getIntent().getExtras();
        String currentMood =b.getString("MOOD");
        String message = mood ? "Current Mood: "+currentMood : "No Current Mood";
        TextView currentMood2 = (TextView) findViewById(R.id.textView3);
        if (mood)
        {
            currentMood2.setTextSize(25);
            currentMood2.setText(message);
        }
        else {
            currentMood2.setTextSize(25);
            currentMood2.setText(message);
        }
    }
    public void fillRandomArtist(View view) {
        EditText artist = (EditText) findViewById(R.id.editTextTextPersonName);
        String artistList[] = {"Kanye", "Drake", "Jon", "Adams", "Joe", "Poe"};
        int pickRandomNum = new Random().nextInt(artistList.length);
        artist.setText(artistList[pickRandomNum]);

    }
    public void fillRandomArtist2(View view) {
        EditText artist = (EditText) findViewById(R.id.editTextTextPersonName2);
        String artistList[] = {"Kanye", "Drake", "Jon", "Adams", "Joe", "Poe"};
        int pickRandomNum = new Random().nextInt(artistList.length);
        artist.setText(artistList[pickRandomNum]);

    }

    public void onClickProfile(View view) {
            Intent intent = new Intent(view.getContext(), PFPActivity.class);
            startActivity(intent);
        }
    public void mashMe(View view) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        map.put("Drake", new ArrayList<String>(
                Arrays.asList("DrakeSong1", "DrakeSong2")));
        map.put("Kanye", new ArrayList<String>(
                Arrays.asList("KanyeSong1", "KanyeSong2")));
        EditText artist = (EditText) findViewById(R.id.editTextTextPersonName2);
        EditText artist1 = (EditText) findViewById(R.id.editTextTextPersonName);
        Log.d("artist", artist.getText().toString());
        ArrayList<String> songs1 = null;
        ArrayList<String> songs2 = null;

        if(map.containsKey(artist.getText().toString())&& map.containsKey(artist1.getText().toString())) {
            songs1 = map.get(artist.getText().toString());
            songs2 = map.get(artist1.getText().toString());


            ArrayList<String> result = new ArrayList<String>();
            int bound = Math.min(songs1.size(), songs2.size());
            for (int i = 0; i < bound; i++) {
                result.add(songs1.get(i) + "x" + songs2.get(i));

            }


            String wow = result.toString();
            Bundle passMashed = new Bundle();
            Intent passToNewPage = new Intent(view.getContext(), PlaylistGenerated.class);
            startActivity(passToNewPage);
        }
        else
        {
            new AlertDialog.Builder(this)
                    .setTitle("Error: Artist(s) not found")
                    .setMessage("Masher does not have data for one or more of the artists you entered. \n" +
                            "Try using the default ones!")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        //idk maybe we autopopultate?
                        }
                    })
                    .setNegativeButton(android.R.string.no, null)
                    .setIcon(android.R.drawable.ic_dialog_alergit)
                    .show();
        }
    }

    public void checkBoxFunction(View view) {
        boolean mood = true;
        CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox);
        mood = cb1.isChecked() ? false: true;
        updateCurrentMoodString(mood);


    }}