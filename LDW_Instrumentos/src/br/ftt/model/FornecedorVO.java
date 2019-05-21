package br.ftt.model;

//import javafx.scene.control.Alert;

public class FornecedorVO {

    private String cnpj;
    private String razaoSocial;
    private String endereco;
    private String bairro;
    private String cidade;
  
    public FornecedorVO() {

    }

    public FornecedorVO(String cnpj, String razaoSocial, String endereco, String bairro, String cidade) 
    {
        super();
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
      
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) throws Exception {

        try {
            if (VerificadoresRegEx.getMatcherVerificadorCNPJ(cnpj).matches()) {//Estou verificando o valor atribuído no construtor para saber se o mesmo é válido
                this.cnpj = cnpj;
            } else {
                throw new Exception("O CNPJ do fornecedor não e válido.");
            }
        } catch (Exception ex)  {
        	throw new Exception("ERRO de cadastro!");
          
        }
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) throws Exception {

        try {
            if (VerificadoresRegEx.getMatcherVerificadorRasaoSocial(razaoSocial).matches()) {
                this.razaoSocial = razaoSocial;
            } else {
                throw new Exception("A razão social do fornecedor não e válido.");
            }
        } catch (Exception ex) {
        	throw new Exception("ERRO de cadastro!");
        
        }
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) throws Exception {

        try {
            if (VerificadoresRegEx.getMatcherVerificadorEndereco(endereco).matches()) {
                this.endereco = endereco;
            } else {
                throw new Exception("O endereço do fornecedor não e válido.");
            }
        } catch (Exception ex) {
    	throw new Exception("ERRO no Endereço!");
     
        }
    }

   
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro)throws Exception {

        try {
            if (VerificadoresRegEx.getMatcherVerificadorBairro(bairro).matches()) {
                this.bairro = bairro;
            } else {
                throw new Exception("O Bairro do fornecedor não e válido.");
            }
        } catch (Exception ex) {
        	throw new Exception("Erro no  Bairro");
       
        }
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade)throws Exception {

        try {
            if (VerificadoresRegEx.getMatcherVerificadorCidade(cidade).matches()) {
                this.cidade = cidade;

            } else {
                throw new Exception("A cidade do fornecedor não e válido.");
            }
        } catch (Exception ex) {
        	throw new Exception("Erro no Campo Cidade");
            
        }
    }

}

