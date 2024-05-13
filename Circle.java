import java.util.Scanner;

public class Circle{
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the number of elements: ");
		int input = scanner.nextInt();
		static []numbers = new int[input];
		System.out.println("enter the elements: ");
		for(int i = 0; i<input; i++) {
			numbers[i] = scanner.nextInt();
		}
		System.out.println("enter the number to be searched: ");
		int num = scanner.nextInt();
		int count=0;
		for(int k: numbers) {
			if(k==num)
				count++;
		}
		System.out.println("your number has been repeated: " + count+ " times.");
		
	}
	
}
	
	
	