package com.example.daudin.catchem.Menu;

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
import android.widget.Toast;

import com.example.daudin.catchem.R;

public class Menu_MD_ajouterDonner extends AppCompatActivity {

    private Button ajouteImma;
    private Button valider;
    private LinearLayout linearyLayoutImma;
    private int nbLigne = 0;
    private EditText nom;
    private EditText prenom;
    private EditText immatriculation1;
    private EditText nouvelleImma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_md_ajouter_donner);
        this.ajouteImma = (Button) findViewById(R.id.ajouteImma);
        nouvelleImma = new EditText(this);
        this.ajouteImma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nouvelleImma.getParent() != null) {
                    nouvelleImma.getParent().clearChildFocus(nouvelleImma);
                    ViewGroup parentViexGroup = (ViewGroup) nouvelleImma.getParent();
                    if (parentViexGroup != null) {
                        parentViexGroup.removeView(nouvelleImma);
                    }
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
        this.valider = (Button) findViewById(R.id.valider);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouter();
            }
        });
    }

    public void ajouter() {
        if (this.champCorrecte()) {
            this.nom = (EditText) findViewById(R.id.nom);
            this.prenom = (EditText) findViewById(R.id.prenom);
            this.immatriculation1 = (EditText) findViewById(R.id.immatriculation);
            String nom = this.nom.getText().toString();
            String prenom = this.prenom.getText().toString();
            String immatriculation = this.immatriculation1.getText().toString();
            String immatriculation2 = this.nouvelleImma.getText().toString();
            Log.i("test", "nom = " + nom);
            Log.i("test", "prenom = " + prenom);
            Log.i("test", "Immatriculation = " + immatriculation);
            Log.i("test", "Immatriculation2 = " + immatriculation2);
        /*
            ...
            Ici on fait pas l'enregistrment dans la BDD nous
            ...
         */
            Toast.makeText(this, "Enregsitrer", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, "Champ incorrecte", Toast.LENGTH_SHORT).show();
    }

    public boolean champCorrecte(){
        boolean champRemplie = true;
        if (this.nom.getText().toString()== null){
            champRemplie = false;
        }
        if(this.prenom.getText().toString() == null){
            champRemplie = false;
        }
        if(this.immatriculation1.getText().toString() == null){
            champRemplie = false;
        }
        if(this.nouvelleImma == null || this.nouvelleImma.getText().toString() == null ){
            champRemplie = false;
        }
        return champRemplie;
    }

}
