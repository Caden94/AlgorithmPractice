package algorithmsAndDataStructures.graph;

public class UnionFind {
    private int[] id;
    private int[] size;

    public UnionFind(int n) {
        this.id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        this.size = new int[n];
    }

    public UnionFind(int[] id, int[] size) {
        this.id = id;
        this.size = size;
    }

    public int find(int i) {
        //Find with Path Compression
        while(i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if(i == j) {
            return;
        }
        //Weighted Union
        if(size[i] < size[j]) {
            id[i] = id[j];
            size[j] += size[i];
        } else {
            id[j] = id[i];
            size[i] += size[j];
        }
    }

}
