package p02_classes.airport_landing;

public class LandingQueueNode {
    private Flight flight;
    private LandingQueueNode next;

    public LandingQueueNode(Flight flight) {
        this.flight = flight;
        this.next = null;
    }

    public Flight getFlight() {
        return flight;
    }

    public LandingQueueNode getNext() {
        return next;
    }

    public void setNext(LandingQueueNode next) {
        this.next = next;
    }
}
