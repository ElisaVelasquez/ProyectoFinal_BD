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
public class Niño extends Candidato {

    public Niño(String nombreTutor, ObjectId id, String nombre, int telefonoContacto, Date fechaNacimiento, String curp, Representante representante) {
        super(id, nombre, telefonoContacto, fechaNacimiento, curp, representante);
        this.nombreTutor = nombreTutor;
    }

   

    private String nombreTutor;

    public String getNombreTutor() {

        return nombreTutor;
    }

    public void setNombreTutor(String nombreTutor) {
        this.nombreTutor = nombreTutor;
    }

}
