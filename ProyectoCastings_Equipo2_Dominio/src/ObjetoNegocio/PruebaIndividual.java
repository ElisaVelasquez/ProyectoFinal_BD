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
public class PruebaIndividual {
    
    private ObjectId id;
    private int numero;
    private Date fecha;
    private String salaCelebracion;
    private String descripcion;
    private boolean resultado;
    private ObjectId candidatoId;

    public PruebaIndividual(ObjectId id, int numero, Date fecha, String salaCelebracion, String descripcion, boolean resultado, ObjectId candidato) {
        this.id = id;
        this.numero = numero;
        this.fecha = fecha;
        this.salaCelebracion = salaCelebracion;
        this.descripcion = descripcion;
        this.resultado = resultado;
        this.candidatoId = candidato;
    }
    
    public PruebaIndividual()
    {}

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getSalaCelebracion() {
        return salaCelebracion;
    }

    public void setSalaCelebracion(String salaCelebracion) {
        this.salaCelebracion = salaCelebracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isResultado() {
        return resultado;
    }

    public void setResultado(boolean resultado) {
        this.resultado = resultado;
    }

    public ObjectId getCandidato() {
        return candidatoId;
    }

    public void setCandidato(ObjectId candidato) {
        this.candidatoId = candidato;
    }
    
}
