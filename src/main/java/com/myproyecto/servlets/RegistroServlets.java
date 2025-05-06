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
@WebServlet(name = "RegistroServlet", urlPatterns = {"/registro"})
public class RegistroServlets extends HttpServlet{
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // reenvio  a la pagina de registros
        request.getRequestDispatcher("/registro.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // datos del formulario
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        // objeto usuario con los datos del formulario
        Usuario nuevoUsuario = new Usuario(nombre, apellido, email, password);
        
        // sesion
        HttpSession session = request.getSession();
        
        // recuperacion de la lista de usuarios
        List<Usuario> listaUsuarios = (List<Usuario>)
                session.getAttribute("listaUsuarios");
        
        if(listaUsuarios == null) {
            listaUsuarios = new ArrayList<>();
            session.setAttribute("listaUsuarios", listaUsuarios);
        }
        
        //agregamos el nuevo usuario a la lista
        listaUsuarios.add(nuevoUsuario);
        
        //mensaje de exito
        request.setAttribute("mensaje", "¡Usuario registrado con exito!");
        
        // redirigir a la pagina de registro
        request.getRequestDispatcher("/registro.jsp").forward(request, response);
        
    }
}
