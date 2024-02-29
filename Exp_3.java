package TechnicalTrain;
import java.util.Scanner;
import java.util.Stack;

public class Exp_3 {

    public static int equalStacks(int[] h1, int[] h2, int[] h3) {
        Stack<Integer> stack1 = createStack(h1);
        Stack<Integer> stack2 = createStack(h2);
        Stack<Integer> stack3 = createStack(h3);

        int height1 = calculateHeight(stack1);
        int height2 = calculateHeight(stack2);
        int height3 = calculateHeight(stack3);

        while (!isEmpty(stack1) && !isEmpty(stack2) && !isEmpty(stack3)) {
            int minHeight = Math.min(height1, Math.min(height2, height3));

            
            while (height1 > minHeight) {
                height1 -= stack1.pop();
            }
            while (height2 > minHeight) {
                height2 -= stack2.pop();
            }
            while (height3 > minHeight) {
                height3 -= stack3.pop();
            }

            if (height1 == height2 && height2 == height3) {
                return height1;
            }
        }
        return 0; // If stacks cannot be made equal
    }

    private static Stack<Integer> createStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            stack.push(arr[i]);
        }
        return stack;
    }

    private static int calculateHeight(Stack<Integer> stack) {
        int height = 0;
        for (int cylinder : stack) {
            height += cylinder;
        }
        return height;
    }

    private static boolean isEmpty(Stack<Integer> stack) {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();

        int[] h1 = new int[n1];
        int[] h2 = new int[n2];
        int[] h3 = new int[n3];

        for (int i = 0; i < n1; i++) {
            h1[i] = scanner.nextInt();
        }
        for (int i = 0; i < n2; i++) {
            h2[i] = scanner.nextInt();
        }
        for (int i = 0; i < n3; i++) {
            h3[i] = scanner.nextInt();
        }

        int result = equalStacks(h1, h2, h3);
        System.out.println("Maximum possible common height: " + result);
    }
}