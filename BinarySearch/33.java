# 33. Search in Rotated Sorted Array

# time complexity: O(log(n)) 用Binary search.
# space complexity: O(n).

# 错误点： two pass Bindary Search 有 bug， 没有找到原因。
# one pass 如下， 比较难以理解。 

//https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/589342/Java-solution-or-O(logn)-or-beats-100-of-java-submissions

class Solution {
 
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1; 
        while(start <= end) {  // 注意
            int mid = start + (end - start) / 2; 
            if(nums[mid] == target) return mid; 
            
            else if (nums[mid] >= nums[start]) {
                if(target >= nums[start] && target < nums[mid]) end = mid - 1; 
                else start = mid + 1; 
                
            } 
            else {
                if(target <= nums[end] && target > nums[mid]) start = mid + 1;
                else end = mid - 1;
            }
        }
        return -1;
    }
}
