import java.util.ArrayDeque;
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

    public void inserir(int valor) {
        raiz = inserir(raiz, valor);
    }


    private No inserir(No atual, int valor) {
        if (atual == null) {
            return new No(valor, null,null);
        }
        if (valor < atual.getValor() ) {
            atual.setEsquerda(inserir(atual.getEsquerda(), valor));
        } else if (valor > atual.getValor()) {
            atual.setDireita(atual.getDireita(), valor);
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
        preOrdem(raiz);
        System.out.println();
    }

    private void preOrdem(No atual) {
        if(atual == null){
            return;
        }
        System.out.print(atual.getValor() + " ");
        preOrdem(atual.getEsquerda());
        preOrdem(atual.getDireita());
    }

    public void emOrdem() {
        emOrdem(raiz);
        System.out.println();
    }

    private void emOrdem(No atual) {
        if(atual == null){
            return;
        }
        emOrdem(atual.getEsquerda());
        System.out.print(atual.getValor() + " ");
        emOrdem(atual.getDireita());
    }

    public void posOrdem() {
        posOrdem(raiz);
        System.out.println();
    }

    private void posOrdem(No atual) {
        if(atual == null){
            return;
        }
        posOrdem(atual.getEsquerda());
        posOrdem(atual.getDireita());
        System.out.print(atual.getValor() + " ");
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
        mostrarEstrutura(raiz, 0, "raiz");
    }

    private void mostrarEstrutura(No atual, int profundidade, String rotulo) {
        if(atual == null){
            return;
        }
        mostrarEstrutura(atual.getDireita(), profundidade + 1, "D");
        System.out.println(" ".repeat(profundidade * 4) + atual.getValor() + " (" + rotulo + ")");
        mostrarEstrutura(atual.getEsquerda(), profundidade + 1, "E");
    }
}