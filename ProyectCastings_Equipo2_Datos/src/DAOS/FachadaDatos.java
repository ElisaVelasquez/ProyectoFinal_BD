/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import DAOS.*;

import ObjetoNegocio.Agente;
import ObjetoNegocio.Casting;
import ObjetoNegocio.Cliente;
import ObjetoNegocio.Fase;
import ObjetoNegocio.Perfil;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author ElisaVelasquez
 */
public class FachadaDatos implements IDatos {

    ClienteDAO clienteDao = new ClienteDAO();
    AgenteDAO agenteDAO = new AgenteDAO();

    public void FachadaDatos() {
    }

    @Override
    public Cliente buscarClienteNombre(String nombre) {
        Cliente clientes = clienteDao.consultarPorNombre(nombre);

        return clientes;
    }

    @Override
    public void guardarCliente(Cliente cliente) {

        clienteDao.guardar(cliente);

    }

    @Override
    public List<Cliente> consultarTodosClientes() {
        try {
            return clienteDao.consultarTodos();

        } catch (RuntimeException e) {

            throw new RuntimeException("Error al consultar los clientes");
        }
    }

    @Override
    public List<Agente> consultarTodosAgentes() {
        return agenteDAO.consultarTodos();
    }

    @Override
    public Fase buscarFaseFecha(Date fecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Perfil buscarPerfilCasting() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void guardarPerfil(Perfil perfil) {

    }

    @Override
    public Cliente buscarCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Agente buscarAgenteNombre(String nombre) {
        return agenteDAO.buscarAgenteNombre(nombre);
    }

    @Override
    public void guardarAgente(Agente agente) {
        agenteDAO.guardar(agente);
    }

    @Override
    public void ActualizarCliene(Object Casting, Cliente cliente) {

        //validar que tipo es
        Casting castin = (Casting) Casting;
        //verificar cliente dueno
        if (clienteDao.consultarPorCastingNombre(castin.getNombre()) == null) {
            if (castin.getTipo().equals("Presencial")) {
                Casting presencial = (Casting) Casting;
                cliente.getCastings().add(presencial);

            } else {
                Casting online = (Casting) Casting;
                cliente.getCastings().add(online);
            }

            clienteDao.actualizar(cliente, cliente.getId());
        } else {
        }

    }

    @Override
    public Cliente buscarClienteporId(ObjectId id) {

        return clienteDao.consultarPorId(id);

    }

    @Override
    public Casting buscarCastingNombre(String nombre) {
        return null;
    }

    @Override
    public List<Casting> consultarTodosCastings() {

        List<Casting> castings = new ArrayList<>();

        List<Cliente> clientes = clienteDao.consultarTodos();
        for (Cliente cliente : clientes) {
            for (Casting casting : cliente.getCastings()) {
                Casting cas = (Casting) casting;
                castings.add(casting);
            }
        }
        return castings;
    }

    @Override
    public List<Perfil> consultarTodosPerfiles() {

        return null;

    }

    @Override
    public Casting consultarCastingId(ObjectId id) {
        for (Cliente cliente : clienteDao.consultarTodos()) {
            for (Casting casting : cliente.getCastings()) {
                if (casting.getId().equals(id)) {
                    return casting;
                }
            }
        }

        return null;
    }

    @Override
    public List<Perfil> consultarCastingPorIdCasting(ObjectId id) {
        Casting casting = this.consultarCastingId(id);
        return casting.getPerfiles();
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        clienteDao.actualizar(cliente, cliente.getId());
    }

    @Override
    public List<Casting> consultarCastingCliente(ObjectId id) {

        return clienteDao.consultarPorId(id).getCastings();
    }

    @Override
    public List<Casting> consultarTodosCasting(String nombre, ObjectId codigo, Date fecha) {

        List<Casting> castings = this.consultarTodosCastings();
        List<Casting> casAux = new ArrayList<>();
        for (Casting casting : castings) {
            if (codigo != null) {
                casAux = this.consultarCastingCliente(codigo);
            }
            if (casting.getNombre().equalsIgnoreCase(nombre)
                    || casting.getId().equals(codigo)) {
                casAux.add(casting);
            }
            if (fecha != null) {
                if (checarSiCastingEstaEntreFechaSeleccionadaYHoy(fecha, casting.getFecha_contratacion())) {
                    casAux.add(casting);
                }
            }
        }

        return casAux;

    }

    private boolean checarSiCastingEstaEntreFechaSeleccionadaYHoy(Date Desde, Date FechaCasting) {
        LocalDateTime diaAComparar = convertToLocalDateTimeViaMilisecond(Desde);
        LocalDateTime Casting = convertToLocalDateTimeViaMilisecond(FechaCasting);
        LocalDateTime hoy = LocalDateTime.now();

        if (Casting.isAfter(diaAComparar) && Casting.isBefore(hoy)) {
            return true;
        } else {
            return false;
        }
    }

    public LocalDateTime convertToLocalDateTimeViaMilisecond(Date dateToConvert) {
        return Instant.ofEpochMilli(dateToConvert.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    @Override
    public void guardarPerfilconIdDeCasting(Perfil perfil, ObjectId idCasting) {
        Casting casting = this.consultarCastingId(idCasting);
        casting.getPerfiles().add(perfil);
        Cliente cliente = buscarClienteporId(casting.getClienteId());
        List<Casting> castings = cliente.getCastings();
        for (Casting cas : castings) {
            if (cas.getId().equals(casting.getId())) {
                int i = castings.indexOf(cas);
                castings.set(i, casting);
            }

        }
        this.actualizarCliente(cliente);
    }

    @Override
    public Cliente consultarPorCastingNombre(String nombreCasting) {

        return clienteDao.consultarPorCastingNombre(nombreCasting);
    }

    @Override
    public boolean existenClientes() {
        boolean confirmmacion= false;
       confirmmacion = (clienteDao.consultarTodos().size() >= 1);
       return confirmmacion;
    }

}
