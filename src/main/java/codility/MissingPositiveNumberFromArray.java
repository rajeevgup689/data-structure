package codility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingPositiveNumberFromArray {

    public static void main(String[] args) {
        MissingPositiveNumberFromArray obj = new MissingPositiveNumberFromArray();

        int[] A = new int[]{1, 8, 6, -1, 2};
        //System.out.println("\n"+ obj.solution(A));

        Set<Integer> set = new HashSet<>();
        for(int a: A) {
            set.add(a);
        }

        int i = 1;
        while(set.contains(i)) {
            i++;
        }

        System.out.println(i);


    }

    public int solution(int[] A) {
        // Implement your solution here
        if(A.length == 0) {
            return 1;
        }

        int[] uniqueNumbers = Arrays.stream(A).distinct().toArray();
        Arrays.sort(uniqueNumbers);
        printArray(uniqueNumbers);

        int i = 1;
        int minPostiveNumberMissing = 0;
        for(int a: uniqueNumbers) {
            if(a != i) {
                minPostiveNumberMissing = i;

            }
            if(a > 0)
                i++;
        }


        if(minPostiveNumberMissing == 0) {
            minPostiveNumberMissing = i;
        }

        return minPostiveNumberMissing;
    }



    private void printArray(int[] A){
        for(int a : A) {
            System.out.print(a + " ");
        }
    }
}