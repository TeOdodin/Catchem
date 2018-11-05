package com.example.daudin.catchem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    private Button modifieDonne;
    private Button historique;
    private Button modifieMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        modifieDonne = (Button) findViewById(R.id.ModifierDonnee);
        modifieDonne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }

        });

        historique = (Button) findViewById(R.id.Historique);
        historique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }

        });

        modifieMail = (Button) findViewById(R.id.ModifeMail);
        modifieMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }

        });
    }
}


