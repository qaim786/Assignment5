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

// buggy test Oscar
public class BoundedQueueBuggy2Tester {

  private BoundedQueueBuggy2<String> qBuggy2;


  @Before
  public void setup() {
    qBuggy2 = new BoundedQueueBuggy2<>(3);
  }
	
  // expecting IllegalStateException because # of items > capacity
	@Test(expected = IllegalStateException.class)
  public void test1() {
    qBuggy2.put("dog");
    qBuggy2.put("cat");
    qBuggy2.put("snake");
    qBuggy2.put("cow"); // throw exception > capacity

    assertTrue(qBuggy2.repOk());
   
      
		
		
		
		
		
		
	
    }

    // should only be dog, cat, snake in toString()
    @Test
    public void test2() {
      qBuggy2.put("dog");
      qBuggy2.put("cat");
      qBuggy2.put("snake");
      qBuggy2.put("cow");
      System.out.println(qBuggy2);
      assertEquals("BoundedQueueBuggy1: [dog, cat, snake]",qBuggy2.toString());
      assertTrue(qBuggy2.repOk());


    }

}