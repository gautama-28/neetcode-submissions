class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if(words.length == 1) return true;
        int[] rank = new int[26];

        int i = 0;
        for(char ch : order.toCharArray()){
            rank[ch - 'a'] = i++;
        }

        for(i = 0; i < words.length - 1 ; i++){
            if(compare(words[i],words[i+1], rank)) return false;
        }
        return true;
    }
    public boolean compare(String a, String b , int[] rank){
        int i = 0;
        while(i < Math.min(a.length(),b.length())){
            char ch1 = a.charAt(i);
            char ch2 = b.charAt(i);
            i++;
            if(ch1==ch2) continue;
            else
            return rank[ch1 - 'a'] > rank[ch2 - 'a']; 
        }
        return a.length() > b.length();        
    }
}