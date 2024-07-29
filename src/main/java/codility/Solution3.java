package codility;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {

    public static void main(String[] args) {
        Solution3 obj = new Solution3();

//        ([2, 5], ["PGP", "M"])
//        ([3, 2, 4], ["MPM", "", "G"])
//        ([2, 1, 1, 1, 2], ["", "PP", "PP", "GM", ""])
        int[] D = {2, 1, 1, 1, 2};
        String[] T = {"", "PP", "PP", "GM", ""};
        System.out.println("\n" + obj.solution(D, T));
    }

    public int solution(int[] D, String[] T) {
        // Implement your solution here
        Map<Character, Integer> last = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < T.length; i++) {
            String str = T[i];
            ans += str.length();
            for (char ch : str.toCharArray())
                last.put(ch, i);
        }

        int ts = 0;
        for (int i = 1; i <= D.length; i++) {
            ts += D[i - 1];
            for (int j : last.values()) {
                if (i == j) {
                    ans += ts;
                }
            }
        }

        return ans;
    }

}