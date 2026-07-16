class Solution {
    int area;
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        boolean vis[][] = new boolean[row][col];
        int ans = 0;
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(grid[i][j]==1 && !vis[i][j])
                {   
                    area = 0;
                    dfs(i,j,vis,grid);
                    ans = Math.max(ans,area);
                }
            }
        }
        return ans;
    }
    public void dfs(int r, int c , boolean[][] vis, int[][] grid){
        vis[r][c]=true;
        area++;

        int dr[] = {1,-1,0,0};
        int dc[] = {0,0,-1,1};

        for(int k = 0 ; k < 4 ; k++){
            int nr = dr[k] + r;
            int nc = dc[k] + c;

            if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && grid[nr][nc]==1 && !vis[nr][nc])
            dfs(nr,nc,vis,grid);
        }
    }
}
