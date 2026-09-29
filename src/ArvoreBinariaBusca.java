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
    }

    public void dfs() {
    }

    public int altura() {
    }

    private int altura(No atual) {
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