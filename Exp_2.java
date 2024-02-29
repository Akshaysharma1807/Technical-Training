package TechnicalTrain;
import java.util.*;
public class Exp_2 {
	public static void shift(int arr[], int d) {
		int arr1[]=new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			int ni=(i+arr.length-d)%arr.length;
			arr1[ni]=arr[i];
		}
		for(int i=0;i<arr.length;i++) {
			arr[i]=arr1[i];
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Size of an array: ");
		int arr[] = new int[sc.nextInt()];
		
		System.out.println();
		
		System.out.print("Enter Elements: ");
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextInt();
		}
		
		System.out.print("Shift it to the left by ");
		int d = sc.nextInt();
		
		shift(arr,d);
		
		System.out.print("Shifted Elements: ");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
