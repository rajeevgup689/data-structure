package codility;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Solution2 {

    public static void main(String[] args) {
        Solution2 obj = new Solution2();

        int[] P = {4,4,2,4};
        int[] S = {5,5,2,5};
        System.out.println("\n" + obj.solution(P, S));
    }

    public int solution(int[] P, int[] S) {
        // Implement your solution here
        int totalPeople = Arrays.stream(P).sum();
        S = IntStream.of(S)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(i -> i)
                .toArray();

        int index = 0;
        while(totalPeople > 0) {
            totalPeople -= S[index];
            index++;
        }

        return index;
    }
    
}