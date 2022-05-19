package DAOS;

import ObjetoNegocio.Agente;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import org.bson.types.ObjectId;

/**
 *
 * @author Jarol, Daniel y Elisa.
 */
public class AgenteDAO extends BaseDAO implements CRUD<Agente> {

    private MongoCollection<Agente> coleccionAgente;

    public AgenteDAO() {
        coleccionAgente = super.basedatos.getCollection("agente", Agente.class);

    }

    @Override
    public void guardar(Agente entidad) {
        coleccionAgente.insertOne(entidad);
    }

    @Override
    public void EliminarPorId(ObjectId id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Agente entidad, ObjectId id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Agente consultarPorId(ObjectId id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Agente> consultarTodos() {

        ArrayList<Agente> UsuariosEncontradosArrayList = new ArrayList<>();

        coleccionAgente.find().into(UsuariosEncontradosArrayList);

        return UsuariosEncontradosArrayList;
    }

    public Agente buscarAgenteNombre(String nombre) {
        return coleccionAgente.find(eq("nombre", nombre)).first();
    }

}
