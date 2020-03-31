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
    int profundidadArbol;
    public ArrayList<Nodo> nodosHijos = new ArrayList<>();
    
    public MinMax(){
    }
    
    public MinMax(Nodo nodoRaiz,int profundidadArbol){
        this.raiz = nodoRaiz;
        this.profundidadArbol = profundidadArbol;
    }
    
    public int valorRaiz(){
        return valorRaiz;
    }
    
    public int calculoMinMax(){
        int valor;
        valor = Max(raiz,profundidadArbol);
        return valor;
    }
    
    public int Max(Nodo rama,int profundidad){
        profundidad -=1;
        int acumulado=-1500;
        int valorMax;
        int valorFinal;
        valorFinal = rama.getValor();
        if(profundidad < 0){
            return valorFinal;
        }
        nodosHijos = rama.getNodosHijos();
        if(nodosHijos != null){
            System.out.println("Calculando Max");
            for(int i=0;i<nodosHijos.size();i++){
                nodoHijo = nodosHijos.get(i);
                valorMax = Min(nodoHijo,profundidad);
                if(valorMax>acumulado){
                    acumulado = valorMax;
                }
            }
        }
        rama.setValor(acumulado);
        return acumulado;
    }
    
    public int Min(Nodo rama,int profundidad){
        profundidad -=1;
        int acumulado=1500;
        int valorMin=0;
        int valorFinal;
        valorFinal = rama.getValor();
        if(profundidad < 0){
            return valorFinal;
        }
        nodosHijos = rama.getNodosHijos();
        if(nodosHijos != null){
            System.out.println("Calculando Min");
            for(int i=0;i<nodosHijos.size();i++){
                nodoHijo = nodosHijos.get(i);
                valorMin = Max(nodoHijo,profundidad);
                if(valorMin<acumulado){
                    acumulado = valorMin;
                }
            }
        }
        rama.setValor(acumulado);
        return acumulado;
    } 
    
    
}
