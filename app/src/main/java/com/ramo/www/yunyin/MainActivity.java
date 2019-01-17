package com.ramo.www.yunyin;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;
import java.util.Queue;

import static android.speech.tts.TextToSpeech.QUEUE_ADD;

public class MainActivity extends AppCompatActivity {
    private TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speakText("阿尼是大傻逼！");
            }
        });
        textToSpeech=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                textToSpeech.setLanguage(Locale.US);
                textToSpeech.setPitch(1.0f);// 设置音调，值越大声音越尖（女生），值越小则变成男声,1.0是常规
                textToSpeech.setSpeechRate(1.0f);
            }
        });


    }

    public void speakText(String text) {
        if (textToSpeech != null) {
            textToSpeech.speak(text,QUEUE_ADD,null,"xxx" );

        }
    }
}
