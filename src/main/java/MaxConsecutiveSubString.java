import java.util.HashMap;
import java.util.Map;

public class MaxConsecutiveSubString {
    public static void main(String[] args) {
        String str ="kpyabcdeitxyzg";

        StringBuilder subString = new StringBuilder();
        Map<String, Integer> consecutiveStringMap = new HashMap<>();
        for (int i = 0; i < str.length() - 1; i++) {
            if(str.charAt(i) + 1 == str.charAt(i + 1)) {
                subString.append(str.charAt(i));
            } else {
                consecutiveStringMap.put(subString.toString(), subString.length());
                subString = new StringBuilder();
            }
        }

        System.out.println(consecutiveStringMap.entrySet().stream().max(Map.Entry.comparingByValue()).get());
        for(Map.Entry entry : consecutiveStringMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}