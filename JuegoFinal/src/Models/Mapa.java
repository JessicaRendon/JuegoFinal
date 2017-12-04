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
public class Mapa {
    Espacio[][] map= new Espacio[50][50];
    Random r= new Random();
    public Mapa()
    {
        for(int i=0;i<map.length;i++)
        {
            for(int j=0;j<map[0].length;j++)
            {
                if(i==0||j==0||i==map.length-1||j==map[0].length-1)
                {
                    map[i][j]= new EspacioBorde();
                }
                else
                {
                    map[i][j]= EspaciosFactory.createEspacio(r.nextInt(5));
                }
            }
        }
    }

    public void ImprimirMapa()
    {
        for(int i=0;i<map.length;i++)
        {
            for(int j=0;j<map[0].length;j++)
            {
                System.out.print(map[i][j].getChar());
            }
            System.out.println("");
        }
    }

    public void ubicarJugador(int i, int j, Jugador jug) {
        map[i][j]= new EspacioVacio();
        ((EspacioVacio)map[i][j]).Ocupar(jug);
    }

    int[] obtenerCoordenadas(Jugador jugador) {
        for(int i=0;i<map.length;i++)
        {
            for(int j=0;j<map[0].length;j++)
            {
               if(map[i][j]instanceof IOcupable)
               {
                   if(map[i][j].jugador==jugador)
                   {
                       int[] retu=new int[2];
                       retu[0]=i;
                       retu[1]=j;
                       return retu;
                   }
               }
            }
        }
        return null;
    }
    Espacio obtenerCasilla(int i,int j)
    {
        return map[i][j];
    }
}

