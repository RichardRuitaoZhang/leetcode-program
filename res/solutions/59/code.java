public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] a = new int[n][n];

        int[] startX = new int[] {0, 0, n - 1, n - 1};
        int[] startY = new int[] {0, n - 1, n - 1, 0};
        int[] startDx = new int[] {1, 1, -1, -1};
        int[] startDy = new int[] {1, -1, -1, 1};
        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {1, 0, -1, 0};

        int cur = 0;

        for (int i = 0; ; ++i) {
            int l = n - 2 * i - 1;

            if (l == 0) a[n / 2][n / 2] = n * n;
            if (l < 1) break;

            for (int j = 0; j < 4; ++j) {
                int x = startX[j] + i * startDx[j];
                int y = startY[j] + i * startDy[j];

                for (int k = 0; k < l; ++k) {
                    a[x + k * dx[j]][y + k * dy[j]] = ++cur;
                }
            }
        }

        return a;
    }
}
