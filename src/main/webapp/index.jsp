<%-- 
    Document   : index
    Created on : 6/05/2025, 8:33:22 a. m.
    Author     : SENA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                font-family: Arial, sans-serif; 
                margin: 0; 
                padding: 20px;
                line-height: 1.6;
            }
            
            h1 {
                color: #333;
            }
            
            .container {
                max-width: 800px; 
                margin: 0 auto;
            }
            
            .menu {
                display: flex; 
                gap: 20px; 
                margin: 20px 0;
            }
            
            .menu a {
                padding: 10px 15px;
                background-color: #4CAF50;
                color: white;
                text-decoration: none;
                border-radius: 4px;
            }
            
            .menu a :hover {
                background-color: #45a049;
            }
        </style>
    </head>
    <body>
        <div class="container">
        <h1>Bienvenido al Sistema de Registros de Usuarios</h1>
        
        <p>Este sistema permite registrar nuevos usuarios y 
            consultar la informacion de usuarios registrados.</p>
        
        <div class="menu">
            <a href="registro.jsp">Registrar Usuario</a>
            <a href="consulta.jsp">Consultar Usuarios</a>
        </div>
        
        <hr>
        
        <h2>Informacion del Sistema</h2>
        
        <p>
            Este sistema es un ejemplo simple que muestra como utilizar:
            
        <ul>
            <li>Servlets para procesar formularios</li>
            <li>JSP para renderizar paginas dinamicas</li>
            <li>Metodos HTTP GET y POST</li>
            <li>Sesiones para almacenar datos</li>
        </ul>
        </p>
        </div>
    </body>
</html>
