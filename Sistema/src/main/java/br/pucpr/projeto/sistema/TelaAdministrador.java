package br.pucpr.projeto.sistema;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaAdministrador {

    public void telaInicial() {
        Stage stage = new Stage();
        stage.setTitle("Tela Administrador");

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);

        Label titulo = new Label("Usuários Cadastrados");
        layout.getChildren().add(titulo);

        //adm
        for (Administrador administrador : RepositorioUsuarios.administradores) {
            Label lbl = new Label("Administrador: " + administrador.getNome() + " " + administrador.getSobrenome() + " | Login: " + administrador.getLogin());
            layout.getChildren().add(lbl);
        }

        //clientes
        for (Cliente cliente : RepositorioUsuarios.clientes) {
            Label lbl = new Label("Cliente: " + cliente.getNome() + " " + cliente.getSobrenome() + " | Login: " + cliente.getLogin());
            layout.getChildren().add(lbl);
        }

        //lojas
        for (Loja loja : RepositorioUsuarios.lojas) {
            Label lbl = new Label("Loja: " + loja.getLoja() + " | Responsável: " + loja.getNome() + " " + loja.getSobrenome() + " | Login: " + loja.getLogin());
            layout.getChildren().add(lbl);
        }

        Scene scene = new Scene(layout, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
}
