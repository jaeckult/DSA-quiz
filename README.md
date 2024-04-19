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


public class CircularQueueWithArrays {
    private int[] queue;
    private int front;
    private int rear;
    private int maxSize;

    public CircularQueueWithArrays(int maxSize) {
        this.maxSize = maxSize;
        queue = new int[maxSize];
        front = 0;
        rear = -1;
    }

    public boolean isEmpty() {
        return rear == front - 1 || (front == 0 && rear == maxSize - 1);
    }

    public boolean isFull() {
        return (rear == maxSize - 1 && front == 0) || (rear == front - 1);
    }

    public void enqueue(int value) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full. Cannot enqueue element " + value);
        }
        if (rear == maxSize - 1 && front != 0) {
            rear = -1; // Wrap around
        }
        queue[++rear] = value;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. Cannot dequeue.");
        }
        int frontValue = queue[front++];
        if (front == maxSize) {
            front = 0; // Wrap around
        }
        return frontValue;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. Cannot peek.");
        }
        return queue[front];
    }

    public static void main(String[] args) {
        CircularQueueWithArrays numQueue = new CircularQueueWithArrays(5);
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


public class Sort {
    private int[] numbers;
    private int front;
    private int rear;
    private int nItems;
    private int maxSize;

    public Sort(int maxSize) {
        this.maxSize = maxSize;
        numbers = new int[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == maxSize;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. Cannot peek.");
        }
        return numbers[front];
    }

    public void enqueue(int value) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full. Cannot enqueue element " + value);
        }
        numbers[++rear] = value;
        nItems++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. Cannot dequeue.");
        }
        int frontValue = numbers[front++];
        nItems--;
        return frontValue;
    }

    public static void main(String[] args) {
        Sort numQueue = new Sort(5);
        numQueue.enqueue(11);
        numQueue.enqueue(22);
        numQueue.enqueue(33);
        numQueue.enqueue(44);
        numQueue.enqueue(55);
        
        numQueue.dequeue();
        numQueue.dequeue();
        System.out.println("Front element: " + numQueue.peek());
        System.out.println("Size of the queue: " + numQueue.nItems);
        // Printing all elements in the queue
        while (!numQueue.isEmpty()) {
            System.out.println(numQueue.dequeue());
        }
    }
}

