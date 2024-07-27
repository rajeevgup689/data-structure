import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FrequencyCount {
    public static void main(String[] args) {
        FrequencyCount obj = new FrequencyCount();
        //obj.getFrequency("geeksForGeeks").forEach((k, v) -> System.out.println(k + " --> " + v));
        obj.getFrequency(new int[]{1,2,3,5, 5, 1, -1, -1 }).forEach((k, v) -> System.out.println(k + " --> " + v));
    }

    private Map<Character, Long> getFrequency(String str) {
        return str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(),
                Collectors.counting()));
    }

    private Map<Integer, Long> getFrequency(int[] A) {
//        return Arrays.stream(A).mapToObj(c -> (Integer) c).collect(Collectors.groupingBy((numberA) -> numberA,
//                Collectors.counting()));
        return IntStream.range(0, A.length).boxed().collect(Collectors.groupingBy(i -> A[i], Collectors.counting()));
    }

}