package br.pucpr.projeto.sistema;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
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

        Label label = new Label("Bem-vindo, " + cliente.getNome());
        label.setFont(new Font("Arial", 20));
        label.setAlignment(Pos.CENTER);

        Button sair = new Button("Sair");
        sair.setOnAction(e -> {
            stage.close();
            new TelaLogin().telaInicial();
        });

        VBox layout = new VBox(20, label, sair);
        layout.setAlignment(Pos.TOP_CENTER);
        layout.setPadding(new Insets(20));

        Label promoTitulo = new Label("Promoções disponíveis:");
        promoTitulo.setFont(new Font("Arial", 16));
        layout.getChildren().add(promoTitulo);

        VBox listaPromocoes = new VBox(15);
        for (Promocao promo : RepositorioUsuarios.promocoes) {
            String nomeLoja = "Loja desconhecida";
            for (Loja loja : RepositorioUsuarios.lojas) {
                if (loja.getId() == promo.getIdLoja()) {
                    nomeLoja = loja.getNome();
                    break;
                }
            }

            VBox dadosPromo = new VBox(5);
            dadosPromo.getChildren().addAll(
                    new Label("Loja: " + nomeLoja + " | Produto: " + promo.getNomeProduto()),
                    new Label("De: R$" + promo.getPrecoInicial()),
                    new Label("Por: R$" + promo.getPrecoPromocional()),
                    new Label("Quantidade: " + promo.getQuantidade()),
                    new Label("Tipo: " + promo.getTipo())
            );

            Button btnDenunciar = new Button("Denunciar");
            btnDenunciar.setOnAction(e -> abrirFormularioDenuncia(stage, promo));

            VBox promocaoBox = new VBox(8, dadosPromo, btnDenunciar);
            promocaoBox.setStyle("-fx-border-color: #ccc; -fx-padding: 10; -fx-border-radius: 5;");
            listaPromocoes.getChildren().add(promocaoBox);
        }

        layout.getChildren().add(listaPromocoes);

        Scene scene = new Scene(layout, 1000, 600);
        stage.setScene(scene);
        stage.show();
    }

    private void abrirFormularioDenuncia(Stage stagePrincipal, Promocao promo) {
        Stage formStage = new Stage();
        formStage.setTitle("Denunciar Promoção: " + promo.getNomeProduto());

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Label descricaoLabel = new Label("Descrição da denúncia:");
        TextArea taDescricao = new TextArea();
        taDescricao.setWrapText(true);
        taDescricao.setPrefRowCount(5);

        Label msgLabel = new Label();

        Button btnEnviar = new Button("Enviar Denúncia");
        Button btnVoltar = new Button("Voltar");

        btnEnviar.setOnAction(e -> {
            String descricao = taDescricao.getText().trim();
            if (descricao.isEmpty()) {
                msgLabel.setText("Por favor, informe uma descrição para a denúncia.");
                return;
            }

            Denuncia denuncia = new Denuncia(
                    promo.getIdLoja(),
                    cliente.getId(),
                    descricao,
                    false,
                    java.time.LocalDate.now().toString()
            );

            RepositorioUsuarios.denuncias.add(denuncia);
            PersistenciaUtils.salvarDenunciasDat();

            msgLabel.setText("Denúncia enviada com sucesso!");
            taDescricao.clear();
        });

        btnVoltar.setOnAction(e -> formStage.close());

        layout.getChildren().addAll(descricaoLabel, taDescricao, btnEnviar, btnVoltar, msgLabel);

        formStage.setScene(new Scene(layout, 400, 300));
        formStage.show();
    }
}
