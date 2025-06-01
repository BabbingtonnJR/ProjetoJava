package br.pucpr.projeto.sistema;

import java.util.ArrayList;

public class Loja extends Usuario{
    private String loja;
    private String cnpj;

    public Loja(int id, String nome, String sobrenome, String email, String login, String senha, String telefone, String endereco, String numero, String loja, String cnpj) {
        super(id, nome, sobrenome, email, login, senha, telefone, endereco, numero);
        this.loja = loja;
        this.cnpj = cnpj;
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
