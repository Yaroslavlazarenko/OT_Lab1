

public class NumberCalculate {
    public static String calculate(String numberOne, String numberTwo) {
        int calculateNumber = Integer.parseInt(numberOne, 2) - Integer.parseInt(numberTwo, 2);
        char[] charCalculateNumber = Integer.toBinaryString(Math.abs(calculateNumber)).toCharArray();
        if (calculateNumber < 0) {
            for (int i = 0; i < charCalculateNumber.length; i++) {
                if(charCalculateNumber[i]=='1')
                    charCalculateNumber[i]='0';
                else
                    charCalculateNumber[i]='1';
            }
            return "1," + new String(charCalculateNumber);
        } else
            return "0," + new String(charCalculateNumber);
    }
}
