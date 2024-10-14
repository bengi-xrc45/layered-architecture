/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sistematransporte.presentacion;

import sistematransporte.servicio.Servicio;
import sistematransporte.persistencia.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author user
 */
public class Control extends HttpServlet {

    private Servicio ser = new Servicio();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Control</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Control at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        //List<Cliente> allClientes = ser.obtenerClientes();
        //request.setAttribute("listaClientes", allClientes);
        //request.getRequestDispatcher("/FormCliente.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String type = request.getParameter("formulario-cliente");
        if (type.equals("registrar")) {
            String nombre = request.getParameter("nombre").toLowerCase();
            String correo = request.getParameter("correo").toLowerCase();
            String telefono = request.getParameter("telefono");
            Cliente cliente = new Cliente(nombre, correo, telefono);
            String mensaje = ser.registrarCliente(cliente);
            request.setAttribute("mensaje", mensaje);
            request.getRequestDispatcher("FormCliente.jsp").forward(request, response);
        } else if (type.equals("listar")) {
            /*String con = "";
            for (Cliente cliente: allClientes){
                con += " "+ cliente.toString();
            }
            request.setAttribute("listaClientes", allClientes);
            request.setAttribute("mensaje", con);*/
            List<Cliente> allClientes = ser.obtenerClientes();
            request.setAttribute("listaClientes", allClientes);
            request.getRequestDispatcher("ListarClientes.jsp").forward(request, response);

        } else if (type.equals("consultar")) {
            String telefono = request.getParameter("telefono");
            Cliente cliente = ser.buscarCliente(telefono);
            request.setAttribute("cliente", cliente);
            request.getRequestDispatcher("ConsultarCliente.jsp").forward(request, response);
        } else if (type.equals("modificar")) {
            String nombre = request.getParameter("nombre").toLowerCase();
            String correo = request.getParameter("correo").toLowerCase();
            String telefono = request.getParameter("telefono");
            String mensaje = ser.modificarCliente(telefono, nombre, correo);
            request.setAttribute("mensaje", mensaje);
            request.getRequestDispatcher("ModificarCliente.jsp").forward(request, response);
            request.getRequestDispatcher("ModificarCliente.jsp").forward(request, response);
        } else if (type.equals("eliminar")) {
            String telefono = request.getParameter("telefono");
            String mensaje = ser.eliminarCliente(telefono);
            request.setAttribute("mensaje", mensaje);
            request.getRequestDispatcher("EliminarCliente.jsp").forward(request, response);

        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
