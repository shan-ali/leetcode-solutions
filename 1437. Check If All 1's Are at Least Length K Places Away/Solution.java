class Solution {
    public boolean kLengthApart(int[] nums, int k) {

        // scan until first 1
        // if the next is 0 count ++ until next 1 is found
        // if we reach the end of the array before a 1 is found then return false

        // scan until first 1

        int i = 0;
        while (i < nums.length) {
            if (nums[i] != 1) {
                i++;
            } else {
                break;
            }
        }

        // loop through the rest of the array to find the next possible 1

        if (i + 1 <= nums.length) {
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == 0) {
                    count++;
                }
                // if we found a 1
                // we need to check if the count is less than k
                if (nums[j] == 1) {
                    if (count < k) {
                        return false;
                    }
                    count = 0;
                }
            }
        }

        return true;
    }
}