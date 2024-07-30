package graph;

/**
 * 200. 岛屿数量
 *
 * @author tenji
 * @date 2024-07-31
 */
public class NumberOfIslands200 {

    public static void main(String[] args) {

        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        // 输入：grid = [[1,1,1,1,0],[1,1,0,1,0],[1,1,0,0,0],[0,0,0,0,0]]
        // 输出：1

        System.out.println(new NumberOfIslands200().numIslands(grid));
    }

    public int numIslands(char[][] grid) {

        /*
        网格类问题，深度优先搜索。

        1、当前坐标的值为 '1' 时，完成深度优先搜索，并将已遍历的坐标值修改为 '2'，岛屿数量 +1；
        2、当前坐标的值不是 '1' 时，跳过，
         */

        int res = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    dfs(grid, r, c);
                    res++;
                }
            }
        }

        return res;
    }

    void dfs(char[][] grid, int r, int c) {
        // 坐标不在网格内
        if (!inArea(grid, r, c)) {
            return;
        }

        // 该坐标已访问过
        if (grid[r][c] != '1') {
            return;
        }
        grid[r][c] = '2';

        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    boolean inArea(char[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}
