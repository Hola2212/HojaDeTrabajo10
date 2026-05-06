public class Token {
    private String origin;
    private String destination;
    private Float distance;
    public Token(String origin, String destination, Float distance){
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
    }
    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public Float getDistance() {
        return distance;
    }
    public void setDistance(Float distance) {
        this.distance = distance;
    }
    public boolean VertexExists(Ciudades vertex){
        return (vertex.getName().equalsIgnoreCase(this.origin));
    }
}