/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjetoNegocio;

import java.awt.Image;
import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author acedo
 */
public class Candidato {

    private ObjectId id;
    private String nombre;
    private int telefonoContacto;
    private Date fechaNacimiento;
    //private Image fotografia;
    private String curp;
    private Representante representante;

    public Candidato() {
    }

    public Candidato(ObjectId id, String nombre, int telefonoContacto, Date fechaNacimiento, String curp, Representante representante) {
        this.id = id;
        this.nombre = nombre;
        this.telefonoContacto = telefonoContacto;
        this.fechaNacimiento = fechaNacimiento;
        //this.fotografia = fotografia;
        this.curp = curp;
        this.representante = representante;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(int telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public Representante getRepresentante() {
        return representante;
    }

    public void setRepresentante(Representante representante) {
        this.representante = representante;
    }

}
