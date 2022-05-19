/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetoNegocio;

/**
 *
 * @author Jarol
 */
public enum RangoEdad {

    De0_15("0-15"), De15_18("15-18"), De18A25("18-25"), De25A35("25-35"), De35A45("35-45"), 
    De45A60("45-60"), Mayor_A60(">60");

    private final String display;

    private RangoEdad(String s) {
        display = s;
    }

    @Override
    public String toString() {
        return display;
    }
}
