package DataStructures;

/**
 * An interface for a Stack.
 * Specific stack implementations will implement this interface
 * for use in ITCS 2214 Data Structures and Algorithms
 * UNC Charlotte, 2016
 * @author clatulip
 * @param <T> - The data type of the objects being managed on this stack
 */
public interface StackADT<T> extends CollectionADT {
    
    /**
     * Adds the specified element to the top of the stack.
     * @param element element to be pushed onto the stack
     */
    public void push(T element);
    
    /**
     * Removes and returns the element that is on top of the stack.
     * @return the element removed from the stack
     * @throws EmptyCollectionException if no items on the stack
     */
    public T pop() throws EmptyCollectionException;
    
    /**
     * Returns (without removing) the element that is on top of the stack.
     * @return the element on top of the stack
     * @throws EmptyCollectionException if no items on the stack
     */
    public T peek()throws EmptyCollectionException;
    
}
