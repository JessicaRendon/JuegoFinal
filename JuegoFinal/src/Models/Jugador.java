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
public abstract class Jugador {

    protected Arma armaEquipada;
    protected char numeroJugador='0';
    protected int vida=100;
    
    public char getChar()
    {
        return numeroJugador;
    }
    public void setChar(char c)
    {
        this.numeroJugador=c; 
    }
    public abstract void EquiparArma(Arma arma);
    public abstract void Curar(int valorCura) ;

    public boolean isVivo() {
        return vida>=0;
    }

    public void ImprimirJugador()
    {
        for(int i=0;i<=49;i++)
        {
            System.out.print('*');
        }
        System.out.println("");
        System.out.print('*');
        System.out.print("Jugador [" +this.getChar()+"]");
        System.out.print('*');
        System.out.print('*');
        System.out.print("Vida: " + vida);
        System.out.print('*');
        System.out.print("");
        System.out.print('*');
        System.out.print("Daño: " + armaEquipada.Fuerza);
        System.out.print('*');
        System.out.println("");
        for(int i=0;i<=49;i++)
        {
            System.out.print('*');
        }
        System.out.println("");
    }

    abstract public void Jugar(Mapa m,Jugador oponente) ;

    void Lastimar(int Fuerza) {
        this.vida-=Fuerza;
    }
    
    
    
}
