import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String inputString = scanner.nextLine();
            stringList.add(inputString);
        }

        sortStringsByLengthAndLexico(stringList);

        for (String str : stringList) {
            System.out.println(str);
        }

        scanner.close();
    }

    public static void sortStringsByLengthAndLexico(List<String> strings) {
        Collections.sort(strings, new CustomComparator());
    }

    static class CustomComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            int lengthComparison = Integer.compare(s1.length(), s2.length());

            if (lengthComparison == 0) {
                return s1.compareTo(s2);
            }

            return lengthComparison;
        }
    }
}
