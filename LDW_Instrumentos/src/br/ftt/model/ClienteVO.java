package br.ftt.model;

public class ClienteVO {
	
	String cpf;
	String nome;
	String endereco;
	String Bairro;
	String Cidade;
		
	public ClienteVO() {
		
	}
		
	
	public ClienteVO(String cpf, String nome, String endereco, String bairro, String cidade) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.Bairro = bairro;
	}

	public ClienteVO( String nome, String endereco, String bairro, String cidade) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.Bairro = bairro;
		this.Cidade = cidade;
	}
	
	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getBairro() {
		return Bairro;
	}


	public void setBairro(String bairro) {
		Bairro = bairro;
	}


	public String getCidade() {
		return Cidade;
	}


	public void setCidade(String cidade) {
		Cidade = cidade;
	}
	
		
}
