class Solution {
    public int searchInsert(int[] nums, int target) {

        int high = nums.length - 1;
        int low = 0;

        return binarySearch(nums, target, high, low);

    }

    public int binarySearch(int[] nums, int target, int high, int low) {

        int midIndex = low + ((high - low) / 2);

        // base case high >= low, since if not found low would increment higher than
        // high
        if (high >= low) {
            if (nums[midIndex] == target) {
                // found the target
                return midIndex;
            }

            // if not found then choose left or right side depending on if target is larger
            // or less than the midvalue
            if (target > nums[midIndex]) {
                // if target is larger than then mid, then search the right side (higher values)
                return binarySearch(nums, target, high, midIndex + 1);
            } else {
                // search left side
                return binarySearch(nums, target, midIndex - 1, low);
            }
        }

        // if the target is never found, then the last index that was searched is where
        // it would be
        return midIndex;

    }
}