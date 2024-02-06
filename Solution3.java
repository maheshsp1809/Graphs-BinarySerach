public class Solution3 {

    public static void rearrange(int n, int[] arr) {
        // Convert array elements to Roman numerals
        String[] romans = new String[n];
        for (int i = 0; i < n; i++) {
            romans[i] = toRoman(arr[i]);
        }

        // Sort the array based on Roman numerals
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (romans[i].compareTo(romans[j]) > 0) {
                    // Swap array elements
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                    // Swap Roman representations
                    String tempRoman = romans[i];
                    romans[i] = romans[j];
                    romans[j] = tempRoman;
                }
            }
        }

        // Print the sorted array
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    public static String toRoman(int num) {
        String[] romanSymbols = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
        int[] romanValues = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };

        StringBuilder roman = new StringBuilder();
        int i = 12;
        while (num > 0) {
            int div = num / romanValues[i];
            num %= romanValues[i];
            while (div-- > 0) {
                roman.append(romanSymbols[i]);
            }
            i--;
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = { 70, 50, 89, 56, 45, 30, 80 };
        System.out.println("Test Case 1:");
        rearrange(7, arr1);

        // Test Case 2
        int[] arr2 = { 1, 2, 3, 21, 20 };
        System.out.println("\nTest Case 2:");
        rearrange(5, arr2);
    }
}
