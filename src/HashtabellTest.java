import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class HashtabellTest {
	
	Hashtabell ht;
	
	@Before
	void setup() {
		System.out.println("hej");
		ht = new Hashtabell(10); 
	}
	

	@Test
	void addTest() {
		Hashtabell ht = new Hashtabell(10);
		ht.add(new Node("a"));	
		
		
		assertEquals("checks if ht is", 1, ht.size());
	}
	
	@Test
	void findTest() {
		Hashtabell ht = new Hashtabell(10);
		assertEquals("Find null", null, ht.find("hejsan"));
		Node n = new Node("h");
		ht.add(n);
		assertEquals("Find node", n , ht.find("h"));
	}
	
	@Test
	void sizeTest() {
		Hashtabell ht = new Hashtabell(10);
		assertEquals("checks if Hashtable is Empty", 0, ht.size());
		Node n = new Node("a");
		Node n2 = new Node("b");
		ht.add(n);
		ht.add(n2);
		assertEquals("checks Hashtable size", 2, ht.size());
		
	}
	
	
}
