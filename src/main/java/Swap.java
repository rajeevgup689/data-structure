import static java.lang.StringTemplate.STR;

public class Swap {
    public static void main(String[] args) {
        int a = 2, b = 3;

        // swap using temp variable
//        int temp;
//        temp = a;
//        a = b;
//        b = temp;
//        System.out.println(STR."a = \{a}, b = \{b}");

        // swap without using temp variable
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(STR."a = \{a}, b = \{b}");
    }
}