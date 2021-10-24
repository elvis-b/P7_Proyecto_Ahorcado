package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Servlet con la lógica del juego

@WebServlet("/ahorcadoGame")
public class AhorcadoGame extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 protected void partidaAhorcado(HttpServletRequest request, HttpServletResponse response)
			   throws ServletException, IOException {
		 
		  String strUrl = "game.jsp";
		  RequestDispatcher rd = request.getRequestDispatcher(strUrl);
		  rd.forward(request, response);
		 
	 }

	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	   throws ServletException, IOException {
		 partidaAhorcado(request, response);
	 }

	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	   throws ServletException, IOException {
		 partidaAhorcado(request, response);
	 }

}
