package br.pucpr.projeto.sistema;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

    public static void escreverLinha(String caminho, String linha) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho, true))) {
            writer.write(linha);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo CSV: " + e.getMessage());
        }
    }

    public static List<String[]> lerCSV(String caminho) {
        List<String[]> dados = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] valores = linha.split(";");
                dados.add(valores);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        }
        return dados;
    }

    public static void salvarClienteCSV() {
        String caminho = "clientes.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho))) {
            for (Cliente cliente : RepositorioUsuarios.clientes) {
                writer.write(
                        cliente.getNome() + ";" +
                                cliente.getSobrenome() + ";" +
                                cliente.getLogin() + ";" +
                                cliente.getEmail() + ";" +
                                cliente.getSenha() + ";" +
                                cliente.getTelefone() + ";" +
                                cliente.getEndereco() + ";" +
                                cliente.getNumero() + ";" +
                                cliente.getCpf()
                );
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar clientes no CSV: " + e.getMessage());
        }
    }

    public static void salvarLojaCSV() {
        String caminho = "lojas.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho))) {
            for (Loja loja : RepositorioUsuarios.lojas) {
                writer.write(
                            loja.getLoja() + ";" +
                                loja.getNome() + ";" +
                                loja.getSobrenome() + ";" +
                                loja.getLogin() + ";" +
                                loja.getEmail() + ";" +
                                loja.getSenha() + ";" +
                                loja.getTelefone() + ";" +
                                loja.getEndereco() + ";" +
                                loja.getNumero() + ";" +
                                loja.getCnpj()
                );
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar Lojas no CSV: " + e.getMessage());
        }
    }


}
