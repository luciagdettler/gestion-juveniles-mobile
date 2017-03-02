package com.gestionjuveniles.appmobile.Repositorio;

import android.os.AsyncTask;

import com.gestionjuveniles.appmobile.Interfaz.BusquedaUsuarioListener;
import com.gestionjuveniles.appmobile.domain.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Usuario on 13/2/2017.
 */
public class AsinTaskFirebase extends AsyncTask<Void,Integer,User> {

    private BusquedaUsuarioListener listener;

    private static FirebaseDatabase database = FirebaseDatabase.getInstance();
    private User user;

    public AsinTaskFirebase(BusquedaUsuarioListener dListener){
        this.listener = dListener;
    }
    @Override
    protected User doInBackground(Void... params) {

        DatabaseReference firebaseReference = database.getReference("users").child("0");
        firebaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                user = dataSnapshot.getValue(User.class);

            }

            @Override
            public void onCancelled(DatabaseError firebaseError) {
                //NADA
            }
        });

        while(user==null){
        }
        return user;

    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(User user) {
        //super.onPostExecute();
        listener.busquedaFinalizada(user);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled(User user) {
        super.onCancelled(user);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

}
