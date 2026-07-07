class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()){
            return "";
        }
        
        HashMap <Character,Integer> countT=new HashMap<>();
        for(char c:t.toCharArray()){
            countT.put(c,countT.getOrDefault(c,0)+1);
            
        }
        HashMap<Character,Integer> window=new HashMap<>();
         int left=0;
         int need=countT.size();
         int have=0;
         int minval=Integer.MAX_VALUE;
         int start=0;
       
        for(int right=0;right<s.length();right++){
            char c=s.charAt(right);
            window.put(c,window.getOrDefault(c,0)+1);
            if(countT.containsKey(c) && window.get(c).intValue()==countT.get(c).intValue()){
                have++;
            }
            while(have==need){
                if((right-left+1)<minval){
                    minval=right-left+1;
                    start=left;
                }
                char leftchar=s.charAt(left);
                window.put(leftchar, window.get(leftchar) - 1);
                if(countT.containsKey(leftchar) && window.get(leftchar)<countT.get(leftchar)){
                    have--;
                }
                left++;
            }
        }
        return minval == Integer.MAX_VALUE
        ? ""
        : s.substring(start, start + minval);
    }
}
