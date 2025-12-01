import java.util.Stack;

public class AdvanceStack<T> extends Stack<T> {

    // View the second-to-last item (from the top of the stack) without removing it
    public T peekSecondLast() {
        if (this.size() < 2) {
            return null;
        }
        // Last index = size() - 1
        // Second-to-last index = size() - 2
        return this.get(this.size() - 2);
    }

    // Add item to the bottom of the stack without changing the order of other elements
    public void insertAtBottom(T item) {
        if (this.isEmpty()) {
            // If the stack is empty, this item becomes both the bottom and top
            this.push(item);
            return;
        }

        // Remove one element from the top
        T top = this.pop();

        // Recursively insert the item to the bottom of the stack
        insertAtBottom(item);

        // Now push the removed element back onto the stack
        this.push(top);
    }
}
