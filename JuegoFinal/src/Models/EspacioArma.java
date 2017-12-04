/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Random;

/**
 *
 * @author Drugdu
 */
public class EspacioArma extends Espacio implements IOcupable, IEspacioUsable{

    private Arma arma=null;
   
    public EspacioArma()
    {
        Random r= new Random();
        int t= r.nextInt(10);
        arma = ArmaFactory.CreateArma(t);
    }
    public EspacioArma(Arma arma)
    {
        this.arma=arma;
    }
    
    @Override
    public char getChar() {
        if(isOcupado())
        {
            return this.jugador.getChar();
        }
        else if(arma!=null)
            return '*';
        else 
            return 'o';
    }

    @Override
    public boolean isOcupado() {
        return jugador!=null;
    }

    @Override
    public void Ocupar(Jugador j) {
       this.jugador=j;
    }

    @Override
    public void Desocupar() {
       this.jugador=null;
    }

    @Override
    public boolean isUsable() {
        return arma!=null;
    }

    @Override
    public void Usar() {
        this.jugador.EquiparArma(arma);
        this.arma=null;
    }
    
}
