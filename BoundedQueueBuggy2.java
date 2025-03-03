import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
/*
 * The bug is not checking the list if full in put()
 * By oscar
 */
public class BoundedQueueBuggy2<E> {
    protected List<E> list;
    protected int capacity = 0;

    // REQUIRES: true
 	// MODIFIES: this
 	// EFFECTS: Basic constructor: if capacity <= 0, throws IllegalArgumentException;
 	//          else sets the BoundedQueue object’s ‘capacity’ with capacity, and assigns ‘list’ to be an
    //          empty ArrayList with the given capacity

    public BoundedQueueBuggy2(int capacity) {
    	// Does not make sense to have a 0-capacity Queue - cannot do anything useful with it
    	if (capacity <= 0) throw new IllegalArgumentException("BoundedQueueBuggy1 constructor");
        this.capacity = capacity;
        list = new ArrayList<E>(capacity);
    }
    
	

	// Rep-invariant: 
	//		list != null and list.size() <= capacity
	// 		for any index i such that 0 <= i < list.size(), list.get(i) != null	
	//
	boolean repOk() {
	    if (list == null) {
	        return false;
	    }
	    
	    if (list.size() > capacity) {
	        return false;
	    }
	    
	    for (int i = 0; i < list.size(); i++) {
	        if (list.get(i) == null) {
	            return false;
	        }
	    }
	    
		return true;
	}
	   
   
    // AF(this) = "BoundedQueue: [list.get(0), list.get(1), list.get(2),..., list.get(list.size()-1)]" 
	//
	// REQUIRES: true
    // EFFECTS: Returns a String representation of the BoundedQueue object,
	// consisting of the class name followed by each of the String representations
	// of the contained objects wrapped in square brackets.
	// Example: A BoundedQueue object whose elements are an Integer 42, a
	// String "Oh no, not again", and a generic Object with hash code
	// <hash code> would return:
	// "BoundedQueue: [42, 'Oh no, not again', java.lang.Object@<hash code>]".
	public String toString() {
	    StringBuilder sb = new StringBuilder("BoundedQueueBuggy1: [");
	    for (int i = 0; i < list.size(); i++) {
	        sb.append(list.get(i));
	        if (i < list.size() - 1) {
	            sb.append(", ");
	        }
	    }
	    sb.append("]");
	    return sb.toString();
	}
	    
    // REQUIRES: true
 	// EFFECTS: returns true if there are no elements in the queue; else returns false
    public boolean isEmpty() { return (list.size() == 0); }

    // REQUIRES: true
 	// EFFECTS: returns true if the number of elements in the queue is equal to the capacity of the 
    // BoundedQueue object; else returns false
    public boolean isFull() { return (list.size() == capacity); }

	// REQUIRES: true
	// EFFECTS: returns the number of elements in the queue
    public int getCount() { return list.size(); }

	// REQUIRES: true
	// MODIFIES: this
	// EFFECTS: if the BoundedQueue is full, throws IllegalStateException;
	//                   else adds e to the end of the queue 
    public void put(E e) { 
    	//if (isFull()) throw new IllegalStateException("BoundedQueue.put"); // BUG
		if (e == null) return;
        list.add(e);
    }
    
	// REQUIRES: true
	// MODIFIES: this
	// EFFECTS: if there's not enough capacity in the BoundedQueue, throws IllegalStateException;
	//          else adds each element from src in order to the end of the queue
    public void putall(Iterable<? extends E> src) {
    	if (!capacitySupports(src)) throw new IllegalStateException("BoundedQueue.putall");
    	for (E e : src) {
			if (e == null) continue;
    		put(e);
    	}
    }
    
	// REQUIRES: true
	// EFFECTS: Returns true if queue has sufficient remaining capacity to hold the elements of src;  
    //          else returns false 
    private boolean capacitySupports(Iterable<? extends E> src) {
    	int projectedCapacity = getCount();
    	Iterator<? extends E> itr = src.iterator();
    	while(itr.hasNext()) {
    		projectedCapacity++;
    		if (projectedCapacity > this.capacity) return false;
    		itr.next();
    	}
    	return true;
    }

	// REQUIRES: true
	// MODIFIES: this
	// EFFECTS: if the BoundedQueue is empty, throws IllegalStateException;
	//          else removes and returns the first element of the queue
    public E get() { 
    	if (isEmpty()) throw new IllegalStateException("BoundedQueue.get"); 
        return list.remove(0);
    }
    
	// REQUIRES: true
	// MODIFIES: dest, this
	// EFFECTS: if the BoundedQueue is empty, throws IllegalStateException;
	//          else removes all the elements from the queue and adds them in order to ‘dest’
    public void getall(Collection<? super E> dest) {
    	if (isEmpty()) throw new IllegalStateException("BoundedQueue.getall");
    	while(!isEmpty()) {
    		dest.add(this.get());
    	}
    }
    
}
