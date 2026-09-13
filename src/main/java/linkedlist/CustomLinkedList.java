package linkedlist;

public class CustomLinkedList {
    private static class Node {
        String info;
        Node next;

        public Node(String info) {
            this.info = info;
            this.next = null;
        }
    }

    private Node head;

    public void add(String info) {
        Node newNode = new Node(info);

        if(head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    static void main() {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.add("10");
        customLinkedList.add("20");
        customLinkedList.add("30");
        customLinkedList.add("40");
        customLinkedList.add("50");
        customLinkedList.add("60");
        customLinkedList.add("70");
        customLinkedList.add("80");
        customLinkedList.add("90");
        customLinkedList.add("100");
        System.out.println(customLinkedList.getNthFromLast(6));
    }

    public String getNthFromLast(int n) {
        if (head == null || n <= 0) return "-1";


        Node mainPtr = head;
        Node refPtr = head;

        // Move refPtr forward by n nodes
        for (int i = 0; i < n; i++) {
            if (refPtr == null) {
                System.out.println("n is larger than the number of nodes in the list.");
                return "-1";
            }
            refPtr = refPtr.next;
        }

        // Move both pointers together until refPtr reaches the end
        while (refPtr != null) {
            mainPtr = mainPtr.next;
            refPtr = refPtr.next;
        }

        // mainPtr now points to the n-th node from the end
        return mainPtr.info;
    }
}
