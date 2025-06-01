package br.pucpr.projeto.sistema;

public class Cliente extends Usuario{
    private String cpf;

    public Cliente(int id, String nome, String sobrenome, String email, String login, String senha, String telefone, String endereco, String numero, String cpf) {
        super(id, nome, sobrenome, email, login, senha, telefone, endereco, numero);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
