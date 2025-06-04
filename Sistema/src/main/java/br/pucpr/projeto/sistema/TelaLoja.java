package br.pucpr.projeto.sistema;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TelaLoja {
    private Loja loja; // pega loja logada

    public TelaLoja(Loja loja) {
        this.loja = loja;
    }

    public void telaInicial() {
        Stage stage = new Stage();
        stage.setTitle("Tela da Loja: " + loja.getNome());

        Label label = new Label("Bem-vindo, " + loja.getNome());
        label.setFont(new Font("Arial", 20));
        label.setAlignment(Pos.CENTER);

        Button btnCriarPromocao = new Button("Criar Promoção");
        btnCriarPromocao.setOnAction(e -> abrirFormularioPromocao());

        VBox layout = new VBox(20, label, btnCriarPromocao);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    private void abrirFormularioPromocao() {
        Stage formStage = new Stage();
        formStage.setTitle("Nova Promoção");

        TextField tfNome = new TextField();
        tfNome.setPromptText("Nome do produto");

        TextField tfPrecoInicial = new TextField();
        tfPrecoInicial.setPromptText("Preço original");

        TextField tfPrecoPromo = new TextField();
        tfPrecoPromo.setPromptText("Preço promocional");

        TextField tfQuantidade = new TextField();
        tfQuantidade.setPromptText("Quantidade");

        TextField tfTipo = new TextField();
        tfTipo.setPromptText("Tipo da promoção");

        Button btnSalvar = new Button("Salvar");
        Label msgLabel = new Label();

        btnSalvar.setOnAction(ev -> {
            try {
                String nome = tfNome.getText();
                double precoInicial = Double.parseDouble(tfPrecoInicial.getText());
                double precoPromo = Double.parseDouble(tfPrecoPromo.getText());
                int qtd = Integer.parseInt(tfQuantidade.getText());
                String tipo = tfTipo.getText();

                Promocao nova = new Promocao(nome, loja.getId(), precoInicial, precoPromo, qtd, tipo);
                RepositorioUsuarios.promocoes.add(nova);
                PersistenciaUtils.salvarPromocoesDat(); // salva no arquivo

                msgLabel.setText("Promoção criada com sucesso!");
                limparCampos(tfNome, tfPrecoInicial, tfPrecoPromo, tfQuantidade, tfTipo);

            } catch (NumberFormatException ex) {
                msgLabel.setText("Erro: verifique os valores numéricos.");
            }
        });

        VBox form = new VBox(10, tfNome, tfPrecoInicial, tfPrecoPromo, tfQuantidade, tfTipo, btnSalvar, msgLabel);
        form.setAlignment(Pos.CENTER);
        form.setPadding(new Insets(20));

        formStage.setScene(new Scene(form, 300, 350));
        formStage.show();
    }

    private void limparCampos(TextField... fields) {
        for (TextField tf : fields) {
            tf.clear();
        }
    }
}
