package com.gestionjuveniles.appmobile;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.gestionjuveniles.appmobile.domain.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Menu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Button fecha_actual;
    public static User miusuariologeado;
   private ProgressBar progressBar;


    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Fecha Actual");
        setSupportActionBar(toolbar);

        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        DatabaseReference firebaseReference = database.getReference("users").child("0");
        firebaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                miusuariologeado = dataSnapshot.getValue(User.class);



            }

            @Override
            public void onCancelled(DatabaseError firebaseError) {
                //NADA
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fecha_actual = (Button) findViewById(R.id.button3);
        fecha_actual.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {


               if(miusuariologeado==null) {
                    AsinTaskEspera ejemploAsyncTask = new AsinTaskEspera();
                    ejemploAsyncTask.execute();

                }
               else{
                   Intent i = new Intent(Menu.this, Fecha_Actual.class);
                   startActivity(i);
               }

            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.fecha_actual) {
            // Handle the camera action
        } else if (id == R.id.historial) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public class AsinTaskEspera extends AsyncTask<Void,Integer,Boolean> {


        @Override
        protected Boolean doInBackground(Void... params) {
            while(miusuariologeado==null){
               int i=1;
                UnSegundo();
                publishProgress(i*10);
                if(isCancelled()){
                    break;
                }
                i++;
            }
            return true;

        }
        private void UnSegundo(){
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){}
        }

        @Override
        public void onPreExecute(){
            progressBar.setVisibility(ProgressBar.VISIBLE);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            progressBar.setProgress(values[0].intValue());

        }



        @Override
        protected void onPostExecute(Boolean resultado) {
            //super.onPostExecute(aVoid);
                Toast.makeText(Menu.this, "Finalizo la carga", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(ProgressBar.INVISIBLE);
            Intent i = new Intent(Menu.this, Fecha_Actual.class);

            startActivity(i);

        }



}

}
