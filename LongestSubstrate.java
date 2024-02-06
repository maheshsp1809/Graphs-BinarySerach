import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubstrate {
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        String inputString = "xyzaaabbbcccdefg";
        String result = findLongestSubstring(inputString);
        System.out.println("Longest significant substrate: " + result);
        // cdefg output
    }

    private static String findLongestSubstring(String text) {
        int start = 0;
        String longestSubstrate = "";
        Map<Character, Integer> visited = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (visited.containsKey(currentChar)) {
                start = Math.max(start, visited.get(currentChar) + 1);
            }
            visited.put(currentChar, i);

            boolean hasConsecutive = false;
            for (int j = start; j <= i; j++) {
                if (j + 2 < text.length() && text.charAt(j) == text.charAt(j + 1) - 1
                        && text.charAt(j) == text.charAt(j + 2) - 2) {
                    hasConsecutive = true;
                    break;
                }
            }
            if (!hasConsecutive) {
                continue;
            }
            if (i - start + 1 > longestSubstrate.length()) {
                longestSubstrate = text.substring(start, i + 1);
            }
        }
        return longestSubstrate;
    }
}
