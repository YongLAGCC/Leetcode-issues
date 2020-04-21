#Sort Characters By Frequency

#Time Complexity : O(nlogn)， sorted。 String to list， O（n) etc.
#Space Complexity : O(n).

#错误： 想法单一， 逻辑条理不够， 应 sort， 放入array， 在sort by length
#： Lambda funtion comparsion 不熟

class Solution {
    public String frequencySort(String s) {
       if(s.length() <= 0) return ""; 
        char [] input = s.toCharArray(); 
        Arrays.sort(input);
        
        List<String> list = new ArrayList<>(); 
        StringBuilder currentString = new StringBuilder(); 
        
        currentString.append(input[0]);
        
        for(int i = 1; i < input.length; ++i)
        {
            if(input[i] != input[i-1])
            {
                list.add(currentString.toString());
                currentString = new StringBuilder(); 
            }
            currentString.append(input[i]);
        }
        list.add(currentString.toString());
        
        Collections.sort(list, (a, b) -> b.length() - a.length());
        
        StringBuilder ans = new StringBuilder(); 
        for(String element: list) ans.append(element); 
        return ans.toString(); 
            
    }
}