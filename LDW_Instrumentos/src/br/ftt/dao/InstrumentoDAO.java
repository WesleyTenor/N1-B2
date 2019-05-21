package br.ftt.dao;

import br.ftt.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class InstrumentoDAO {

    public void insere(InstrumentoVO ins) throws SQLException {
        Connection conexao = ConexaoBD.getConexao();
        try {
            String sql = "insert into tbl_Instrumento (id_ins, descricao, imagem) values (?,?)";

            PreparedStatement p = conexao.prepareStatement(sql);

            p.setInt(1, ins.getId());
            p.setString(2, ins.getDescricao());
            p.execute();
            p.close();
        } finally {
            conexao.close();
        }
    }

    public void alterar(InstrumentoVO inst) throws SQLException {
        Connection conexao = ConexaoBD.getConexao();
        try {
            String sql = "update tbl_Instrumento set descricao=?, where id=?";
            PreparedStatement p = conexao.prepareStatement(sql);
            p.setString(1, inst.getDescricao());
            p.setInt(2, inst.getId());
            p.close();
        } finally {
            conexao.close();
        }

    }

    public void excluir(String id) throws SQLException {
        Connection conexao = ConexaoBD.getConexao();
        try {
            String sql = "delete tbl_Componente where id=?";
            PreparedStatement p = conexao.prepareStatement(sql);
            p.setString(1, id);
            p.execute();
            p.close();
        } finally {
            conexao.close();
        }

    }


    public InstrumentoVO consulta(String id) throws SQLException {
        Connection cx = ConexaoBD.getConexao();

        try {
            String sql = "select * from TBL_Instrumento where id=?";
            PreparedStatement smt = cx.prepareStatement(sql);
            smt.setString(1, id);
            ResultSet rs = smt.executeQuery();

            InstrumentoVO inst = null;
            if (rs.next()) {
            	try {
					inst = MontaVO(rs);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
            }
            smt.close();
            return inst;
        } finally {
            cx.close();
        }
    }


    private static InstrumentoVO MontaVO(ResultSet rs) throws Exception {
        InstrumentoVO ins = new InstrumentoVO();
        ins.setId(rs.getString("id_comp"));
        ins.setDescricao(rs.getString("descricao"));
       
        return ins;
    }

   

    
}
