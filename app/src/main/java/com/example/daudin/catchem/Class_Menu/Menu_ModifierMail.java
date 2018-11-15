package com.example.daudin.catchem.Class_Menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.daudin.catchem.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu_ModifierMail extends AppCompatActivity {

    private EditText mail;
    private Button enregistrement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_modifier_mail);
       mail = (EditText) findViewById(R.id.mail);
       enregistrement = (Button) findViewById(R.id.enregistrer);
       enregistrement.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               enregistrer();
           }
       });
    }

    private void enregistrer(){
        if (this.verifChap()){
            String adresseMail = mail.getText().toString();
            Log.i("test","mail = "+mail.getText().toString());
         /*
        ...
        Ici on fait pas l'enregistrement dans la BDD nous
        ...
         */
            Toast.makeText(this, "Enregistrer", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "Champ incorrecte", Toast.LENGTH_SHORT).show();
    }

    private boolean verifChap(){
        boolean champRemplie =  true;
        if(this.mail.getText().toString() == ""){
            this.mail.setError("Veuillez remplir ce champ");
            champRemplie = false;
        }
        if(!verifSyntax()){
            champRemplie = false;
        }

        return champRemplie;
    }

    private boolean verifSyntax(){
        boolean syntaxCorrect = true;
        Pattern p = Pattern.compile(".*@.*\\..*");
        Matcher m = p.matcher(this.mail.getText().toString());
        if (!m.matches())
            syntaxCorrect = false;
        return syntaxCorrect;
    }
}
