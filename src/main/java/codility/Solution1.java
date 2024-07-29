package codility;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution1 {

    public static void main(String[] args) {
        Solution1 obj = new Solution1();

        int[] A = {1, 1, 1, 1, 3, 3, 4, 4, 4, 4, 4}; // not working
        System.out.println("\n" + obj.solution(A));
    }

    public int solution(int[] A) {
        // Implement your solution here
        int x = 0;
        for (int i = 0; i < A.length;) {
            for (int j = i; i < A.length && A[i] == A[j]; ++i)
            // A[j] occurs (i - j) times.
            x += Math.min(Math.abs(A[j] - (i - j)), i - j);
        }
        return x;
    }

}