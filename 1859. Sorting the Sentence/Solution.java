import java.util.HashMap;

class Solution {
    public String sortSentence(String s) {

        String[] splitSentence = s.split(" ");
        HashMap<Integer, String> map = new HashMap<>();

        for (String sentence : splitSentence) {
            int index = Character.getNumericValue(sentence.charAt(sentence.length() - 1));
            // System.out.println(index);
            map.put(index, sentence.substring(0, sentence.length() - 1));
            // System.out.println(sentence.substring(0, sentence.length()-1));
        }

        String[] sortedSentenceArr = new String[map.size()];

        for (int index : map.keySet()) {
            sortedSentenceArr[index - 1] = map.get(index);
        }

        StringBuilder sortedSentence = new StringBuilder();

        for (int i = 0; i < sortedSentenceArr.length; i++) {
            sortedSentence.append(sortedSentenceArr[i]);
            if (i != sortedSentenceArr.length - 1) {
                sortedSentence.append(" ");
            }
        }

        return sortedSentence.toString();
    }
}