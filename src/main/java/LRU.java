import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LRU {
    public static void main(String[] args) {
        String name = "Rajeev Gupta";

        // 1. Find out frequency of each char
        Map<Character, Long> charFrequency = name.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // 2. Sort map by value and collect into a LinkedHashMap
        Map<Character, Long> sortedCharFrequency = charFrequency.entrySet().stream()
                //.sorted(Map.Entry.comparingByValue()) //
                .sorted((o1, o2) -> Long.compare(o1.getValue(), o2.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new // Maintains insertion order
                ));

        // 3. Print the sorted map
        sortedCharFrequency.entrySet().forEach(o -> System.out.println(o.getKey() + " --> " + o.getValue()));
    }
}
