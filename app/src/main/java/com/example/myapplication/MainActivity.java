package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;


public class MainActivity extends AppCompatActivity {
    private ImageView image;
    private ArrayList<Button> answers;
    private ArrayList<Button> variants;
    private ArrayList<GameData> data;
    private int currentGame;
    private FrameLayout freamlyuot;
    private TextView coins;
    private ArrayList<String> javob;
    private TextView text;
    private Button volume;
    private int coin=GameData.INITIAL_COIN;
    MediaPlayer player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       coin=Settings.getSettings(this).getCoin();
      currentGame=Settings.getSettings(this).getcurrentgame();


        loadViews();
        loadData();
        loadDataToViews();
    }

    @SuppressLint("WrongViewCast")
    private void loadViews() {
        image = findViewById(R.id.image);
        freamlyuot=findViewById(R.id.fream_lyout);
        coins=findViewById(R.id.coins);
        text=findViewById(R.id._1);
        volume=findViewById(R.id.volume);


        answers = new ArrayList<>();
        answers.addAll(getButtons(findViewById(R.id.answers)));

        variants = new ArrayList<>();
        variants.addAll(getButtons(findViewById(R.id.variants1)));
        variants.addAll(getButtons(findViewById(R.id.variants2)));
        Collections.shuffle(variants);

        for (Button answer : answers) {
            answer.setOnClickListener(this::answerClick);
        }
        for (Button variant : variants) {
            variant.setOnClickListener(this::variantClick);
        }
    }

    private void loadData() {
        data = new ArrayList<>();
        javob=new ArrayList<>();
        data.add(new GameData(R.drawable.test3, "Mother", "ehstrolqzzrm"));
        data.add(new GameData(R.drawable.sea, "sea", "ehstrolqazrm"));
        data.add(new GameData(R.drawable.img_4, "drink", "aigndlrekken"));
        data.add(new GameData(R.drawable.img_5, "sleep", "evgoslsreapf"));
        data.add(new GameData(R.drawable.img_6, "sweet", "egrsobswxtte"));
        data.add(new GameData(R.drawable.img_7, "hard", "hlnlnedvabrd"));
        data.add(new GameData(R.drawable.img_21, "triangle", "thrsiayngkle"));
        data.add(new GameData(R.drawable.img_22, "trees", "ltbkrfeyedsl"));
        data.add(new GameData(R.drawable.img_23, "nature", "naytupmirjel"));
        data.add(new GameData(R.drawable.img_24, "climate", "scludihmnate"));
        data.add(new GameData(R.drawable.img_25, "air", "cvtaqiwedrkg"));
        data.add(new GameData(R.drawable.img_26, "camera", "cplatmyergad"));
        data.add(new GameData(R.drawable.img_27, "horse", "wahrpotrgsek"));
        data.add(new GameData(R.drawable.img_28, "elephant", "ewleprhanqti"));
        data.add(new GameData(R.drawable.img_29, "alarm", "hagletarpmln"));
        data.add(new GameData(R.drawable.img_30, "apple", "apdswplghemn"));
        data.add(new GameData(R.drawable.img_31, "beetroot", "bsefegtronot"));
        javob.add("mother");
        javob.add("drink");
        javob.add("sleep");
        javob.add("sweet");
        javob.add("hard");
        javob.add("triangle");
        javob.add("trees");
        javob.add("nature");
        javob.add("climate");
        javob.add("air");
        javob.add("camera");
        javob.add("horse");
        javob.add("elephant");
        javob.add("alarm");
        javob.add("apple");
        javob.add("beetroot");
    }

    private void loadDataToViews() {
        GameData game = data.get(currentGame);
        image.setImageResource(game.getImageId());

        for (int i = 0; i < answers.size(); i++) {
            answers.get(i).setVisibility(i < game.getAnswer().length() ? View.VISIBLE : View.GONE);
            answers.get(i).setText("");
        }

        for (int i = 0; i < variants.size(); i++) {
            variants.get(i).setVisibility(View.VISIBLE);
            variants.get(i).setText(String.valueOf(game.getVariant().charAt(i)));
        }
        coins.setText(coin+"");
    }

    private ArrayList<Button> getButtons(ViewGroup viewGroup) {
        ArrayList<Button> list = new ArrayList<>();
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            Button button = (Button) viewGroup.getChildAt(i);
            list.add(button);
        }

        return list;
    }

    private void answerClick(View view) {
        volume();

        Button button = (Button) view;
        String variant = data.get(currentGame).getVariant();

        for (int i = 0; i < variants.size(); i++) {
            if (button.getText().toString().equals(String.valueOf(variant.charAt(i))) && variants.get(i).getVisibility() == View.INVISIBLE) {
                variants.get(i).setText(button.getText());
                variants.get(i).setVisibility(View.VISIBLE);
                button.setText("");
            }
        }
    }
    private void variantClick(View view) {
        volume();

        Button button = (Button) view;
        String answer = data.get(currentGame).getAnswer();

        for (int i = 0; i < answers.size(); i++) {

            if (answers.get(i).getText().toString().isEmpty() && answers.get(i).getVisibility() == View.VISIBLE) {
                answers.get(i).setText(button.getText());
                button.setVisibility(View.INVISIBLE);
                button.setText("");
                if(answer.equalsIgnoreCase(getAnswer())){
                    freamlyuot.setVisibility(View.VISIBLE);
                }
                if (answer.equalsIgnoreCase(getAnswer())) {
                    coin+=15;
                    currentGame++;
                    if (data.size() == currentGame) {
                        Toast.makeText(this, "Siz yutdingiz", Toast.LENGTH_SHORT).show();
                        finish();
                        return;
                    }
                    loadDataToViews();
                } else if (answer.length() == getAnswer().length()) {
                    Toast.makeText(this, "Noto'g'ri", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }

    private String getAnswer() {

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < answers.size(); i++) {
            str.append(answers.get(i).getText().toString());
        }
        return str.toString();
    }
    public void onContinuable(View view) {
        if(currentGame==data.size()-1){
            Intent intent=new Intent(this, Natija.class);
            startActivity(intent);
            finish();
        }
        volume();
        freamlyuot.setVisibility(View.GONE);
    }

    public void onPlusclick(View view) {
        volume();

        String answer = data.get(currentGame).getAnswer();

        if(coin>60){
            for (int i = 0; i < answer.length()-1; i++) {
                if(answers.get(i).getText()==""){
                    answers.get(i).setText(javob.get(currentGame).charAt(i)+"");
                    for (int j = 0; j < variants.size(); j++) {
                        if(answers.get(i).getText().equals(variants.get(j).getText())){
                            variants.get(j).setVisibility(View.GONE);
                            coin-=60;
                            coins.setText(coin+"");
                            break;
                        }
                    }     break;
                }
            }
        }
        else{
            Toast.makeText(this,"Not enough coin",Toast.LENGTH_SHORT).show();
        }
    }

    public void onarrowclick(View view) {
       volume();
        Intent intent=new Intent(this, Menu.class);
        startActivity(intent);
        finish();
    }


    public void onMainvolumeclick(View view) {
        volume();
        if(text.getText().toString().equalsIgnoreCase("_1")){
            volume.setBackgroundResource(R.drawable.volumenow);
            text.setText("_2");
        }
        else {
            volume.setBackgroundResource(R.drawable.volume_up_fill0_wght400_grad0_opsz48__1_);
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

    @Override
    protected void onStop() {
        super.onStop();

        Settings.getSettings(this).setCoin(coin);
        Settings.getSettings(this).setcurrentgame(currentGame);
    }
}