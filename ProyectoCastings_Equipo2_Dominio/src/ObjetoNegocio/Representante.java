/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjetoNegocio;

import org.bson.types.ObjectId;

/**
 *
 * @author acedo
 */
public class Representante {
    
    private ObjectId id;
    private String RFC;
    private String CURP;
    private String nombre;
    private int telefono;
    private String direccion;

    public Representante() {
    }

    public Representante(ObjectId id, String RFC, String CURP, String nombre, int telefono, String direccion) {
        this.id = id;
        this.RFC = RFC;
        this.CURP = CURP;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
