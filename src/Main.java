import java.io.*;

public class Main {
    static String inputFilePath = "D:\\Edu\\SimpleSimpleCalc\\input.txt";
    static String outputFilePath = "D:\\Edu\\SimpleSimpleCalc\\output.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(inputFilePath);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            calc(line);

        }

        bufferedReader.close();


    }
    public static void calc(String line) throws IOException {
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
            writeToFile(infinity);
        }catch (NumberFormatException num) {
            writeToFile("Error! Not number");
        }catch (IllegalStateException il) {
            writeToFile(il.getMessage());
        }catch (ArithmeticException ar) {
            writeToFile("Error! Division by zero");
        }
    }

    static void writeToFile(String str) throws IOException {
        FileWriter fileWriter = new FileWriter(outputFilePath, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(str + "\n");
        bufferedWriter.close();
    }
}
