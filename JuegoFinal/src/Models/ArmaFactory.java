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
public class ArmaFactory {
    public static Arma CreateArma(int t) {
        switch(t)
        {
            case 0:
                return new Rifle();
            case 1:
                return new Franco();
            case 2:
                return new Hacha();
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            default:
                return new Pistola();
        }
    }
}
