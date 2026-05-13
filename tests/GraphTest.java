import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {

    private Graph graph;

    @BeforeEach
    void setUp() {
        Vector<Token> tokens = new Vector<>();

        tokens.add(new Token("A", "B", 10f));   //Identificador de float. No hexadecimal.
        tokens.add(new Token("B", "C", 5f));
        tokens.add(new Token("A", "C", 20f));
        tokens.add(new Token("C", "D", 2f));
        tokens.add(new Token("D", "E", 1f));

        graph = new Graph(tokens);
        graph.floyd();
    }

    // =========================
    // 🔹 FLOYD / DISTANCIAS
    // =========================

    @Test
    void testShortestDistanceBasic() {
        assertEquals(15f, graph.getDistance("A", "C"), 0.001);
    }

    @Test
    void testShortestDistanceMultiHop() {
        assertEquals(17f, graph.getDistance("A", "D"), 0.001);
    }

    @Test
    void testDistanceToSelf() {
        assertEquals(0f, graph.getDistance("A", "A"), 0.001);
    }

    // =========================
    // 🔹 RUTAS
    // =========================

    @Test
    void testPathBasic() {
        List<String> expected = Arrays.asList("A", "B", "C");
        assertEquals(expected, graph.getPath("A", "C"));
    }

    @Test
    void testPathMultiHop() {
        List<String> expected = Arrays.asList("A", "B", "C", "D");
        assertEquals(expected, graph.getPath("A", "D"));
    }

    @Test
    void testPathSingleNode() {
        List<String> expected = Collections.singletonList("A");
        assertEquals(expected, graph.getPath("A", "A"));
    }

    // =========================
    // 🔹 ELIMINAR ARISTA
    // =========================

    @Test
    void testRemoveEdgeDirect() {
        graph.removeEdge("A", "C");
        graph.floyd();

        // ahora debe usar A -> B -> C
        assertEquals(15f, graph.getDistance("A", "C"), 0.001);
    }

    @Test
    void testRemoveEdgeBreakPath() {
        graph.removeEdge("B", "C");
        graph.removeEdge("A", "C");
        graph.floyd();

        assertEquals(Float.POSITIVE_INFINITY, graph.getDistance("A", "C"));
    }

    // =========================
    // 🔹 AGREGAR ARISTA
    // =========================

    @Test
    void testAddEdgeImprovesPath() {
        graph.addEdge("A", "D", 5f);
        graph.floyd();

        assertEquals(5f, graph.getDistance("A", "D"), 0.001);
    }

    @Test
    void testAddEdgeNewConnection() {
        graph.addEdge("E", "A", 3f);
        graph.floyd();

        assertEquals(3f, graph.getDistance("E", "A"), 0.001);
    }

    // =========================
    // 🔹 CENTRO DEL GRAFO
    // =========================

    @Test
    void testCenterExists() {
        String center = graph.getCenter();
        assertNotNull(center);
    }

    @Test
    void testCenterIsValidNode() {
        String center = graph.getCenter();

        List<String> nodes = Arrays.asList("A", "B", "C", "D", "E");
        assertTrue(nodes.contains(center));
    }

    // =========================
    // 🔹 CASOS BORDE
    // =========================

    @Test
    void testInvalidCityDistance() {
        assertEquals(Float.POSITIVE_INFINITY,
                graph.getDistance("X", "A"));
    }

    @Test
    void testInvalidCityPath() {
        assertTrue(graph.getPath("X", "A").isEmpty());
    }

    @Test
    void testNoPathExists() {
        graph.removeEdge("A", "B");
        graph.removeEdge("B", "C");
        graph.removeEdge("A", "C");
        graph.floyd();

        assertEquals(Float.POSITIVE_INFINITY,
                graph.getDistance("A", "C"));
    }

    // =========================
    // 🔹 CONSISTENCIA
    // =========================

    @Test
    void testDistanceMatchesPath() {
        List<String> path = graph.getPath("A", "C");
        float distance = graph.getDistance("A", "C");

        // A -> B -> C = 10 + 5 = 15
        assertEquals(15f, distance, 0.001);
        assertEquals(Arrays.asList("A", "B", "C"), path);
    }
}