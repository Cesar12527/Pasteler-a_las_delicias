package IGU.Modelos;

import Entidades.ActivoFijo;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaActivoFijo extends AbstractTableModel {

    private ArrayList<ActivoFijo> listadoActivos = null;

    public ArrayList<ActivoFijo> getListadoActivos() {
        return listadoActivos;
    }

    public void setListadoActivos(ArrayList<ActivoFijo> listadoActivos) {
        this.listadoActivos = listadoActivos;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        if (this.listadoActivos != null) {
            return this.listadoActivos.size();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 5; // No incluimos el ID en la tabla, si deseas incluirlo cámbialo a 6
    }

    @Override
    public String getColumnName(int column) {
        String nombreCol = "";
        switch (column) {
            case 0: nombreCol = "Nombre"; break;
            case 1: nombreCol = "Descripción"; break;
            case 2: nombreCol = "Fecha Adquisición"; break;
            case 3: nombreCol = "Valor Precio"; break;
            case 4: nombreCol = "Estado"; break;
            default: throw new AssertionError();
        }
        return nombreCol;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       
        Object celda = "";
        ActivoFijo objC = null;
        if (this.listadoActivos != null) {
            objC = this.listadoActivos.get(rowIndex);
            switch (columnIndex) {
                case 0: celda = objC.getNombre(); break;
                case 1: celda = objC.getDescripcion(); break;
                case 2: celda = objC.getFechaAdquisicion(); break;
                case 3: celda = objC.getValorPrecio(); break;
                case 4: celda = objC.getEstado(); break;
                default: throw new AssertionError();
            }
        }
        return celda;
    }

    public void addActivoFijo(ActivoFijo af) {
        if (this.listadoActivos == null) {
            this.listadoActivos = new ArrayList<>();
        }
        this.listadoActivos.add(af);
        fireTableDataChanged();
    }

    public ActivoFijo getActivoFijo(int indiceSeleccionado) {
        if (this.listadoActivos != null) {
            return this.listadoActivos.get(indiceSeleccionado);
        }
        return null;
    }
}