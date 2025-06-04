package br.pucpr.projeto.sistema;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class TelaCadastro {

    private TextField criarTextField() {
        TextField campo = new TextField();
        campo.setPrefWidth(250);
        campo.setPrefHeight(30);
        campo.setMaxWidth(250);
        campo.setAlignment(Pos.CENTER);
        return campo;
    }

    private PasswordField criarPasswordField() {
        PasswordField campo = new PasswordField();
        campo.setPrefWidth(250);
        campo.setPrefHeight(30);
        campo.setMaxWidth(250);
        campo.setAlignment(Pos.CENTER);
        return campo;
    }

    public void selecao() {
        Stage stage = new Stage();
        stage.setTitle("Seleção de Cadastro");

        Label tipo = new Label("Selecione como quer cadastrar");
        tipo.setFont(new Font("Arial", 24));
        tipo.setAlignment(Pos.CENTER);

        Button cliente = new Button("Cliente");
        cliente.setOnAction(e -> cadastroCliente());

        Button loja = new Button("Loja");
        loja.setOnAction(e -> cadastroLoja());

        Button voltar = new Button("Voltar");
        voltar.setOnAction(e -> stage.close());

        VBox layout = new VBox(10, tipo, cliente, loja, voltar);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 1000, 1000);
        stage.setScene(scene);
        stage.show();
    }

    public void cadastroCliente() {
        Stage stage = new Stage();
        stage.setTitle("Cadastro Cliente");

        Label clienteLBL = new Label("Cadastro Cliente");
        clienteLBL.setFont(new Font("Arial", 24));

        TextField nome = criarTextField();
        TextField sobrenome = criarTextField();
        TextField email = criarTextField();
        TextField telefone = criarTextField();
        TextField cpf = criarTextField();
        TextField endereco = criarTextField();
        TextField numero = criarTextField();
        TextField login = criarTextField();
        PasswordField senha = criarPasswordField();
        PasswordField repSenha = criarPasswordField();

        Button cadastrar = new Button("Cadastrar");
        cadastrar.setOnAction(e -> {
            if (!senha.getText().equals(repSenha.getText())) {
                System.out.println("As senhas não coincidem!");
                return;
            }

            Cliente novoCliente = new Cliente(
                    RepositorioUsuarios.clientes.size() + 1,
                    nome.getText(),
                    sobrenome.getText(),
                    email.getText(),
                    login.getText(),
                    senha.getText(),
                    telefone.getText(),
                    endereco.getText(),
                    numero.getText(),
                    cpf.getText()
            );

            RepositorioUsuarios.clientes.add(novoCliente);
            PersistenciaUtils.salvarClientesDat();

            System.out.println("Cadastro feito com sucesso!");
            stage.close();
        });

        Button voltar = new Button("Voltar");
        voltar.setOnAction(e -> stage.close());

        VBox layout = new VBox(10,
                clienteLBL,
                new Label("Digite seu Nome"), nome,
                new Label("Digite seu Sobrenome"), sobrenome,
                new Label("Digite seu Email"), email,
                new Label("Digite seu Número de Telefone"), telefone,
                new Label("Digite o Número do seu CPF"), cpf,
                new Label("Digite seu Endereço"), endereco,
                new Label("Digite seu Número Residencial"), numero,
                new Label("Digite seu Login de Usuário"), login,
                new Label("Digite sua Senha"), senha,
                new Label("Confirme sua Senha"), repSenha,
                cadastrar, voltar
        );
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 1000, 1000);
        stage.setScene(scene);
        stage.show();
    }

    public void cadastroLoja() {
        Stage stage = new Stage();
        stage.setTitle("Cadastro Loja");

        Label cadCliente = new Label("Cadastro Loja");
        cadCliente.setFont(new Font("Arial", 24));

        TextField loja = criarTextField();
        TextField nome = criarTextField();
        TextField sobrenome = criarTextField();
        TextField email = criarTextField();
        TextField telefone = criarTextField();
        TextField endereco = criarTextField();
        TextField numero = criarTextField();
        TextField cnpj = criarTextField();
        TextField login = criarTextField();
        PasswordField senha = criarPasswordField();
        PasswordField repSenha = criarPasswordField();

        Button cadastrar = new Button("Cadastrar");
        cadastrar.setOnAction(e -> {
            if (!senha.getText().equals(repSenha.getText())) {
                System.out.println("As senhas não coincidem!");
                return;
            }

            Loja novaLoja = new Loja(
                    RepositorioUsuarios.lojas.size() + 1,
                    nome.getText(),
                    sobrenome.getText(),
                    email.getText(),
                    login.getText(),
                    senha.getText(),
                    telefone.getText(),
                    endereco.getText(),
                    numero.getText(),
                    loja.getText(),
                    cnpj.getText()
            );

            RepositorioUsuarios.lojas.add(novaLoja);
            PersistenciaUtils.salvarLojasDat();

            System.out.println("Loja cadastrada com sucesso!");
            stage.close();
        });

        Button voltar = new Button("Voltar");
        voltar.setOnAction(e -> stage.close());

        VBox layout = new VBox(10,
                cadCliente,
                new Label("Digite o Nome da Loja"), loja,
                new Label("Digite seu Nome"), nome,
                new Label("Digite seu Sobrenome"), sobrenome,
                new Label("Digite seu Email"), email,
                new Label("Digite seu Número de Telefone"), telefone,
                new Label("Digite o Endereço da Loja"), endereco,
                new Label("Digite o Número do Endereço"), numero,
                new Label("Digite o CNPJ da Loja"), cnpj,
                new Label("Digite seu Login de Usuário"), login,
                new Label("Digite sua Senha"), senha,
                new Label("Confirme sua Senha"), repSenha,
                cadastrar, voltar
        );
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 1000, 1000);
        stage.setScene(scene);
        stage.show();
    }
}
