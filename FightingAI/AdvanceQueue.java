import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.List;

public class AdvanceQueue<T> extends PriorityQueue<T> {

    // Allow viewing the next item without removing it
    public T peekNext() {
        // PriorityQueue.peek() returns null if the queue is empty
        return this.peek();
    }

    // Add item to the "start" of the queue
    public void insertAtStart(T item) {
        // If the queue is empty, just add is sufficient
        if (this.isEmpty()) {
            this.add(item);
            return;
        }

        // Temporarily transfer all elements to a list
        List<T> temp = new ArrayList<>();
        while (!this.isEmpty()) {
            temp.add(this.poll());
        }

        // First, add the new item
        this.add(item);

        // Then, re-insert the previous elements back into the queue
        for (T element : temp) {
            this.add(element);
        }
    }
}
