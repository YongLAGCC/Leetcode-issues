# 658. Find K Closest Elements

# time complexity: O(log(n) + k) k is the length of output.
# space complexity: O(k) by using list in length of k.

# 错误点： 对 binarySearch collecton 不熟悉. 浪费了大量时间。 


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new LinkedList<>(); 
        
        if (arr == null || arr.length == 0) return ans;
        int index = Arrays.binarySearch(arr, x);
        
        int right = -1, left = -1;
        if(index < 0)
        {
            index = Math.abs(index) - 1; 
            right = index; 
        } else {
            ans.add(arr[index]);
            right = index + 1; 
            k--;
        }
        left = index - 1;
        
        while(k > 0) {
            int absLeft = left < 0 ? Integer.MAX_VALUE : Math.abs(x - arr[left]);
            int absRight = right > arr.length -1 ? Integer.MAX_VALUE : Math.abs(x - arr[right]);
            
            if (absLeft <= absRight) {
                ((LinkedList<Integer>)ans).addFirst(arr[left--]);
            }else{
                ans.add(arr[right++]);
            } k--;
        }
        return ans; 
    }
}