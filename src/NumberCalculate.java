

public class NumberCalculate {
    public static String calculate(String numberOne, String numberTwo) {
        int calculateNumber = Integer.parseInt(numberOne, 2) - Integer.parseInt(numberTwo, 2);
        char[] charCalculateNumber = Integer.toBinaryString(Math.abs(calculateNumber)).toCharArray();
        if (calculateNumber < 0) {
            return "1," + new String(charCalculateNumber);
        } else
            return "0," + new String(charCalculateNumber);
    }
}
