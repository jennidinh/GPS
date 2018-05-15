import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

public class PriorityQueueTest {
	
	PriorityQueue <Integer> pq;
	
	@Before
	public void setUp() {
	
	pq = new PriorityQueue<Integer>();
	}
	
	@Test
	public void testAdd() {
		pq = new PriorityQueue<Integer>();
		assertEquals("Checks if it's added", true, pq.add(10)); // TODO
		assertEquals("Checks if it's added", true, pq.add(20)); // TODO
		assertEquals("Checks if it's added", true, pq.add(30)); // TODO
		assertEquals("Checks if it's added", true, pq.add(40)); // TODO
		
	}

	@Test
	public void testRemove() {
		pq = new PriorityQueue<Integer>();
		
	
		
		
		pq.add(10); 
		pq.add(30);

		assertEquals("Checks if it's removed", 10 , (int) pq.remove()); // TODO
		
		assertEquals("Checks if it's removed", 30 , (int) pq.remove()); // TODO
		
	
	}

	@Test
	public void testIsEmpty() {
		pq = new PriorityQueue<Integer>();
		assertEquals("Not yet implemented", true , pq.isEmpty()); // TODO

		pq.add(30);
		pq.add(40);
		pq.add(50);
		assertEquals("Not yet implemented", false , pq.isEmpty()); // TODO

		pq.remove();
		pq.remove();
		pq.remove();
		assertEquals("Not yet implemented", true , pq.isEmpty()); // TODO

		
		
		
		
		
	}

	@Test
	public void testFindMin() {
		pq = new PriorityQueue<Integer>();

		pq.add(10);
		pq.add(20);
		assertEquals("Not yet implemented", 10 , (int)pq.findMin()); // TODO
	}

}
