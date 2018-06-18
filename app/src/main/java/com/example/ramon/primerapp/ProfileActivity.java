package com.example.ramon.primerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class ProfileActivity extends AppCompatActivity {

    TextView textViewName;
    TextView textViewAbout;
    TextView textViewProjects;
    TextView textViewRepos;
    TextView textViewStars;

    AppCompatButton buttonShare;


    private final String PROFILE_DATA = "PROFILE_DATA";

    Persona currentPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle("Perfil");

        textViewName = findViewById(R.id.textViewNombre);
        textViewAbout = findViewById(R.id.textViewAbout);
        textViewProjects = findViewById(R.id.Repos);
        textViewRepos = findViewById(R.id.tv_project_Resp);
        textViewStars = findViewById(R.id.tv_stat_Resp);
        buttonShare = findViewById(R.id.btncompartir);

        if(getIntent()!=null && getIntent().getExtras()!= null){
            currentPerson = getIntent().getParcelableExtra(PROFILE_DATA);
            if(currentPerson != null){
                textViewName.setText(currentPerson.getName());
                textViewAbout.setText(currentPerson.getAbout());
               textViewProjects.setText(String.valueOf(currentPerson.getProjects()));
               // textViewRepos.setText(String.valueOf(currentPerson.getRepos()));
               // textViewStars.setText(String.valueOf(currentPerson.getStars()));
            }
        }

        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CompartirPerfil(currentPerson);
            }
        });

    }

    private void CompartirPerfil(Persona persona){
        Intent comp = new Intent();

        String textToSend = persona.getName() +"\n"+ persona.getEmail()+"\n"+ persona.getAbout();
        comp.setAction(Intent.ACTION_SEND);
        comp.putExtra(Intent.EXTRA_TEXT, textToSend);
        comp.setType("text/plain");

        startActivity(comp);
    }

}