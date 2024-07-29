package java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsClient {

    private static StreamsClient obj = new StreamsClient();
    public static void main(String[] args) {
        // SumOfAllNumbers
        //System.out.println("sum: " + obj.sumOfAllNumbers(new int[]{1, 2, 3, 4, 5, -1, 0}));

        // AverageOfAllNumbers
        //System.out.println("avg: " + obj.averageOfAllNumbers(new int[]{1, 2, 3}));

        // take out DISTINCT numbers from an Array
        //Arrays.stream(obj.fetchDistinctNumbers(new int[]{1, 2, 3, 1, 2})).forEach(System.out:: println);

        // take out duplicate numbers from an Array
        //Arrays.stream(obj.fetchDuplicateNumbers(new int[]{1, 2, 3, 1, 2})).forEach(System.out:: println);

        // Number start with
        //Arrays.stream(obj.numberStartWith(new int[]{2, 222, 234, 567, 890, 432, 236, 211, 22}, 2)).forEach(System
        // .out:: println);

        // Max and Min numbers
        //int max = Arrays.stream(new int[]{1,3,10,11,5,-1,0,23}).max().getAsInt();
        int max =
                Arrays.stream(new int[]{1,3,10,11,5,-1,0,23}).sorted().skip(new int[]{1,3,10,11,5,-1,0,23}.length -1).findFirst().getAsInt();
        System.out.println("Max: "+ max);
        //int min = Arrays.stream(new int[]{1,3,10,11,5,-1,0,23}).min().getAsInt();
        //int min = Arrays.stream(new int[]{1,3,10,11,5,-1,0,23}).sorted().findFirst().getAsInt();
        int min = Arrays.stream(new int[]{1,3,10,11,5,-1,0,23}).sorted().limit(1).findFirst().getAsInt();
        System.out.println("Min: "+ min);
    }

    private int[] numberStartWith(int[] A, int startsWith) {
        return Arrays.stream(A).mapToObj(a -> String.valueOf(a)).filter(a -> a.startsWith(""+startsWith)).mapToInt(a -> Integer.parseInt(a)).toArray();
    }

    private int[] fetchDistinctNumbers(int[] A) {
        //return Arrays.stream(A).distinct().toArray();

//        Set<Integer> distinctNumbers = new HashSet<>();
//        return Arrays.stream(A).filter((n) -> distinctNumbers.add(n)).toArray();

        List<Integer> numbers = Arrays.stream(A).boxed().collect(Collectors.toList());
        return Arrays.stream(A).filter(n -> Collections.frequency(numbers, n) == 1).toArray();
    }

    private int[] fetchDuplicateNumbers(int[] A) {
//        List<Integer> numbers = Arrays.stream(A).boxed().collect(Collectors.toList());
//        return Arrays.stream(A).filter(n -> Collections.frequency(numbers, n) > 1).distinct().toArray();

        Set<Integer> distinctNumbers = new HashSet<>();
        return Arrays.stream(A).filter((n) -> !distinctNumbers.add(n)).toArray();
    }

    private double averageOfAllNumbers(int[] A) {
        return Arrays.stream(A).average().getAsDouble();
    }

    private int sumOfAllNumbers(int[] A) {
//        return Arrays.stream(A)
//                .reduce((a, b) -> a + b)
//                .getAsInt();
        return Arrays.stream(A)
                .sum();
    }
}