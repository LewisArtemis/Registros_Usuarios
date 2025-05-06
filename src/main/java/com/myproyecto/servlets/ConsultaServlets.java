/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproyecto.servlets;

import com.miproyecto.modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author SENA
 */
@WebServlet(name = "ConsultaServlet" , urlPatterns = {"/consulta"})
public class ConsultaServlets extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //sesion http
        HttpSession session = request.getSession();
        
        //recuperacion de la lista de usuarios
        List<Usuario> listaUsuarios = (List<Usuario>)
                session.getAttribute("listaUsuarios");
        
        if(listaUsuarios == null) {
            listaUsuarios = new ArrayList<>();
            session.setAttribute("listaUsuarios", listaUsuarios);
        }
        
        //parametro de busqueda
        String emailBusqueda = request.getParameter("email");
        
        // si hay parametro, buscar el usuario
        if(emailBusqueda != null && !emailBusqueda.isEmpty()) {
            Usuario usuarioEncontrado = null;
            
            //busqueda de usuario por email
            for (Usuario usuario : listaUsuarios) {
                if(usuario.getEmail().equals(emailBusqueda)) {
                    usuarioEncontrado = usuario;
                    break;
                }
            }
            
            //resultado de la busqueda como atributo
            request.setAttribute("usuarioBuscado", usuarioEncontrado);
            request.setAttribute("busquedaRealizada", true);
        }
        
        //redirigir a la pagina de consulta
        request.getRequestDispatcher("/consulta.jsp").forward(request, response);
    }
}
