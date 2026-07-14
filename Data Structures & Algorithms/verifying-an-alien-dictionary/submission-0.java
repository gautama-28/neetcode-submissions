class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int i = 0;
        for(char ch : order.toCharArray()){
            mp.put(ch,i++);
        }
        if(words.length==1) return true;;
        int a = 0 , b = 1;
        while(b < words.length){
            if(!compare(words[a],words[b],mp)) return false;
            a++; b++;
        }
        return true;
    }
    public boolean compare(String a, String b,HashMap<Character, Integer> mp){
        //String ki length jisme dono same hai
        //Chracter map se
        //phle character krte hai fir size
        int i = 0;
        while (i < Math.min(a.length(), b.length())) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);

            if (c1 != c2) {
                return mp.get(c1) < mp.get(c2);
            }

            i++;
        }

        // All compared characters are same
        return a.length() <= b.length();    
    }
}