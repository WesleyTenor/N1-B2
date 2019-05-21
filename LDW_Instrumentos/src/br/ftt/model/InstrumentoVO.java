package br.ftt.model;


public class InstrumentoVO {

    int id;
    String descricao;
    String especificacao;
    int qtde;

    public InstrumentoVO() {

    }
    

    public InstrumentoVO(int id, String descricao, String especificacao, int qtde) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.especificacao = especificacao;
		this.qtde = qtde;
	}


	

    public void setId(String id) throws Exception {

        try {
            if (VerificadoresRegEx.getMatcherVerificadorIDs(id).matches()) {
                this.id = Integer.parseInt(id);
            } else {
                throw new Exception("O ID do instrumento informado não válido !");
            }
        } catch (Exception ex) {
        	throw new Exception("ERRO no id!"); 
           
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao)throws Exception {
        try {
            if (VerificadoresRegEx.getVerificadorDescricaoComponente(descricao).matches()) {
                this.descricao = descricao;
            } else {
                throw new Exception("A descrição do instrumento não e válido.");
            }
        } catch (Exception ex) {
        	throw new Exception("A descrição do instrumento não está correto, favor verificar esse campo.");
        

        }
    }


	public String getEspecificacao() {
		return especificacao;
	}


	public void setEspecificacao(String especificacao) {
		this.especificacao = especificacao;
	}


	public int getQtde() {
		return qtde;
	}


	public void setQtde(int qtde) {
		this.qtde = qtde;
	}


	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}




    
   
}

