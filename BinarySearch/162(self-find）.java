# 162. Find Peak Element

# time complexity: O(log 2 ^ (n)).
# space complexity: O(1).

# 错误点： Binary Search, 觉的重在考察对题的理解，并不是binary Search 。 


class Solution {
    public int findPeakElement(int[] nums) {
        
        int left = 0; 
        int right = nums.length - 1; 
      
        while(left < right) {
            int mid = left + (right - left) / 2; 
            
            if(nums[mid] > nums[mid + 1])
                right = mid;       // 错误点
            else 
                left = mid + 1;
        }
        return left;
    }
}