package d.edu.itla.taskapp.Repositorio;

import d.edu.itla.taskapp.entidad.Nota;

import java.util.List;


public interface NotaRepositorio {

    boolean guardar(Nota nota);
    List<Nota>buscarNotasPorTarea(Integer idTarea);
}
