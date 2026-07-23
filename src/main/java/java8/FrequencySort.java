package java8;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencySort {

    public static void main (String[] args) throws java.lang.Exception
    {
        String str = "Rajeev Gupta";
        Map<Character, Long> frequencyMap = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Character, Long> list = frequencyMap.entrySet().stream().sorted((a, b) -> Long.compare(a.getValue(), b.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue, (a, b) -> a));


        System.out.println(list);

    }
}