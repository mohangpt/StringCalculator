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

    private int[] generateNumbersFromString(String input, String[] delimiter) {
        if (input.startsWith("//")) {
            input = input.substring(input.indexOf('\n')+1);
        }

        input = input.replace("\n", delimiter[0]);

        if (delimiter.length > 1) {
            for (int i = 1; i < delimiter.length; i++) {
                input = input.replace(delimiter[i], delimiter[0]);
            }
        }

        String[] stringsArray = input.split(Pattern.quote(delimiter[0]));

        int[] output = new int[stringsArray.length];

        for (int i = 0; i < stringsArray.length; i++) {
            output[i] = Integer.parseInt(stringsArray[i]);
        }
        return output;
    }

    private String[] extractDelimiter(String input) {
        String [] delimiter = new String[1];
        // case1: no custom delimiter
        // check if string starts with '//'
        if (!input.startsWith("//")) {
            delimiter[0] = ",";
            return delimiter;
        }
        // case2: custom delimiter with single char
        // string starts with '//'
        if (input.charAt(2) != '[') {
            delimiter[0] = input.charAt(2) + "";
            return delimiter;
        }
        // case3: custom delimiter with multiple char delimiter
        // string is like this "//[&&&&]\n....."
        // take a substring of 3 to place of \n-1
        input = input.substring(3,input.indexOf('\n')-1);
        if (!input.contains("][")) {
            delimiter[0] = input;
            return delimiter;
        }
        // if that substring not contain ']' case 1
        delimiter = input.split(Pattern.quote("]["));
        // case 1 with single delimiter
        // case 2 with multiple delimiter

        return delimiter;
    }
}
