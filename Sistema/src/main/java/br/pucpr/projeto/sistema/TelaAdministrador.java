package br.pucpr.projeto.sistema; // ou outro nome

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class TelaAdministrador {

    public void telaInicial() {
        Stage stage = new Stage();
        stage.setTitle("Tela Administrador");

        Button addLoja = new Button("Adicionar Loja");

        addLoja.setOnAction(e -> {
            TelaAdicionarLoja();
            telaInicial();
        });

        Button addCliente = new Button("Adicionar Cliente");

        addCliente.setOnAction(e -> {
            TelaAdicionarCliente();
            telaInicial();
        });

        Button atualizar = new Button("Atualizar");

        atualizar.setOnAction(e -> {
            stage.close();
            telaInicial();
        });

        VBox layout = new VBox(15, addLoja, addCliente, atualizar);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new javafx.geometry.Insets(20));

        Label titulo = new Label("Usuários Cadastrados");
        layout.getChildren().add(titulo);

        // Clientes
        for (Cliente cliente : RepositorioUsuarios.clientes) {
            HBox linha = new HBox(10);
            linha.setAlignment(Pos.CENTER_LEFT);

            Label lbl = new Label("Cliente: " + cliente.getNome() + " " + cliente.getSobrenome() + " | Login: " + cliente.getLogin());

            Button editar = new Button("Editar");
            editar.setOnAction(e -> TelaEdicao(cliente));

            Button excluir = new Button("Excluir");
            excluir.setOnAction(e -> {
                RepositorioUsuarios.clientes.remove(cliente);
                CSVUtils.salvarClienteCSV(); // atualiza o CSV após remover
                stage.close();
                telaInicial(); // recarrega a tela
            });


            linha.getChildren().addAll(lbl, editar, excluir);
            layout.getChildren().add(linha);
        }

        // Lojas
        for (Loja loja : RepositorioUsuarios.lojas) {
            HBox linha = new HBox(10);
            linha.setAlignment(Pos.CENTER_LEFT);

            Label lbl = new Label("Loja: " + loja.getLoja() + " | Responsável: " + loja.getNome() + " " + loja.getSobrenome() + " | Login: " + loja.getLogin());

            Button editar = new Button("Editar");
            editar.setOnAction(e -> TelaEdicao(loja));

            Button excluir = new Button("Excluir");
            excluir.setOnAction(e -> {
                RepositorioUsuarios.lojas.remove(loja);
                CSVUtils.salvarLojaCSV(); // atualiza o CSV após remover
                stage.close();
                telaInicial();
            });


            linha.getChildren().addAll(lbl, editar, excluir);
            layout.getChildren().add(linha);
        }

        Scene scene = new Scene(layout, 1000, 1000);
        stage.setScene(scene);
        stage.show();
    }


    private void TelaEdicao(Object usuario) {
        //tela para edição
        Stage editarStage = new Stage();
        editarStage.setTitle("Editar Usuário");


        Button voltar = new Button("Voltar");

        voltar.setOnAction(e ->{
            editarStage.close();
        });

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);

        if (usuario instanceof Cliente cliente) {

            TextField nome = new TextField();
            TextField sobrenome = new TextField();
            TextField login = new TextField();
            TextField email = new TextField();
            TextField senha = new TextField();
            TextField telefone = new TextField();
            TextField endereco = new TextField();
            TextField numero = new TextField();
            TextField cpf = new TextField();

            nome.setText(cliente.getNome());
            sobrenome.setText(cliente.getSobrenome());
            login.setText(cliente.getLogin());
            email.setText(cliente.getEmail());
            senha.setText(cliente.getSenha());
            telefone.setText(cliente.getTelefone());
            endereco.setText(cliente.getEndereco());
            numero.setText(cliente.getNumero());
            cpf.setText(cliente.getCpf());

            Button salvar = new Button("Salvar");
            salvar.setOnAction(e -> {
                cliente.setNome(nome.getText());
                cliente.setSobrenome(sobrenome.getText());
                cliente.setLogin(login.getText());
                cliente.setEmail(email.getText());
                cliente.setSenha(senha.getText());
                cliente.setTelefone(telefone.getText());
                cliente.setEndereco(endereco.getText());
                cliente.setNumero(numero.getText());
                cliente.setCpf(cpf.getText());

                CSVUtils.salvarClienteCSV(); //atualiza arquivo CSV
                editarStage.close();
                telaInicial();
            });

            layout.getChildren().addAll(
                    new Label("Nome:"), nome,
                    new Label("Sobrenome:"), sobrenome,
                    new Label("Login:"), login,
                    new Label("Email:"), email,
                    new Label("Senha:"), senha,
                    new Label("Telefone:"), telefone,
                    new Label("Endereço:"), endereco,
                    new Label("Número:"), numero,
                    new Label("CPF:"), cpf,
                    salvar,
                    voltar
            );
        }

        if (usuario instanceof Loja loja) {

            TextField nomeLoja = new TextField();
            TextField nome = new TextField();
            TextField sobrenome = new TextField();
            TextField login = new TextField();
            TextField email = new TextField();
            TextField senha = new TextField();
            TextField telefone = new TextField();
            TextField endereco = new TextField();
            TextField numero = new TextField();
            TextField cnpj = new TextField();

            nomeLoja.setText(loja.getLoja());
            nome.setText(loja.getNome());
            sobrenome.setText(loja.getSobrenome());
            login.setText(loja.getLogin());
            email.setText(loja.getEmail());
            senha.setText(loja.getSenha());
            telefone.setText(loja.getTelefone());
            endereco.setText(loja.getEndereco());
            numero.setText(loja.getNumero());
            cnpj.setText(loja.getCnpj());

            Button salvar = new Button("Salvar");
            salvar.setOnAction(e -> {
                loja.setLoja(nomeLoja.getText());
                loja.setNome(nome.getText());
                loja.setSobrenome(sobrenome.getText());
                loja.setLogin(login.getText());
                loja.setEmail(email.getText());
                loja.setSenha(senha.getText());
                loja.setTelefone(telefone.getText());
                loja.setEndereco(endereco.getText());
                loja.setNumero(numero.getText());
                loja.setCnpj(cnpj.getText());

                CSVUtils.salvarLojaCSV(); //atualiza arquivo CSV
                editarStage.close();
                telaInicial();
            });

            layout.getChildren().addAll(
                    new Label("Loja:"), nomeLoja,
                    new Label("Nome:"), nome,
                    new Label("Sobrenome:"), sobrenome,
                    new Label("Login:"), login,
                    new Label("Email:"), email,
                    new Label("Senha:"), senha,
                    new Label("Telefone:"), telefone,
                    new Label("Endereço:"), endereco,
                    new Label("Número:"), numero,
                    new Label("CNPJ:"), cnpj,
                    salvar,
                    voltar
            );
        }


        Scene scene = new Scene(layout, 1000, 1000);
        editarStage.setScene(scene);
        editarStage.show();
    }



    private void TelaAdicionarLoja() {
        Stage addStage = new Stage();
        addStage.setTitle("Cadastro Loja");

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
            addStage.close();
        });

        Button voltar = new Button("Voltar");

        voltar.setOnAction(e ->{
            addStage.close();
        });

        VBox layout = new VBox(10, lojaLBL, loja, nomeLBL, nome, sobrenomeLBL, sobrenome, emailLBL, email, telefoneLBL, telefone, enderecoLBL, endereco, numeroLBL, numero, cnpjLBL, cnpj, loginLBL, login, senhaLBL, senha, repSenhaLBL, repSenha, cadastrar, voltar);//caixa com as informações
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 1000, 1000);//cena visual, com a caixa com as informações
        addStage.setScene(scene);
        addStage.show();

    }


    private void TelaAdicionarCliente() {
        Stage addStage = new Stage();
        addStage.setTitle("Cadastro Cliente");

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
            addStage.close();
        });


        Button voltar = new Button("Voltar");

        voltar.setOnAction(e ->{
            addStage.close();
        });

        //layout
        VBox layout = new VBox(10, clienteLBL, nomeLBL, nome, sobrenomeLBL, sobrenome, emailLBL, email, telefoneLBL, telefone, cpfLBL, cpf, enderecoLBL, endereco, numeroLBL, numero, loginLBL, login, senhaLBL, senha, repSenhaLBL, repSenha, cadastrar, voltar);//caixa com as informações
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 1000, 1000);//cena visual, com a caixa com as informações
        addStage.setScene(scene);
        addStage.show();
    }
}