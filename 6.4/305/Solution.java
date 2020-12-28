import java.util.*;

class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        int[][] island = new int[m][n];
        int total = m * n;
        UF uf = new UF(total);

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for (int[] p : positions) {
            if (island[p[0]][p[1]] != 1) {
                island[p[0]][p[1]] = 1;
                total--;
                for (int i = 0 ; i < 4; i++) {
                    int x = p[0] + dx[i], y = p[1] + dy[i];
                    if (x >= 0 && y >= 0 && x < m && y < n && island[x][y] == 1)
                        uf.union(p[0] * n + p[1], x * n + y);
                }
            }
            ans.add(uf.count - total);
        }
        return ans;
    }

    class UF {
        int count;  // 记录当前包含集合的个数
        int[] size; // 记录每个集合的大小
        int[] id; // 每一个节点保存着到它的父节点的引用

        public UF (int n) {
            // 初始时，每个节点是只包含它本身的集合
            count = n; // n个节点对应n个集合
            // 创建与节点个数相同大小的两个数组
            size = new int[n];
            id = new int[n];
            for (int i = 0 ; i < n; i++) {
                // 因为每个初始集合是只包含节点本身
                size[i] = 1; // 集合大小为1
                id[i] = i; // 集合id为节点本身的id
            }
        }

        public int find(int n) {
            // 根据当前节点父节点的引用向根行进，直到到达树根
            while (n != id[n]) {
                id[n] = id[id[n]]; // 路径压缩，改变每一个节点的引用
                n = id[n];
            }
            return n;
        }

        public boolean union(int a, int b) {
            // 分别找到a, b的父节点
            int pa = find(a);
            int pb = find(b);
            // a & b已经属于统一集合
            if (pa == pb) return false;

            // 将小的集合合并入大的集合
            if (size[pa] < size[pb]) {
                id[pa] = pb;
                size[pb] += size[pa];
            } else {
                id[pb] = pa;
                size[pa] += size[pb];
            }
            count--; // 合并后，集合个数减1
            return true; // 合并成功
        }
    }
}