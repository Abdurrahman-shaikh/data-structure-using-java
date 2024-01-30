package src.main.recursion;

public class IgnoreChar {

    public static void main(String[] args) {
//        String ans = str("ababac","",0);
//        System.out.println(ans);
        System.out.println(skipApple("This is an apple apple apple apple appi"));
    }

    static String str(String str, String result, int index) {

        if (index == str.length()) return result;

        if (str.charAt(index) != 'a') {
            result += str.charAt(index) + "";
        }

        return str(str,result,index+=1);
    }

    static String skipApple(String s) {
        if (s.isEmpty()) {
            return "";
        }

        String s1 = s.substring(0,5);

        if ((s1.startsWith("app") && !s1.startsWith("apple")) && s1.length() >= 4) {
            return skipApple(s.substring(3));
        }

        if (s1.startsWith("apple")) {
            return skipApple(s.substring(5));
        } else {
            return s.charAt(0) + skipApple(s.substring(1));
        }
    }
}
