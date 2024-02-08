/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Maze_DS;

import DataStructures.EmptyCollectionException;
import DataStructures.StackADT;
import java.util.ArrayList;

/**
 * An implementation of a stack using an ArrayList
 *@author mahmood
 * @param <T> The type of elements that the stack contains
 */
public class ArrayListStack<T> implements StackADT<T> {

    private ArrayList<T> myStack;
    private int counter;

    

    /**
     * Constructs a new ArrayListStack with an empty stack and initializes the
     * counter to 0.
     */
    public ArrayListStack() {
        myStack = new ArrayList<>();
        counter = 0;
    }

    /**
     * Pushes an element onto the top of the stack.
     *
     * @param element The element to be pushed onto the stack.
     */
    @Override
    public void push(T element) {
        this.myStack.add(element);
        counter++;
    }

    /**
     * Removes and returns the element at the top of the stack
     *
     * @return The element at the top of the stack
     * @throws EmptyCollectionException if the stack is empty
     */
    @Override
    public T pop()throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack is empty.");
        }
        // Remove the element at the current top (counter - 1) of the stack
        T pop = this.myStack.remove(counter - 1);
        counter--;
        return pop;
    }

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return The element at the top of the stack.
     * @throws EmptyCollectionException if the stack is empty.
     */
    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack is empty.");
        }
        // Get the element at the current top (counter - 1) of the stack
        T peek = this.myStack.get(counter - 1);
        return peek;
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        // If counter is 0, the stack is empty; otherwise, it's not
        return counter == 0;
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return The number of elements in the stack.
     */
    @Override
    public int size() {
        return counter;
    }

    /**
     *
     * @return a string
     */
    @Override
    public String toString() {
        return "ArrayListStack{" + "myStack=" + myStack + ", counter=" + counter + '}';
    }

    /**
     *
     * @return counter as a int
     */
    public int getCounter() {
        return counter;
    }
}
