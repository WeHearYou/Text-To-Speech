package com.example.mytexttospeech;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.speech.tts.TextToSpeech;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.mytexttospeech.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextToSpeech tts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText e1=findViewById(R.id.editTextTextMultiLine);
        Button b1= findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener()
                              {
                                  @Override
                                  public  void onClick(View view){
                                      tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                          @Override
                                          public void onInit(int i) {
                                              if (i==TextToSpeech.SUCCESS){
                                                  tts.setLanguage(Locale.ENGLISH);
                                                  tts.setSpeechRate(1.0f);
                                                  tts.speak(e1.getText().toString(),TextToSpeech.QUEUE_ADD,null);
                                              }

                                          }
                                      });
                                  }
                              }
        );





    }
}