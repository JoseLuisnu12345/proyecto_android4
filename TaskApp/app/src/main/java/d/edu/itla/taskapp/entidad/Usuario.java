package d.edu.itla.taskapp.entidad;

public class Usuario {

    public enum TipoUsuario{
        TECNICO, NORMAL
    }

    private Integer id;
    private String nombre;
    private String email;
    private String contraseña;
    private TipoUsuario tipoUuario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public TipoUsuario getTipoUuario() {
        return tipoUuario;
    }

    public void setTipoUuario(TipoUsuario tipoUuario) {
        this.tipoUuario = tipoUuario;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Usuario{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", contraseña='").append(contraseña).append('\'');
        sb.append(", tipoUuario=").append(tipoUuario);
        sb.append('}');
        return sb.toString();
    }
}
