import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void executar(No raiz) {

        if (raiz == null) {
            System.out.println("A árvore está vazia.");
            return;
        }

        Queue<No> fila = new LinkedList<>();

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
}
