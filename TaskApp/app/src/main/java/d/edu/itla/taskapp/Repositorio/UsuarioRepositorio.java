package d.edu.itla.taskapp.Repositorio;

import d.edu.itla.taskapp.entidad.Usuario;

import java.util.List;

public interface UsuarioRepositorio {

    boolean guardar(Usuario usuario);

    boolean actualizar(Usuario usuario);

    Usuario buscar(int id);

    List<Usuario> buscar(String nombre);

}

