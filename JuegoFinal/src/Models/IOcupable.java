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
public interface IOcupable {
    
    
    public boolean isOcupado();
    public void Ocupar(Jugador j);
    public void Desocupar();
    
    
}
