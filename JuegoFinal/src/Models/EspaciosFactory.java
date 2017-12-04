/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Drugdu
 */
public class EspaciosFactory {

    static Espacio createEspacio(int nextInt) {
        switch(nextInt)
        {
            case 1:
                return new EspacioArma();
            case 2:
                return new EspacioCura();
            case 3:
                return new EspacioEscudo();
            default:
                return new EspacioVacio();
            
        }
    }
    
}
