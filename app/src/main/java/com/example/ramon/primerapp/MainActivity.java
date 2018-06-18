package com.example.ramon.primerapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private AppCompatButton buttonLogin;
    EditText inputEmail;
    EditText inputPassword;
    HashMap<String, Persona> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Login");
        inputEmail = findViewById(R.id.editTextEmail);
        inputPassword = findViewById(R.id.Password);

        buttonLogin = findViewById(R.id.buttonLogin);

        createDummyListOfPeople();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = "";
                String nom = "Ramon Agustin Castillo Veras";
                String about = "Soy un Progamador con conocimiento en diferentes Lenguaje de Progamacion : C#, C++, Java etc";
                int rp = 100;
                int pj = 100;
                int st = 50;

                if(inputEmail != null){

                    email = inputEmail.getText().toString().toLowerCase();
                }

                Persona objPersona = new Persona(nom,about,email,rp,pj,st);
                String em = objPersona.getEmail();

                if(em != null && inputEmail.getText().toString().equals("051991@gmail.com") && inputPassword.getText().toString().equals("12345")){

                    Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                    intent.putExtra("PROFILE_DATA",objPersona);
                    startActivity(intent);

                }else{
                    Toast.makeText(getApplicationContext(), "Email o Contraseña Invalida", Toast.LENGTH_SHORT).show();
                    inputEmail.setText("");
                    inputPassword.setText("");
                }
            }
        });

    }

    private void createDummyListOfPeople(){
        Persona person = new Persona();
        person.setName("Ramon Agustin Castillo Veras");
        person.setEmail("ramoncastillo051991@gmail.com");
        person.setAbout("Soy un Progamador con conocimiento en diferentes Lenguaje de Progamacion : C#, C++, Java etc");
        person.setProjects(100);
        person.setStars(300);
        person.setRepos(150);

        data  = new HashMap<>();
        data.put("ramoncastillo051991@gmail.com", person);
    }
}

