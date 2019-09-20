
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.alg.util.Pair;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
/**
 * Representacao de um circulo de um amigos em uma determinada rede social.
 * 
 * @author Jonatha Kennedy Monteiro Costa - 118210227
 * @author Leticia Gabriela Calixto - 118210691
 * @author Lucas Oliveira Belmiro - 118210068
 *
 */
public class CirculoAmigos {
	
	/**
	 * Metodo que calcula a lista de Circulos de amigos de uma rede social, onde cada elemento é um conjunto de vertices do tipo String.
	 * @param paresAmigos Conjunto de vertices do tipo String.
	 * @return uma lista contendo conjuntos de vértices que estão num mesmo componente conectado.
	 */
	public static List<Set<String>> retornaCirculos(List<Pair<String, String>> paresAmigos) {

		// Instancia grafo
		Graph<String, DefaultEdge> grafo = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);

		// Itera sobre os pares passados na entrada para colocar no grafo
		for (Pair<String, String> par : paresAmigos) {
			grafo.addVertex(par.getFirst());
			grafo.addVertex(par.getSecond());
			grafo.addEdge(par.getFirst(), par.getSecond());
		}

		// Instancia objeto para inspecionar conectividade de um grafo, sendo passado o
		// grafo anteriormente criado como parâmetro.
		ConnectivityInspector ci = new ConnectivityInspector(grafo);

		// Retorna lista contendo conjuntos de vértices que estão num mesmo componente
		// conectado
		return ci.connectedSets();
	}
}
