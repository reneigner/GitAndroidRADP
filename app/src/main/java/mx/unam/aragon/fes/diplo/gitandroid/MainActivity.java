package mx.unam.aragon.fes.diplo.gitandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button miBoton, otroBoton;
    private TextView txtVista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miBoton = findViewById(R.id.button);
        otroBoton = findViewById(R.id.button2);
        txtVista = findViewById(R.id.textView);

        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                txtVista.setText("Hola Github");
                Toast.makeText(MainActivity.this,
                        "Se cambio el mensaje en el TextView",Toast.LENGTH_SHORT).show();
            }
        });

        otroBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtVista.setText("Diplomado Android");
                Toast.makeText(MainActivity.this,
                        "Se cambio el mensaje en el TextView",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
