public class AsciiValue {
    public static void main(String[] args) {

        char ch = 'a'; // A --> 65, a --> 97
        int ascii = ch;
        // You can also cast char to int
        int castAscii = (int) ch;

        System.out.println("The ASCII value of " + ch + " is: " + ascii);
        System.out.println("The ASCII value of " + ch + " is: " + castAscii);
    }
}