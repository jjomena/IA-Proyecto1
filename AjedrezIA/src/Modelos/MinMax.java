package Modelos;

import java.util.ArrayList;

/**
 *
 * @author Joaquin
 */
public class MinMax {
    int valorRaiz=0;
    Nodo raiz;
    Nodo nodoHijo;
    int profundidad=3;
    public ArrayList<Nodo> nodosHijos = new ArrayList<>();
    
    public MinMax(){
    }
    
    public MinMax(Nodo nodoRaiz){
        this.raiz = nodoRaiz;
    }
    
    public int valorRaiz(){
        return valorRaiz;
    }
    
   
    public int Max(Nodo rama){
        profundidad -=1;
        int acumulado;
        int valorMax=0;
        acumulado = rama.getValor();
        if(profundidad < 0){
            return acumulado;
        }
        nodosHijos = rama.getNodosHijos();
        if(nodosHijos != null){
            for(int i=0;i<nodosHijos.size();i++){
                nodoHijo = nodosHijos.get(i);
                valorMax = Min(nodoHijo);
                if(valorMax>acumulado){
                    acumulado = valorMax;
                }
            }
        }
        return acumulado;
    }
    
    public int Min(Nodo rama){
        profundidad -=1;
        int acumulado=1500;
        int valorMin=0;
        int valorFinal;
        valorFinal = rama.getValor();
        if(profundidad == 0){
            return valorFinal;
        }
        nodosHijos = rama.getNodosHijos();
        if(nodosHijos != null){
            for(int i=0;i<nodosHijos.size();i++){
                nodoHijo = nodosHijos.get(i);
                valorMin = Max(nodoHijo);
                if(valorMin<acumulado){
                    acumulado = valorMin;
                }
                rama.setValor(acumulado);
            }
        }
        return acumulado;
    } 
    
    
}
