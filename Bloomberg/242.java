#242. Valid Anagram

# Time complexity is O(n) because accessing the counter is constant 
# Space complexity: O(1) 


# 错误点， 没有想起 Hash table 的方法做， 而是用了 sorting array， then compare
class Solution {
    public boolean isAnagram(String s, String t) {
        
        int letter [] = new int [26];
        if(s.length() != t.length()) return false; 
        
        for(int i = 0; i < s.length(); ++i){
            letter[s.charAt(i) - 'a']++;
            letter[t.charAt(i) - 'a']--;
        }
       for(int count: letter) 
           if(count != 0)
               return false;
        return true; 
       
    }
}