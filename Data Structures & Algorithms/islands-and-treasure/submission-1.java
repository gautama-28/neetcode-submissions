class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        Queue<int[]> q= new LinkedList<>();

        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(grid[i][j]==0) {
                    q.offer(new int[]{i,j});
                }
            }
        }   
        bfs(grid,q);     
    }
    private void bfs(int[][] grid, Queue<int[]> q)
    {   
        int dr[] = {1,-1,0,0};
        int dc[] = {0,0,-1,1};
        while(!q.isEmpty()){
        int idx[] = q.poll();
        int r = idx[0];
        int c = idx[1];
        for(int k = 0 ; k < 4 ; k++){
            int nr = dr[k] + r;
            int nc = dc[k] + c;
            if(nr>=0 && nc>=0 && nr<grid.length && 
                nc<grid[0].length && grid[nr][nc]==2147483647){
                    grid[nr][nc] = Math.min(grid[nr][nc], grid[r][c] + 1);
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
