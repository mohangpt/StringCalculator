import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String s) throws IllegalArgumentException {
        if (s == "" || s.isEmpty()) return 0;
        int[] input = generateNumbersFromString(s, extractDelimiter(s));
        int sum = 0;
        for (int i : input) {
            if (i < 0) {
                throw new IllegalArgumentException("negatives are not allowed");
            }
            if (i < 1000) {
                sum = sum + i;
            }
        }
        return sum;
    }

    private int[] generateNumbersFromString(String input, String delimiter) {
        if (input.startsWith("//")) {
            input = input.substring(input.indexOf('\n')+1);
        }
        input = input.replace("\n", delimiter);

        String[] stringsArray = input.split(Pattern.quote(delimiter));

        int[] output = new int[stringsArray.length];

        for (int i = 0; i < stringsArray.length; i++) {
            output[i] = Integer.parseInt(stringsArray[i]);
        }
        return output;
    }

    private String extractDelimiter(String input) {
        if (!input.startsWith("//")) {
            return ",";
        }
        if (input.charAt(2) != '[') {
            return input.charAt(2) + "";
        }
        String delimiter = "";
        for (int i = 3; i < input.length(); i++) {
            if (input.charAt(i) == ']') break;
            delimiter = delimiter + input.charAt(i);
        }
        return delimiter;
    }
}
