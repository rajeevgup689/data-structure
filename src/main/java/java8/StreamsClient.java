package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsClient {

    private static StreamsClient obj = new StreamsClient();
    public static void main(String[] args) {
        // SumOfAllNumbers
        //System.out.println("sum: " + obj.sumOfAllNumbers(new int[]{1, 2, 3, 4, 5, -1, 0}));
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, -1, 0);
        //System.out.println(numbers.stream().mapToInt(n -> (int)n).sum());

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
//        int max =
//                Arrays.stream(new int[]{1,3,10,11,5,-1,0,23}).sorted().skip(new int[]{1,3,10,11,5,-1,0,23}.length -1).findFirst().getAsInt();
        //int max = Arrays.stream(new int[]{1,3,10,11,5,-1,0,23}).reduce((a,b) -> a>b?a:b).getAsInt();
        int max = numbers.stream().max(Comparator.naturalOrder()).get();
        System.out.println("Max: "+ max);
//        //int min = Arrays.stream(new int[]{1,3,10,11,5,-1,0,23}).min().getAsInt();
//        //int min = Arrays.stream(new int[]{1,3,10,11,5,-1,0,23}).sorted().findFirst().getAsInt();
//        int min = Arrays.stream(new int[]{1,3,10,11,5,-1,0,23}).sorted().limit(1).findFirst().getAsInt();
        //int min = Arrays.stream(new int[]{1,3,10,11,5,-1,0,23}).reduce((a,b) -> a<b?a:b).getAsInt();
        int min = numbers.stream().max(Comparator.reverseOrder()).get();
        System.out.println("Min: "+ min);

        // word frequency in sentence
        String str = "Java is programming language. java is  versatile.";
        Map<String, Long> wordFrequencyMap = Arrays.stream(str.split("\\s+"))
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
        System.out.println(wordFrequencyMap);

        // merge 2 sorted Array into a single array
        int[] A = {1,3,5,7};
        int[] B = {2,4,6,8};
        int[] C = IntStream.concat(Arrays.stream(A), Arrays.stream(B)).sorted().toArray();
        Arrays.stream(C).forEach(System.out:: print);

        // merge 2 lists of String and merge & sort them and remove duplicates
        List<String> list1 = List.of("apple", "banana", "orange");
        List<String> list2 = List.of("banana", "kiwi", "grape");
        List<String> finalList = Stream.concat(list1.stream(), list2.stream()).sorted(Comparator.comparing(String::valueOf)).distinct().collect(Collectors.toList());
        System.out.println(finalList);

        // count the special chars in given String
        String str1 = "a$b#c!~";
        int count = 0;
        for(char ch : str1.toCharArray()) {
            if(!Character.isAlphabetic(ch)) {
                count++;
            }
        }
        System.out.println("Special chars count is " + count);
        long count1 = str1.chars().filter(ch -> !Character.isLetterOrDigit(ch)).count();
        System.out.println("Special chars count using streams is " + count1);
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