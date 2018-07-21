package d.edu.itla.taskapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import d.edu.itla.taskapp.Vista.CategoriaListaActivity;
import d.edu.itla.taskapp.Vista.CrearCategoriaActivity;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnCategoria = findViewById(R.id.btnCategoria);

        btnCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CategoriaListaActivity.class);
                startActivity(intent);
            }

        });
        Button btnVerCategoria = findViewById(R.id.btnVerCategoria);
        btnVerCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CategoriaListaActivity.class);
                startActivity(intent);
            }
        });


    }
}
