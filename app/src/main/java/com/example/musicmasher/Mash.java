package com.example.musicmasher;

import androidx.appcompat.app.AppCompatActivity;

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

        //some hacky stuff
        ImageView imageRounded= (ImageView) findViewById(R.id.imageLeft);
                imageRounded.setClipToOutline(true);
//        Button mashButton = findViewById(R.id.button);
//        mashButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(view.getContext(), PlaylistGenerated.class);
//                intent.putExtra("MOOD", getIntent().getStringExtra("MOOD"));
//                startActivity(intent);
//            }
//        });
        if (getIntent().getStringExtra("MOOD") != null) {
            updateCurrentMoodString(true);
        } else {
            updateCurrentMoodString(false);
        }


        // Get a reference to the AutoCompleteTextView in the layout
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
        //does something cuz otherwise nothing

        Bundle b=this.getIntent().getExtras();
        String currentMood =b.getString("MOOD");



        String message = mood ? "Current Mood: "+currentMood : "No Current Mood";
        TextView currentMood2 = (TextView) findViewById(R.id.textView3);
        if (mood)
        {
            //some stupid stuff text too large
            currentMood2.setTextSize(25);
            currentMood2.setText(message);
        }
        else {
            currentMood2.setTextSize(25);
            currentMood2.setText(message);
        }
    }
    public void fillRandomArtist(View view) {
        //does something
        EditText artist = (EditText) findViewById(R.id.editTextTextPersonName);
        String artistList[] = {"Kanye", "Drake", "Jon", "Adams", "Joe", "Poe"};
        int pickRandomNum = new Random().nextInt(artistList.length);
        artist.setText(artistList[pickRandomNum]);

    }
    public void fillRandomArtist2(View view) {
        //does something like last something -- > can merge this w/ other function probably by checking ids of button calling
        // but too much work.
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

        if(map.containsKey(artist.getText().toString())&& map.containsKey(artist1.getText().toString()))
        {

             songs1 = map.get(artist.getText().toString());
             songs2 = map.get(artist1.getText().toString());        }
        ArrayList<String> result = new ArrayList<String>();
        int bound = Math.min(songs1.size(), songs2.size());
        for(int i = 0; i<bound; i++)
        {
            result.add (songs1.get(i) +"x"  + songs2.get(i));

        }
        String wow = result.toString();
        Log.d("myTag", wow);





        Bundle passMashed=new Bundle();
//        i.putExtras(passMashed);
//         passMashed.putStringArrayList("MashedList",result );
        Intent passToNewPage = new Intent(view.getContext(), PlaylistGenerated.class);
        startActivity(passToNewPage);





    }







    public void checkBoxFunction(View view) {
        boolean mood = true;
        CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox);
        mood = cb1.isChecked() ? false: true;
        updateCurrentMoodString(mood);

        System.out.println(mood);

    }}