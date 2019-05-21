package br.ftt.dao;

import br.ftt.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class ClienteDAO {
    
       //insere cliente
	
      public void insere(ClienteVO cliente) {
        Connection cx = ConexaoBD.getConexao();
        try {
            if(cx==null){
                throw new Exception("Erro na conexão com o banco!!");
            }
            String sql = "insert into TBL_CLIENTE (CPF, NOME, ENDERECO, BAIRRO, CIDADE) values (?,?,?,?,?)";

            PreparedStatement p = cx.prepareStatement(sql);
            
            p.setString(1, cliente.getCpf());
            p.setString(2, cliente.getNome());
            p.setString(3, cliente.getEndereco());
            p.setString(4, cliente.getBairro());
            p.setString(5, cliente.getCidade());
            p.execute();
            p.close();
            cx.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
   
      
	
      //altera os dados de um cliente
      public void alterar(ClienteVO cliente) throws SQLException {
        Connection cx = ConexaoBD.getConexao();
        
        try {
            String sql = "update tbl_Cliente set nome=?, endereco=?, bairro=?, "
                          + "cidade=?, cep=? where cpf=?";
            
            PreparedStatement p = cx.prepareStatement(sql);
            p.setString(1, cliente.getNome());
            p.setString(2, cliente.getEndereco());
            p.setString(3, cliente.getBairro());
            p.setString(4, cliente.getCidade());
            p.setString(5, cliente.getCpf()); 
            p.execute();
            p.close();
            cx.close();
        } 
        finally {
            cx.close();
        }
    }
    
    public void excluir(String cpf) {
        Connection cx = ConexaoBD.getConexao();
        try{
            String sql = "delete from tbl_Cliente where cpf=?";
            PreparedStatement p = cx.prepareStatement(sql);
            p.setString(1, cpf);
            p.execute();
            p.close();
            cx.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
 
          
    
    //consulta um cliente pelo cpf    
    public ClienteVO consulta(String cpf) throws SQLException {
        Connection cx = ConexaoBD.getConexao();
        
        try{
            String sql ="select * from tbl_Cliente where cpf = ?";
            
            PreparedStatement p = cx.prepareStatement(sql);
            p.setString(1, cpf);
            ResultSet rs = p.executeQuery();
            
            ClienteVO cliente = null;
            if(rs.next()){
                cliente = MontaClienteVO(rs);
            }
                   
            return cliente;    
        }finally{
            cx.close();
        }
    }
    
    //monta os dados do objeto cliente
    private static ClienteVO MontaClienteVO(ResultSet rs) throws SQLException {
        ClienteVO cl = new ClienteVO();
        cl.setCpf(rs.getString("cpf"));
        cl.setNome(rs.getString("nome"));
        cl.setEndereco(rs.getString("endereco"));
        cl.setBairro(rs.getString("bairro"));
        cl.setCidade(rs.getString("cidade"));
        return cl;
    }

}
