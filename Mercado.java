package main;
import Utils.Utils;
import modelo.Produto;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Mercado {
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Produto> produtos;
    private static Map<Produto, Integer> carrinho;

    public static void main(String[] args) {
        produtos = new ArrayList<>();
        carrinho = new HashMap<>();
        menu();
    }

    private static void menu() {
        System.out.println("----------------------------------------------------");
        System.out.println("-------------Bem Vindo ao Mercado-------------------");
        System.out.println("----------------------------------------------------");
        System.out.println("** Selecione uma operação que deseja realizar * ");
        System.out.println("----------------------------------------------------");
        String option_One = (JOptionPane.showInputDialog("Digite as seguintes opções: " +
                "1 - Cadastrar / 2 - Listar / 3 - Comprar / 4 - Carrinho / 5 - Finalizar Compra / 6 - Sair "));
        System.out.println("   Opção 1 - Cadastrar         ");
        System.out.println("   Opção 2 - Listar            ");
        System.out.println("   Opção 3 - Comprar           ");
        System.out.println("   Opção 4 - Carrinho          ");
        System.out.println("   Opção 5 - Finalizar comprar ");
        System.out.println("   Opção 6 - Sair              ");

        String option = option_One;

        switch (option) {
            case ("1"):
                cadastrarProdutos();
                break;
            case ("2"):
                listarProdutos();
                break;
            case ("3"):
                comprarProdutos();
                break;
            case ("4"):
                verCarrinho();
                break;
            case ("5"):
                finalizarCompra();
            case ("6"):
                System.out.println("Volte sempre!");
                System.exit(0);
            default:
                System.out.println("Opção Inválida!");
                menu();
                break;
        }
    }
    private static void cadastrarProdutos() {
        String option_Nome_produto = (JOptionPane.showInputDialog("Nome do produto: "));
        System.out.println("Nome do produto: " + option_Nome_produto);

        Double option_Preco = Double.valueOf((JOptionPane.showInputDialog(("Digite o preço do produto: "))));
        System.out.println("Preço do Produto " + option_Preco);

        Produto produto = new Produto(option_Nome_produto, option_Preco);
        produtos.add(produto);

        System.out.println(produto.getNome() + " Foi cadastrado com sucesso!");
        menu();
    }

    private static void listarProdutos() {
        if (produtos.size() > 0) {
            System.out.println("Lista de produtos \n");

            for (Produto p: produtos){
                System.out.println(p);
            }

        } else {
            System.out.println("Nenhum produto cadastrado!");
        }
        menu();
    }

    private static void comprarProdutos() {
        if (produtos.size() > 0) {
            System.out.println("Código de produtos! \n");

            System.out.println("------------------------ Produtos Disponíveis -----------------");
            for (Produto p : produtos) {
                System.out.println(p + "\n");
            }
            int id = Integer.parseInt((JOptionPane.showInputDialog("Digite o codigo do produto: ")));
            boolean isPresent = false;

            for (Produto p : produtos) {
                if (p.getId() == id) {
                    int qtd = 0;
                    try {
                        qtd = carrinho.get(p);
                        // checa se o produto já está no carrinho, incrementa a quantidade.
                        carrinho.put(p, qtd + 1);
                    }catch (NullPointerException e) {
                        // se o produto for o promeiro no carrinho.
                        carrinho.put(p, 1);
                    }
                        System.out.println(p.getNome()+ "Adicionado ao carrinho.");
                    isPresent = true;

                    if (isPresent) {
                        System.out.println("Deseja adicionar outro produto ao carrinho? ");
                        System.out.println("Digite 1 para sim, ou 0 para finalizar a compra. \n");
                        int option = Integer.parseInt(JOptionPane.showInputDialog("Digite 1 para continuar comprando, 2 para voltar ao carrinho ou 0 para finalizar a compra: "));

                        switch (option){
                            case (1):
                                comprarProdutos();
                                break;
                            case (2):
                                verCarrinho();
                                break;
                            case (0):
                                finalizarCompra();
                                break;
                        } {

                        }
                    }
                }// else {
                    // System.out.println("Produto não encontrado.");
                //menu(); }
            }
        } //else {
            // System.out.println("Não existem produtos cadastrados!");
                //menu();
            // } }

        }

        private static void verCarrinho() {
            System.out.println("--- Produto no seu carrinho! ---");
            if (carrinho.size() > 0) {
                for (Produto p : carrinho.keySet()) {
                    System.out.println("Produto: " + p + "\nQuantidade: " + carrinho.get(p));
                }
            }else {
                System.out.println("Carrinho vazio!");
            }
            Double valorDaCompra = 0.0;
            System.out.println("Seus produtos!");

            for (Produto p : carrinho.keySet()) {
                int qtd = carrinho.get(p);
                valorDaCompra += p.getPreco() * qtd;
                System.out.println(qtd);
                System.out.println(("Quantidade: " + qtd));
                System.out.println("---------------------");

            }
            System.out.println("O valor da sua compra até agora é: " + Utils.doubleToString(valorDaCompra));


            menu();

    }

    private static void finalizarCompra() {
        Double valorDaCompra = 0.0;
        System.out.println("Seus produtos!");

        for (Produto p : carrinho.keySet()) {
            int qtd = carrinho.get(p);
            valorDaCompra += p.getPreco() * qtd;
            System.out.println(qtd);
            System.out.println(("Quantidade: " + qtd));
            System.out.println("---------------------");

        }
        System.out.println("O valor da sua compra é " + Utils.doubleToString(valorDaCompra));
        carrinho.clear();

        System.out.println("Obrigado pela preferência!");
        menu();
    }
}
