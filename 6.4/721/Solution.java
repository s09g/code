import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> email2Id = new HashMap<>();
        UF uf = new UF(accounts.size());

        for (int i = 0; i < accounts.size(); i++) {
            List<String> acc = accounts.get(i);
            for (int j = 1; j < acc.size(); j++) {
                String email = acc.get(j);
                email2Id.putIfAbsent(email, i);
                uf.union(i, email2Id.get(email));
            }
        }

        HashMap<Integer, List<String>> id2Email = new HashMap<>();
        for (String email: email2Id.keySet()) {
            int id = uf.find(email2Id.get(email));
            id2Email.putIfAbsent(id, new ArrayList<>());
            id2Email.get(id).add(email);
        }

        List<List<String>> result = new ArrayList<>();
        for (int id : id2Email.keySet()) {
            List<String> account = new ArrayList<>();
            result.add(account);

            String name = accounts.get(id).get(0);
            account.add(name);

            List<String> email = id2Email.get(id);
            Collections.sort(email);

            account.addAll(email);
        }
        return result;
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

            if (pa == pb)
                return false;
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