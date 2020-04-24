# 350. Intersection of Two Arrays II (binary Search and sort)

# time complexity: O(nlog(n) + k).
# space complexity: O(n) by using list in length of k.

# 错误点： binarySearch should return index of the array that matchs with num2. could not return true and false. 


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
       
        Arrays.sort(nums1);
        
       
        List<Integer> nums1List = new ArrayList<>(); 
        
        for(int num : nums1) 
        {
            nums1List.add(num);     
        }
        
         List<Integer> ans = new ArrayList<>(); 
        
        for(int num: nums2){
            int indx = binarySearch(nums1List, num);
            if (indx != -1){
                nums1List.remove(indx);
                ans.add(num);
            }
        }
        int [] ret = new int [ans.size()];
        int k = 0; 
        for(int ele: ans){
            ret[k++] = ele; 
        }
        return ret;
    }
    public int binarySearch(List<Integer> nums1, int num2) {
        
        int left = 0, right = nums1.size() -1; 
        while(left <= right) // get mistake here
        {
            int mid = left + (right - left) / 2; 
            if(nums1.get(mid) == num2){
                return mid;
            }else if( nums1.get(mid) > num2)
            {
                right = mid - 1; 
            } else {
                left = mid + 1; 
            }
        }
        return -1; 
    }
}