
package BaseDatos;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ICRUD {
    public ArrayList listar() throws Exception;
    public int crear(Object object) throws SQLException;
    public void actualizar(int id, Object object) throws Exception;   
    public void eliminar(int id)throws Exception;
    public Object obtener(int id)throws Exception;
}
