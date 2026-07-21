class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        boolean vis[][] = new boolean[row][col];
        for(int i = 0 ; i < row ; i++){
            if(board[i][0]=='O' && !vis[i][0])
            dfs(i,0,vis,board);
        }
        for(int i = 0 ; i < row ; i++){
            if(board[i][col-1]=='O' && !vis[i][col-1])
            dfs(i,col -1,vis,board);
        }
        for(int i = 0 ; i < col ; i++){
            if(board[0][i]=='O' && !vis[0][i])
            dfs(0,i,vis,board);
        }
        for(int i = 0 ; i < col ; i++){
            if(board[row-1][i]=='O'&& !vis[row-1][i])
            dfs(row - 1,i,vis,board);
        }
        for(int i = 0; i < row ; i++){
            for(int j = 0;j < col ;j++){
                if(!vis[i][j] && board[i][j] == 'O') board[i][j] = 'X'; 
            }
        }
    }
    private void dfs(int r, int c, boolean[][] vis, char[][] grid){
        vis[r][c] = true;
        
        int dr[] = {1,-1,0,0};
        int dc[] = {0,0,-1,1};

        for(int k = 0 ; k < 4; k++){
            int nr = dr[k] + r;
            int nc = dc[k] + c;

            if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length
            && !vis[nr][nc] && grid[nr][nc]=='O') {
                dfs(nr,nc,vis,grid);
            }
        }
    }
}
