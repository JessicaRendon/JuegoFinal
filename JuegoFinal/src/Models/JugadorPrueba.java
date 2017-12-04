/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Drugdu
 */
public class JugadorPrueba extends Jugador{

    @Override
    public void EquiparArma(Arma arma) {
        super.armaEquipada=arma;
    }

    @Override
    public void Curar(int valorCura) {
       if(super.vida+valorCura>=100)
           super.vida=100;
       else
           super.vida+=valorCura;
    }

    @Override
    public void Jugar(Mapa m,Jugador oponente) {
        int j1[],j2[];
        j1=m.obtenerCoordenadas(this);
        j2=m.obtenerCoordenadas(oponente);
        //vamos a mover al jugador mas cerca al otro jugador
        ((IOcupable)m.obtenerCasilla(j1[0],j1[1])).Desocupar();
        System.out.println();
        if(j1[0]<j2[0])
        {
            j1[0]++;
        }
        if(j1[1]!=j2[1]-armaEquipada.Rango)
        {
            System.out.print("jugador se mueve a "+j1[0]+"--"+j1[1]+"");
            j1[1]++;
        }
        else
        {
            this.atacar(oponente);
            System.out.print("Se ha hecho un ataque");
        }
          //vamos a mover al jugador mas cerca al otro jugador
        ((IOcupable)m.obtenerCasilla(j1[0],j1[1])).Ocupar(this);
    }

    private void atacar(Jugador oponente){
        oponente.Lastimar(this.armaEquipada.Fuerza);
    }
    
}
