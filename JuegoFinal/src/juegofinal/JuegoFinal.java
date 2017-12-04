/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegofinal;

import Models.ArmaFactory;
import Models.Danna;
import Models.Jugador;
import Models.JugadorInutil;
import Models.JugadorPrueba;
import Models.Karinna;
import Models.Mapa;
import Models.Muneca;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 *
 * @author Drugdu
 */
public class JuegoFinal {

    static Mapa m;
    static Jugador j1;
    static Jugador j2;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader br = new InputStreamReader(System.in);
        Random R= new Random();
        j1= new Karinna();
        j1.EquiparArma(ArmaFactory.CreateArma(2));
        j1.setChar('1');
        j2= new JugadorInutil();
        j2.EquiparArma(ArmaFactory.CreateArma(R.nextInt(10)));
        j2.setChar('2');
        CrearMapa();
        while(j2.isVivo()&&j1.isVivo())
        {
            j1.ImprimirJugador();
            j2.ImprimirJugador();
            m.ImprimirMapa();

            System.out.println("");
            j1.Jugar(m,j2);
            System.out.println("");
            j2.Jugar(m,j1);
            System.out.println("");
            //br.read(); esto obliga a que exista un enter entre turnos

        }
        
    }

    private static void CrearMapa() {
        m= new Mapa(); 
        m.ubicarJugador(18,15,j1);
        m.ubicarJugador(2,4,j2);
    }
    
}
