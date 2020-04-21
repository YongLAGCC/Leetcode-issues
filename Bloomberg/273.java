
#Time complexity : O(N). the number N of digits in the input.
#Space complexity : O(1) since the output is just a string.


# 错误点： 忘记细节。should call helper function every time. 

class Solution {
    
        
        String [] below20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen","Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
    //arrays for values in tens after 19 
    String [] tens = {"","","Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"} ; 
    
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
     return words(num); 
    
    }
    
        public String words(int num)
        {
            StringBuilder sb = new StringBuilder(); 
           if(num / 1000000000 > 0)
           {
               sb.append(helper(num / 1000000000));
               sb.append(" Billion ");
               
               if(num % 1000000000 == 0)
                 return sb.toString().trim(); 
               sb.append(words(num % 1000000000));
           }
            
            
             else if(num / 1000000 > 0)
           {
              sb.append(helper(num / 1000000));
                sb.append(" Million ");
            if(num % 1000000 == 0)
                return sb.toString().trim(); 
            sb.append(words(num % 1000000));
               
           }
             else if(num / 1000 > 0)
            {
                sb.append(helper(num / 1000));
                sb.append(" Thousand ");
                if(num % 1000 == 0)
                    return sb.toString().trim(); 
                sb.append(helper(num % 1000));
            }
            else {
                sb.append(helper(num));
            }
            
        return sb.toString(); 
        }
        
    
    public String helper(int num){
        StringBuilder sb = new StringBuilder(); 
        if(num == 0) return ""; 
        if(num < 20) sb.append(below20[num]);
        
        else if(num < 100) 
        {
            sb.append(tens[num/10]);
            if(num % 10 > 0)
            {
                sb.append(" ");
            }
                sb.append(below20[num%10]);
        }
            
        else {
            sb.append(below20[num/100]);
            sb.append(" Hundred ");
            sb.append(helper(num%100));
            
        }  
    return sb.toString().trim(); 
    }
}