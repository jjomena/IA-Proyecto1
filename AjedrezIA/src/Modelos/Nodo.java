package Modelos;

import java.util.ArrayList;

/**
 *
 * @author Joaquin
 */
public class Nodo {
    
    public Tablero tablero;
    public boolean isMax;
    public int nivel;
    public int valor;
    public int alpha;
    public int beta;
    public Nodo nodoPadre=null;
    public ArrayList<Nodo> nodosHijos = new ArrayList<>();
    
    public Nodo(){};

    public Nodo(Tablero tablero){
        this.tablero = tablero;
    }

    public Nodo getNodoPadre() {
        return nodoPadre;
    }

    public void setNodoPadre(Nodo nodoPadre) {
        this.nodoPadre = nodoPadre;
    }

    public ArrayList<Nodo> getNodosHijos() {
        return nodosHijos;
    }

    public void setNodosHijos(ArrayList<Nodo> nodosHijos) {
        this.nodosHijos = nodosHijos;
    }
    
    public void agregarNodoHijo(Nodo nodoHijo){
        nodosHijos.add(nodoHijo);
    }
    
    public Nodo obtenerNodoHijo(int index){
        return nodosHijos.get(index);
    }
    
    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public boolean isMax() {
        return isMax;
    }

    public void setIsMax(boolean isMax) {
        this.isMax = isMax;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }

    public int getBeta() {
        return beta;
    }

    public void setBeta(int beta) {
        this.beta = beta;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
}
