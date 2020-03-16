package Modelos;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author Joaquin
 */
public class ModeloRegistrarActividad extends AbstractListModel {
    
    private ArrayList<Actividad> log = new ArrayList<>();

    @Override
    public int getSize() {
        return log.size();
    }

    @Override
    public Object getElementAt(int i) {
        Actividad actividad = log.get(i);
        String cadena;
        cadena =actividad.getUsuario();
        cadena = cadena+":"+actividad.getDescripcion();
        return cadena;
    }
    
    public void agregarActividad(Actividad actividad){
        log.add(actividad);
        this.fireIntervalAdded(this, getSize(), getSize()+1);
    }
    
    public void eliminarActividad(int index){
        log.remove(index);
         this.fireIntervalRemoved(index, getSize(), getSize()+1);
    }
    
    public Actividad getActividad(int index){
        return log.get(index);
    }
    
    public void eliminarTodasActividades(){
        log.clear();
    }
    
}
