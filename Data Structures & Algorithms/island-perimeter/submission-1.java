class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] dr = {1,-1,0,0};
        int[] dl = {0,0,-1,1};
        int sum = 0;       
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                     int p = 4;
                    for(int k=0;k<4;k++){
                        int ni = i+dr[k];
                        int nj = j+dl[k];
                        if(ni>=0 && ni<n && nj>=0 && nj<m){
                            if(grid[ni][nj]==1){
                                p--;
                            }                            
                        }
                    }
                    sum+=p;
                }
            }
        }
        return sum;
    }
}