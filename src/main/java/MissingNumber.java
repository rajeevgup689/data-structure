import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MissingNumber {

    public static void main(String[] args) {
        int[] A = new int[]{2,3,1,4};
//        Arrays.sort(A);
//        for(int a : A) {
//            System.out.print(a + " ");
//        }
        System.out.println(solution(A));
    }
    public static int solution(int[] A) {
        int missingNumber= 0;
        if(A.length == 0) {
            return 1;
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int a : A) {
            if(frequencyMap.containsKey(a)) {
                frequencyMap.put(a, frequencyMap.get(a) + 1);
            } else {
                frequencyMap.put(a, 1);
            }
        }

        // findMissingNumber
        for(int i = 1; i < maxNumber(A) ; i++) {
            if(frequencyMap.get(i) == null) {
                missingNumber = i;
                break;
            }
        }
//        for(int a : frequencyMap.keySet()) {
//            if(frequencyMap.get(a) != 1) {
//                missingNumber = a;
//                break;
//            }
//        }

        if(missingNumber == 0) {
            missingNumber = maxNumber(A) + 1;
        }


        return missingNumber;
    }


    public static int solution1(int[] A) {
        // Implement your solution here
        if(A.length == 0) {
            return 1;
        }

        long totalSum = 0;
        for(int a: A) {
            totalSum += a;
        }
        int N = maxNumber(A);
        long expectedSum = (N+1)*(N+2)/2;
        int missingNumber=(int) (expectedSum - totalSum);
        return missingNumber;
    }

    private static int maxNumber(int[] A) {
        int maxNumber = 0;
        for(int a : A) {
            if(maxNumber < a) {
                maxNumber = a;
            }
        }
        return maxNumber;
    }
}