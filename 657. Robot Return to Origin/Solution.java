class Solution {
    public boolean judgeCircle(String moves) {

        // possible moves and their effects
        // (row, column)
        // R = (0, +1)
        // L = (0, -1)
        // U = (+1, 0)
        // D = (-1, 0)

        int column = 0;
        int row = 0;

        for (int i = 0; i < moves.length(); i++) {
            char m = moves.charAt(i);
            if (m == 'R') {
                row++;
                continue;
            }
            if (m == 'L') {
                row--;
                continue;
            }
            if (m == 'U') {
                column++;
                continue;
            }
            if (m == 'D') {
                column--;
                continue;
            }
        }

        if (column == 0 && row == 0) {
            return true;
        } else {
            return false;
        }
    }
}