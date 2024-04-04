package TechnicalTrain;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class Exp_6 {
    public static void preOrder(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.val + " ");

        preOrder(root.left);
        preOrder(root.right);
    }

    public static TreeNode createBinaryTree(List<Integer> arr) {
        if (arr.isEmpty())
            return null;

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(arr.get(0));
        q.add(root);

        for (int i = 1; i < arr.size(); i += 2) {
            TreeNode current = q.poll();

            if (arr.get(i) != -1) {
                current.left = new TreeNode(arr.get(i));
                q.add(current.left);
            }

            if (i + 1 < arr.size() && arr.get(i + 1) != -1) {
                current.right = new TreeNode(arr.get(i + 1));
                q.add(current.right);
            }
        }

        return root;
    }

    public static void deleteBinaryTree(TreeNode root) {
        if (root == null)
            return;

        deleteBinaryTree(root.left);
        deleteBinaryTree(root.right);
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, -1, 4, 5, 6, -1, -1, 7, 8);

        TreeNode root = createBinaryTree(arr);

        System.out.print("Preorder Traversal: ");
        preOrder(root);
        System.out.println();
    }
}
