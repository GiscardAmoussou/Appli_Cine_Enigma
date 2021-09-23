package com.example.applicineenigma;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;


import android.widget.EditText;
import android.widget.Toast;

public class AppliCineEnigma extends AppCompatActivity {
    EditText titre_du_film, date_heure_projection, note_scenario, note_realisation, note_musique, zone_description_critique;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appli_cine_enigma);
        final DatabaseHelper helper = new DatabaseHelper(this);
        titre_du_film = findViewById(R.id.titre_du_film);
        date_heure_projection = findViewById(R.id.date_heure_projection);
        note_scenario = findViewById(R.id.note_scenario);
        note_realisation = findViewById(R.id.note_realisation);
        note_musique = findViewById(R.id.note_musique);
        zone_description_critique = findViewById(R.id.zone_description_critique);
        findViewById(R.id.submit).setOnClickListener(view -> {
            if (!titre_du_film.getText().toString().isEmpty() && date_heure_projection.getText().toString().isEmpty() &&
                    note_scenario.getText().toString().isEmpty() && note_realisation.getText().toString().isEmpty() &&
                    note_musique.getText().toString().isEmpty() && zone_description_critique.getText().toString().isEmpty()) {
                if (helper.insert(titre_du_film.getText().toString(), date_heure_projection.getText().length(), note_scenario.getText().length(),
                        note_realisation.getText().length(), note_musique.getText().length(), zone_description_critique.getText().toString())) {
                    Toast.makeText(AppliCineEnigma.this, "Inserted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(AppliCineEnigma.this, "NOT Inserted", Toast.LENGTH_LONG).show();
                }
            } else {
                titre_du_film.setError("Entrer le titre du film");
                date_heure_projection.setError("Entrer la date et l'heure de la projection");
                note_scenario.setError("Entrer la notre du scénarion");
                note_realisation.setError("entrer la note de la réalisation");
                note_musique.setError("Entrer la note de la musique");
                zone_description_critique.setError("Entrer une description / critique");

            }
        });

    }
 }


