package d.edu.itla.taskapp.Vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import d.edu.itla.taskapp.R;
import d.edu.itla.taskapp.entidad.Categoria;
import d.edu.itla.taskapp.entidad.Tarea;
import d.edu.itla.taskapp.entidad.Usuario;
import d.edu.itla.taskapp.Repositorio.CategoriaRepositorio;
import d.edu.itla.taskapp.Repositorio.CategoriaRepositorioImp;
import d.edu.itla.taskapp.Repositorio.TareaRepositorio;
import d.edu.itla.taskapp.Repositorio.TareaRepositorioDbImpl;
import d.edu.itla.taskapp.Repositorio.UsuarioRepositorio;
import d.edu.itla.taskapp.Repositorio.UsuarioRepositorioDbImpl;



public class RegistrarTareaActivity extends AppCompatActivity {

    private CategoriaRepositorio categoriaRepositorio;
    private UsuarioRepositorio usuarioRepositorio;
    private TareaRepositorio tareaRepositorio;


}
