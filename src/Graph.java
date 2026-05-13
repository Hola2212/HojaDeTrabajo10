import java.util.*;

public class Graph {

    private Map<String, Integer> indexMap;
    private List<String> cities;

    private float[][] graph; // grafo original
    private float[][] dist;  // resultado de Floyd
    private int[][] next;

    public Graph(Vector<Token> tokens) {
        indexMap = new HashMap<>();
        cities = new ArrayList<>();

        for (Token t : tokens) {
            addCity(t.getOrigin());
            addCity(t.getDestination());
        }

        int n = cities.size();

        graph = new float[n][n];
        dist = new float[n][n];
        next = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) graph[i][j] = 0;
                else graph[i][j] = Float.POSITIVE_INFINITY;
            }
        }

        for (Token t : tokens) {
            int i = indexMap.get(t.getOrigin());
            int j = indexMap.get(t.getDestination());
            graph[i][j] = t.getDistance();
        }
    }

    private void addCity(String name) {
        if (!indexMap.containsKey(name)) {
            indexMap.put(name, cities.size());
            cities.add(name);
        }
    }

    public void floyd() {
        int n = graph.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = graph[i][j];

                if (i != j && graph[i][j] != Float.POSITIVE_INFINITY) {
                    next[i][j] = j;
                } else {
                    next[i][j] = -1;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (dist[i][k] == Float.POSITIVE_INFINITY ||
                            dist[k][j] == Float.POSITIVE_INFINITY)
                        continue;

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

        while (!i.equals(j)) {
            i = next[i][j];
            path.add(cities.get(i));
        }

        return path;
    }

    public float getDistance(String from, String to) {
        Integer i = indexMap.get(from);
        Integer j = indexMap.get(to);

        if (i == null || j == null) return Float.POSITIVE_INFINITY;

        return dist[i][j];
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
        Integer i = indexMap.get(from);
        Integer j = indexMap.get(to);

        if (i == null || j == null) {
            System.out.println("Ciudad no encontrada");
            return;
        }

        graph[i][j] = Float.POSITIVE_INFINITY;
    }

    public void addEdge(String from, String to, float distance) {
        Integer i = indexMap.get(from);
        Integer j = indexMap.get(to);

        if (i == null || j == null) {
            System.out.println("Ciudad no encontrada");
            return;
        }

        graph[i][j] = distance;
    }
}