import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindUniquePair {
    public static void main(String[] args) {
        List<Integer> A = List.of(1,2, 40, 3, 9, 4, 0, 2, 7, 1, 3);
        int N = 4;

        Set<String> pairSet = new HashSet<>();
        for(int i = 0; i < A.size() ; i++) {
            if((A.contains(N - A.get(i)))) {
                if(A.get(i) <= (N - A.get(i))) {
                    pairSet.add(new String(A.get(i) + String.valueOf(N - A.get(i))));
                }
            }
        }

        pairSet.stream().forEach(System.out:: println);

    }
}