import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Dictionary {
    public static void main(String[] args) {
        String[] names = {"one", "two", "three"};
        String[] sortedNames = Arrays.stream(names)
                //.sorted()
                .sorted(Comparator.naturalOrder())
                .toArray(String[]::new);

        Arrays.stream(sortedNames).forEach((name) -> System.out.println(name));
    }
}