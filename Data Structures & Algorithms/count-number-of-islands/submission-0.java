class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        boolean[][] vis = new boolean[row][col];
        int count = 0;

        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(!vis[i][j] && grid[i][j]=='1')
                {   
                    count++;
                    dfs(i,j,vis,grid);
                }
            }
        }
        return count;
    }
    public void dfs(int row, int col , boolean[][] vis, char[][] grid)
    {   
        vis[row][col] = true;
        int dr[] = {1,-1,0,0};
        int dc[] = {0,0,-1,1};

        for(int k = 0; k < 4 ; k++){
            int nr = dr[k] + row;
            int nc = dc[k] + col;
            if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && !vis[nr][nc] && grid[nr][nc]=='1')
            dfs(nr,nc,vis,grid);
        }
    }
}
