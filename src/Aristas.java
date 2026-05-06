public class Aristas implements Comparable<Aristas> {
    private Ciudades destination;
    private Float distance;
    private boolean condition;
    public Aristas(Ciudades destination, Float distance){
        this.destination = destination;
        this.distance = distance;
        this.condition = true;
    }
    public Float getDistance() {
        if (condition){
            return distance;
        }
        return Float.POSITIVE_INFINITY;
    }
    public void setDistance(Float distance) {
        this.distance = distance;
    }
    public Ciudades getDestination() {
        return destination;
    }
    public void setDestination(Ciudades destination) {
        this.destination = destination;
    }
    public void disableEdge(){ this.condition = false; }
    public void enableEdge(){ this.condition = true; }
    @Override
    public int compareTo(Aristas other){
        if (destination.compareTo(other.getDestination()) == 0 && distance.equals(other.getDistance())){ return 0; }
        if (destination.compareTo(other.getDestination()) == 0){ return 1; }
        return -1;
    }
}