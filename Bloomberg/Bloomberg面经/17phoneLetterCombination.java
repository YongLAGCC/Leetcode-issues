
# 17. Letter Combinations of a Phone Number

# Time complexity: Time complexity : O(3^N × 4^M) where N is the number of digits in the input that maps to 3 letters (e.g. 2, 3, 4, 5, 6, 8) and M is the number of digits in the input that maps to 4 letters (e.g. 7, 9),



# recurrsive Error I made

class Solution {
    
    public List<String> letterCombinations(String digits) {
        String [] mapping = {
            "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        List<String> result = new ArrayList<>(); 
        if(digits.length() == 0 || digits == null) 
            return result; 
        letterRecurrsive(result, "", 0, digits, mapping);
        
        return result; 
        }
    public void letterRecurrsive(List<String> result, String current, int index, String digits, String [] mapping){
        if(index == digits.length() ){
            result.add(current); 
            return ; 
        }
        
        String letter = mapping[digits.charAt(index) - '0'];
        for(int i = 0; i < letter.length(); ++i){
            letterRecurrsive(result, current + letter.charAt(i), index + 1, digits, mapping);
        }
        }
    }