class Solution {
    public int findClosestNumber(int[] nums) {

        // constraint -> nums.length is always >= 1
        // we can preset the first iteration of comparisons
        int minDistance = Math.abs(nums[0] - 0);
        int num = nums[0];

        for (int i = 0; i < nums.length; i++) {

            int distance = Math.abs(nums[i] - 0);

            if (distance <= minDistance) {
                // if the distance is the same then we need to see which is larger (positive)
                if (distance == minDistance) {
                    num = Math.max(nums[i], num);
                } else {
                    num = nums[i];
                }
                // set the new minDistance regardless
                minDistance = distance;
            }
        }
        return num;
    }
}