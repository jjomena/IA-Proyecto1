/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;
import  Modelos.NoPieza;
import Modelos.Casilla;
/**
 *
 * @author actuaria
 */
public class Tablero{
    private Casilla [][] casillas;
    
    public Tablero(){
        casillas = new Casilla[8][8];
        for (int i=0; i<8; i++){
            for(int j=0;j<8;j++){
                casillas[i][j] = new Casilla();
            }
        }
        for (Casilla[] escaques : casillas) {
            for (Casilla escaque : escaques) {
                escaque.setPieza( new NoPieza());
            }
        }
    }

    public Casilla[][] getCasillas() {
        return casillas;
    }

    public void setCasillas(Casilla[][] casillas) {
        this.casillas = casillas;
    }
//    
//    @Override
//    public Object clone() throws CloneNotSupportedException{
//        Object obj=null;
//        try{
//            obj=super.clone();
//        }catch(CloneNotSupportedException ex){
//            System.out.println(" no se puede duplicar");
//        }
//        return obj;
//    }
//    
    
}
