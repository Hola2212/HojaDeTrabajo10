public class Aristas implements Comparable<Aristas> {
    private Ciudades destination;
    private int distance;
    public Aristas(Ciudades destination, int distance){
        this.destination = destination;
        this.distance = distance;
    }
    public int getDistance() {
        return distance;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }
    public Ciudades getDestination() {
        return destination;
    }
    public void setDestination(Ciudades destination) {
        this.destination = destination;
    }
    @Override
    public int compareTo(Aristas other){
        if (destination.compareTo(other.getDestination()) == 1 && distance == other.getDistance()){ return 1; }
        return 0;
    }
}