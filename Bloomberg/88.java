# 88. Merge Sorted Array

# time complexity: O(n+m), n, m are the length of two input arrays.
# space complexity: O(1) by using original array.

# 错误点： 注意语法 System.arraycopy(), 最后的copy 长度应该是 arr2 + 1. 




class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // two pointer
        int arr1 = m - 1; 
        int arr2 = n - 1; 
        int ans = m + n - 1;
        
        while(arr2 >= 0 && arr1 >=0){
            nums1[ans--] = nums1[arr1] > nums2[arr2] ? nums1[arr1--] : nums2[arr2--];
        }
        
        System.arraycopy(nums2, 0, nums1, 0, arr2 + 1);
       
    }
}