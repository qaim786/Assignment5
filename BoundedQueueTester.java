import org.junit.*;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import static org.junit.Assume.*;


import java.lang.Iterable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

// done by Qaim
public class BoundedQueueTester {

	// Happy Path
 @Test
    public void testEmptyQueue() {
        BoundedQueue<String> queue = new BoundedQueue<>(5);
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());
        assertEquals(0, queue.getCount());
        assertTrue(queue.repOk());
    }

	// Happy Path
 @Test
    public void testFullQueue() {
        BoundedQueue<Integer> queue = new BoundedQueue<>(3);
        queue.put(1);
        queue.put(2);
        queue.put(3);
        assertTrue(queue.isFull());
        assertFalse(queue.isEmpty());
        assertEquals(3, queue.getCount());
        assertTrue(queue.repOk());
    }

	// Happy Path (put at least one null)
 @Test
    public void testPut() {
        BoundedQueue<String> queue = new BoundedQueue<>(3);
        queue.put("CS");
        queue.put(null); 
        queue.put("419");
        assertEquals(2, queue.getCount()); 
        assertTrue(queue.repOk());
    }

	// Passes when exception is thrown
 @Test(expected = IllegalStateException.class)
    public void testPutException() {
        BoundedQueue<Integer> queue = new BoundedQueue<>(3);
        queue.put(1);
        queue.put(2);
        queue.put(3);
	queue.put(4);
    }

	
	// Happy Path
@Test
   public void testGet() {
        BoundedQueue<String> queue = new BoundedQueue<>(3);
        queue.put("CS");
        queue.put("419");
        assertEquals("CS", queue.get());
        assertEquals(1, queue.getCount());
        assertTrue(queue.repOk());
    }

    //Tests written by Smita
	// Passes when exception is thrown
    @Test(expected = IllegalStateException.class) 
    public void testGetException() {
        BoundedQueue<String> queue = new BoundedQueue<>(1);
        queue.get();
        queue.get();
        assertTrue(queue.repOk());
		
		
    }

	// Happy Path (put at least one null)
    @Test
    public void testPutAll() {
        BoundedQueue<String> queue = new BoundedQueue<>(3);
        List<String> source = new ArrayList<>();
        source.add("one");
        source.add(null);
        source.add("two");
        queue.putall(source);
        //should not add null to the list
        assertEquals(2,queue.getCount());
        assertEquals("BoundedQueue: [one, two]",queue.toString());
        assertTrue(queue.repOk());

        
		
		
    }

	// Passes when exception is thrown
    @Test(expected = IllegalStateException.class)
    public void testPutAllException() {
        BoundedQueue<String> queue = new BoundedQueue<>(1);
        List<String> source = new ArrayList<>();
        source.add("one");
        source.add(null);
        source.add("two");
        queue.putall(source);
        assertTrue(queue.repOk());
        //should not add null to the list
        //assertEquals(2,queue.getCount());
    
	
	
    }

	// Happy Path
    @Test
    public void testGetAll() {
        BoundedQueue<String> queue = new BoundedQueue<>(3);
        Collection<String> destination = new ArrayList<>();
        queue.put("one");
        queue.put("two");;
        queue.put("three");
        queue.getall(destination);
        assertEquals(3,destination.size());
        assertTrue(destination.contains("one"));
        assertTrue(destination.contains("two"));
        assertTrue(destination.contains("three"));
        assertTrue(queue.isEmpty());
        assertTrue(queue.repOk());


    
    
    }

	// Passes when exception is thrown
    @Test(expected = IllegalStateException.class) 
    public void testGetAllException() {
        BoundedQueue<String> queue = new BoundedQueue<>(3);
        Collection<String> destination = new ArrayList<>();
        queue.getall(destination);
        assertTrue(queue.repOk());

    }



	////////////////////////////
	//AF() toString Tests
	
	@Test
	// Test toString() when queue is empty
	public void toStringTestEmpty() {
        BoundedQueue<String> queue = new BoundedQueue<>(3);
        assertEquals("BoundedQueue: []",queue.toString() );
        assertTrue(queue.repOk());
		
	}

	// Test toString() when all elements are strings
	@Test
	public void toStringTestStrings() {
        BoundedQueue<String> queue = new BoundedQueue<>(3);
        queue.put("one");
        queue.put("two");;
        queue.put("three");
        assertEquals("BoundedQueue: [one, two, three]",queue.toString() );
        assertTrue(queue.repOk());


		
	}
	
	// Test toString() when all elements are doubles. 
	@Test
	public void toStringTestDoubles() {
        BoundedQueue<Double> queue = new BoundedQueue<>(3);
        queue.put(1.1);
        queue.put(2.2);;
        queue.put(3.3);
        assertEquals("BoundedQueue: [1.1, 2.2, 3.3]",queue.toString() );
        assertTrue(queue.repOk());
		
	}

	// Test toString() when all elements are integers
	@Test
	public void toStringTestIntegers() {
        BoundedQueue<Integer> queue = new BoundedQueue<>(3);
        queue.put(1);
        queue.put(2);
        queue.put(3);
        assertEquals("BoundedQueue: [1, 2, 3]",queue.toString() );
        assertTrue(queue.repOk());

		
	}
	

	// Test toString() when elements have mixed types (e.g., strings, doubles, integers)
	@Test
	public void toStringTestMixed() {
        BoundedQueue<Object> queue = new BoundedQueue<>(3);
        queue.put("one");
        queue.put(2.2);
        queue.put(3);
        assertEquals("BoundedQueue: [one, 2.2, 3]",queue.toString() );
        assertTrue(queue.repOk());

		
	}
}
