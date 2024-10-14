/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistematransporte.servicio;

import java.util.List;
import sistematransporte.persistencia.Repositorio;
import sistematransporte.persistencia.Cliente;

/**
 *
 * @author user
 */
public class Servicio {

    private Repositorio repo = new Repositorio();

    public String registrarCliente(Cliente cliente) {
        if (cliente != null) {
            String nombre = cliente.getNombre();
            String correo = cliente.getCorreo();
            String telefono = cliente.getTelefono();
            if (!nombre.matches("[a-zA-Z\\s]+")) {
                return "El nombre no debe contener números.";
            } else {
                if (!telefono.matches("\\d{10}")) {
                    return "El teléfono debe contener solo 10 dígitos numericos .";
                } else {
                    repo.guardarCliente(cliente);
                    return "Cliente registrado con éxito.";
                }
            }
        } else {
            return "Cliente no registrado.";
        }
    }

    public List<Cliente> obtenerClientes() {
        return repo.buscarTodosClientes();
    }

    public Cliente buscarCliente(String telefono) {
        if (telefono != null) {
            return repo.buscarClienteTel(telefono);
        } else {
            throw new IllegalArgumentException("Telefono no encontrado.");
        }

    }

    public String modificarCliente(String telefono, String nombre, String correo) {
        boolean modificado = repo.modificarClienteCod(telefono, nombre, correo);
        if (modificado) {
            return "Cliente modificado con éxito.";
        } else {
            return "No se encontró ningún cliente con ese teléfono.";
        }
    }

    public String eliminarCliente(String telefono) {
        boolean eliminado = repo.eliminarClienteTel(telefono);
        if (eliminado) {
            return "Cliente eliminado con éxito.";
        } else {
            return "No se encontró ningún cliente con ese teléfono.";
        }
    }
}
