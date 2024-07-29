package java8;

import java.util.Arrays;

public class Dictionary {
    public static void main(String[] args) {
        String[] names = {"one", "two", "three"};
        String[] sortedNames = Arrays.stream(names)
                //.sorted()
                //.sorted(Comparator.naturalOrder())
                .sorted((a,b) -> a.compareTo(b))
                .toArray(String[]::new);

        Arrays.stream(sortedNames).forEach((name) -> System.out.println(name));
    }
}