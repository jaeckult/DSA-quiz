public class Stack{
	static int max_size;
	static int top;
	static int[]num_array;
	 
	public Stack(int max_size) {
		num_array = new int[max_size];	
		max_size = 0;
		top = -1;
	}
	public int size() {
		return max_size;
	}
	public boolean isEmpty() {
		return max_size == 0;
	}
	public static boolean isFull() {
		return max_size == num_array.length;
	}
	public static void push(int item) {
		if (top <max_size - 1) {
			num_array[++top] = item;
			max_size++;
		}else
			System.out.println("the stack is full!");
	}
	public int pop() {
		if (num_array.length > 0) {
			max_size--;
			return num_array[top--];
		}
		return -1;
	}
	public static int peek() {
		if (isFull()) {
			return num_array[top];
		}
		return -1;
		
	}
	public static void main(String[] args) {
		Stack numStack = new Stack(5);
		numStack.push(11);
		numStack.push(22);
		numStack.push(33);
		numStack.push(44);
		numStack.push(55);
		numStack.pop();
		numStack.pop();
		for (int i = 0; i < numStack.max_size; i++) {
			System.out.println(numStack.num_array[i]);
		}
	}
}