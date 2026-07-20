class Solution {

    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Pacific: top row
        for (int j = 0; j < cols; j++) {
            dfs(0, j, heights, pacific);
        }

        // Pacific: left column
        for (int i = 0; i < rows; i++) {
            dfs(i, 0, heights, pacific);
        }

        // Atlantic: bottom row
        for (int j = 0; j < cols; j++) {
            dfs(rows - 1, j, heights, atlantic);
        }

        // Atlantic: right column
        for (int i = 0; i < rows; i++) {
            dfs(i, cols - 1, heights, atlantic);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    private void dfs(int r, int c, int[][] heights, boolean[][] vis) {

        if (vis[r][c]) return;

        vis[r][c] = true;

        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];

            if (nr >= 0 && nr < heights.length &&
                nc >= 0 && nc < heights[0].length &&
                !vis[nr][nc] &&
                heights[nr][nc] >= heights[r][c]) {

                dfs(nr, nc, heights, vis);
            }
        }
    }
}