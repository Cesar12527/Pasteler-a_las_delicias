
package Entidades;

public class Usuario {
     private int idt;
    private String usuario;
    private String claveHash; // 🔐 Aquí se almacena la contraseña encriptada
    private TipoRol tiporol;
    public Usuario() {
    }

    public Usuario(String usuario, String claveHash, TipoRol tiporol) {
        this.usuario = usuario;
        this.claveHash = claveHash;
        this.tiporol = tiporol;
    }

    public int getId() {
        return idt;
    }

    public void setId(int id) {
        this.idt = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClaveHash() {
        return claveHash;
    }

    public void setClaveHash(String claveHash) {
        this.claveHash = claveHash;
    }

    public TipoRol getTiporol() {
        return tiporol;
    }

    public void setTiporol(TipoRol tiporol) {
        this.tiporol = tiporol;
    }
    
    
    
}
