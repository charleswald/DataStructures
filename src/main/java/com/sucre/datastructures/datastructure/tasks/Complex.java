package com.sucre.datastructures.datastructure.tasks;

import java.util.ArrayList;
import java.util.List;

public class Complex {

    public static List<Integer> getNumPairs(int serverNodes, List<Integer> serverFrom, List<Integer> serverTo, List<Integer> serverWeight, int signalSpeed) {
        List<Triple> triples = new ArrayList<>();
        int numEdges = Math.min(serverFrom.size(), Math.min(serverTo.size(), serverWeight.size()));

        for (int i = 0; i < numEdges; i++) {
            triples.add(new Triple(serverFrom.get(i), serverTo.get(i), serverWeight.get(i)));
        }

        ServerTree serverTree = new ServerTree(serverNodes, signalSpeed);

        for (Triple triple : triples) {
            serverTree.addEdge(triple.serverFrom, triple.serverTo, triple.serverWeight);
        }

        return serverTree.countPairs();
    }


}

class Server {
    int id;
    List<Edge> edges;

    public Server(int id) {
        this.id = id;
        this.edges = new ArrayList<>();
    }
}

class Edge {
    int serverTo;
    int weight;

    public Edge(int serverTo, int weight) {
        this.serverTo = serverTo;
        this.weight = weight;
    }
}

class ServerTree {
    Server[] servers;
    int signalSpeed;
    List<Integer> result;

    public ServerTree(int numServers, int signalSpeed) {
        servers = new Server[numServers];
        result = new ArrayList<>();
        this.signalSpeed = signalSpeed;

        for (int i = 0; i < numServers; i++) {
            servers[i] = new Server(i);
        }
    }

    public void addEdge(int serverFrom, int serverTo, int weight) {
        servers[serverFrom].edges.add(new Edge(serverTo, weight));
        servers[serverTo].edges.add(new Edge(serverFrom, weight)); // Assuming undirected tree
    }

    public List<Integer> countPairs() {
        for (int i = 0; i < servers.length; i++) {
            dfs(i, i, 0, new ArrayList<>());
        }
        return result;
    }

    private void dfs(int root, int current, int distance, List<Integer> distances) {
        distances.add(distance);

        for (Edge edge : servers[current].edges) {
            if (edge.serverTo != root) {
                dfs(current, edge.serverTo, distance + edge.weight, distances);
            }
        }

        int count = 0;
        for (int d : distances) {
            if (d % signalSpeed == 0) {
                count++;
            }
        }
        result.add(count);
        distances.remove(distances.size() - 1);
    }

}




class Triple {
    int serverFrom;
    int serverTo;
    int serverWeight;

    public Triple(int serverFrom, int serverTo, int serverWeight) {
        this.serverFrom = serverFrom;
        this.serverTo = serverTo;
        this.serverWeight = serverWeight;
    }
}

