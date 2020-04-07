package Modelos;

public class Casilla {
    
    private char color;
    public Pieza pieza;
    
    public Casilla(){
        pieza = new NoPieza();
    }
    public char isColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public Pieza getPieza() {
        return pieza;
    }

    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    } 
}
