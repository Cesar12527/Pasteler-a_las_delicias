package IGU.Modelos;

import Entidades.Usuario;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class ModeloComboUsuario extends AbstractListModel implements ComboBoxModel {
    private ArrayList<Usuario> listaUsuarios;
    private Usuario seleccionado = null;

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Usuario getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Usuario seleccionado) {
        this.seleccionado = seleccionado;
    }

    @Override
    public int getSize() {
        int cantElem = 0;
        
        if(this.listaUsuarios != null) {        
            cantElem = this.listaUsuarios.size();
        }
        return cantElem; 
    }

    @Override
    public Object getElementAt(int index) {
        Object elem = "";
        if(this.listaUsuarios != null) { 
            elem = this.listaUsuarios.get(index).toString();
        }
        return elem;
    }

     @Override
    public void setSelectedItem(Object anItem) {
        this.seleccionado = null;
        if(this.listaUsuarios != null && anItem != null) {
            for (Usuario cat_Pro : this.listaUsuarios) {
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
