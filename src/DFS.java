import java.util.Stack;

public class DFS {

    public static void executar(No raiz) {

        if (raiz == null) {
            System.out.println("A árvore está vazia.");
            return;
        }

        Stack<No> pilha = new Stack<>();

        pilha.push(raiz);

        System.out.print("DFS - Busca em Profundidade: ");

        while (!pilha.isEmpty()) {

            No atual = pilha.pop();

            System.out.print(atual.getValor() + " ");

            // Coloca a direita primeiro
            // para a esquerda ser visitada primeiro
            if (atual.getDireita() != null) {
                pilha.push(atual.getDireita());
            }

            if (atual.getEsquerda() != null) {
                pilha.push(atual.getEsquerda());
            }
        }

        System.out.println();
    }
}