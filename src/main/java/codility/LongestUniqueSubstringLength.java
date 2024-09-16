package codility;

import java.util.HashSet;
import java.util.Set;

public class LongestUniqueSubstringLength {
    public static void main(String[] args) {
        LongestUniqueSubstringLength obj = new LongestUniqueSubstringLength();
        String str = new String("geeksforgeeks"); // abcabcabbba
        System.out.println(obj.longestUniqueSubStringLength(str));
    }

    private int longestUniqueSubStringLength(String str) {
        // if string length is 0
        if (str.length() == 0) {
            return 0;
        }

        // if string length 1
        if (str.length() == 1) {
            return 1;
        }

        // if string length is more than 1
        int maxLength = 0;

        // left and right pointer of sliding window
        int left = 0, right = 0;
        boolean[] visited = new boolean[256];
        while (right < str.length()) {
            // If the character is repeated, move left pointer to the right and mark visited characters as false
            // until the repeating character is no longer part of the current window.
            while (visited[str.charAt(right)]) {
                visited[str.charAt(left)] = false;
                left++;
            }

            visited[str.charAt(right)] = true;

            // The length of the current window (right - left + 1)
            // is calculated and answer is updated accordingly
            maxLength = Math.max(maxLength, (right - left + 1));
            right++;
        }

//        Set<Character> characterSet = new HashSet<>();
//        int leftIndex = 0, rightIndex = 0;
//        while(rightIndex < str.length()) {
//            if(!characterSet.contains(str.charAt(leftIndex))) {
//                characterSet.add(str.charAt(leftIndex++));
//            } else {
//                maxLength = Math.max(characterSet.size(), maxLength);
//                characterSet.remove(str.charAt(rightIndex));
//
//                rightIndex++;
//            }
//        }

        return maxLength;
    }
}