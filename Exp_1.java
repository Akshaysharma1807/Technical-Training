package TechnicalTrain;
import java.util.*;
public class Exp_1 {
	public static void revereseArray(int arr[]) {
		int start = 0;
		int end = arr.length-1;
		while(start<end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of an array: ");
		int arr[] = new int[sc.nextInt()];
		System.out.println("Enter the Elements: ");
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println();
		revereseArray(arr);
		System.out.print("Reversed Array: ");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}