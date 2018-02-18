package mx.unam.aragon.fes.diplo.gitandroid;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private Button miBoton, otroBoton, imgBoton;
    private Bitmap imgInt;
    private ImageView miImagen;
    private TextView txtVista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miBoton = findViewById(R.id.button);
        otroBoton = findViewById(R.id.button2);
        imgBoton = findViewById(R.id.button3);
        miImagen = findViewById(R.id.imageView);
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

        imgBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    new DescargaImg().execute(new URL("https://i.ytimg.com/vi/O9FyfaWEf_c/hqdefault.jpg"));
                }catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    class DescargaImg extends AsyncTask<URL,Integer,Bitmap> {
        @Override
        protected Bitmap doInBackground(URL... urls) {
            try {
                imgInt = BitmapFactory.decodeStream(urls[0].openConnection().getInputStream());
            }catch(Exception e) {
                Log.e("diplo","Error" + e.toString());
            }
            return imgInt;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            miImagen.setImageBitmap(imgInt);
            super.onPostExecute(bitmap);
        }
    }
}
