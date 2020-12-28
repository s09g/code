class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UF uf = new UF(edges.length + 1);
        for (int[] e: edges) {
            if (uf.find(e[0]) == uf.find(e[1])) {
                return e;
            }
            uf.union(e[0], e[1]);
        }
        return new int[0];
    }

    class UF {
        int count;
        int[] size;
        int[] id;

        public UF(int n) {
            count = n;
            size = new int[n];
            id = new int[n];
            for (int i = 0 ; i < n ; i++) {
                size[i] = 1;
                id[i] = i;
            }
        }

        public boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if (pa == pb) return false;
            if (size[pa] < size[pb]) {
                size[pb] += size[pa];
                id[pa] = pb;
            } else {
                size[pa] += size[pb];
                id[pb] = pa;
            }
            count--;
            return true;
        }


        public int find(int n) {
            while (n != id[n]) {
                id[n] = id[id[n]];
                n = id[n];
            }
            return n;
        }
    }
}