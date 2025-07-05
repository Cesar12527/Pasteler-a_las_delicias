package Seguridad;

import Entidades.Empleado;

public class sesion {
     public static Empleado empleadoLogueado;

    public static void setUsuarioLogueado(Empleado e) {
        empleadoLogueado = e;
    }

    public static Empleado getUsuarioLogueado() {
        return empleadoLogueado;
    }
}