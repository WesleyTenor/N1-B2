
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

import br.ftt.dao.ClienteDAO;
import br.ftt.model.ClienteVO;

@WebServlet("/Cliente_Api")
public class Cliente_Api extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cliente_Api() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: GET CLIENTE ").append(request.getContextPath());
		
		ClienteDAO clienteDAO = new ClienteDAO(); 
		ClienteVO clienteVO = new ClienteVO();
		
		try {
			clienteVO = clienteDAO.consulta(request.getParameter("cpf"));
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		Gson clienteGson = new GsonBuilder().create(); 
		response.getWriter().append(clienteGson.toJson(clienteVO, ClienteVO.class));
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClienteVO cliente = new ClienteVO();		
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setNome(request.getParameter("nome"));
		cliente.setEndereco(request.getParameter("endereco"));
		cliente.setBairro(request.getParameter("bairro"));
						
		ClienteDAO clienteDAO = new ClienteDAO();
		
		try {
			clienteDAO.insere(cliente);
		} catch (Exception erro) {
			erro.printStackTrace();
		}
	
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClienteVO cliente = new ClienteVO(
				request.getParameter("nome"),
				request.getParameter("endereco"),
				request.getParameter("bairro"),
				request.getParameter("cidade"));
		
		ClienteDAO clienteDAO = new ClienteDAO();
		
		try {
			clienteDAO.alterar(cliente);
		}
		catch (Exception erro){
			throw new ArithmeticException("Update Aluno: " + erro.getMessage());
		}
		
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClienteDAO clienteDAO = new ClienteDAO(); 
		clienteDAO.excluir(request.getParameter("cpf")); 
	}

}
