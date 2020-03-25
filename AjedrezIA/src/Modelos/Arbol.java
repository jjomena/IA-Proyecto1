package Modelos;

/**
 *
 * @author Joaquin
 */
public class Arbol {
    
    protected Nodo raiz = null;
    
    public Arbol()
    {
        raiz = new Nodo();          
    }
    public Arbol(Tablero tablero)
    {
        this.raiz = new Nodo(tablero);
    }
    public Nodo getRaiz()
    {
        return this.raiz;
    }
    
    public void setRaiz(Tablero tablero)
    {
        this.raiz = new Nodo(tablero);
    }
    
}
