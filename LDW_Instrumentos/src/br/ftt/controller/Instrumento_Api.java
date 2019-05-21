package br.ftt.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import br.ftt.dao.InstrumentoDAO;
import br.ftt.model.InstrumentoVO;


@WebServlet("/Instrumento_Api")
public class Instrumento_Api extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Instrumento_Api() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: Componentes ").append(request.getContextPath());
		
		InstrumentoDAO instrumentoDAO = new InstrumentoDAO(); 
		InstrumentoVO instrumento = new InstrumentoVO();
		
		try {
			instrumento = instrumentoDAO.consulta(request.getParameter("id"));
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		Gson instrumentoGson = new GsonBuilder().create(); 
		response.getWriter().append(instrumentoGson.toJson(instrumento, InstrumentoVO.class));
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		InstrumentoDAO instrumentoDAO = new InstrumentoDAO(); 
		try {
			instrumentoDAO.excluir(request.getParameter("id"));
		} catch (SQLException erro) {
			erro.printStackTrace();
		} 
	}

}
