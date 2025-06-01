package br.pucpr.projeto.sistema;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class TelaCadastro{

    public void selecao() {
        Stage stage = new Stage();
        stage.setTitle("Seleção de Cadastro");


        //labels
        Label tipo = new Label("Selecione como quer cadastrar");
        tipo.setFont(new Font("Arial", 24));
        tipo.setAlignment(Pos.CENTER);


        //botões
        Button cliente = new Button("Cliente");

        cliente.setOnAction(e ->{
            cadastroCliente();
        });

        Button loja = new Button("Loja");

        loja.setOnAction(e ->{
            cadastroLoja();
        });

        Button voltar = new Button("Voltar");

        voltar.setOnAction(e ->{
            stage.close();
        });


        //layout
        VBox layout = new VBox(10, tipo, cliente, loja, voltar);//caixa com as informações
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 1000, 1000);//cena visual, com a caixa com as informações
        stage.setScene(scene);
        stage.show();
    }



    public void cadastroCliente() {
        Stage stage = new Stage();
        stage.setTitle("Cadastro Cliente");


        //labels
        Label clienteLBL = new Label("Cadastro Cliente");
        clienteLBL.setFont(new Font("Arial", 24));
        clienteLBL.setAlignment(Pos.CENTER);

        Label nomeLBL = new Label("Digite seu Nome");
        nomeLBL.setFont(new Font("Arial", 12));
        nomeLBL.setAlignment(Pos.CENTER);
        Label sobrenomeLBL = new Label("Digite seu Sobrenome");
        sobrenomeLBL.setFont(new Font("Arial", 12));
        sobrenomeLBL.setAlignment(Pos.CENTER);
        Label emailLBL = new Label("Digite seu Email");
        emailLBL.setFont(new Font("Arial", 12));
        emailLBL.setAlignment(Pos.CENTER);
        Label telefoneLBL = new Label("Digite seu Número de Telefone");
        telefoneLBL.setFont(new Font("Arial", 12));
        telefoneLBL.setAlignment(Pos.CENTER);
        Label cpfLBL = new Label("Digite o Número do seu CPF");
        cpfLBL.setFont(new Font("Arial", 12));
        cpfLBL.setAlignment(Pos.CENTER);
        Label enderecoLBL = new Label("Digite seu Endereco");
        enderecoLBL.setFont(new Font("Arial", 12));
        enderecoLBL.setAlignment(Pos.CENTER);
        Label numeroLBL = new Label("Digite seu Número Residencial");
        numeroLBL.setFont(new Font("Arial", 12));
        numeroLBL.setAlignment(Pos.CENTER);
        Label loginLBL = new Label("Digite seu Login de Usuário");
        loginLBL.setFont(new Font("Arial", 12));
        loginLBL.setAlignment(Pos.CENTER);
        Label senhaLBL = new Label("Digite sua Senha");
        senhaLBL.setFont(new Font("Arial", 12));
        senhaLBL.setAlignment(Pos.CENTER);
        Label repSenhaLBL = new Label("Confirme sua Senha");
        repSenhaLBL.setFont(new Font("Arial", 12));
        repSenhaLBL.setAlignment(Pos.CENTER);

        //textFields
        TextField nome = new TextField();
        nome.setPrefWidth(250);
        nome.setPrefHeight(30);
        nome.setMaxWidth(250);
        nome.setAlignment(Pos.CENTER);
        TextField sobrenome = new TextField();
        sobrenome.setPrefWidth(250);
        sobrenome.setPrefHeight(30);
        sobrenome.setMaxWidth(250);
        sobrenome.setAlignment(Pos.CENTER);
        TextField email = new TextField();
        email.setPrefWidth(250);
        email.setPrefHeight(30);
        email.setMaxWidth(250);
        email.setAlignment(Pos.CENTER);
        TextField telefone = new TextField();
        telefone.setPrefWidth(250);
        telefone.setPrefHeight(30);
        telefone.setMaxWidth(250);
        telefone.setAlignment(Pos.CENTER);
        TextField cpf = new TextField();
        cpf.setPrefWidth(250);
        cpf.setPrefHeight(30);
        cpf.setMaxWidth(250);
        cpf.setAlignment(Pos.CENTER);
        TextField endereco = new TextField();
        endereco.setPrefWidth(250);
        endereco.setPrefHeight(30);
        endereco.setMaxWidth(250);
        endereco.setAlignment(Pos.CENTER);
        TextField numero = new TextField();
        numero.setPrefWidth(250);
        numero.setPrefHeight(30);
        numero.setMaxWidth(250);
        numero.setAlignment(Pos.CENTER);
        TextField login = new TextField();
        login.setPrefWidth(250);
        login.setPrefHeight(30);
        login.setMaxWidth(250);
        login.setAlignment(Pos.CENTER);
        TextField senha = new TextField();
        senha.setPrefWidth(250);
        senha.setPrefHeight(30);
        senha.setMaxWidth(250);
        senha.setAlignment(Pos.CENTER);
        TextField repSenha = new TextField();
        repSenha.setPrefWidth(250);
        repSenha.setPrefHeight(30);
        repSenha.setMaxWidth(250);
        repSenha.setAlignment(Pos.CENTER);

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

            // Salva no CSV
            String linhaCSV = String.join(";",
                    novoCliente.getNome(),
                    novoCliente.getSobrenome(),
                    novoCliente.getEmail(),
                    novoCliente.getLogin(),
                    novoCliente.getSenha(),
                    novoCliente.getTelefone(),
                    novoCliente.getEndereco(),
                    novoCliente.getNumero(),
                    novoCliente.getCpf()
            );

            CSVUtils.escreverLinha("clientes.csv", linhaCSV);

            System.out.println("Cadastro feito com sucesso!");
            stage.close();
        });


        Button voltar = new Button("Voltar");

        voltar.setOnAction(e ->{
            stage.close();
        });

        //layout
        VBox layout = new VBox(10, clienteLBL, nomeLBL, nome, sobrenomeLBL, sobrenome, emailLBL, email, telefoneLBL, telefone, cpfLBL, cpf, enderecoLBL, endereco, numeroLBL, numero, loginLBL, login, senhaLBL, senha, repSenhaLBL, repSenha, cadastrar, voltar);//caixa com as informações
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 1000, 1000);//cena visual, com a caixa com as informações
        stage.setScene(scene);
        stage.show();

    }

    public void cadastroLoja() {
        Stage stage = new Stage();
        stage.setTitle("Cadastro Loja");

        Label cadCliente = new Label("Cadastro Loja");
        cadCliente.setFont(new Font("Arial", 24));
        cadCliente.setAlignment(Pos.CENTER);

        Label lojaLBL = new Label("Digite o Nome da Loja");
        lojaLBL.setFont(new Font("Arial", 12));
        lojaLBL.setAlignment(Pos.CENTER);
        Label nomeLBL = new Label("Digite seu Nome");
        nomeLBL.setFont(new Font("Arial", 12));
        nomeLBL.setAlignment(Pos.CENTER);
        Label sobrenomeLBL = new Label("Digite seu Sobrenome");
        sobrenomeLBL.setFont(new Font("Arial", 12));
        sobrenomeLBL.setAlignment(Pos.CENTER);
        Label emailLBL = new Label("Digite seu Email");
        emailLBL.setFont(new Font("Arial", 12));
        emailLBL.setAlignment(Pos.CENTER);
        Label telefoneLBL = new Label("Digite seu Número de Telefone");
        telefoneLBL.setFont(new Font("Arial", 12));
        telefoneLBL.setAlignment(Pos.CENTER);
        Label enderecoLBL = new Label("Digite o Endereco da Loja");
        enderecoLBL.setFont(new Font("Arial", 12));
        enderecoLBL.setAlignment(Pos.CENTER);
        Label numeroLBL = new Label("Digite o Número do Endereço");
        numeroLBL.setFont(new Font("Arial", 12));
        numeroLBL.setAlignment(Pos.CENTER);
        Label cnpjLBL = new Label("Digite o CNPJ da Loja");
        cnpjLBL.setFont(new Font("Arial", 12));
        cnpjLBL.setAlignment(Pos.CENTER);
        Label loginLBL = new Label("Digite seu Login de Usuário");
        loginLBL.setFont(new Font("Arial", 12));
        loginLBL.setAlignment(Pos.CENTER);
        Label senhaLBL = new Label("Digite sua Senha");
        senhaLBL.setFont(new Font("Arial", 12));
        senhaLBL.setAlignment(Pos.CENTER);
        Label repSenhaLBL = new Label("Confirme sua Senha");
        repSenhaLBL.setFont(new Font("Arial", 12));
        repSenhaLBL.setAlignment(Pos.CENTER);

        TextField loja = new TextField();
        loja.setPrefWidth(250);
        loja.setPrefHeight(30);
        loja.setMaxWidth(250);
        loja.setAlignment(Pos.CENTER);
        TextField nome = new TextField();
        nome.setPrefWidth(250);
        nome.setPrefHeight(30);
        nome.setMaxWidth(250);
        nome.setAlignment(Pos.CENTER);
        TextField sobrenome = new TextField();
        sobrenome.setPrefWidth(250);
        sobrenome.setPrefHeight(30);
        sobrenome.setMaxWidth(250);
        sobrenome.setAlignment(Pos.CENTER);
        TextField email = new TextField();
        email.setPrefWidth(250);
        email.setPrefHeight(30);
        email.setMaxWidth(250);
        email.setAlignment(Pos.CENTER);
        TextField telefone = new TextField();
        telefone.setPrefWidth(250);
        telefone.setPrefHeight(30);
        telefone.setMaxWidth(250);
        telefone.setAlignment(Pos.CENTER);
        TextField endereco = new TextField();
        endereco.setPrefWidth(250);
        endereco.setPrefHeight(30);
        endereco.setMaxWidth(250);
        endereco.setAlignment(Pos.CENTER);
        TextField numero = new TextField();
        numero.setPrefWidth(250);
        numero.setPrefHeight(30);
        numero.setMaxWidth(250);
        numero.setAlignment(Pos.CENTER);
        TextField cnpj = new TextField();
        cnpj.setPrefWidth(250);
        cnpj.setPrefHeight(30);
        cnpj.setMaxWidth(250);
        cnpj.setAlignment(Pos.CENTER);
        TextField login = new TextField();
        login.setPrefWidth(250);
        login.setPrefHeight(30);
        login.setMaxWidth(250);
        login.setAlignment(Pos.CENTER);
        TextField senha = new TextField();
        senha.setPrefWidth(250);
        senha.setPrefHeight(30);
        senha.setMaxWidth(250);
        senha.setAlignment(Pos.CENTER);
        TextField repSenha = new TextField();
        repSenha.setPrefWidth(250);
        repSenha.setPrefHeight(30);
        repSenha.setMaxWidth(250);
        repSenha.setAlignment(Pos.CENTER);


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

            //salva no CSV
            String linhaCSV = String.join(";",
                    novaLoja.getNome(),
                    novaLoja.getSobrenome(),
                    novaLoja.getEmail(),
                    novaLoja.getLogin(),
                    novaLoja.getSenha(),
                    novaLoja.getTelefone(),
                    novaLoja.getEndereco(),
                    novaLoja.getNumero(),
                    novaLoja.getLoja(),
                    novaLoja.getCnpj()
            );

            CSVUtils.escreverLinha("lojas.csv", linhaCSV);

            System.out.println("Loja cadastrada com sucesso!");
            stage.close();
        });

        Button voltar = new Button("Voltar");

        voltar.setOnAction(e ->{
            stage.close();
        });

        VBox layout = new VBox(10, lojaLBL, loja, nomeLBL, nome, sobrenomeLBL, sobrenome, emailLBL, email, telefoneLBL, telefone, enderecoLBL, endereco, numeroLBL, numero, cnpjLBL, cnpj, loginLBL, login, senhaLBL, senha, repSenhaLBL, repSenha, cadastrar, voltar);//caixa com as informações
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 1000, 1000);//cena visual, com a caixa com as informações
        stage.setScene(scene);
        stage.show();

    }
}
