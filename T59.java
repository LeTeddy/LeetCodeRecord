class Solution {
    public static int[][] generateMatrix(int n) {
        // 循环不变量 ： 左闭右开
        // 保证每次循环 都遵循同一个规则 就不会乱
        int[][] res = new int[n][n];
        // 转几圈? n / 2圈
        int c_count = 0, startX = 0, startY = 0, offset = 1;
        int i = 0, j = 0, count = 1;
        while (c_count < n / 2) {
            for (j = startX; j < n - offset; j++) {
                //这一次i得是startY呀，不然就是上次循环的i，比如第二次循环的时候，这里的i就是0，就会开始修改1，1
                res[startY][j] = count++; // 先用count，再把count++
            }
            for (i = startY; i < n - offset; i++) {
                res[i][j] = count++;
            }
            for (; j > startX; j--) {
                res[i][j] = count++;
            }
            for (; i > startY; i--) {
                res[i][j] = count++;
            }
            offset++;
            c_count++;
            startY++;
            startX++;
        }
        if (n % 2 == 1) {
            res[n / 2][n / 2] = count;
        }
        return res;

    }
}