package java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CommonElementInArrays {
    public static void main(String[] args) {
        CommonElementInArrays obj = new CommonElementInArrays();
        int[] A = {1,2,3,4,5};
        int[] B = {4,5, 4, 6,7};
        int[] common = obj.findCommonElements(A, B);
        Arrays.stream(common).forEach(System.out::println);
    }

    private int[] findCommonElements(int[] a, int[] b) {
        Set<Integer> commonElements =
                Arrays.stream(a).filter((numberA) -> Arrays.stream(b).anyMatch((numberB) -> numberB == numberA)).boxed().collect(Collectors.toSet());
        return commonElements.stream().mapToInt(n -> (int) n).toArray();

//         2nd method
//        Set<Integer> set1 = new HashSet<>(Arrays.stream(a).boxed().collect(Collectors.toSet()));
//        int[] commonElements = Arrays.stream(b)
//                .distinct()
//                .filter((numberB) -> set1.contains(numberB))
//                .toArray();
//        return commonElements;

    }
}