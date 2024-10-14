/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistematransporte.persistencia;

//import jakarta.jms.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import sistematransporte.accesodatos.Bd;

/**
 *
 * @author user
 */
public class Repositorio {

    static final String DB_URL = "jdbc:postgresql://localhost:5432/sitravi";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "1193585023Bn*";

    public Repositorio() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void guardarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (nombre, correo, telefono) VALUES (?, ?, ?)";
        try {
            Bd conbd = new Bd(DB_URL, DB_USER, DB_PASSWORD);
            Connection conn = conbd.getconn();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getCorreo());
            stmt.setString(3, cliente.getTelefono());

            int filasInsertadas = stmt.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("Insertado con exito");
            }
        } catch (SQLException e) {
            System.out.println("error al guardar cliente");
        }

    }

    public List<Cliente> buscarTodosClientes() {
        List<Cliente> lista = new LinkedList<>();
        String sql = "SELECT * FROM cliente";
        try {
            Bd condb = new Bd(DB_URL, DB_USER, DB_PASSWORD);
            Connection conn = condb.getconn();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String nombre = rs.getString(2);
                String email = rs.getString(3);
                String telefono = rs.getString(4);
                Cliente cli = new Cliente(nombre, email, telefono);
                lista.add(cli);
            }
            System.out.println("número de clientes enc: " + lista.size());
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("" + e.getMessage());
        }
        return lista;
    }

    public Cliente buscarClienteTel(String telefono) {
        Cliente cliente = null;
        String sql = "SELECT * FROM cliente WHERE telefono = ?";
        try {
            Bd condb = new Bd(DB_URL, DB_USER, DB_PASSWORD);
            Connection conn = condb.getconn();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, telefono);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cliente = new Cliente(rs.getString("nombre"), rs.getString("correo"), rs.getString("telefono"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    public boolean eliminarClienteTel(String telefono) {
        String sql = "DELETE FROM cliente WHERE telefono = ?";
        try {
            Bd condb = new Bd(DB_URL, DB_USER, DB_PASSWORD);
            Connection conn = condb.getconn();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, telefono);
            int filasEliminadas = stmt.executeUpdate();
            return filasEliminadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean modificarClienteCod(String telefono, String nombre, String correo) {
        String sql = "UPDATE cliente SET nombre = ?, correo = ? WHERE telefono = ?";
        try {
            Bd condb = new Bd(DB_URL, DB_USER, DB_PASSWORD);
            Connection conn = condb.getconn();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombre);
            stmt.setString(2, correo);
            stmt.setString(3, telefono);

            int filasModificadas = stmt.executeUpdate();
            return filasModificadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
