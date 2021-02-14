public class StringCalculator {
    public int add (String s) {
        if (s == "" || s.isEmpty()) return 0;
        int[] input = generateNumbersFromString(s);
        int sum = 0;
        for (int i : input) {
            sum = sum + i;
        }
        return sum;
    }

    private int[] generateNumbersFromString(String input) {
        input = input.replace("\n",",");

        String[] stringsArray=  input.split(",");

        int[] output = new int[stringsArray.length];

        for (int i = 0 ; i < stringsArray.length; i++) {
            output[i] = Integer.parseInt(stringsArray[i]);
        }
        return output;
    }
}
