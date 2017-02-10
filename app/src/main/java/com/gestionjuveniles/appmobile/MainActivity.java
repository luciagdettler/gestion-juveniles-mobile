package gestion_juveniles.com.gestionjuveniles_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import gestion_juveniles.com.gestionjuveniles_mobile.Modelo.Profesor;

public class MainActivity extends AppCompatActivity {

    private EditText user;
    private EditText pass;
    private Button iniciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);
        String email = user.getText().toString();
        String contraseña = pass.getText().toString();

        //Profesor prof = buscarProfesor(email,contraseña,listaProfesores);



        iniciarSesion = (Button) findViewById(R.id.ingresar);
        iniciarSesion.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Menu.class);

                startActivity(i);
            }
        });

    }

    public Profesor buscarProfesor(String email, String contraseña, List<Profesor> profes){
        Profesor profesor = new Profesor();
        profesor=null;
        for (Profesor p : profes){
            if(email.equals(p.getEmail())){
                if(contraseña.equals(p.getPass())){
                    profesor = p;
                }
            }
        }
        return profesor;
    }

}
