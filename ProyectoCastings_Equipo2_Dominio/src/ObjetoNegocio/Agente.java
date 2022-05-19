/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetoNegocio;

import org.bson.types.ObjectId;

/**
 *
 * @author Jarol
 */
public class Agente {
   private String RFC,CURP,nombre,direccion;
    private ObjectId id;

     

    public Agente(String RFC, String CURP, String nombre, String direccion) {
        this.RFC = RFC;
        this.CURP = CURP;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Agente( String RFC, String CURP, String nombre, String direccion,ObjectId id) {
        this.id = id;
        this.RFC = RFC;
        this.CURP = CURP;
        this.nombre = nombre;
        this.direccion = direccion;
    }
    
    
     
     public Agente()
     {}

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return  nombre ;
    }


    
      public void validarDatos(Agente agente)
    {
      
        if(agente.getNombre().trim().length()==0||agente.getDireccion().trim().length()==0||agente.getCURP().trim().length()==0||
                agente.getRFC().trim().length()==0)
        {
           throw new RuntimeException("Datos incompletos");
        }
    }
   
    
    
}
