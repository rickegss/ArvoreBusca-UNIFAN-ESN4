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
    }

    public void dfs() {
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

    private void mostrarEstrutura(No atual, int profundidade) {
    }
}