class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==1 || trust.length == 0) return -1;
        
        HashMap<Integer,Integer> mp = new HashMap<>();
        HashSet<Integer> trustees = new HashSet<>();

        for(int[] row : trust){
            mp.put(row[1], mp.getOrDefault(row[1], 0) + 1);
            trustees.add(row[0]);
        }
        
        for (Integer key : mp.keySet()){
            if( mp.get(key)== n-1 && !trustees.contains(key)) return key;

        }
        return -1;
    }
}