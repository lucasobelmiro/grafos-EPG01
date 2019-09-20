import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jgrapht.alg.util.Pair;
import org.junit.Test;

/**
 * Testes da Classe CirculoAmigos.
 * 
 * @author Jonatha Kennedy Monteiro Costa - 118210227
 * @author Leticia Gabriela Calixto - 118210691
 * @author Lucas Oliveira Belmiro - 118210068
 *
 */
public class CirculoAmigosTest {

	@Test
	public void test1() {
		ArrayList<Pair<String,String>> listaAmigos = new ArrayList <Pair<String,String>> ();
		listaAmigos.add(new Pair<String, String>("a","b"));
		listaAmigos.add(new Pair<String, String>("c","d"));
		listaAmigos.add(new Pair<String, String>("e","f"));
		listaAmigos.add(new Pair<String, String>("f","g"));
		listaAmigos.add(new Pair<String, String>("i","j"));
		
		// Circulos que devem ser encontrados
		Set <String> c1 = new HashSet<String> (); c1.add("a"); c1.add("b");
		Set <String> c2 = new HashSet<String> (); c2.add("c"); c2.add("d");
		Set <String> c3 = new HashSet<String> (); c3.add("e"); c3.add("f"); c3.add("g"); 
		Set <String> c4 = new HashSet<String> (); c4.add("i"); c4.add("j");
		
		// Calculando círculos
		List <Set<String>> circuloAmigos = CirculoAmigos.retornaCirculos(listaAmigos);
		
		assertTrue(circuloAmigos.contains(c1));
		assertTrue(circuloAmigos.contains(c2));
		assertTrue(circuloAmigos.contains(c3));
		assertTrue(circuloAmigos.contains(c4));
		assertEquals(circuloAmigos.size(),4);		
	}
	
	@Test 
	public void test2 () {
		ArrayList<Pair<String,String>> listaAmigos = new ArrayList <Pair<String,String>> ();
		listaAmigos.add(new Pair<String, String>("a","b"));
		listaAmigos.add(new Pair<String, String>("c","b"));
		listaAmigos.add(new Pair<String, String>("e","a"));
		listaAmigos.add(new Pair<String, String>("f","b"));
		listaAmigos.add(new Pair<String, String>("f","a"));		
		
		// Circulos que devem ser encontrados
		Set <String> c1 = new HashSet<String> (); c1.add("a"); c1.add("b"); c1.add("c"); c1.add("e"); c1.add("f");
		
		// Calculando círculos
		List <Set<String>> circuloAmigos = CirculoAmigos.retornaCirculos(listaAmigos);
		
		assertTrue(circuloAmigos.contains(c1));
		assertEquals(circuloAmigos.size(),1);	
	}
	
	@Test
	public void test3 () {
		ArrayList<Pair<String,String>> listaAmigos = new ArrayList <Pair<String,String>> ();

		// Calculando círculos
		List <Set<String>> circuloAmigos = CirculoAmigos.retornaCirculos(listaAmigos);

		assertEquals(circuloAmigos.size(),0);	
	}
	
	@Test
	public void test4 () {
		ArrayList<Pair<String,String>> listaAmigos = new ArrayList<Pair<String,String>>();
		listaAmigos.add(new Pair<String, String>("a", "f"));
		listaAmigos.add(new Pair<String, String>("f", "h"));
		listaAmigos.add(new Pair<String, String>("h", "c"));
		listaAmigos.add(new Pair<String, String>("c", "j"));
		listaAmigos.add(new Pair<String, String>("j", "a"));
		
		Set <String> c1 = new HashSet<String>(); 
		c1.add("a"); 
		c1.add("f"); 
		c1.add("h"); 
		c1.add("c"); 
		c1.add("j");
		
		List <Set<String>> circuloAmigos = CirculoAmigos.retornaCirculos(listaAmigos);
		
		assertTrue(circuloAmigos.contains(c1));
		assertEquals(circuloAmigos.size(), 1);
	}
	
	@Test
	public void test5 () {
		ArrayList<Pair<String,String>> listaAmigos = new ArrayList<Pair<String,String>>();
		listaAmigos.add(new Pair<String, String>("A", "B"));
		listaAmigos.add(new Pair<String, String>("A", "C"));
		listaAmigos.add(new Pair<String, String>("A", "E"));
		listaAmigos.add(new Pair<String, String>("E", "F"));
		listaAmigos.add(new Pair<String, String>("F", "G"));
		listaAmigos.add(new Pair<String, String>("F", "H"));
		listaAmigos.add(new Pair<String, String>("F", "I"));
		listaAmigos.add(new Pair<String, String>("J", "K"));
		listaAmigos.add(new Pair<String, String>("K", "L"));
		
		Set<String> c1 = new HashSet<String>();
		Set<String> c2 = new HashSet<String>();
		
		c1.add("A");
		c1.add("B");
		c1.add("C");
		c1.add("E");
		c1.add("F");
		c1.add("G");
		c1.add("H");
		c1.add("I");
		c2.add("J");
		c2.add("K");
		c2.add("L");
		
		List <Set<String>> circuloAmigos = CirculoAmigos.retornaCirculos(listaAmigos);
		
		assertTrue(circuloAmigos.contains(c1));
		assertTrue(circuloAmigos.contains(c2));
		assertEquals(circuloAmigos.size(), 2);
	}
	
	@Test
	public void test6 () {
		ArrayList<Pair<String,String>> listaAmigos = new ArrayList<Pair<String,String>>();
		listaAmigos.add(new Pair<String, String>("A", "B"));
		listaAmigos.add(new Pair<String, String>("B", "C"));
		listaAmigos.add(new Pair<String, String>("D", "A"));
		listaAmigos.add(new Pair<String, String>("E", "F"));
		listaAmigos.add(new Pair<String, String>("B", "E"));
		listaAmigos.add(new Pair<String, String>("L", "M"));
		
		Set<String> c1 = new HashSet<String>();
		Set<String> c2 = new HashSet<String>();
		
		c1.add("A");
		c1.add("B");
		c1.add("C");
		c1.add("D");
		c1.add("E");
		c1.add("F");
		c2.add("L");
		c2.add("M");
		
		List <Set<String>> circuloAmigos = CirculoAmigos.retornaCirculos(listaAmigos);
		
		assertTrue(circuloAmigos.contains(c1));
		assertTrue(circuloAmigos.contains(c2));
		assertEquals(circuloAmigos.size(), 2);
	}
}

