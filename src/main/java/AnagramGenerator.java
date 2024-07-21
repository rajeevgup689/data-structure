import java.util.*;

public class AnagramGenerator {

    public static List<String> generateAnagrams(String str) {
        List<String> result = new ArrayList<>();
        generateAnagramsHelper(str.toCharArray(), 0, result);
        return result;
    }

    private static void generateAnagramsHelper(char[] chars, int index, List<String> result) {
        if (index == chars.length - 1) {
            result.add(String.valueOf(chars));
            return;
        }

        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            generateAnagramsHelper(chars, index + 1, result); //using recursion
            swap(chars, index, i); // Backtrack
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        List<String> anagrams = generateAnagrams(str);

        System.out.println("Anagrams of " + str + ":");
        for (String anagram : anagrams) {
            System.out.println(anagram);
        }

//        printPermutationsIterative("a");
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    /**
     * You should use the fact that when you want all permutations of N numbers there are N! possibilities.
     * Therefore each number x from 1..N! encodes such a permutation. Here is a sample that iteratively prints out all permutations of a sting.
     * @param string
     */
    private static void printPermutationsIterative(String string) {
        int[] factorials = new int[string.length() + 1];
        factorials[0] = 1;
        for (int i = 1; i <= string.length(); i++) {
            factorials[i] = factorials[i - 1] * i;
        }

        for (int i = 0; i < factorials[string.length()]; i++) {
            String onePermutation = "";
            String temp = string;
            int positionCode = i;
            for (int position = string.length(); position > 0; position--) {
                int selected = positionCode / factorials[position - 1];
                onePermutation += temp.charAt(selected);
                positionCode = positionCode % factorials[position - 1];
                temp = temp.substring(0, selected) + temp.substring(selected + 1);
            }
            System.out.println(onePermutation);
        }
    }

}