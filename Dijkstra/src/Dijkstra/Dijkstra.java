package Dijkstra;
import java.util.*;

	public class Dijkstra {
	    private static final int INFINITO = Integer.MAX_VALUE;
	    
	    // Implementação do algoritmo de Dijkstra
	    public static void dijkstra(int[][] grafo, int origem) {
	        int numVertices = grafo.length;
	        int[] distancia = new int[numVertices];
	        boolean[] visitado = new boolean[numVertices];

	        for (int i = 0; i < numVertices; i++) {
	            distancia[i] = INFINITO;
	            visitado[i] = false;
	        }

	        distancia[origem] = 0;

	        for (int i = 0; i < numVertices - 1; i++) {
	            int u = minDistancia(distancia, visitado);
	            visitado[u] = true;

	            for (int v = 0; v < numVertices; v++) {
	                if (!visitado[v] && grafo[u][v] != 0 && distancia[u] != INFINITO && distancia[u] + grafo[u][v] < distancia[v]) {
	                    distancia[v] = distancia[u] + grafo[u][v];
	                }
	            }
	        }

	        imprimirDistancias(distancia);
	    }

	    private static int minDistancia(int[] distancia, boolean[] visitado) {
	        int min = INFINITO;
	        int minIndex = -1;

	        for (int i = 0; i < distancia.length; i++) {
	            if (!visitado[i] && distancia[i] <= min) {
	                min = distancia[i];
	                minIndex = i;
	            }
	        }

	        return minIndex;
	    }

	    private static void imprimirDistancias(int[] distancia) {
	        System.out.println("Distâncias mínimas a partir do vértice de origem:");
	        for (int i = 0; i < distancia.length; i++) {
	            System.out.println("Vértice " + i + ": " + distancia[i]);
	        }
	    }

	    public static void main(String[] args) {
	        // Exemplo de grafo com 4 vértices
	        int[][] grafo = {
	            {0, 2, 0, 5},
	            {2, 0, 4, 0},
	            {0, 4, 0, 3},
	            {5, 0, 3, 0}
	        };

	        // Executando o algoritmo de Dijkstra a partir do vértice 0 (vértice 1)
	        dijkstra(grafo, 0);
	    }

}
