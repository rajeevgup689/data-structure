package codility;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ReverseArray {

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        IntStream.range(0, A.length/2).forEach(i -> {
            // swap first and last
            int temp = A[i];
            A[i] = A[A.length - i - 1];
            A[A.length - i - 1] = temp;
        });

        Arrays.stream(A).forEach(System.out::println);
    }
}