public class Stack {

    private int size;
    //private Node first;
    private Node last;

    private int min;

    public static void main(String[] args) {
        // push, pop, min O(1)
        Stack myStack = new Stack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());

    }

    private void push(int number) {
        if (size == 0) {
            Node node = new Node(number);
            last = node;
            min = number;
        } else {
            Node node = new Node(number);
            node.lptr = last;
            last.rptr = node;
            last = node;

            if(min > number) {
                min = number;
            }
        }
        size++;
    }

    private int pop() {
        int number = 0;
        if (size == 0) {
            min = -1;
            System.out.println("myStack is empty.");
            return -1;
        } else {
            number = last.number;
            last.rptr = null;
            last = last.lptr;
            size--;

            if(min == number) {

            }
        }

        return number;
    }

    private int min() {
        if (size == 0) {
            System.out.println("myStack is empty.");
            return -1;
        }

        return min;
    }

    static class Node {
        private int number;
        private Node lptr;
        private Node rptr;

        Node(int number) {
            this.number = number;
            lptr = null;
            rptr = null;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }


    }
}