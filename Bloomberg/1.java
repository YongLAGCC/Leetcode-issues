#54. Spiral Matrix
# Layer by Layer

# Time Complexity: O(N)O(N), where NN is the total number of elements in the input matrix
# Space Complexity: O(N)O(N), the information stored in list


# 错误点： 注意边界问题的处理， 特别是每一个layer 之后的处理。 


 public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>(); 
        
        if(matrix.length == 0) return list;
        int row1 = 0, row2 = matrix.length -1;
        int col1 = 0, col2 = matrix[0].length -1; 
        
        while(row1 <= row2 && col1 <= col2){
            
            for(int col = col1; col <= col2; ++col) list.add(matrix[row1][col]);
            for(int row = row1+1; row <= row2; ++row) list.add(matrix[row][col2]);
            
            if(row1 < row2 && col1 < col2){
                for(int col = col2 - 1; col > col1; --col) list.add(matrix[row2][col]);
                for(int row = row2; row > row1; --row) list.add(matrix[row][col1]);
            }
            col1++;
            col2--;
            row1++;
            row2--;
        }
        return list;
    }