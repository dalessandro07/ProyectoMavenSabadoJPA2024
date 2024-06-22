<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.TblCliente" %>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Listado de Clientes</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
  <%
      List<TblCliente> defaultClientes = (List<TblCliente>)request.getAttribute("clientes");
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
    
    <% if (request.getAttribute("clienteEliminado") != null) { %>
      <% TblCliente clienteEliminado = (TblCliente) request.getAttribute("clienteEliminado"); %>
      <div class="bg-green-100 border-l-4 border-green-500 text-green-700 p-4" role="alert">
        <p>El cliente con ID <strong><%= clienteEliminado.getIdcliente() %></strong> y nombre <strong><%= clienteEliminado.getNombre() %></strong> ha sido eliminado exitosamente.</p>
      </div>
  <% } %>
    
    <a href="FormRegistrarCliente.jsp" class="bg-blue-600 text-white w-max px-4 hover:bg-blue-800 transition-all duration-300 py-2 rounded">Nuevo cliente</a>

    <div class="overflow-x-auto">
      <table class="min-w-full bg-white border border-gray-200">
        <thead>
          <tr class="bg-gray-100 text-gray-600 uppercase text-sm leading-normal">
            <th class="py-3 px-6 text-left">ID</th>
            <th class="py-3 px-6 text-left">Nombre</th>
            <th class="py-3 px-6 text-left">Apellido</th>
            <th class="py-3 px-6 text-left">Email</th>
            <th class="py-3 px-6 text-left">DNI</th>
            <th class="py-3 px-6 text-left">Teléfono</th>
            <th class="py-3 px-6 text-left">Sexo</th>
            <th class="py-3 px-6 text-left">Nacionalidad</th>
            <th class="py-3 px-6 text-left">Acciones</th>
          </tr>
        </thead>
        <tbody class="text-gray-600 text-sm">
          <%
            List<TblCliente> clientes = (List<TblCliente>) request.getAttribute("clientes");
            if (clientes == null || clientes.isEmpty()) {
          %>
          <tr>
            <td colspan="9" class="py-3 px-6 text-center">No hay clientes registrados.</td>
          </tr>
          <%
            } else {
              for (TblCliente cliente : clientes) {
          %>
          <tr class="border-b border-gray-200 hover:bg-gray-200">
            <td class="py-3 px-6 text-left"><%= cliente.getIdcliente() %></td>
            <td class="py-3 px-6 text-left"><%= cliente.getNombre() %></td>
            <td class="py-3 px-6 text-left"><%= cliente.getApellido() %></td>
            <td class="py-3 px-6 text-left"><%= cliente.getEmail() %></td>
            <td class="py-3 px-6 text-left"><%= cliente.getDni() %></td>
            <td class="py-3 px-6 text-left"><%= cliente.getTelefono() %></td>
            <td class="py-3 px-6 text-left"><%= cliente.getSexo() %></td>
            <td class="py-3 px-6 text-left"><%= cliente.getNacionalidad() %></td>
            <td class="py-3 px-6 text-left flex gap-2">
              <a
                title="Actualizar cliente"
               href="ControladorCliente?action=edit&id=<%= cliente.getIdcliente() %>" 
               class="bg-green-600 text-white p-3 rounded hover:bg-green-800 transition-all duration-300">
               <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="size-5">
        <path stroke-linecap="round" stroke-linejoin="round" d="m16.862 4.487 1.687-1.688a1.875 1.875 0 1 1 2.652 2.652L10.582 16.07a4.5 4.5 0 0 1-1.897 1.13L6 18l.8-2.685a4.5 4.5 0 0 1 1.13-1.897l8.932-8.931Zm0 0L19.5 7.125M18 14v4.75A2.25 2.25 0 0 1 15.75 21H5.25A2.25 2.25 0 0 1 3 18.75V8.25A2.25 2.25 0 0 1 5.25 6H10" />
      </svg>
      </a>
              
              <form action="ControladorCliente" method="post" onsubmit="return confirm('¿Estás seguro de que quieres eliminar a este cliente?');">
                <input type="hidden" name="id" value="<%= cliente.getIdcliente() %>">
                <button title="Eliminar cliente" type="submit" name="action" value="delete" class="bg-red-600 text-white p-3 rounded hover:bg-red-800 transition-all duration-300"><svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="size-5">
  <path stroke-linecap="round" stroke-linejoin="round" d="m14.74 9-.346 9m-4.788 0L9.26 9m9.968-3.21c.342.052.682.107 1.022.166m-1.022-.165L18.16 19.673a2.25 2.25 0 0 1-2.244 2.077H8.084a2.25 2.25 0 0 1-2.244-2.077L4.772 5.79m14.456 0a48.108 48.108 0 0 0-3.478-.397m-12 .562c.34-.059.68-.114 1.022-.165m0 0a48.11 48.11 0 0 1 3.478-.397m7.5 0v-.916c0-1.18-.91-2.164-2.09-2.201a51.964 51.964 0 0 0-3.32 0c-1.18.037-2.09 1.022-2.09 2.201v.916m7.5 0a48.667 48.667 0 0 0-7.5 0" />
</svg>
</button>
              </form>
            </td>
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
