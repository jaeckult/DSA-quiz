import java.util.Stack;

public class LinearQueueWithStack {
    private Stack<Integer> enqueueStack;
    private Stack<Integer> dequeueStack;

    public LinearQueueWithStack() {
        enqueueStack = new Stack<Integer>();
        dequeueStack = new Stack<Integer>();
    }

    public void enqueue(int value) {
        enqueueStack.push(value); // Push the element to the enqueue stack
    }

    public int dequeue() {
        if (dequeueStack.isEmpty()) {
            if (enqueueStack.isEmpty()) {
                throw new IllegalStateException("Queue is empty. Cannot dequeue.");
            }
            // Transfer elements from enqueue stack to dequeue stack to reverse the order
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
        return dequeueStack.pop(); // Pop the front element from the dequeue stack
    }

    public boolean isEmpty() {
        return enqueueStack.isEmpty() && dequeueStack.isEmpty();
    }

    public boolean isFull() {
        // Since a stack can grow dynamically, we won't encounter a full condition
        return false;
    }

    public int peek() {
        if (dequeueStack.isEmpty()) {
            if (enqueueStack.isEmpty()) {
                throw new IllegalStateException("Queue is empty. Cannot peek.");
            }
            // Transfer elements from enqueue stack to dequeue stack to reverse the order
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
        return dequeueStack.peek(); // Peek at the front element of the dequeue stack
    }

    public static void main(String[] args) {
        LinearQueueWithStack numQueue = new LinearQueueWithStack();
        numQueue.enqueue(11);
        numQueue.enqueue(22);
        numQueue.enqueue(33);
        numQueue.enqueue(44);

        System.out.println("Dequeued element: " + numQueue.dequeue());
        System.out.println("Dequeued element: " + numQueue.dequeue());

        System.out.println("Is queue empty? " + numQueue.isEmpty());
        System.out.println("Peeked element: " + numQueue.peek());
    }
}
