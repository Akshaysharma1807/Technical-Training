package TechnicalTrain;
import java.util.Scanner;
class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    SinglyLinkedListNode(int node_data) {
        this.data = node_data;
        this.next = null;
    }
}
public class Exp_4 {
    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

        if (llist == null) {
            return newNode;
        } else {
            newNode.next = llist;
            return newNode;
        }
    }
    static void printLinkedList(SinglyLinkedListNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements to be inserted at the head: ");
        int n = scanner.nextInt();
        SinglyLinkedListNode head = null;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the element to be inserted: ");
            int data = scanner.nextInt();
            head = insertNodeAtHead(head, data);
        }
        System.out.print("Linked List after insertion: ");
        printLinkedList(head);
        scanner.close();
    }
}
