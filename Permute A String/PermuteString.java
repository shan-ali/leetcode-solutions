import java.util.Scanner;

public class PermuteString {

    public static void permuteString(String s) {
        permute(s, "");
    }

    // decisions are the pool of characters we will use
    // permutation is the permutation we are building
    // when decisions has no characters then print permutation
    public static void permute(String decisions, String permutation) {

        if (decisions.length() == 0) {
            System.out.print(permutation + ", ");
        }

        // loop over all decisions
        for (int i = 0; i < decisions.length(); i++) {
            // need to get all decisions left, not the string that we are on
            String left = decisions.substring(0, i); // the right value is non inclusive
            String right = decisions.substring(i + 1, decisions.length());
            String remainingDecisions = left + right;
            permute(remainingDecisions, permutation + decisions.charAt(i));
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s;
        System.out.print("Enter the string : ");

        s = scan.next();
        permuteString(s);
        scan.close();
    }
}
