import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();

        carregarValoresIniciais(arvore);

        int opcao;

        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção: ");

            executarOpcao(opcao, arvore);

        } while (opcao != 10);

        teclado.close();
    }

    private static void carregarValoresIniciais(ArvoreBinariaBusca arvore) {

        int quantidade = lerInteiro("Quantos valores deseja inserir na árvore? ");

        while (quantidade < 1) {
            System.out.println("A quantidade deve ser maior que zero.");
            quantidade = lerInteiro("Quantos valores deseja inserir na árvore? ");
        }

        int inseridos = 0;

        while (inseridos < quantidade) {
            int valor = lerInteiro("Digite o valor " + (inseridos + 1) + ": ");

            if (arvore.inserir(valor)) {
                inseridos++;
            } else {
                System.out.println("Valor repetido. Digite outro valor.");
            }
        }
    }

    private static void exibirMenu() {

        System.out.println();
        System.out.println("======================================");
        System.out.println("       ÁRVORE BINÁRIA DE BUSCA");
        System.out.println("======================================");
        System.out.println("1  - Inserir valor");
        System.out.println("2  - Buscar valor");
        System.out.println("3  - Mostrar Pré-ordem");
        System.out.println("4  - Mostrar Em ordem");
        System.out.println("5  - Mostrar Pós-ordem");
        System.out.println("6  - Mostrar BFS - Busca em Largura");
        System.out.println("7  - Mostrar DFS - Busca em Profundidade");
        System.out.println("8  - Mostrar altura da árvore");
        System.out.println("9  - Mostrar estrutura da árvore");
        System.out.println("10 - Sair");
        System.out.println("======================================");
    }

    private static int lerInteiro(String mensagem) {

        while (true) {

            try {

                System.out.print(mensagem);

                return teclado.nextInt();

            } catch (InputMismatchException e) {

                System.out.println("Digite apenas números.");

                teclado.nextLine();
            }
        }
    }

    private static void executarOpcao(int opcao, ArvoreBinariaBusca arvore) {

        switch (opcao) {

            case 1:
                inserirValor(arvore);
                break;

            case 2:
                buscarValor(arvore);
                break;

            case 3:
                System.out.println();
                System.out.println("Pré-ordem (Raiz, Esquerda, Direita):");
                arvore.preOrdem();
                break;

            case 4:
                System.out.println();
                System.out.println("Em ordem (Esquerda, Raiz, Direita):");
                arvore.emOrdem();
                break;

            case 5:
                System.out.println();
                System.out.println("Pós-ordem (Esquerda, Direita, Raiz):");
                arvore.posOrdem();
                break;

            case 6:
                System.out.println();
                arvore.bfs();
                break;

            case 7:
                System.out.println();
                arvore.dfs();
                break;

            case 8:
                System.out.println();
                System.out.println("Altura da árvore: " + arvore.altura() + " (a raiz está no nível 0)");
                break;

            case 9:
                System.out.println();
                System.out.println("Estrutura da árvore (raiz no topo):");
                System.out.println("Legenda: E = filho esquerdo | D = filho direito | + = ponto de ligação com o pai");
                System.out.println();
                arvore.mostrarEstrutura();
                break;

            case 10:
                System.out.println();
                System.out.println("Programa encerrado.");
                break;

            default:
                System.out.println();
                System.out.println("Opção inválida.");
        }
    }

    private static void inserirValor(ArvoreBinariaBusca arvore) {

        int valor = lerInteiro("Digite o valor que deseja inserir: ");

        if (arvore.inserir(valor)) {
            System.out.println("Valor inserido com sucesso!");
        } else {
            System.out.println("O valor " + valor + " já existe na árvore e não foi inserido.");
        }
    }

    private static void buscarValor(ArvoreBinariaBusca arvore) {

        int valor = lerInteiro("Digite o valor que deseja buscar: ");

        if (arvore.buscar(valor)) {
            System.out.println("Valor " + valor + " encontrado na árvore!");
        } else {
            System.out.println("Valor " + valor + " não encontrado na árvore.");
        }
    }
}