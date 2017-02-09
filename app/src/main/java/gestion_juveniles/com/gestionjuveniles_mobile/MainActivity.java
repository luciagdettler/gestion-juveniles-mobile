package gestion_juveniles.com.gestionjuveniles_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

        iniciarSesion = (Button) findViewById(R.id.ingresar);
        iniciarSesion.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Menu.class);

                startActivity(i);
            }
        });

    }

}
