
package dominio;


public class Cliente {
    private int idsolicitud_cliente;
    private String Categoria;
    private String Variedad;
    private String Grado;
    private String Color;
    private String Nombre_empresa;

    public Cliente() {
    }

    public Cliente(int idsolicitud_cliente) {
        this.idsolicitud_cliente = idsolicitud_cliente;
    }

    public Cliente(String Categoria, String Variedad, String Grado, String Color, String Nombre_empresa) {
        this.Categoria = Categoria;
        this.Variedad = Variedad;
        this.Grado = Grado;
        this.Color = Color;
        this.Nombre_empresa = Nombre_empresa;
    }

    public Cliente(int idsolicitud_cliente, String Categoria, String Variedad, String Grado, String Color, String Nombre_empresa) {
        this.idsolicitud_cliente = idsolicitud_cliente;
        this.Categoria = Categoria;
        this.Variedad = Variedad;
        this.Grado = Grado;
        this.Color = Color;
        this.Nombre_empresa = Nombre_empresa;
    }

    public int getIdsolicitud_cliente() {
        return idsolicitud_cliente;
    }

    public void setIdsolicitud_cliente(int idsolicitud_cliente) {
        this.idsolicitud_cliente = idsolicitud_cliente;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getVariedad() {
        return Variedad;
    }

    public void setVariedad(String Variedad) {
        this.Variedad = Variedad;
    }

    public String getGrado() {
        return Grado;
    }

    public void setGrado(String Grado) {
        this.Grado = Grado;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getNombre_empresa() {
        return Nombre_empresa;
    }

    public void setNombre_empresa(String Nombre_empresa) {
        this.Nombre_empresa = Nombre_empresa;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idsolicitud_cliente=" + idsolicitud_cliente + ", Categoria=" + Categoria + ", Variedad=" + Variedad + ", Grado=" + Grado + ", Color=" + Color + ", Nombre_empresa=" + Nombre_empresa + '}';
    }
    
}
