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
                input.nextLine().replaceAll(" ", "").split(":")[1].toCharArray());
        String numberOne = NumberConversion.converse(inputData);
        inputData.setBaseNumber(input.nextLine().replaceAll(" ", "").split(":")[1].toCharArray());
        String numberTwo = NumberConversion.converse(inputData);
        input.close();
        String finalNumber = NumberCalculate.calculate(numberOne,numberTwo);
        String outputData = "Начальное первое число: "+ numberOne + "\nНачальное второе число: "+
                numberTwo  + "\nСлогаемые числа представлены в виде прямого кода:\n" +
                NumberConversion.directCodeStyle(numberOne.toCharArray()) + " - " +
                NumberConversion.directCodeStyle(numberTwo.toCharArray()) + " = " +
                "\nОтвет в виде обратного кода: \n" + finalNumber;
        output.write(outputData.getBytes());
        output.close();
    }
}
