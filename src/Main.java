import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new FileInputStream("./src/input.txt"));
        FileOutputStream output = new FileOutputStream("./src/output.txt");
        InputData inputData = new InputData(Integer.parseInt(input.nextLine().replaceAll(" ", "").split(":")[1]),
                Integer.parseInt(input.nextLine().replaceAll(" ", "").split(":")[1]),
                Integer.parseInt(input.nextLine().replaceAll(" ", "").split(":")[1]),
                input.nextLine().replaceAll(" ", "").split(":")[1].toCharArray());
        input.close();
        String outputData = "Основание исходной системы счисления: " + inputData.getBaseOrig()+
                "\nОснование целевой системы счисления: " + inputData.getBaseTarget() + "\nНачальное число: "
                + new String(inputData.getBaseNumber()) + "\nИтоговое число: " + NumberCalculate.calculate(inputData);
        output.write(outputData.getBytes());
        output.close();
    }
}
