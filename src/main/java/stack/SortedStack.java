package stack;

import java.util.Stack;
import java.util.EmptyStackException;

public class SortedStack {
    // The main stack that always maintains elements in sorted order
    private final Stack<Integer> mainStack;
    // An auxiliary stack used to re-arrange elements during push operations
    private final Stack<Integer> tempStack;

    public SortedStack() {
        this.mainStack = new Stack<>();
        this.tempStack = new Stack<>();
    }

    /**
     * Pushes an element onto the stack while maintaining sorted order.
     * Time Complexity: O(N) where N is the number of elements currently in the stack.
     */
    public void push(int val) {
        // Move elements from mainStack to tempStack if they are smaller than val
        // (Change '<' to '>' if you want ascending order instead of descending)
        while (!mainStack.isEmpty() && mainStack.peek() < val) {
            tempStack.push(mainStack.pop());
        }

        // Place the new value into its correct sorted position
        mainStack.push(val);

        // Move the temporarily displaced elements back to the main stack
        while (!tempStack.isEmpty()) {
            mainStack.push(tempStack.pop());
        }
    }

    /**
     * Removes and returns the top element from the sorted stack.
     * Time Complexity: O(1)
     */
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return mainStack.pop();
    }

    /**
     * Returns the top element of the sorted stack without removing it.
     * Time Complexity: O(1)
     */
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return mainStack.peek();
    }

    /**
     * Checks if the stack is empty.
     * Time Complexity: O(1)
     */
    public boolean isEmpty() {
        return mainStack.isEmpty();
    }

    // Driver code to test the behavior
    public static void main(String[] args) {
        SortedStack sortedStack = new SortedStack();

        // Pushing elements in an unsorted fashion
        sortedStack.push(30);
        sortedStack.push(10);
        sortedStack.push(50);
        sortedStack.push(20);

        System.out.println("Popping elements one by one (Guaranteed sorted order):");
        while (!sortedStack.isEmpty()) {
            // Each pop operation executes instantly in O(1)
            System.out.print(sortedStack.pop() + " ");
        }
        // Output: 50 30 20 10
    }
}