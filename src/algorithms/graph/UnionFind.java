package algorithmsAndDataStructures.graph;

import java.util.PriorityQueue;

// use map to mapping the string to id if the given id is not integer
public class UnionFind {
    private int[] id;
    private int[] size;
    public int counts;

    public UnionFind(int n) {
        this.id = new int[n];
        this.size = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            size[i] = 1;
        }
        this.counts = n;
    }

    public UnionFind(int[] id, int[] size) {
        this.id = id;
        this.size = size;
        this.counts = id.length;
    }

    public int find(int i) {
        //Find without Path Compression
        while(i != id[i]) {
            // Path Compression -> Amortized O(1) operations
            // id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    // O(logN)
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // O(logN)
    public boolean union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if(i == j) {
            return false;
        }
        //Weighted Union -> make the tree balanced
        if(size[i] < size[j]) {
            id[i] = id[j];
            size[j] += size[i];
        } else {
            id[j] = id[i];
            size[i] += size[j];
        }
        counts--;
        return true;
    }
}

///*
// *   Minimum Spanning Tree
// */
//
///**
// * Definition for a Connection.
// */
//
//public class Connection {
//    public String city1, city2;
//    public int cost;
//    public Connection(String city1, String city2, int cost) {
//        this.city1 = city1;
//        this.city2 = city2;
//        this.cost = cost;
//    }
//  }
//
//public class Solution {
//    /**
//     * @param connections given a list of connections include two cities and cost
//     * @return a list of connections from results
//     */
//    public List<Connection> lowestCost(List<Connection> connections) {
//        // Write your code here
//        Collections.sort(connections, new Comparator<Connection>(){
//            public int compare(Connection o1, Connection o2) {
//                if (o1.cost != o2.cost) {
//                    return o1.cost - o2.cost;
//                } else {
//                    if (!o1.city1.equals(o2.city1)) {
//                        return o1.city1.compareTo(o2.city1);
//                    }
//                    return o1.city2.compareTo(o2.city2);
//                }
//            }
//        });
//        Map<String, Integer> map = new HashMap<>();
//        int count = 0;
//        for (Connection connection : connections) {
//            if (!map.containsKey(connection.city1)) {
//                map.put(connection.city1, count++);
//            }
//            if (!map.containsKey(connection.city2)) {
//                map.put(connection.city2, count++);
//            }
//        }
//        List<Connection> res = new ArrayList<>();
//        UnionFind unionFind = new UnionFind(map.size());
//        for (Connection connection : connections) {
//            String city1 = connection.city1;
//            String city2 = connection.city2;
//            if (unionFind.isConnected(map.get(city1), map.get(city2))) {
//                continue;
//            }
//            unionFind.union(map.get(city1), map.get(city2));
//            res.add(connection);
//        }
//        return unionFind.counts == 1 ? res : new ArrayList<Connection>();
//    }
//}