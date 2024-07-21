// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution_MaxGapOfBinary1 {

    public static void main(String[] args) {
        Solution_MaxGapOfBinary1 obj = new Solution_MaxGapOfBinary1();
        System.out.println(obj.solution(1041));
    }
    public int solution(int N) {
        // Implement your solution here
        int maxGapCount = 0;
        if(N == 0) {
            return 0;
        }

        String binary = Integer.toBinaryString(N);
        if(binary.contains("01")) {
            // char[] binaryArray = binary.toCharArray();
            // for(char ch : binaryArray) {

            // }

            List<Integer> indices = findAllIndices(binary, "1");
            for(int i=0; i< indices.size()-1; i++) {
                if(maxGapCount < (indices.get(i+1) - indices.get(i))) {
                    maxGapCount = (indices.get(i+1) - indices.get(i)) -1;
                }

            }

            return maxGapCount;
        } else {
            return 0;
        }

    }

    public static List<Integer> findAllIndices(String text, String pattern) {
        List<Integer> indices = new ArrayList<>();
        int index = text.indexOf(pattern);

        while (index != -1) {
            indices.add(index);
            index = text.indexOf(pattern, index + 1);
        }

        return indices;
    }
}