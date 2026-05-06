import java.util.Comparator;
import java.util.Vector;
public class Ciudades implements Comparable<Ciudades> {
    private String name;
    private Vector<Aristas> conections;
    public Ciudades(String name){
        this.name = name;
        this.conections = new Vector<>();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) { //Innecesario ya que no se modificarán los nombres de las Ciudades
        this.name = name;
    }
    public Aristas getConection(Ciudades destination) {
        for (Aristas conection : conections){
            if (compareTo(destination) == 0){
                return conection;
            }
        }
        return null;
    }
    public void addConection(Ciudades destination, Float distance) {
        this.conections.add(new Aristas(destination, distance));
    }
    @Override
    public int compareTo(Ciudades other) {
        return this.name.compareToIgnoreCase(other.getName());
    }
}
