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
public class EspacioCura extends Espacio implements IOcupable, IEspacioUsable {
    int valorCura=100;
    
    public EspacioCura()
    {
        Random r = new Random();
        int t=r.nextInt(100);
        valorCura=t;
    }
    @Override
    public char getChar() {
        if(isOcupado())
        {
        return this.jugador.getChar();
        }
       else if(valorCura>0)
        {
            return '+';
        }
        return 'o';
    }

    @Override
    public boolean isOcupado() {
       return this.jugador!=null;
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
      return valorCura>0;
    }

    @Override
    public void Usar() {
      jugador.Curar(valorCura);
      valorCura-=valorCura*.20;
    }
    
}
