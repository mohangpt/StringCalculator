public class StringCalculator {
    public int add (String s) {
        if (s == "" || s.isEmpty()) return 0;
        int[] input = generateNumbersFromString(s);
        return input[0]+input[1];
    }

    private int[] generateNumbersFromString(String input) {

        String[] stringsArray=  input.split(",");

        int[] output = new int[stringsArray.length];

        for (int i = 0 ; i < stringsArray.length; i++) {
            output[i] = Integer.parseInt(stringsArray[i]);
        }
        return output;
    }
}
