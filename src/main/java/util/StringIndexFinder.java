package util;

import java.util.ArrayList;
import java.util.List;

public class StringIndexFinder {
    public static List<Integer> findAllIndices(String text, String pattern) {
        List<Integer> indices = new ArrayList<>();
        int index = text.indexOf(pattern);

        while (index != -1) {
            indices.add(index);
            index = text.indexOf(pattern, index + 1);
        }

        return indices;
    }

    public static void main(String[] args) {
        String text = "10000010001";
        String pattern = "1";

        List<Integer> indices = findAllIndices(text, pattern);

        System.out.println("Indices of '" + pattern + "': " + indices);
    }
}