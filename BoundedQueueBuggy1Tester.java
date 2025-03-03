import org.junit.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import static org.junit.Assume.*;


import java.lang.Iterable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class BoundedQueueBuggy1Tester {

	// Buggy1
    @Test 
    public void testBuggy1() {
		BoundedQueueBuggy1<Integer> queue = new BoundedQueueBuggy1<>(3);
		queue.put(1);
        queue.put(null); 
        queue.put(2);
        assertEquals(3, queue.getCount()); 
        assertTrue(queue.repOk());
		
	}

}
