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
    public String getDestination() {
        return destination;
    }
    public Float getDistance() {
        return distance;
    }
}