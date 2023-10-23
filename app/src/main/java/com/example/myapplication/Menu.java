package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R.drawable;

public class Menu extends AppCompatActivity {

    MediaPlayer player;

    private Button volume;
    private TextView text;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

          volume=findViewById(R.id.volume);
          text=findViewById(R.id._1);

    }

    public void onVolumeclick(View view) {
        volume();
        if(text.getText().toString().equalsIgnoreCase("_1")){
            volume.setBackgroundResource(drawable.volumenow);
            text.setText("_2");
        }
        else {
            volume.setBackgroundResource(drawable.volume_up_fill0_wght400_grad0_opsz48__1_);
            text.setText("_1");
        }

    }

    public void volume(){
        if(player==null){
            player= MediaPlayer.create(this, R.raw.ring);
        }
        if(text.getText().toString().equalsIgnoreCase("_1")){
            player.start();
        }
        else {
            player.pause();
        }
    }
    public void onPlayclick(View view) {
        volume();
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void onCloseclick(View view) {
        volume();

        finish();
    }

    public void onInfoclick(View view) {
        volume();
        Intent intent=new Intent(this, Info.class);
        startActivity(intent);
        finish();
    }
}
