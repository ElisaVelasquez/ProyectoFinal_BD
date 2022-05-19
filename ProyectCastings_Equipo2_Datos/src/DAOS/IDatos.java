/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOS;

import ObjetoNegocio.*;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author acedo
 */
public interface IDatos {

    public Cliente buscarClienteNombre(String nombre);

    public void guardarCliente(Cliente cliente);

    public List<Cliente> consultarTodosClientes();

    public List<Agente> consultarTodosAgentes();

    public Fase buscarFaseFecha(Date fecha);

    public Casting buscarCastingNombre(String nombre);

    public Perfil buscarPerfilCasting();

    public void guardarPerfil(Perfil perfil);

    public Cliente buscarCliente(Cliente cliente);

    public Agente buscarAgenteNombre(String nombre);

    public void guardarAgente(Agente agente);

//    public void guardarCasting(Online casting);
    public void ActualizarCliene(Object Casting, Cliente cliente);

    public Cliente buscarClienteporId(ObjectId id);

    public Cliente consultarPorCastingNombre(String nombreCasting);

    public List<Casting> consultarTodosCastings();

    public List<Perfil> consultarTodosPerfiles();

    public Casting consultarCastingId(ObjectId id);

    public List<Perfil> consultarCastingPorIdCasting(ObjectId id);

    public void actualizarCliente(Cliente cliente);

    public List<Casting> consultarCastingCliente(ObjectId id);

    public List<Casting> consultarTodosCasting(String nombre, ObjectId codigo, Date fecha);

    public void guardarPerfilconIdDeCasting(Perfil perfil, ObjectId id);

    public boolean existenClientes();

}
