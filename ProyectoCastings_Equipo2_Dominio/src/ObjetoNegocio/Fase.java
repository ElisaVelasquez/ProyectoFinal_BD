/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjetoNegocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author acedo
 */
public class Fase {

    private ObjectId id;
    private int numero;
    private Date fechaInicio;
    private PruebaIndividual pruebaIndividual;
    
    public Fase() {
    }

    public Fase(ObjectId id, int numero, Date fechaInicio, PruebaIndividual pruebaIndividual) {
        this.id = id;
        this.numero = numero;
        this.fechaInicio = fechaInicio;
        this.pruebaIndividual = pruebaIndividual;
    }

    public Fase(Date fechaInicio, PruebaIndividual pruebaIndividual) {
        this.fechaInicio = fechaInicio;
        this.pruebaIndividual = pruebaIndividual;
    }

    public Fase(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

   

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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public PruebaIndividual getPruebaIndividual() {
        return pruebaIndividual;
    }

    public void setPruebaIndividual(PruebaIndividual pruebaIndividual) {
        this.pruebaIndividual = pruebaIndividual;
    }

    public void verificaDatos(Date fecha) throws ParseException
    {
         LocalDate fechaActual = LocalDate.now();

          SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        Date f= date.parse( fechaActual.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
       
         if(fecha!=f)
         {
             
         if(fecha.before(f)){
             
     throw new RuntimeException("Fecha pasada");
         }
   }
    
    }
    
    public void verificaDatos(List<Fase>fases)
    {
        if(fases.size()<2)
        {
            throw new RuntimeException("Agregue mas de 2 fases");
        }
    }
    
    @Override
    public String toString() {
        return  "numero=" + numero + ", fechaInicio=" + fechaInicio + ", pruebaIndividual=" + pruebaIndividual + '}';
    }
    
    
    
}
