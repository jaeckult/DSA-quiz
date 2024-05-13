class Queue{

	Stack numstack1 = new Stack(5);
	Stack numstack2 = new Stack(5);

	public void enqueue(int value) {
		if (numstack1.isFull()) {
			throw new IllegalStateException("Queue is full. Cannot enqueue element " + value);
		}
		
		numstack1.push(value);
	}
	public int dequeue() {
		if (numstack2.isEmpty()) {
			while(!numstack1.isEmpty()) {
				numstack1.push(numstack2.pop());
			}
		}
		return numstack2.pop();
		
		
	}
	public int peek() {
		if (numstack2.isEmpty()) {
			numstack2.push(numstack1.pop());
			
		}
		return numstack2.peek();
	}
	public static void main(String args[]) {
		enqueue(5);
	}
}
