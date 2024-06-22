<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.TblCliente" %>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Listado de Clientes</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
  <%
      List<TblCliente> defaultClientes = (List<TblCliente>) request.getAttribute("clientes");
      if (defaultClientes == null || defaultClientes.isEmpty()) {
          response.sendRedirect("ControladorCliente");
          return;
      }
  %>
  <main class="flex flex-col gap-5 p-10 min-h-dvh">
    <a class="underline w-max" href="index.jsp">
      Inicio
    </a>
    
    <h1 class="text-xl font-bold">Listado de clientes registrados en BD</h1>
    
    <a href="FormRegistrarCliente.jsp" class="bg-blue-600 text-white w-max px-4 hover:bg-blue-800 transition-all duration-300 py-2 rounded">Nuevo cliente</a>

    <div class="overflow-x-auto">
      <table class="min-w-full bg-white border border-gray-200">
        <thead>
          <tr class="bg-gray-100 text-gray-600 uppercase text-sm leading-normal">
            <th class="py-3 px-6 text-left">Nombre</th>
            <th class="py-3 px-6 text-left">Apellido</th>
            <th class="py-3 px-6 text-left">Email</th>
            <th class="py-3 px-6 text-left">DNI</th>
            <th class="py-3 px-6 text-left">Teléfono</th>
            <th class="py-3 px-6 text-left">Sexo</th>
            <th class="py-3 px-6 text-left">Nacionalidad</th>
          </tr>
        </thead>
        <tbody class="text-gray-600 text-sm">
          <%
            List<TblCliente> clientes = (List<TblCliente>) request.getAttribute("clientes");
            if (clientes == null || clientes.isEmpty()) {
          %>
          <tr>
            <td colspan="7" class="py-3 px-6 text-center">No hay clientes registrados.</td>
          </tr>
          <%
            } else {
              for (TblCliente cliente : clientes) {
          %>
          <tr class="border-b border-gray-200 hover:bg-gray-200">
            <td class="py-3 px-6 text-left"><%= cliente.getNombre() %></td>
            <td class="py-3 px-6 text-left"><%= cliente.getApellido() %></td>
            <td class="py-3 px-6 text-left"><%= cliente.getEmail() %></td>
            <td class="py-3 px-6 text-left"><%= cliente.getDni() %></td>
            <td class="py-3 px-6 text-left"><%= cliente.getTelefono() %></td>
            <td class="py-3 px-6 text-left"><%= cliente.getSexo() %></td>
            <td class="py-3 px-6 text-left"><%= cliente.getNacionalidad() %></td>
          </tr>
          <%
              }
            }
          %>
        </tbody>
      </table>
    </div>
  </main>
</body>
</html>
