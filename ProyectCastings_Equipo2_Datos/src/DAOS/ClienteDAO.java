/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import ObjetoNegocio.Casting;
import ObjetoNegocio.Cliente;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.bson.types.ObjectId;

/**
 * 
 * @author tellez
 */
public class ClienteDAO extends BaseDAO implements CRUD<Cliente> {
private MongoCollection<Cliente> coleccionClientes;
    public ClienteDAO() {
    
        coleccionClientes= super.basedatos.getCollection("cliente",Cliente.class);
       
    }

    @Override
    public void guardar(Cliente cliente) {
        
           
            coleccionClientes.insertOne(cliente);
            
       
    }

    @Override
    public void EliminarPorId(ObjectId id) {
        coleccionClientes.deleteOne(eq("_id", id));
    }

    @Override
    public void actualizar(Cliente entidad, ObjectId id) {

        String EnumEspecialidad = entidad.getTipoActividad().toString();
        String nombre = entidad.getNombre();
        String direccion = entidad.getDireccion();
        String telefono = entidad.getTelefono();
        String personaContacto = entidad.getPersonaContacto();
        List<Casting> castings = entidad.getCastings();

        coleccionClientes.updateOne(
                eq("_id", id),
                combine(set("nombre", nombre),
                        set("direccion", direccion),
                        set("telefono", telefono),
                        set("personaContacto", personaContacto),
                        set("tipoActividad", EnumEspecialidad),
                        set("castings", castings)) // DATOS A ACTUALIZAR  
        );
    }

    @Override
    public Cliente consultarPorId(ObjectId id) {
        Cliente cliente = coleccionClientes.find(eq("_id", id)).first();
        return cliente;
    }

    @Override
    public ArrayList<Cliente> consultarTodos() {
        ArrayList<Cliente> UsuariosEncontradosArrayList = new ArrayList<>();
        coleccionClientes.find().into(UsuariosEncontradosArrayList);
        return UsuariosEncontradosArrayList;
    }
    
      public Cliente consultarPorNombre(String nombre) {
        Cliente cliente = coleccionClientes.find(eq("nombre", nombre)).first();
        return cliente;
    }
      
      public Cliente consultarPorCastingNombre(String nombreCasting)
      {
          //db.cliente.find({"castings.nombre":"verano"})
          Cliente cliente= null;
        cliente=coleccionClientes.find(eq("castings.nombre",nombreCasting)).first();
        return cliente;
        
          
      }

  
    

    

}
