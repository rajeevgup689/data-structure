package codility;

public class Solution_NonExistingIncrementalNumber {
    public static void main(String[] args) {
        Solution_NonExistingIncrementalNumber obj = new Solution_NonExistingIncrementalNumber();

        int[] A = new int[] {1, 3, 6, 4, 1, 2};
        System.out.println(obj.solution(A));
    }

    public int solution(int[] A) {
        // Implement your solution here
        int min = 1;
        if(A.length == 0) {
            return 1;
        }

        int max = max(A) +1;
        boolean matched = false;
        for(int i = 1; i< max; i++) {
            matched = false;
            for(int a : A) {
                if(i == a) {
                    matched = true;
                }
            }

            if(!matched) {
                min = i;
                break;
            }
        }

        if(matched) {
            min = max;
        }



        return min;
    }

    private int max(int[] a) {
        int max = a[0];
        for(int i = 1; i< a.length ; i++) {
            if(max < a[i]) {
                max = a[i];
            }
        }
        return max;
    }

}