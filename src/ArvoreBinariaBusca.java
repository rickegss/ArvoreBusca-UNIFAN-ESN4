import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class ArvoreBinariaBusca {

    private No raiz;

    public ArvoreBinariaBusca() {
    }

    public boolean estaVazia() {
    }

    public void inserir(int valor) {
    }

    private No inserir(No atual, int valor) {
    }

    public boolean buscar(int valor) {
    }

    private boolean buscar(No atual, int valor) {
    }

    public void preOrdem() {
    }

    private void preOrdem(No atual) {
    }

    public void emOrdem() {
    }

    private void emOrdem(No atual) {
    }

    public void posOrdem() {
    }

    private void posOrdem(No atual) {
    }

    public void bfs() {

        if (raiz == null) {
            System.out.println("A árvore está vazia.");
            return;
        }

        Queue<No> fila = new ArrayDeque<>();

        fila.add(raiz);

        System.out.print("BFS - Busca em Largura: ");

        while (!fila.isEmpty()) {

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
    }

    public void dfs() {

        if (raiz == null) {
            System.out.println("A árvore está vazia.");
            return;
        }

        Deque<No> pilha = new ArrayDeque<>();

        pilha.push(raiz);

        System.out.print("DFS - Busca em Profundidade: ");

        while (!pilha.isEmpty()) {

            No atual = pilha.pop();

            System.out.print(atual.getValor() + " ");

            if (atual.getDireita() != null) {
                pilha.push(atual.getDireita());
            }

            if (atual.getEsquerda() != null) {
                pilha.push(atual.getEsquerda());
            }
        }

        System.out.println();
    }

    public int altura() {
    }

    private int altura(No atual) {
    }

    public void mostrarEstrutura() {
    }

    private void mostrarEstrutura(No atual, int profundidade) {
    }
}