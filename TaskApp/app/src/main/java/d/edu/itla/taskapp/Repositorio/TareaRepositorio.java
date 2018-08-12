package d.edu.itla.taskapp.Repositorio;

import java.text.ParseException;
import java.util.List;

import d.edu.itla.taskapp.entidad.Tarea;
import d.edu.itla.taskapp.entidad.Usuario;

public interface TareaRepositorio {
    boolean guardar(Tarea tarea);
    boolean actualizar(Tarea tarea);
    void actualizarEstatus(Tarea tarea);
    Tarea buscar(int id);
    List<Tarea>buscarAsignada(Usuario usuario) throws ParseException;
    List<Tarea>buscarCreadaPor(Usuario usuario);
}
