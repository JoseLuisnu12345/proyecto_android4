package d.edu.itla.taskapp.Vista;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import d.edu.itla.taskapp.R;
import d.edu.itla.taskapp.entidad.Categoria;

import java.util.List;

public class CategoriaListAdapter extends BaseAdapter {
    private Context context;
    private List<Categoria> categorias;


    public CategoriaListAdapter(Context context, List<Categoria> categorias) {
        this.context = context;
        this.categorias = categorias;
    }
    @Override
    public int getCount(){
        return categorias.size();
    }

    @Override
    public Object getItem(int i){
        return categorias.get(i);
    }
    @Override
    public long getItemId(int i){
        return categorias.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup parent){
        if(view==null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.categoria_listview_row, null, true);
        }

        TextView IbCategoriaId = view.findViewById(R.id.lbId);
        TextView IbCategoriaNombre = view.findViewById(R.id.lbNombre);

        Categoria cat = categorias.get(i);

        IbCategoriaId.setText(cat.getId().toString());
        IbCategoriaNombre.setText(cat.getNombre());

        return view;

        }


}