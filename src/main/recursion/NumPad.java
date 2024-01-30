package src.main.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumPad {

    public static void main(String[] args) {
//        pad("","12");
//        dice("",4);
        letterCombinations("723");

    }

    private static void pad(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0';
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char)('a' + i);
            pad(p + ch, up.substring(1));
        }
    }

    static void dice(String p, int target) {
        if (target == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= 6 && i <= target; i++)
            dice(p + i,target - i);
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();

        List<String> al = new ArrayList<>();
        Map<Character,String> m = new HashMap<>();
        m.put('2',"abc");
        m.put('3',"def");
        m.put('4',"ghi");
        m.put('5',"jkl");
        m.put('6',"mno");
        m.put('7',"pqrs");
        m.put('8',"tuv");
        m.put('9',"wxyz");
        helper("",digits,al,m);
        return al;
    }

    static void helper(String p, String up,List<String> al,Map<Character,String> m) {
        if (up.isEmpty()) {
            al.add(p);
            System.out.println(p);
            return;
        }
        char digit = up.charAt(0);
        int len = m.get(digit).length();
        for (int i = 0; i < len; i++) {
            char ch = m.get(digit).charAt(i);
            helper(p + ch,up.substring(1),al,m);
        }
    }
}
