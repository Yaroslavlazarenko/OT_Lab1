public class NumberConversion {
    public static boolean negative = false;

    public NumberConversion() {
    }

    public static String converse(InputData inputData) {
        int[] lettersToNumbers = lettersToNumbers(inputData.baseNumber);
        int numbTen = calculateToTenBase(lettersToNumbers, inputData.baseOrig);
        String[] baseTenToTarget = baseTenToTarget(numbTen, inputData.baseTarget);
        return numbersToLetters(baseTenToTarget);
    }

    public static int[] lettersToNumbers(char[] inputNumber) {
        int[] editBaseNumber = new int[inputNumber.length];
        if (inputNumber[0] == '-') {
            editBaseNumber = new int[inputNumber.length - 1];
            negative = true;
            int k = 0;
            for (int i = 1; i < inputNumber.length; ++i) {
                editBaseNumber[k] = inputNumber[i] > '@' ? 10 + (inputNumber[i] - 65) : inputNumber[i] - 48;
                k++;
            }
        } else
            for (int i = 0; i < editBaseNumber.length; ++i)
                editBaseNumber[i] = inputNumber[i] > '@' ? 10 + (inputNumber[i] - 65) : inputNumber[i] - 48;

        return editBaseNumber;
    }

    public static int calculateToTenBase(int[] editBaseNumber, int baseOrig) {
        int baseLength = editBaseNumber.length - 1;
        int numbTen = 0;

        for (int number : editBaseNumber)
            numbTen = numbTen + (int) Math.pow(baseOrig, baseLength--) * number;

        return numbTen;
    }

    public static String[] baseTenToTarget(int numbTen, int baseTarget) {
        String targetNumber;

        for (targetNumber = ""; numbTen != 0; numbTen /= baseTarget)
            targetNumber += numbTen % baseTarget + " ";

        return targetNumber.split(" ");
    }

    public static String numbersToLetters(String[] targetNumber) {
        char[] charsTargetNumber = new char[targetNumber.length];
        int k = 0;

        for (int i = targetNumber.length - 1; i > -1; --i) {
            int intTargetNumber = Integer.parseInt(targetNumber[i]);

            if (intTargetNumber - 10 > -1)
                charsTargetNumber[k++] = (char) (Integer.toString(intTargetNumber - 10).charAt(0) + 17);
            else
                charsTargetNumber[k++] = Integer.toString(intTargetNumber).charAt(0);
        }
        if (negative) {
            negative = false;
            return '-' + new String(charsTargetNumber);
        } else
            return new String(charsTargetNumber);
    }

    public static String directInReverse(char[] number) {
        if (number[0] == '-') {
            number[0] = ',';
            for (int i = 1; i < number.length; i++) {
                if(number[i]=='0')
                    number[i]='1';
                else
                    number[i]='0';
            }
            return "1" + new String(number);
        } else
            return "0," + new String(number);
    }
}