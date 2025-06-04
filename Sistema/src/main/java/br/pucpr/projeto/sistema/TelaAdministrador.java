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

        Label label = new Label("Tela do Administrador");
        label.setFont(new Font("Arial", 20));
        label.setAlignment(Pos.CENTER);

        Button addLoja = new Button("Adicionar Loja");

        addLoja.setOnAction(e -> {
            stage.close();
            TelaAdicionarLoja();
        });

        Button addCliente = new Button("Adicionar Cliente");

        addCliente.setOnAction(e -> {
            stage.close();
            TelaAdicionarCliente();
        });

        Button atualizar = new Button("Atualizar");

        atualizar.setOnAction(e -> {
            stage.close();
            telaInicial();
        });

        Button sair = new Button("Sair");
        sair.setOnAction(e -> {
            stage.close();
            new TelaLogin().telaInicial(); // Volta para a tela de login
        });


        VBox layout = new VBox(15, label, addLoja, addCliente, atualizar, sair);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new javafx.geometry.Insets(20));

        Label titulo = new Label("Usuários Cadastrados");
        titulo.setFont(new Font("Arial", 24));
        layout.getChildren().add(titulo);

        // Clientes
        for (Cliente cliente : RepositorioUsuarios.clientes) {
            HBox linha = new HBox(10);
            linha.setAlignment(Pos.CENTER_LEFT);

            Label lbl = new Label("Cliente: " + cliente.getNome() + " " + cliente.getSobrenome() + " | Login: " + cliente.getLogin());

            Button editar = new Button("Editar");
            editar.setOnAction(e -> {
                stage.close();
                TelaEdicao(cliente);
            });

            Button excluir = new Button("Excluir");
            excluir.setOnAction(e -> {
                RepositorioUsuarios.clientes.remove(cliente);
                PersistenciaUtils.salvarClientesDat();
                //atualiza o dat apos remover
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
            editar.setOnAction(e -> {
                stage.close();
                TelaEdicao(loja);
            });

            Button excluir = new Button("Excluir");
            excluir.setOnAction(e -> {
                RepositorioUsuarios.lojas.remove(loja);
                PersistenciaUtils.salvarLojasDat();
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


    private Label criarLabel(String texto) {
        Label label = new Label(texto);
        label.setFont(new Font("Arial", 12));
        label.setAlignment(Pos.CENTER);
        return label;
    }


    private TextField criarTextFieldPadrao() {
        TextField campo = new TextField();
        campo.setPrefWidth(250);
        campo.setPrefHeight(30);
        campo.setMaxWidth(250);
        campo.setAlignment(Pos.CENTER);
        return campo;
    }

    private PasswordField criarPasswordFieldPadrao() {
        PasswordField campo = new PasswordField();
        campo.setPrefWidth(250);
        campo.setPrefHeight(30);
        campo.setMaxWidth(250);
        campo.setAlignment(Pos.CENTER);
        return campo;
    }

    private void TelaEdicao(Object usuario) {
        Stage editarStage = new Stage();
        editarStage.setTitle("Editar Usuário");

        Button voltar = new Button("Voltar");
        voltar.setOnAction(e -> {
            editarStage.close();
            telaInicial();
        });

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);

        if (usuario instanceof Cliente cliente) {
            // Criação dos campos usando métodos auxiliares
            TextField nome = criarTextFieldPadrao();
            TextField sobrenome = criarTextFieldPadrao();
            TextField login = criarTextFieldPadrao();
            TextField email = criarTextFieldPadrao();
            PasswordField senha = criarPasswordFieldPadrao();
            TextField telefone = criarTextFieldPadrao();
            TextField endereco = criarTextFieldPadrao();
            TextField numero = criarTextFieldPadrao();
            TextField cpf = criarTextFieldPadrao();

            // Preenchendo com os dados atuais
            nome.setText(cliente.getNome());
            sobrenome.setText(cliente.getSobrenome());
            login.setText(cliente.getLogin());
            email.setText(cliente.getEmail());
            senha.setText(cliente.getSenha());
            telefone.setText(cliente.getTelefone());
            endereco.setText(cliente.getEndereco());
            numero.setText(cliente.getNumero());
            cpf.setText(cliente.getCpf());

            // Botão salvar
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

                PersistenciaUtils.salvarClientesDat();
                editarStage.close();
                telaInicial();
            });

            // Adiciona ao layout
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
            // Criação dos campos usando métodos auxiliares
            TextField nomeLoja = criarTextFieldPadrao();
            TextField nome = criarTextFieldPadrao();
            TextField sobrenome = criarTextFieldPadrao();
            TextField login = criarTextFieldPadrao();
            TextField email = criarTextFieldPadrao();
            PasswordField senha = criarPasswordFieldPadrao();
            TextField telefone = criarTextFieldPadrao();
            TextField endereco = criarTextFieldPadrao();
            TextField numero = criarTextFieldPadrao();
            TextField cnpj = criarTextFieldPadrao();

            // Preenchendo com os dados atuais
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

            // Botão salvar
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

                PersistenciaUtils.salvarLojasDat();
                editarStage.close();
                telaInicial();
            });

            // Adiciona ao layout
            layout.getChildren().addAll(
                    new Label("Nome da Loja:"), nomeLoja,
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

        Scene scene = new Scene(layout, 500, 800);
        editarStage.setScene(scene);
        editarStage.show();
    }





    private void TelaAdicionarLoja() {
        Stage addStage = new Stage();
        addStage.setTitle("Cadastro Loja");

        Label cadCliente = new Label("Cadastro Loja");
        cadCliente.setFont(new Font("Arial", 24));
        cadCliente.setAlignment(Pos.CENTER);

        TextField loja = criarTextFieldPadrao();
        TextField nome = criarTextFieldPadrao();
        TextField sobrenome = criarTextFieldPadrao();
        TextField email = criarTextFieldPadrao();
        TextField telefone = criarTextFieldPadrao();
        TextField endereco = criarTextFieldPadrao();
        TextField numero = criarTextFieldPadrao();
        TextField cnpj = criarTextFieldPadrao();
        TextField login = criarTextFieldPadrao();
        PasswordField senha = criarPasswordFieldPadrao();
        PasswordField repSenha = criarPasswordFieldPadrao();

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
            addStage.close();
            telaInicial();
        });

        Button voltar = new Button("Voltar");
        voltar.setOnAction(e -> {
            telaInicial();
            addStage.close();
        });

        VBox layout = new VBox(10,
                cadCliente,
                criarLabel("Digite o Nome da Loja"), loja,
                criarLabel("Digite seu Nome"), nome,
                criarLabel("Digite seu Sobrenome"), sobrenome,
                criarLabel("Digite seu Email"), email,
                criarLabel("Digite seu Número de Telefone"), telefone,
                criarLabel("Digite o Endereço da Loja"), endereco,
                criarLabel("Digite o Número do Endereço"), numero,
                criarLabel("Digite o CNPJ da Loja"), cnpj,
                criarLabel("Digite seu Login de Usuário"), login,
                criarLabel("Digite sua Senha"), senha,
                criarLabel("Confirme sua Senha"), repSenha,
                cadastrar, voltar
        );
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 1000, 1000);
        addStage.setScene(scene);
        addStage.show();
    }



    private void TelaAdicionarCliente() {
        Stage addStage = new Stage();
        addStage.setTitle("Cadastro Cliente");

        Label clienteLBL = new Label("Cadastro Cliente");
        clienteLBL.setFont(new Font("Arial", 24));
        clienteLBL.setAlignment(Pos.CENTER);

        TextField nome = criarTextFieldPadrao();
        TextField sobrenome = criarTextFieldPadrao();
        TextField email = criarTextFieldPadrao();
        TextField telefone = criarTextFieldPadrao();
        TextField cpf = criarTextFieldPadrao();
        TextField endereco = criarTextFieldPadrao();
        TextField numero = criarTextFieldPadrao();
        TextField login = criarTextFieldPadrao();
        PasswordField senha = criarPasswordFieldPadrao();
        PasswordField repSenha = criarPasswordFieldPadrao();

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
            addStage.close();
            telaInicial();
        });

        Button voltar = new Button("Voltar");
        voltar.setOnAction(e -> {
            telaInicial();
            addStage.close();
        });

        VBox layout = new VBox(10,
                clienteLBL,
                criarLabel("Digite seu Nome"), nome,
                criarLabel("Digite seu Sobrenome"), sobrenome,
                criarLabel("Digite seu Email"), email,
                criarLabel("Digite seu Número de Telefone"), telefone,
                criarLabel("Digite o Número do seu CPF"), cpf,
                criarLabel("Digite seu Endereço"), endereco,
                criarLabel("Digite seu Número Residencial"), numero,
                criarLabel("Digite seu Login de Usuário"), login,
                criarLabel("Digite sua Senha"), senha,
                criarLabel("Confirme sua Senha"), repSenha,
                cadastrar, voltar
        );
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 1000, 1000);
        addStage.setScene(scene);
        addStage.show();
    }
}