package com.example.daudin.catchem;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class Menu_MD_ajouterDonner extends AppCompatActivity {

    private Button ajouteImma;
    private LinearLayout linearyLayoutImma;
    private int nbLigne=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_md_ajouter_donner);
        this.ajouteImma = (Button) findViewById(R.id.ajouteImma);
        final EditText nouvelleImma = new EditText(this);
        this.ajouteImma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nouvelleImma.getParent() != null){
                    nouvelleImma.getParent().clearChildFocus(nouvelleImma);
                }
                linearyLayoutImma = (LinearLayout) findViewById(R.id.linearyLayoutImma);
                LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                nouvelleImma.setLayoutParams(p);
                nouvelleImma.setHint("ex : HH-888-HH");
                nouvelleImma.setId(nbLigne);
                linearyLayoutImma.addView(nouvelleImma);
                nbLigne++;
            }
        });
    }

}
