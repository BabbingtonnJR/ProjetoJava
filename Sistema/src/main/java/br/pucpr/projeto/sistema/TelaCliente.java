package br.pucpr.projeto.sistema;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TelaCliente {
    private Cliente cliente;

    public TelaCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void telaInicial() {
        Stage stage = new Stage();
        stage.setTitle("Tela do Cliente: " + cliente.getNome());

        Label titulo = new Label("Cliente: " + cliente.getNome());
        titulo.setFont(new Font("Arial", 24));
        titulo.setAlignment(Pos.CENTER);

        Label mensagem = new Label("Bem-vindo, " + cliente.getNome());
        mensagem.setFont(new Font("Arial", 18));
        mensagem.setAlignment(Pos.CENTER);

        Button btnSair = new Button("Sair");
        btnSair.setOnAction(e -> stage.close());

        VBox layout = new VBox(20, titulo, mensagem, btnSair);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(30));

        Scene scene = new Scene(layout, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
}
