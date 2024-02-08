/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Maze_DS;

import DataStructures.EmptyCollectionException;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the ArrayListStack class.
 * @author mahmood
 */
public class ArrayListStackTest {
    
    public ArrayListStackTest() {
    }

    /**
     * Test the push method.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        String element = "object";
        ArrayListStack instance = new ArrayListStack();
        assertTrue(instance.isEmpty()); // The stack should be empty initially
       
        instance.push(element); // Push an element onto the stack

        // Check if the counter is incremented and peek returns the pushed element
        assertEquals(1, instance.getCounter());
        try {
            assertEquals("object", instance.peek()); // Verify the top element is as expected
        } catch (EmptyCollectionException e) {
            fail("Unexpected EmptyCollectionException");
        }
    }

    /**
     * Test the pop method.
     */
    @Test
    public void testPop()  {
        System.out.println("pop");
        ArrayListStack instance = new ArrayListStack();
        assertTrue(instance.isEmpty()); // The stack should be empty initially
        
        try {
            instance.pop(); // Attempt to pop from an empty stack
            fail("Expected exception, but it wasn't thrown");
        } catch (EmptyCollectionException e) {
            e.getMessage();
        }
        
        String element = "object";
        instance.push(element);
        assertEquals(1, instance.getCounter());

        try {
            Object pop = instance.pop(); // Pop an element from the stack
            assertEquals(element, pop); // Verify the popped element is as expected
        } catch (EmptyCollectionException ex) {
            fail("Unexpected EmptyCollectionException");
        }
        
        assertTrue(instance.isEmpty()); // The stack should be empty after popping
    }
    
    /**
     * Test the peek method.
     */
    @Test
    public void testPeek()  {
        System.out.println("peek");
        ArrayListStack instance = new ArrayListStack();
        assertTrue(instance.isEmpty()); // The stack should be empty initially
        String element = "object";
        
        try {
            instance.peek(); // Attempt to peek into an empty stack
            fail("Expected exception, but it wasn't thrown");
        } catch (EmptyCollectionException e) {
            e.getMessage();
        }
        
        instance.push(element); // Push an element onto the stack
        assertEquals(1, instance.getCounter());

        try {
            assertEquals(element, instance.peek()); // Verify peek returns the top element
        } catch (EmptyCollectionException ex) {
            fail("Unexpected EmptyCollectionException");
        }
    }

    /**
     * Test the isEmpty method.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        ArrayListStack instance = new ArrayListStack();
        assertTrue(instance.isEmpty()); // The stack should be empty initially

        String element = "Object";
        instance.push(element); // Push an element onto the stack
        assertFalse(instance.isEmpty()); // The stack should not be empty after pushing
    }
        
    /**
     * Test the size method.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        ArrayListStack instance = new ArrayListStack();
        int expResult = 0;
        assertEquals(expResult, instance.getCounter()); // The counter should be 0 initially
        
        String element = "object";
        instance.push(element);
        expResult++;
        assertEquals(expResult, instance.getCounter()); // The counter should be 1 after pushing
        
        String pushing = "pushing";
        instance.push(pushing);
        expResult++;
        assertEquals(expResult, instance.getCounter()); // The counter should be 2 after pushing
        
        try {
            instance.pop();
            expResult--;
            assertEquals(expResult, instance.getCounter()); // The counter should be 1 after popping
        } catch (EmptyCollectionException ex) {
        }
    }
}
