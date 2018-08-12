package d.edu.itla.taskapp.Repositorio.db;

public interface EstructuraDb {
    public static final String TABLA_CATEGORIA = "CREATE TABLE categoria (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT)";
    public static final String TABLA_USUARIO = "CREATE TABLE usuario (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, email TEXT, tipoUsuario TEXT, Ccontrasena TEXT)";

    public static final String TABLA_USUARIO_CATEGORIA = "CREATE TABLE usuario_categoria(usuario_id INTEGER, categoria_id INTEGER)";

    public static final String TABLA__TAREA = "CREATE TABLE tarea (id INTEGER PRIMARY KEY AUTOINCREMENT,"+"" +
            "nombre TEXT, fecha NUMERIC, usuario_creador_id INTEGER,"+
            "usuario_asignado-id INTEGER, estado TEXT DEFAULT 'PENDIENTE',"+
            "descripcion TEXT, categoria_id INTEGER)";


}
