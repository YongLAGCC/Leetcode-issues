# 702. Search in a Sorted Array of Unknown Size

# time complexity: O(log(T)) T is an index of target value.
# space complexity: O(1).

# 错误点： 边界的想象力，并不是binary Search. 


/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0; 
        int right = 1; 
   
        while(target > reader.get(right) ) {
                left = right; 
                right <<= 1;   
            }
        
        int mid = 0; 
        while(left <= right) {
            
            mid = left + ((right - left) >> 1) ; 
            if(reader.get(mid) == target) {
                return mid; 
            } else if (reader.get(mid) > target) {
                right = mid - 1; 
            } else  left = mid + 1; 
        }
        
        return -1; 
    }
}