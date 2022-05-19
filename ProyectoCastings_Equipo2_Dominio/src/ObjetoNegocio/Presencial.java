///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package ObjetoNegocio;
//
//import java.util.Date;
//import java.util.List;
//import org.bson.types.ObjectId;
//
///**
// *
// * @author acedo
// */
//public class Presencial extends Casting {
//
//    private int numPersonas;
//    private Agente agente;
//    private List<Fase> fase;
//    private List <PruebaIndividual> pruebaIndividual;
//
//    public Presencial() {
//        super();
//    }
//
//   
//
//    public Presencial(int numPersonas, Agente agente, List<Fase> fase, List<PruebaIndividual> pruebaIndividual, ObjectId id, String nombre, String descripcion, Date fecha_contratacion, Float coste, String tipo, List<Perfil> perfiles, List<Candidato> candidatos,ObjectId clienteid) {
//        super(id, nombre, descripcion, fecha_contratacion, coste, tipo, perfiles, candidatos,clienteid);
//        this.numPersonas = numPersonas;
//        this.agente = agente;
//        this.fase = fase;
//        this.pruebaIndividual = pruebaIndividual;
//    }
//
//   
//
//    public Agente getAgente() {
//        return agente;
//    }
//
//    public void setAgente(Agente agente) {
//        this.agente = agente;
//    }
//
//    public int getNumPersonas() {
//        return numPersonas;
//    }
//
//    public void setNumPersonas(int numPersonas) {
//        this.numPersonas = numPersonas;
//    }
//
//    public List<Fase> getFase() {
//        return fase;
//    }
//
//    public void setFase(List<Fase> fase) {
//        this.fase = fase;
//    }
//
//    public List<PruebaIndividual> getPruebaIndividual() {
//        return pruebaIndividual;
//    }
//
//    public void setPruebaIndividual(List<PruebaIndividual> pruebaIndividual) {
//        this.pruebaIndividual = pruebaIndividual;
//    }
//    
//     public void validarDatos(Presencial casting,Cliente cliente)
//    {
//      
//          if(cliente ==null)
//        {
//            throw new RuntimeException("Seleccione un cliente");
//        }else if(casting.getAgente()== null)
//        {
//             throw new RuntimeException("Seleccione un agente");
//        }else if(casting.getCoste().toString().trim().length()==0||casting.getNombre().trim().length()==0||casting.getDescripcion().trim().length()==0)
//        {
//            throw new RuntimeException("Datos incompletos");
//        }else if(casting.getCoste().toString().matches("[+-]?\\d*(\\.\\d+)?")==false)
//        {
//              throw new RuntimeException("Coste no numerico");
//        } 
//          
//          
//    }
//
//    
//   
//
//}
