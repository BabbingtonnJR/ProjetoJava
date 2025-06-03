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


public class TelaLogin {

    public void telaInicial() {
        Stage stage = new Stage(); // cria a tela
        stage.setTitle("PromoSearch"); // título da tela

        //texto LOGIN
        Label loginLBL = new Label("Login");
        loginLBL.setFont(new Font("Arial", 24));//define fonte e tamanho
        loginLBL.setAlignment(Pos.CENTER);//alinhamento no centro

        //texto usuario
        Label user = new Label("Digite seu usuario");
        user.setFont(new Font("Arial", 12));
        user.setAlignment(Pos.CENTER);

        //usuario
        TextField login = new TextField(); //input de texto
        login.setPrefWidth(250); //largura em pixels
        login.setPrefHeight(30); //altura em pixels
        login.setMaxWidth(250); //não deixa esticar
        login.setAlignment(Pos.CENTER);

        //texto senha
        Label senhatxt = new Label("Digite sua senha");
        senhatxt.setFont(new Font("Arial", 12));
        senhatxt.setAlignment(Pos.CENTER);

        //senha
        PasswordField senha = new PasswordField();
        senha.setPrefWidth(250);
        senha.setPrefHeight(30);
        senha.setMaxWidth(250);
        senha.setAlignment(Pos.CENTER);


        Button entrar = new Button("Entrar");

        entrar.setOnAction(e -> {
            String loginDigitado = login.getText();
            String senhaDigitada = senha.getText();

            //verificação do adm
            if (loginDigitado.equals("admin") && senhaDigitada.equals("1234")) {
                new TelaAdministrador().telaInicial();
            } else {
                //adicionar verificação dos outros (usuarios lojas e clientes)
                System.out.println("Login ou senha inválidos");
            }
        });


        Button cadastrar = new Button("Cadastrar");

        cadastrar.setOnAction(e -> {
            new TelaCadastro().selecao();
        });

        VBox layout = new VBox(10, loginLBL, user, login, senhatxt, senha, entrar, cadastrar);//caixa com as informações
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 1000, 1000);//cena visual, com a caixa com as informações
        stage.setScene(scene);
        stage.show();

    }
}
