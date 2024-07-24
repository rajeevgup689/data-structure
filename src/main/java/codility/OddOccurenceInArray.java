package codility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OddOccurenceInArray {

    public static void main(String[] args) {
        OddOccurenceInArray obj = new OddOccurenceInArray();
        //System.out.println(obj);
        int[] A = new int[]{9,3,9,3,9,7,9};
        System.out.println(obj.solution(A));

    }

    public int solution(int[] A) {
        // Implement your solution here
        if (A.length == 0) {
            return 0;
        }

        int unpaired = 0;
        Map<Integer, List<Boolean>> mappings = new HashMap<>();
        for (int a : A) {
            if (mappings.containsKey(a)) {
                List<Boolean> list = mappings.get(a);
                list.add(false);
                mappings.put(a, list);
            } else {
                List<Boolean> list = new ArrayList<>();
                list.add(false);
                mappings.put(a, list);
            }
        }

        for(Integer key : mappings.keySet()) {
            if(mappings.get(key).size() % 2 != 0) {
                unpaired = key;
            }
        }

//        for (int i = 0; i < A.length; i++) {
//            for (int j = i; j < A.length; j++) {
//                if (A[i])
//            }
//
//        }

        return unpaired;
    }


}