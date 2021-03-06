package d.edu.itla.taskapp.Repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import d.edu.itla.taskapp.Repositorio.db.ConexionDb;
import d.edu.itla.taskapp.entidad.Categoria;
import d.edu.itla.taskapp.Repositorio.db.ConexionDb;

import java.util.ArrayList;
import java.util.List;

import d.edu.itla.taskapp.entidad.Usuario;

public class CategoriaRepositorioImp implements CategoriaRepositorio {

    private ConexionDb conexionDb;

    private static final String CAMPO_NOMBRE = "nombre";
    private static final String TABLA_CATEGORIA = "categoria";

    public CategoriaRepositorioImp(Context context)
    {
        conexionDb = new ConexionDb(context);
    }

    @Override
    public boolean guardar(Categoria categoria) {

        if(categoria.getId() != null && categoria.getId() > 0)
        {
            return actualizar(categoria);
        }
        //datos de categoria
        ContentValues cv = new ContentValues();
        cv.put(CAMPO_NOMBRE, categoria.getNombre());
        //db
        SQLiteDatabase db = conexionDb.getWritableDatabase();
        Long id = db.insert(TABLA_CATEGORIA,null, cv);
        //cerrando la db
        db.close();

        if(id.intValue() > 0)
        {
            categoria.setId(id.intValue());
            //retorna true si la categoria se guardo
            return true;
        }
        //retorna false si la categoria no guardo
        return false;
    }

    @Override
    public boolean actualizar(Categoria categoria) {

        //datos de categoria
        ContentValues cv = new ContentValues();
        cv.put(CAMPO_NOMBRE, categoria.getNombre());
        //db
        SQLiteDatabase db = conexionDb.getWritableDatabase();
        int cantidad = db.update(TABLA_CATEGORIA, cv, "id = ?"
                , new String[]{categoria.getId().toString()});
        //cerrando la db
        db.close();
        //retorna false si la categoria no guardo
        return cantidad > 0;
    }

    @Override
    public Categoria buscar(int id) {
        return null;
    }

    @Override
    public List<Categoria> buscar(String buscar) {

        //TODO: buscar las categorias por su nombre (LIKE)

        List<Categoria> categorias = new ArrayList<>();

        SQLiteDatabase db = conexionDb.getReadableDatabase();

        String[] columnas = {"id", CAMPO_NOMBRE};
        //query
        Cursor cr = db.query(TABLA_CATEGORIA, columnas, null, null
                ,null, null,null);

        cr.moveToFirst();

        while (!cr.isAfterLast())
        {
            int id = cr.getInt(cr.getColumnIndex("id"));
            String nombre = cr.getString(cr.getColumnIndex(CAMPO_NOMBRE));

            Categoria c = new Categoria();
            c.setId(id);
            c.setNombre(nombre);
            //add categoria
            categorias.add(c);
            //move next
            cr.moveToNext();
        }
        //close
        cr.close();
        db.close();
        //return
        return categorias;
    }

    public static interface UsuarioRepositorio {

        boolean guardar(Usuario usuario);

        boolean actualizar(Usuario usuario);

        Usuario buscar(int id);

        List<Usuario>buscar(String nombre);


    }
}

