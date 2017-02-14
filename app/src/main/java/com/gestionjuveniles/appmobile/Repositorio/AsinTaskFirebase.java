package com.gestionjuveniles.appmobile.Repositorio;

import android.os.AsyncTask;
import android.util.Log;

import com.gestionjuveniles.appmobile.domain.Team;
import com.gestionjuveniles.appmobile.domain.User;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

/**
 * Created by Usuario on 13/2/2017.
 */
public class AsinTaskFirebase extends AsyncTask<DatabaseReference,Integer,User> {


    private User user;

    @Override
    protected User doInBackground(DatabaseReference... voids) {

        DatabaseReference database = (DatabaseReference) voids[0];//FirebaseDatabase.getInstance();

        database.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                user = dataSnapshot.getValue(User.class);
                Team team = user.getTeams().get(0);
                Log.d("fechaActual", "equipo  "+team.getId() +"   " + team.getPlayers().get(2).getName()+ "    "+team.getFormation().get(2).getPosition());

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
       /* firebaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                user = dataSnapshot.getValue(User.class);
                Team team = user.getTeams().get(0);
                Log.d("fechaActual", "equipo  "+team.getId() +"   " + team.getPlayers().get(2).getName()+ "    "+team.getFormation().get(2).getPosition());


            }

            @Override
            public void onCancelled(DatabaseError firebaseError) {
                //NADA
            }
        });
*/
        return user;


    }

}
