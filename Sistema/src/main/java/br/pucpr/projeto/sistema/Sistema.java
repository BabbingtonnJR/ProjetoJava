package br.pucpr.projeto.sistema;

import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Sistema extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        new TelaLogin().telaInicial();
    }

    public static void main(String[] args) {

        Administrador admin = new Administrador(
                0,
                "Admin",
                "Master",
                "admin@admin.com",
                "admin",// login
                "1234",// senha
                "0000-0000",
                "Endereço",
                "100",
                "000.000.000-00"
        );

        //adiciona no repositorio dos usuarios
        if (RepositorioUsuarios.administradores.isEmpty()) {
            RepositorioUsuarios.administradores.add(admin);
        }

        List<String[]> lojasCSV = CSVUtils.lerCSV("lojas.csv");
        for (String[] dados : lojasCSV) {
            Loja loja = new Loja(
                    RepositorioUsuarios.lojas.size() + 1,
                    dados[0], dados[1], dados[2], dados[3], dados[4],
                    dados[5], dados[6], dados[7], dados[8], dados[9]
            );
            RepositorioUsuarios.lojas.add(loja);
        }

        List<String[]> clienteCSV = CSVUtils.lerCSV("clientes.csv");
        for (String[] dados : clienteCSV) {
            Cliente cliente = new Cliente(
                    RepositorioUsuarios.clientes.size() + 1,
                    dados[0], dados[1], dados[2], dados[3], dados[4],
                    dados[5], dados[6], dados[7], dados[8]
            );
            RepositorioUsuarios.clientes.add(cliente);
        }


        launch();
    }
}
