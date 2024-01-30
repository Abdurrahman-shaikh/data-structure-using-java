package src.main.recursion;

public class Permutation {
    public static void main(String[] args) {
        int count = permutation("","abc");
        System.out.println(count);
    }

    private static int permutation(String p, String up) {
        int count = 0;
        if (up.isEmpty()) {
            System.out.println(p);
            count++;
            return 1;
        }

        char ch = up.charAt(0);
//        count += permutation(p + ch, up.substring(1));
//        count += permutation(ch + p, up.substring(1));
//        return count;

        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0,i);
            String second = p.substring(i,p.length());
            count += permutation(first + ch + second, up.substring(1));
        }

        return count;
    }
}
