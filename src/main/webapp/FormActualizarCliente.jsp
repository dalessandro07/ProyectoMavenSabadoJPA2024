<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.TblCliente" %>
<html lang="es">
<head>
<meta charset="UTF-8" />
<title>Actualizar Cliente</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<%
    // Obtener el cliente de la solicitud
    TblCliente cliente = (TblCliente) request.getAttribute("cliente");
    if (cliente == null) {
        response.sendRedirect("ControladorCliente");
        return;
    }
%>
  <main class="flex flex-col p-10 gap-10 justify-center min-h-dvh max-w-screen-md mx-auto">
    <h1 class="text-5xl font-bold">Actualizar Cliente</h1>
    
    <form class="flex flex-col gap-4" action="ControladorCliente" method="POST">
      <input type="hidden" name="id" value="<%= cliente.getIdcliente() %>" />

      <label class="flex flex-col gap-2" for="nombres">
        <span>Nombres:</span>
        <input required placeholder="Alessandro" class="border border-black p-2 rounded" name="nombres" value="<%= cliente.getNombre() %>" />
      </label>
      
      <label class="flex flex-col gap-2" for="apellidos">
        <span>Apellidos:</span>
        <input required placeholder="Rios" class="border border-black p-2 rounded" name="apellidos" value="<%= cliente.getApellido() %>" />
      </label>
      
      <label class="flex flex-col gap-2" for="email">
        <span>Email:</span>
        <input required placeholder="example@gmail.com" type="email" class="border border-black p-2 rounded" name="email" value="<%= cliente.getEmail() %>" />
      </label>
      
      <div class="grid grid-cols-2 gap-2">        
        <label class="flex flex-col gap-2" for="dni">
          <span>DNI:</span>
          <input required placeholder="74859632" type="number" class="border border-black p-2 rounded" name="dni" value="<%= cliente.getDni() %>" />
        </label>
        
        <label class="flex flex-col gap-2" for="telefono">
          <span>Teléfono:</span>
          <input required placeholder="987654321" type="number" class="border border-black p-2 rounded" name="telefono" value="<%= cliente.getTelefono() %>" />
        </label>
      </div>
      
      <div class="grid grid-cols-2 gap-2"> 
        <label class="flex flex-col gap-2" for="sexo">
          <span>Sexo:</span>
          <select required class="border border-black p-2 rounded" name="sexo">
            <option disabled>Selecciona el sexo</option>
            <option value="M" <%= "M".equals(cliente.getSexo()) ? "selected" : "" %>>Masculino</option>
            <option value="F" <%= "F".equals(cliente.getSexo()) ? "selected" : "" %>>Femenino</option>
          </select>
        </label>
        
        <label class="flex flex-col gap-2" for="nacionalidad">
          <span>Nacionalidad:</span>
          <input required placeholder="Peruano" class="border border-black p-2 rounded" name="nacionalidad" value="<%= cliente.getNacionalidad() %>" />
        </label>
      </div>
      
      <div class="flex gap-10 items-center">
        <button name="action" value="edit" class="bg-blue-600 text-white w-max px-6 hover:bg-blue-800 transition-all duration-300 py-3 rounded" type="submit">Actualizar</button>
      
        <a href="listadoClientes.jsp" class="text-blue-600 underline">Listado</a>
      </div>
    </form>
  </main>
</body>
</html>
