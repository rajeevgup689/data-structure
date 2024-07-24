package codility;

public class ArrListLen {
    public static void main(String[] args) {
        int A[] = new int[]{1, 4, -1, 3, 2};

        ArrListLen obj = new ArrListLen();

        System.out.println(obj.solution(A));
    }

    public int solution(int[] A) {
        if(A.length == 0) {
            return 0;
        }

        int length = 0;

        return length;
    }

    private class Node {
        public int value;
        public Node next;

        Node(int value) {
            this.value = value;
        }
    }
}