/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjetoNegocio;

import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author acedo
 */
public class Cliente {

    private ObjectId id;

    private String nombre;
    private String direccion;
    private String telefono;
    private String personaContacto;
    private String tipoActividad;
    private List<Casting> castings;

    public Cliente() {
    }

    public Cliente(ObjectId id,
            String nombre,
            String direccion,
            String telefono,
            String personaContacto,
            String tipoActividad,
            List<Casting> castings) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.personaContacto = personaContacto;
        this.tipoActividad = tipoActividad;
        this.castings = castings;
    }

    public Cliente(String nombre) {
        this.nombre = nombre;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPersonaContacto() {
        return personaContacto;
    }

    public void setPersonaContacto(String personaContacto) {
        this.personaContacto = personaContacto;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public List<Casting> getCastings() {
        return castings;
    }

    public void setCastings(List<Casting> castings) {
        this.castings = castings;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public void validarDatos(Cliente cliente) {

        if (cliente.getNombre().trim().length() == 0 || cliente.getDireccion().trim().length() == 0 || String.valueOf(cliente.getTelefono()).trim().length() == 0
                || cliente.getPersonaContacto().trim().length() == 0) {
            throw new RuntimeException("Datos incompletos");
        } else if (cliente.getTipoActividad() == null) {
            throw new RuntimeException("No ha elegido tipo de actividad");
        }

    }
}
