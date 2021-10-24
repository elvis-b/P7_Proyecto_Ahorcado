package com.controller;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Servlet con la lógica del sistema de inicio de sesión

@WebServlet("/login")
public class Login extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	
	private static final long serialVersionUID = 1L;

	public Login() {
	  super();
	 }

	 protected void autenticacionLDAP(HttpServletRequest request, HttpServletResponse response)
	   throws ServletException, IOException {

	  final String SUCCESS = "success.jsp";
	  final String FAILURE = "failure.jsp";
	  String strUrl = "login.jsp";
	  String username = request.getParameter("username");
	  String password = request.getParameter("password");

	  Hashtable<String, String> env = new Hashtable();

	  boolean autenticado = false;

	  env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
	  env.put(Context.PROVIDER_URL, "ldap://localhost:10389");
	  env.put(Context.SECURITY_AUTHENTICATION, "simple");
	  env.put(Context.SECURITY_PRINCIPAL, "uid=" + username + ", ou=people, dc=javap7, dc=com");
	  env.put(Context.SECURITY_CREDENTIALS, password);

	  try {
	   // Creando contexto
	   DirContext ctx = new InitialDirContext(env);

	   // Cerrando contexto cuando finaliza
	   autenticado = true;
	   ctx.close();

	  } catch (NamingException e) {
	   autenticado = false;
	  } finally {
		  
		  
	   if (autenticado) {
		  System.out.println("Se ha identificado correctamente "+username);
	    
	    strUrl = SUCCESS;
	   } else {
		   System.out.println("Se ha intentado identificar "+username);
	       strUrl = FAILURE;
	   }
	  }
	  
	  RequestDispatcher rd = request.getRequestDispatcher(strUrl);
	  rd.forward(request, response);

	 }

	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	   throws ServletException, IOException {
	  autenticacionLDAP(request, response);
	 }

	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	   throws ServletException, IOException {
		 autenticacionLDAP(request, response);
	 }
	}