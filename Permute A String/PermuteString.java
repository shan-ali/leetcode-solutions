public class PermuteString {

    public static void permuteString(String s) {
        for (int i = 0; i < s.length(); i++) {
            recurse(s, i);
        }
    }

    public static void recurse(String s, int i) {

    }

    public static void main(String[] args) {
        String s = "abc";
        permuteString(s);
    }
}
