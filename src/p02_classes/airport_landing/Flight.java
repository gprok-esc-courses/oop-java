package p02_classes.airport_landing;

public class Flight {
    private String flightNo;
    private String departure;

    public Flight(String flightNo, String departure) {
        this.flightNo = flightNo;
        this.departure = departure;
    }

    public String toString() {
        return "Flight " + flightNo + " from: " + departure;
    }
}

