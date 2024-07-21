import org.w3c.dom.Node;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        Node newNode = new Node(value);
        this.tail = this.head = newNode;
        this.length = 1;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(1);

        linkedList.append(2);
        linkedList.append(3);
        linkedList.prepend(0);

//        linkedList.printList(linkedList);

//        System.out.println("\n" + linkedList.removeLast().value);
//        linkedList.printList(linkedList);
//        System.out.println("\n" + linkedList.removeLast().value);
//        linkedList.printList(linkedList);

//        System.out.println("\n" + linkedList.removeFirst().value);
//        linkedList.printList(linkedList);

//        System.out.println("\n" + linkedList.get(2).value);

//        linkedList.set(3, 4);
//        linkedList.printList(linkedList);

//        linkedList.insert(4, 4);
//        linkedList.printList(linkedList);

//        linkedList.remove(1);
//        linkedList.printList(linkedList);

        linkedList.reverse(linkedList);
        linkedList.printList(linkedList);
    }

    private void reverse(LinkedList linkedList) {
        Node prev, curr, next;
        curr = linkedList.head;
        next = curr.next;
        prev = null;

        curr.next = null;
        while(next != null) {
            prev = curr;
            curr = next;
            next = curr.next;
            curr.next = prev;
        }
        linkedList.head = curr;
    }

    private boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }

        return false;
    }

    private void printList(LinkedList linkedList) {
        Node temp = linkedList.head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }

    private void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    private void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    private boolean insert(int index, int value) {
        if (index < 0 || index > length) {
            return false;
        } else if (index == 0) {
            prepend(value);
            return true;
        } else if (index == length) {
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node temp = get(index - 1);

        newNode.next = temp.next;
        temp.next = newNode;
        length++;

        return true;
    }

    private Node removeLast() {
        if (length == 0) {
            return null;
        }

        int value = tail.value;
        Node temp = head;
        Node pre = head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;

        return temp;
    }

    private Node removeFirst() {
        if (length == 0) {
            return null;
        }

        Node temp = head;
        head = head.next;
        temp.next = null; // optional
        length--;

        return temp;
    }

    private Node remove(int index) {
        if (index < 0 || index >= length) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == length - 1) {
            return removeLast();
        }

        Node prev = get(index - 1);
        Node temp = get(index);

        prev.next = temp.next;
        temp.next = null; // optional
        length--;

        return temp;
    }

    private Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }


}