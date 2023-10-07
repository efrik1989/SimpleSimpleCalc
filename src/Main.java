import java.io.*;
import java.util.Scanner;

public class Main {
    static String filePath = "D:\\Edu\\SimpleSimpleCalc\\input.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(filePath);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            calc(line);

        }


    }
    public static void calc(String line) {
        String[] str = line.split("\\s");

        try {
            double a = Double.parseDouble(str[0]);
            double b = Double.parseDouble(str[2]);
            double result;
            switch (str[1]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "/":
                    result = a / b;
                    break;
                case "*":
                    result = a * b;
                    break;
                default:
                    throw new IllegalStateException("Operation Error!");
            }
            String infinity = "" + result;
            if (infinity.equals("Infinity")) {
                throw new ArithmeticException();
            }
            System.out.println(result);
        }catch (NumberFormatException num) {
            System.out.println("Error! Not number");
        }catch (IllegalStateException il) {
            System.out.println(il.getMessage());
        }catch (ArithmeticException ar) {
            System.out.println("Error! Division by zero");
        }
    }
}
