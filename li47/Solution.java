package day10.li47;

import java.util.regex.Matcher;

// 动态规划
public class Solution {
    public static int maxValue(int[][] grid) {
        // 行
        int i = 0;
        int j = 0;
        for (i = 0; i < grid.length ; i++) {
            // 遍历列
            for (j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0){
                    continue;
                }else if (i == 0 && j != 0){
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                }else if (i != 0 && j == 0){
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                }else {
                    // 左边 和 上面 的最大值，加上当前值
                    grid[i][j] = grid[i][j] + Math.max(grid[i][j - 1],grid[i-1][j]);
                }
            }
        }
        return grid[i - 1][j - 1];
    }

    public static void main(String[] args) {
        int[][] map = {{1, 3, 5}
                        ,{2, 5, 8}
                        ,{4, 7, 4}};
        maxValue(map);
    }
    // 方法二： 简洁判断，提升效率
    public int maxValue2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 初始化第一列
        for (int i = 1; i < m; i++){
            grid[i][0] = grid[i][0] + grid[i - 1][0];
        }
        // 初始化第一行
        for (int j = 1; j < n; j++){
            grid[0][j] = grid[0][j] + grid[0][j - 1];
        }
        // 除开第一行 第一列的数
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = grid[i][j] + Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[m - 1][n - 1];
    }


}
