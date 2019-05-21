package br.ftt.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBD {
    public static Connection getConexao() {
	Connection conn = null;        
        try {            //hostname:127.0.0.1 | Port:3306
	        	String local = "jdbc:mysql://localhost/dbloja";
	        	String user = "";
	        	String pass = "";
	        	conn = DriverManager.getConnection(local,user,pass);
        	
	        } catch (Exception erro) {
	            erro.printStackTrace();
	        }
        return conn;
    }   
}
