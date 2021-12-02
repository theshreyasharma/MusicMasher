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

public class PlaylistGenerated extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist_generated);



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
                recap_list);
        lv1.setAdapter(lv1_arr);

        Button profileButton = findViewById(R.id.profile5);
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
