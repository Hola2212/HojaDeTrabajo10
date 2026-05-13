import java.util.*;

public class Main {
    public static void main(String[] args) {
        Vector<Token> tokens = new FileReaderUtil().ReadFile("src/resources/guategrafo.txt");
        Graph g = new Graph(tokens);
        g.floyd();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Ruta más corta");
            System.out.println("2. Centro del grafo");
            System.out.println("3. Modificar grafo");
            System.out.println("4. Salir");
            int op = sc.nextInt();
            if (op == 1) {
                System.out.print("Origen: ");
                String a = sc.next();
                System.out.print("Destino: ");
                String b = sc.next();
                System.out.println("Ruta: " + g.getPath(a, b));
                System.out.println("Distancia: " + g.getDistance(a, b));
            }
            else if (op == 2) {
                System.out.println("Centro: " + g.getCenter());
            }
            else if (op == 3) {
                System.out.println("1. Eliminar conexión");
                System.out.println("2. Agregar conexión");
                int sub = sc.nextInt();
                if (sub == 1) {
                    String a = sc.next();
                    String b = sc.next();
                    g.removeEdge(a, b);
                } else {
                    String a = sc.next();
                    String b = sc.next();
                    float d = sc.nextFloat();
                    g.addEdge(a, b, d);
                }
                g.floyd();
            }
            else break;
        }
    }
}