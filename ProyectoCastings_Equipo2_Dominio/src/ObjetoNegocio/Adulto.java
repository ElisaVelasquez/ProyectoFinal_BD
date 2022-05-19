/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjetoNegocio;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author acedo
 */
public class Adulto extends Candidato {

    private String RFC;

    public Adulto() {
        super();
    }

    public Adulto(String RFC, ObjectId id, String nombre, int telefonoContacto, Date fechaNacimiento, String curp, Representante representante) {
        super(id, nombre, telefonoContacto, fechaNacimiento, curp, representante);
        this.RFC = RFC;
    }

    
    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

}
