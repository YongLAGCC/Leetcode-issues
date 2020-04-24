# 34. Find First and Last Position of Element in Sorted Array

# time complexity: O(log(n))， n is the length of the input Array, Binary search is invoked twice, so the overall complexity is logarithmic
# space complexity: O(1). All work is done in place, so the overall memory usage is constant.

# 错误点： recurrsive 不太好找，Binary search 非常巧妙的避开了 boolean。 


class Solution {
    //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/discuss/534490/100-faster-binary-search-JAVA    (Binary Search)
  public int[] searchRange(int[] nums, int target) {
        int left = 0; 
        int right = nums.length - 1; 
        int ans [] = new int [2]; 
        ans[0] = found(nums, target, false);
        ans[1] = found(nums, target, true); 
      return ans; 
    }
    public int found(int [] nums, int target, boolean findLeft) {
        int left = 0; 
        int right = nums.length - 1; 
        int result = -1; 
        while(left <= right){
            int mid = left + (right - left) / 2; 
            
            if(nums[mid] == target) {
                result = mid;
            }
            if(nums[mid] < target || (nums[mid] == target && findLeft)){
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }
        return result; 
    }
}
