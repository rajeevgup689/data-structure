public static void main(String[] args) {
    int decimal = 9;
    System.out.println(decimalToBinary(decimal));

    // or using utility
    decimal = -1;
    System.out.println(Integer.toBinaryString(decimal));
}

private static String decimalToBinary(int decimal) {
    StringBuilder binary = new StringBuilder();
    if (decimal == 0) {
        return "0";
    }

    while (decimal > 0) {
        int remainder = decimal % 2;
        binary.insert(0, remainder);
        decimal /= 2;
    }

    return binary.toString();
}