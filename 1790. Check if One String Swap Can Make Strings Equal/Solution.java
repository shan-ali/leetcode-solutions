import java.util.HashMap;
import java.util.List;

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {

        // use s1 as a base and scan s2 for same characters in the same positions
        // if a character is different then scan for the correct char that is in s1
        // check that if we were to swap if it would be correct
        // if ok, keep scanning, if there are any incorrect characters then return false

        int swaps = 0;

        if (s1.length() != s2.length()) {
            return false;
        }

        if (s1.equals(s2)) {
            return true;
        }

        for (int i = 0; i < s1.length(); i++) {

            char s1c = s1.charAt(i);
            char s2c = s2.charAt(i);

            if (s1c != s2c) {
                // scan for correct
                System.out.println("scanning for " + s1c);
                for (int j = i + 1; j < s2.length(); j++) {
                    if (s2.charAt(j) == s1c && s1.charAt(j) == s2c) {
                        // found a possible swap
                        // build a new string with the values swapped
                        char[] s2Temp = s2.toCharArray();
                        s2Temp[i] = s2Temp[j];
                        s2Temp[j] = s2c;
                        s2 = new String(s2Temp);
                        swaps++;
                        break;
                    }
                }
            }
        }

        if (s1.equals(s2) && swaps <= 1) {
            return true;
        } else {
            return false;
        }
    }
}