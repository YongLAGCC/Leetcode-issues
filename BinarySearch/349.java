# 349. Intersection of Two Arrays(binary Search and sort)

# time complexity: O(nlog(n)).
# space complexity: O(n).

# 错误点： last for loop. 小心。 


class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Arrays.sort(nums1); 
        Set<Integer> set = new HashSet<>(); 
        for(int num: nums2){
            if(Arrays.binarySearch(nums1, num) >= 0) {
                set.add(num);
            }
        }
        int [] ans = new int [set.size()];
        int i = 0;
        for(Integer setEle: set)
            ans[i++] = setEle; 
    
        return ans; 
    
    }
} 
