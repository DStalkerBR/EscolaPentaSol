package model.bean;

public class Instrumento {

    private short id;
    private String nome;
    private String descricao;
    private int qtdInstrumentos;

    //Construtor
    public Instrumento() {

    }

    public Instrumento(String nome, String descricao, int qtdInstrumentos) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.qtdInstrumentos = qtdInstrumentos;
    }

    public short getId() {
        return this.id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtdInstrumentos() {
        return qtdInstrumentos;
    }

    public void setQtdInstrumentos(int qtdInstrumentos) {
        this.qtdInstrumentos = qtdInstrumentos;
    }   
    
    @Override
    public String toString(){
        return "Id: '" + String.valueOf(this.id ) + "', Nome: '" + this.nome + "', Descrição: '" + this.descricao +  
                "', Quantidade: '" + String.valueOf(this.qtdInstrumentos) + "'";
    }   
}
