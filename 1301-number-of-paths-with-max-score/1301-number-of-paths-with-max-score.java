class Solution {

    private static final int MOD = 1000000007;
    private int n;
    private List<String> board;
    private int[][] maxScore;
    private int[][] ways;
    private boolean[][] visited;

    private int[] solve(int i, int j) {
        if (i < 0 || j < 0) return new int[]{-1, 0};

        if (board.get(i).charAt(j) == 'X')
            return new int[]{-1, 0};

        if (i == 0 && j == 0)
            return new int[]{0, 1};

        if (visited[i][j])
            return new int[]{maxScore[i][j], ways[i][j]};

        visited[i][j] = true;

        int val = (board.get(i).charAt(j) == 'S') ? 0 : board.get(i).charAt(j) - '0';

        int[] up = solve(i - 1, j);
        int[] left = solve(i, j - 1);
        int[] diag = solve(i - 1, j - 1);

        int best = Math.max(up[0], Math.max(left[0], diag[0]));

        if (best == -1) {
            maxScore[i][j] = -1;
            ways[i][j] = 0;
            return new int[]{-1, 0};
        }

        long count = 0;

        if (up[0] == best)
            count = (count + up[1]) % MOD;
        if (left[0] == best)
            count = (count + left[1]) % MOD;
        if (diag[0] == best)
            count = (count + diag[1]) % MOD;

        maxScore[i][j] = best + val;
        ways[i][j] = (int) count;

        return new int[]{maxScore[i][j], ways[i][j]};
    }

    public int[] pathsWithMaxScore(List<String> board) {
        this.board = board;
        n = board.size();

        maxScore = new int[n][n];
        ways = new int[n][n];
        visited = new boolean[n][n];

        int[] ans = solve(n - 1, n - 1);

        if (ans[0] == -1)
            return new int[]{0, 0};

        return ans;
    }
}