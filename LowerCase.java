public class LowerCase {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(lowerCase(str));

    }

   /**
    * Returns a string which is identical to the original string, 
    * except that all the upper-case letters are converted to lower-case letters.
    * Non-letter characters are left as is.
    */
    public static String lowerCase(String s) {
        String newstring = s;
        for (int i = 0; i < newstring.length(); i++){
            char a = newstring.charAt(i) ;
            if (a > 64 && a < 91){
                newstring = newstring.replace( a,(char) (a + 32));
            }


        }
        return newstring;
    }
}

