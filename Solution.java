import java.util.Scanner;

public class Solution {

    public static String[][] transposeAndModify(String[][] dataMatrix) {
        int rows = dataMatrix.length;
        int cols = dataMatrix[0].length;
        String[][] transposed = new String[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = modifyElement(dataMatrix[i][j], j != 0); // Don't modify city names
            }
        }
        return transposed;
    }

    private static String modifyElement(String element, boolean isNumeric) {
        if (isNumeric) {
            try {

                double value = Double.parseDouble(element);
                return String.format("%.1f", value + 1);
            } catch (NumberFormatException e) {

                int index = element.indexOf("M");
                if (index != -1) {
                    double numericPart = Double.parseDouble(element.substring(0, index));
                    return (numericPart + 1) + "M";
                }
            }
        }
        return element;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        String[][] dataMatrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dataMatrix[i][j] = scanner.next();
            }
        }

        String[][] transposedMatrix = transposeAndModify(dataMatrix);

        System.out.println("Transposed and Modified Matrix:");
        for (int i = 0; i < transposedMatrix.length; i++) {
            for (int j = 0; j < transposedMatrix[0].length; j++) {
                System.out.print(transposedMatrix[i][j] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
