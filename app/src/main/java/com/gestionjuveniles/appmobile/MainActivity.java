package com.gestionjuveniles.appmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gestionjuveniles.appmobile.domain.Team;
import com.gestionjuveniles.appmobile.domain.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;



public class MainActivity extends AppCompatActivity {

    private EditText user;
    private EditText pass;
    private Button iniciarSesion;
    private User prof;
    private Team team;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private FirebaseDatabase database2 = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);
        final String email = user.getText().toString();
        final String contraseña = pass.getText().toString();




        User usuarioNoAutenticado = new User();


        DatabaseReference firebaseReference = database.getReference("users").child("0");
        firebaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                prof = dataSnapshot.getValue(User.class);

                Log.d("DATALUCIA","nombre  "+ prof.getEmail() + prof.getId()+prof.getPassword()+prof.getName());

            }

            @Override
            public void onCancelled(DatabaseError firebaseError) {
                //NADA
            }
        });


        iniciarSesion = (Button) findViewById(R.id.ingresar);
        iniciarSesion.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent i = new Intent(MainActivity.this, Menu.class);

                startActivity(i);

            }
        });

    }

    public Boolean esProfesor(String e, String c, List<User> profes){
       Boolean prof=false;
        user =null;
        for (User p : profes){
            if(e.equals(p.getEmail())){
                if(c.equals(p.getPassword())){
                    prof=true;
                }
            }
        }
        return prof;
    }



}
