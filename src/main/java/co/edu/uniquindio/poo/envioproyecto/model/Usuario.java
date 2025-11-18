package co.edu.uniquindio.poo.envioproyecto.model;

/**
 * Modelo que representa un usuario cliente de la plataforma. Contiene
 * información de contacto y el método de pago preferido.
 */
public class Usuario {

    private String nombre, apellido, correo, telefono, direccion;
    private int idUsuario;
    private MetodoPago metodoPago;

    public Usuario(String nombre, String apellido, String correo, String telefono, String direccion, int idUsuario,MetodoPago metodoPago) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.idUsuario = idUsuario;
        this.metodoPago= metodoPago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }
}
