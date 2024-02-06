public class UniqueChars {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a string as a command-line argument.");
            return;
        }

        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    /**
     * Returns a string which is identical to the original string,
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String s) {
        String newString = "";

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);

            if (newString.indexOf(a) == -1 || a == ' ') {
                newString += a;
            }
        }

        return newString;
    }
}