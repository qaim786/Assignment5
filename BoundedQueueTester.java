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
 @Test
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

	// Passes when exception is thrown
    @Test 
    public void testGetException() {
        
		
		
    }

	// Happy Path (put at least one null)
    @Test
    public void testPutAll() {
        
		
		
    }

	// Passes when exception is thrown
    @Test 
    public void testPutAllException() {
    
	
	
    }

	// Happy Path
    @Test
    public void testGetAll() {
    
    
    }

	// Passes when exception is thrown
    @Test 
    public void testGetAllException() {

    }



	////////////////////////////
	//AF() toString Tests
	
	@Test
	// Test toString() when queue is empty
	public void toStringTestEmpty() {
		
	}

	// Test toString() when all elements are strings
	@Test
	public void toStringTestStrings() {
		
	}
	
	// Test toString() when all elements are doubles. 
	@Test
	public void toStringTestDoubles() {
		
	}

	// Test toString() when all elements are integers
	@Test
	public void toStringTestIntegers() {
		
	}
	

	// Test toString() when elements have mixed types (e.g., strings, doubles, integers)
	@Test
	public void toStringTestMixed() {
		
	}
}
