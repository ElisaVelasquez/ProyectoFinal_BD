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
public enum RangoAltura {
    MenorA1_5("< 1.50"), De1_5A1_7("1.50-1.70"), De1_7A1_9("1.70-1.90"), MayorA1_9("> 1.90");
    private final String display;

    private RangoAltura(String s) {
        display = s;
    }

    @Override
    public String toString() {
        return display;
    }

}
