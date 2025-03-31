
public class testarray {

	public static void main(String[] args) {
		double[] arr = {1, 2, 3, 4, 5};
		double max = arr[0];
		for(double x : arr) {
			if (max < x) {
				max = x;
			}
			System.out.print(x + " ");
		}
		System.out.println();
		System.out.println("max: " + max);

	}

}
