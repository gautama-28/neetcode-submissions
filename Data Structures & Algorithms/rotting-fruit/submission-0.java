class Solution {
    class Pair {
        int row ;
        int col ;
        int min;
        Pair(int _row, int _col , int _min){
            this.row = _row;
            this.col = _col;
            this.min = _min;
        }
    }
       
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        //boolean vis[][] = new boolean[row][col];
        int ans = 0; 
        int count = 0;
        for(int i = 0 ; i < row ;i++){
            for(int j = 0 ; j < col ; j++){
                if(grid[i][j]==2) q.offer(new Pair(i,j,0));
                else if(grid[i][j]==1) count++;
            }
        }
        int dr[] = {1,-1,0,0};
        int dc[] = {0,0,-1,1};

        while(!q.isEmpty()){
            Pair orange = q.poll();
            int r = orange.row;
            int c = orange.col;
            int t = orange.min;
            ans = Math.max(ans,t);

            for(int k = 0 ; k < 4 ; k++){
                int nr = r + dr[k];
                int nc = c + dc[k];
                if(nr>=0 && nc>=0 && nr<row && nc<col && grid[nr][nc]==1){                    
                    q.offer(new Pair(nr,nc,t+1));
                    grid[nr][nc] = 2;
                    count--;
                }
            }
        }
        return count==0?ans:-1;
    }
}
