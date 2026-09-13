package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Multiple {
    static void main() {
        // Challenge 1: Given a list of strings, return the 3 longest strings sorted by length descending.
        List<String> strings = Arrays.asList("First", "Second", "Third", "Fourth", "Fifth");
        List<String> last3LongestStrings = strings.stream()
                .sorted((a, b) -> Long.compare(b.length(), a.length())) // reversed
                .limit(3)
                .collect(Collectors.toList());
        last3LongestStrings.forEach(System.out::println);
        //or
        List<String> top3 = strings.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .limit(3)
                .collect(Collectors.toList());

        //Challenge 2: Count the frequency of each word in a list.
        // Challenge 3: Find the first non-repeated character in a string.
        String str = "This is string with repeated elements";
        Optional<Character> firstNonRepeatedChar = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                //.map(Map.Entry::getKey)
                .map(e -> e.getKey())
                .findFirst();
        if(firstNonRepeatedChar.isPresent())
            System.out.println("firstNonRepeatedChar: " + firstNonRepeatedChar.get());
    }
}
