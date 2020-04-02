package Modelos;

import java.util.ArrayList;

/**
 *
 * @author Joaquin
 */
public class MinMax {
    int valorRaiz=0;
    Nodo raiz;
    //Nodo nodoHijo;
    int profundidadArbol;
    //public ArrayList<Nodo> nodosHijos = new ArrayList<>();
    
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
        //profundidad -=1;
        int acumulado=-1500;
        int valorMax;
        int valorFinal;
        int valorBeta;
        valorFinal = rama.getValor();
        if(profundidad == 0){
            acumulado = valorFinal;
        }
        else{
            ArrayList<Nodo> nodosHijos = rama.getNodosHijos();
            int cantHijos = nodosHijos.size(); 
            
            if (cantHijos == 0){
                acumulado = valorFinal;
            }

            for(int i=0;i<cantHijos;i++){
                Nodo padre = rama.getNodoPadre(); 
                if(padre ==  null){
                    valorBeta = -1;
                }
                else{
                    valorBeta = padre.getBeta();
                }
                Nodo nodoHijo = nodosHijos.get(i);
                valorMax = Min(nodoHijo,profundidad-1);
                if(valorMax>acumulado){
                    acumulado = valorMax;
                    rama.setAlpha(acumulado);
                }
                if((valorMax>valorBeta) &&(valorBeta != -1)){
                    break;
                }
            }
            rama.setValor(acumulado);
        }
        return acumulado;
    }
    
    public int Min(Nodo rama,int profundidad){
        int acumulado=1500;
        int valorMin;
        int valorFinal;
        int valorAlfa;
        valorFinal = rama.getValor();
        if(profundidad == 0){
            acumulado = valorFinal;
        }
        else{
            ArrayList<Nodo> nodosHijos = rama.getNodosHijos();
            int cantHijos = nodosHijos.size(); 
            
            if (cantHijos == 0){
                acumulado = valorFinal;
                
            }

            for(int i=0;i<cantHijos;i++){
                valorAlfa = rama.getNodoPadre().getAlpha();
                Nodo nodoHijo = nodosHijos.get(i);
                valorMin = Max(nodoHijo,profundidad-1);
                if(valorMin<acumulado){
                    acumulado = valorMin;
                    rama.setBeta(acumulado);
                }
                if((valorAlfa>valorMin) && (valorAlfa !=-1)){
                    break;
                }
            }
            rama.setValor(acumulado);
        }
        
        return acumulado;
    }   
}
