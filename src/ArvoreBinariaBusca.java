import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

public class ArvoreBinariaBusca {

    private No raiz;

    public ArvoreBinariaBusca() {
        this.raiz = null;
    }

    public boolean estaVazia() {
        return raiz == null;
    }

    public boolean inserir(int valor) {
        if (buscar(valor)) {
            return false;
        }
        raiz = inserir(raiz, valor);
        return true;
    }

    private No inserir(No atual, int valor) {
        if (atual == null) {
            return new No(valor, null, null);
        }
        if (valor < atual.getValor()) {
            atual.setEsquerda(inserir(atual.getEsquerda(), valor));
        } else if (valor > atual.getValor()) {
            atual.setDireita(inserir(atual.getDireita(), valor));
        }
        return atual;
    }

    public boolean buscar(int valor) {
        return buscar(raiz, valor);
    }

    private boolean buscar(No atual, int valor) {
        if (atual == null) {
            return false;
        }
        if (valor == atual.getValor()) {
            return true;
        }
        if (valor < atual.getValor()) {
            return buscar(atual.getEsquerda(), valor);
        }
        return buscar(atual.getDireita(), valor);
    }

    public void preOrdem() {
        if (estaVazia()) {
            System.out.println("A árvore está vazia.");
            return;
        }
        preOrdem(raiz);
        System.out.println();
    }

    private void preOrdem(No atual) {
        if (atual == null) {
            return;
        }
        System.out.print(atual.getValor() + " ");
        preOrdem(atual.getEsquerda());
        preOrdem(atual.getDireita());
    }

    public void emOrdem() {
        if (estaVazia()) {
            System.out.println("A árvore está vazia.");
            return;
        }
        emOrdem(raiz);
        System.out.println();
    }

    private void emOrdem(No atual) {
        if (atual == null) {
            return;
        }
        emOrdem(atual.getEsquerda());
        System.out.print(atual.getValor() + " ");
        emOrdem(atual.getDireita());
    }

    public void posOrdem() {
        if (estaVazia()) {
            System.out.println("A árvore está vazia.");
            return;
        }
        posOrdem(raiz);
        System.out.println();
    }

    private void posOrdem(No atual) {
        if (atual == null) {
            return;
        }
        posOrdem(atual.getEsquerda());
        posOrdem(atual.getDireita());
        System.out.print(atual.getValor() + " ");
    }

    public void bfs() {
        if (estaVazia()) {
            System.out.println("A árvore está vazia.");
            return;
        }

        Queue<No> fila = new ArrayDeque<>();
        fila.add(raiz);
        int nivel = 0;

        System.out.println("BFS - Busca em Largura (por níveis):");

        while (!fila.isEmpty()) {
            int quantidadeNoNivel = fila.size();
            System.out.print("Nível " + nivel + ": ");

            for (int i = 0; i < quantidadeNoNivel; i++) {
                No atual = fila.poll();
                System.out.print(atual.getValor() + " ");

                if (atual.getEsquerda() != null) {
                    fila.add(atual.getEsquerda());
                }
                if (atual.getDireita() != null) {
                    fila.add(atual.getDireita());
                }
            }

            System.out.println();
            nivel++;
        }
    }

    public void dfs() {
        if (estaVazia()) {
            System.out.println("A árvore está vazia.");
            return;
        }

        Deque<No> pilha = new ArrayDeque<>();
        Deque<Integer> niveis = new ArrayDeque<>();
        pilha.push(raiz);
        niveis.push(0);
        boolean primeiro = true;

        System.out.println("DFS - Busca em Profundidade (nó e nível de profundidade):");

        while (!pilha.isEmpty()) {
            No atual = pilha.pop();
            int nivel = niveis.pop();

            if (!primeiro) {
                System.out.print(" -> ");
            }
            System.out.print(atual.getValor() + " (nível " + nivel + ")");
            primeiro = false;

            if (atual.getDireita() != null) {
                pilha.push(atual.getDireita());
                niveis.push(nivel + 1);
            }
            if (atual.getEsquerda() != null) {
                pilha.push(atual.getEsquerda());
                niveis.push(nivel + 1);
            }
        }

        System.out.println();
    }

    public int altura() {
        return altura(raiz);
    }

    private int altura(No atual) {
        if (atual == null) {
            return -1;
        }
        int alturaEsquerda = altura(atual.getEsquerda());
        int alturaDireita = altura(atual.getDireita());
        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }

    public void mostrarEstrutura() {
        if (estaVazia()) {
            System.out.println("A árvore está vazia.");
            return;
        }

        int largura = maiorTexto(raiz) + 2;
        int linhas = 2 * altura() + 1;
        int colunas = contarNos(raiz) * largura;

        char[][] grade = new char[linhas][colunas];
        for (char[] linha : grade) {
            Arrays.fill(linha, ' ');
        }

        preencherGrade(raiz, 0, new int[]{0}, grade, largura);

        for (char[] linha : grade) {
            System.out.println(new String(linha).stripTrailing());
        }
    }

    private int preencherGrade(No atual, int profundidade, int[] contador, char[][] grade, int largura) {
        int centroEsquerda = -1;
        int centroDireita = -1;

        if (atual.getEsquerda() != null) {
            centroEsquerda = preencherGrade(atual.getEsquerda(), profundidade + 1, contador, grade, largura);
        }

        int inicioCelula = contador[0] * largura;
        contador[0]++;
        int centro = inicioCelula + largura / 2;

        String texto = String.valueOf(atual.getValor());
        int inicioTexto = inicioCelula + (largura - texto.length()) / 2;
        for (int i = 0; i < texto.length(); i++) {
            grade[2 * profundidade][inicioTexto + i] = texto.charAt(i);
        }

        if (atual.getDireita() != null) {
            centroDireita = preencherGrade(atual.getDireita(), profundidade + 1, contador, grade, largura);
        }

        int linhaLigacao = 2 * profundidade + 1;

        if (centroEsquerda != -1) {
            for (int coluna = centroEsquerda + 1; coluna < centro; coluna++) {
                grade[linhaLigacao][coluna] = '-';
            }
            grade[linhaLigacao][centroEsquerda] = 'E';
            grade[linhaLigacao][centro] = '+';
        }

        if (centroDireita != -1) {
            for (int coluna = centro + 1; coluna < centroDireita; coluna++) {
                grade[linhaLigacao][coluna] = '-';
            }
            grade[linhaLigacao][centroDireita] = 'D';
            grade[linhaLigacao][centro] = '+';
        }

        return centro;
    }

    private int contarNos(No atual) {
        if (atual == null) {
            return 0;
        }
        return 1 + contarNos(atual.getEsquerda()) + contarNos(atual.getDireita());
    }

    private int maiorTexto(No atual) {
        if (atual == null) {
            return 0;
        }
        int tamanho = String.valueOf(atual.getValor()).length();
        return Math.max(tamanho, Math.max(maiorTexto(atual.getEsquerda()), maiorTexto(atual.getDireita())));
    }
}