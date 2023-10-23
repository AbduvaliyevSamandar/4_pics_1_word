package com.example.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Info extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);


    }

    public void onInfoarrovclick(View view) {
        MediaPlayer player=MediaPlayer.create(this,R.raw.ring);
        player.start();
        Intent intent=new Intent(this, Menu.class);
        startActivity(intent);
        finish();
    }
}
