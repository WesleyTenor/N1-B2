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
import br.ftt.dao.FornecedorDAO;
import br.ftt.model.FornecedorVO;


@WebServlet("/Fornecedor_Api")
public class Fornecedor_Api extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fornecedor_Api() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: Fornecedor ").append(request.getContextPath());
		
		FornecedorDAO fornecedorDAO = new FornecedorDAO(); 
		FornecedorVO fornecedorVO = new FornecedorVO();
		
		try {
			fornecedorVO = fornecedorDAO.consulta(request.getParameter("cnpj"));
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		Gson fornecedorGson = new GsonBuilder().create(); 
		response.getWriter().append(fornecedorGson.toJson(fornecedorVO, FornecedorVO.class));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FornecedorVO fornecedor = new FornecedorVO();		
		try {
			fornecedor.setCnpj(request.getParameter("cnpj"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fornecedor.setRazaoSocial(request.getParameter("razaoSocial"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fornecedor.setEndereco(request.getParameter("endereco"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fornecedor.setBairro(request.getParameter("bairro"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		
		try {
			fornecedorDAO.insere(fornecedor);
		} catch (Exception erro) {
			erro.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FornecedorVO fornecedor = new FornecedorVO(
				request.getParameter("cnpj"),
				request.getParameter("razaoSocial"),
				request.getParameter("endereco"),
				request.getParameter("bairro"),
				request.getParameter("cidade"));
		
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		
		try {
			fornecedorDAO.alterar(fornecedor);
		}
		catch (Exception erro){
			throw new ArithmeticException("Atualizado Fornecedor: " + erro.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FornecedorDAO fornecedorDAO = new FornecedorDAO(); // objeto retorno do DAO
		fornecedorDAO.excluir(request.getParameter("cnpj")); // VO recebendo DAO
	}

}
