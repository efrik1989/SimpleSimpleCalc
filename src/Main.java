import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.isEmpty() || line.matches(".*exit.*")) {
                break;
            }
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
