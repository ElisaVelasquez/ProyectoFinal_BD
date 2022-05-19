package DAOS;

import ObjetoNegocio.Cliente;
import ObjetoNegocio.Perfil;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public class BaseDAO {

    protected CodecRegistry pojoCodecRegistry;
    protected MongoClient conexion;
    protected MongoDatabase basedatos;
    protected MongoCollection<Cliente> coleccionClientes;
    protected MongoCollection<Perfil> coleccionPerfil;

    public  BaseDAO() {
        this.pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        this.conexion = new MongoClient("localhost", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
        this.basedatos = conexion.getDatabase("database");
        
    }
 
   
}
