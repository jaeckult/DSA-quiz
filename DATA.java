
public class DATA {
	public static int[] delete(int[]arr, int index) {
		int[] newArray = new int[arr.length - 1];

		int newIndex = 0;
		if (index > arr.length || index<arr.length)
			return arr;
		for (int i = 0; i<arr.length;  i++) {
			
			if (i != index)
				newArray[newIndex++] = arr[i];
		}
		return newArray;
	}

	public static void main(String[] args) {
	    int[]array = {1, 2, 3, 4, 5};
		System.out.println(delete(array, 3));

	}
}





