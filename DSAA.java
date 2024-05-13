public class DSAA{
	public static void bubblsort(char[] bubble) {
		for(int i = bubble.length - 1; i >= 0; i--) {
			for(int j = 0; j < i; j++) {
				//do swap adjacent files after comparison
				if(bubble[j] > bubble[j + 1]) {
					char temp = bubble[j];
					bubble[j] = bubble[j + 1];
					bubble[j + 1] = temp;
					
				}
			}
		}
		
	}
	public static void main(String args[]) {
		bubblsort({a,b,c});
	}
	
}