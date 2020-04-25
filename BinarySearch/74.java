# 74. Search a 2D Matrix

# time complexity: O(log(mn))， m: # of row, n: # or col.
# space complexity: O(1).

# 错误点： while loop condition, 小心细节。 


class Solution {
    public boolean searchMatrix(int[][] matrix, int target)     {
        
        int row = matrix.length; 
        if(row == 0) return false; 
        
        int col = matrix[0].length; 
        int end = row * col - 1, start = 0; 
        
        while( start <= end) {
            int mid = start + (end - start) / 2; 
            int r = mid / col; 
            int c = mid % col; 
            
            if(matrix[r][c] == target) 
                return true; 
            else if(matrix[r][c] > target) 
                end = mid - 1; 
            else 
                start = mid + 1;
        }
        return false; 
      
    }   
}