package d.edu.itla.taskapp.Vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import d.edu.itla.taskapp.R;
import d.edu.itla.taskapp.Repositorio.CategoriaRepositorio;
import d.edu.itla.taskapp.Repositorio.CategoriaRepositorioImp;
import d.edu.itla.taskapp.entidad.Categoria;

public class CategoriaListaActivity extends AppCompatActivity {
    private static final String LOG_TAG = "CategoriaListaActivity";
    private CategoriaRepositorio categoriaRepositorio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_lista);

        categoriaRepositorio = new CategoriaRepositorioImp(this);
        List<Categoria> categorias = categoriaRepositorio.buscar(null);

        Log.i(LOG_TAG, "TOTAL DE CATEGORIAS"+categorias.size());

        ListView catListView =(ListView)findViewById(R.id.categoria_listview);

        catListView.setAdapter(new CategoriaListAdapter(this,categorias));
        catListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long I) {
                //categoria item
                Categoria cat = (Categoria) adapterView.getItemAtPosition(i);
                //intent
                Intent regCatIntent = new Intent(CategoriaListaActivity.this, CrearCategoriaActivity.class);
                regCatIntent.putExtra("categoria",cat);
                startActivity(regCatIntent);


            }
        });




    }
}
