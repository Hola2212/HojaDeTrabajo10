import java.util.*;

public class Graph {

    private Map<String, Integer> indexMap;
    private List<String> cities;
    private float[][] dist;
    private int[][] next;

    public Graph(Vector<Token> tokens) {
        indexMap = new HashMap<>();
        cities = new ArrayList<>();

        for (Token t : tokens) {
            addCity(t.getOrigin());
            addCity(t.getDestination());
        }

        int n = cities.size();
        dist = new float[n][n];
        next = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = Float.POSITIVE_INFINITY;
                next[i][j] = -1;
            }
        }

        for (Token t : tokens) {
            int i = indexMap.get(t.getOrigin());
            int j = indexMap.get(t.getDestination());
            dist[i][j] = t.getDistance();
            next[i][j] = j;
        }
    }

    private void addCity(String name) {
        if (!indexMap.containsKey(name)) {
            indexMap.put(name, cities.size());
            cities.add(name);
        }
    }

    public void floyd() {
        int n = dist.length;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
    }

    public List<String> getPath(String from, String to) {
        List<String> path = new ArrayList<>();

        Integer i = indexMap.get(from);
        Integer j = indexMap.get(to);

        if (i == null || j == null) return path;
        if (next[i][j] == -1) return path;

        path.add(from);

        while (i != j) {
            i = next[i][j];
            path.add(cities.get(i));
        }

        return path;
    }

    public float getDistance(String from, String to) {
        return dist[indexMap.get(from)][indexMap.get(to)];
    }

    public String getCenter() {
        float minMax = Float.POSITIVE_INFINITY;
        String center = null;

        for (int i = 0; i < dist.length; i++) {
            float max = 0;

            for (int j = 0; j < dist.length; j++) {
                if (dist[i][j] > max) {
                    max = dist[i][j];
                }
            }

            if (max < minMax) {
                minMax = max;
                center = cities.get(i);
            }
        }

        return center;
    }

    public void removeEdge(String from, String to) {
        int i = indexMap.get(from);
        int j = indexMap.get(to);
        dist[i][j] = Float.POSITIVE_INFINITY;
        next[i][j] = -1;
    }

    public void addEdge(String from, String to, float distance) {
        int i = indexMap.get(from);
        int j = indexMap.get(to);
        dist[i][j] = distance;
        next[i][j] = j;
    }
}