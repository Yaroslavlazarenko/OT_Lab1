public class NumberCalculate {
    public NumberCalculate() {
    }

    public static String calculate(InputData inputData) {
        return numbersToLetters(baseTenToTarget(calculateToTenBase(lettersToNumbers(inputData.baseNumber), inputData.baseOrig), inputData.baseTarget));
    }

    public static int[] lettersToNumbers(char[] inputNumber) {
        int[] editBaseNumber = new int[inputNumber.length];

        for(int i = 0; i < editBaseNumber.length; ++i)
            editBaseNumber[i] = inputNumber[i] > '@' ? 10 + (inputNumber[i] - 65) : inputNumber[i] - 48;

        return editBaseNumber;
    }

    public static int calculateToTenBase(int[] editBaseNumber, int baseOrig) {
        int baseLength = editBaseNumber.length - 1;
        int numbTen = 0;

        for (int number : editBaseNumber)
            numbTen =  numbTen + (int) Math.pow(baseOrig, baseLength--) *  number;

        return numbTen;
    }

    public static String[] baseTenToTarget(int numbTen, int baseTarget) {
        String targetNumber;

        for(targetNumber = ""; numbTen != 0; numbTen /= baseTarget)
            targetNumber += numbTen % baseTarget + " ";

        return targetNumber.split(" ");
    }

    public static String numbersToLetters(String[] targetNumber) {
        char[] charsTargetNumber = new char[targetNumber.length];
        int k = 0;

        for(int i = targetNumber.length - 1; i > -1; --i) {
            int intTargetNumber = Integer.parseInt(targetNumber[i]);

            if (intTargetNumber - 10 > -1)
                charsTargetNumber[k++] = (char)(Integer.toString(intTargetNumber - 10).charAt(0) + 17);
            else
                charsTargetNumber[k++] = Integer.toString(intTargetNumber).charAt(0);
        }

        return new String(charsTargetNumber);
    }
}