public class StringCalculator {
    public int add (String s) {
        if (s == "" || s.isEmpty()) return 0;
        int[] input = generateNumbersFromString(s , extractDelimiter(s));
        int sum = 0;
        for (int i : input) {
            sum = sum + i;
        }
        return sum;
    }

    private int[] generateNumbersFromString(String input, String delimiter) {
        if (input.startsWith("//")) {
            input = input.substring(4);
        }
        input = input.replace("\n",delimiter);

        String[] stringsArray=  input.split(delimiter);

        int[] output = new int[stringsArray.length];

        for (int i = 0 ; i < stringsArray.length; i++) {
            output[i] = Integer.parseInt(stringsArray[i]);
        }
        return output;
    }
    private String extractDelimiter(String input) {
        if (!input.startsWith("//")) {
            return ",";
        }

        return input.charAt(2) + "";
    }
}
