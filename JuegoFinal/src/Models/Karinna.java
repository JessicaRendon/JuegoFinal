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
 * @author Acer
 */
public class Karinna extends Jugador{
    
    

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
        int a,b=1,c=1;
        b=j1[0];
        c=j1[1];
        //vamos a mover al jugador mas cerca al otro jugador   
        if(this.EnRango(j1, j2)){
            this.atacar(oponente);
            System.out.println(" Karinna ataco!!! XD ");
        }else{
                               if(j1[0]<j2[0]){
                    a=0;
                   if( j1[0]==j2[0] ||  j1[0]<49){
                        j1[0]++;
                        a++;
                    }
                }if(j1[1]<j2[1]){
                    a=0;
                   if( j1[1]==j2[1] ||  j1[1]<50){
                        j1[1]++;
                        a++;
                    }
                } if(j1[0]>j2[0]){
                    a=0;
                    if( j1[1]==j2[1] || j1[0]>0 ){
                        j1[0]--;
                        a++;
                    }
                } if(j1[1]>j2[1]){
                    a=0;
                    if(j1[1]==j2[1] || j1[1]>0){
                        j1[1]--;
                    }
                }
            if(!((IOcupable)m.obtenerCasilla(j1[0], j1[1])).isOcupado()){
                ((IOcupable)m.obtenerCasilla(j1[0], j1[1])).Ocupar(this);
                ((IOcupable)m.obtenerCasilla(b,c)).Desocupar();
                 System.out.print("Karinna se movio de "+b+"--"+c+" a "+j1[0]+"--"+j1[1]);
                if(m.obtenerCasilla(j1[0], j1[1]) instanceof  IEspacioUsable){
                  if(m.obtenerCasilla(j1[0], j1[1]) instanceof EspacioCura)  {
                    if(this.vida<=50){
                        this.Curar(((EspacioCura)m.obtenerCasilla(j1[0], j1[1])).valorCura);
                    }
                  }
                }    
            }
        }
           
    }
    private boolean EnRango(int j1[], int j2[]){
        boolean q=false;
        if( j2[1]>=j1[1]-this.armaEquipada.Rango && j2[1]<=j1[1]+this.armaEquipada.Rango){
            q= true;
        }if(j2[0]>=j1[0]-this.armaEquipada.Rango && j2[0]<=j1[0]+this.armaEquipada.Rango && q==true){
          return true;
        }
        else{
          return false;
        }
    }
    private void atacar(Jugador oponente){
           oponente.Lastimar(this.armaEquipada.Fuerza);
    }
    
}
