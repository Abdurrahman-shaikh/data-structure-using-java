package src.main.recursion;

public class Combination {
    public static void main(String[] args) {
        String str = allCombination("","abc");
        System.out.println(str);
    }

    static String  allCombination(String p, String up) {

        if (up.isEmpty()) {
            return p;
        }

        char ch = up.charAt(0);
        String withComb = allCombination(p + ch,up.substring(1));
        String withoutComb = allCombination(p,up.substring(1));

        return withComb+ "\n" + withoutComb;
    }
}
