import java.util.HashMap;
import java.util.Map;

public class Palindrome {

    public static void main(String[] args) {
        String str = "abab12";
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for(char ch : str.toCharArray()) {
            if(frequencyMap.containsKey(ch)) {
                frequencyMap.put(ch, frequencyMap.get(ch) + 1);
            } else {
                frequencyMap.put(ch, 1);
            }
        }
        frequencyMap.forEach((k,v) -> System.out.println("Key: " + k + ", Value: " + v));

        int oddCount = 0;
        boolean isPalindrome = false;
        for(Character ch : frequencyMap.keySet()) {
            if(str.length() % 2 == 0) {
                if(frequencyMap.get(ch) % 2 != 0) {
                    isPalindrome = false;
                    break;
                } else {
                    isPalindrome = true;
                }
            } else {
                if(frequencyMap.get(ch) % 2 == 0) {
                    isPalindrome = true;
                } else {
                    oddCount++;
                }
            }
        };

        if(str.length() % 2 != 0) {
            System.out.println("oddCount: " + oddCount);
            if(oddCount % 2 != 0) {
                isPalindrome = true;
            } else {
                isPalindrome = false;
            }
        }

        System.out.println("isPalindrome: " + isPalindrome);

    }
}