
package IGU.Modelos;

import Entidades.CategoriaProducto;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class ModeloComboCategoriaProducto extends AbstractListModel implements ComboBoxModel{
    private ArrayList<CategoriaProducto> listadocategoriaProducto;
    private CategoriaProducto seleccionado = null;

    public ArrayList<CategoriaProducto> getListadocategoriaProducto() {
        return listadocategoriaProducto;
    }

    public void setListadocategoriaProducto(ArrayList<CategoriaProducto> listadocategoriaProducto) {
        this.listadocategoriaProducto = listadocategoriaProducto;
    }

    public CategoriaProducto getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(CategoriaProducto seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    
    @Override
    public int getSize() {
        int cantElem = 0;
        
        if(this.listadocategoriaProducto != null) {        
            cantElem = this.listadocategoriaProducto.size();
        }
        return cantElem; 
    }

    @Override
    public Object getElementAt(int index) {
        Object elem = "";
        if(this.listadocategoriaProducto != null) { 
            elem = this.listadocategoriaProducto.get(index).toString();
        }
        return elem;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.seleccionado = null;
        if(this.listadocategoriaProducto != null && anItem != null) {
            for (CategoriaProducto cat_Pro : this.listadocategoriaProducto) {
                if( cat_Pro.toString().equals(anItem) ) {
                    this.seleccionado = cat_Pro;
                    return;
                }
            }
        }
    }

    @Override
    public Object getSelectedItem() {
        Object elem = "";
        if(this.seleccionado != null) {
            elem = this.seleccionado;
        }
        return elem;
    }
    
}
