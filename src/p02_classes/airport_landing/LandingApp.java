package p02_classes.airport_landing;

public class LandingApp {
    public static void main(String[] args) {
        LandingQueue queue = new LandingQueue();

        // Lets add some flights waiting to land
        queue.addFlight(new Flight("AE987", "Rome"));
        queue.addFlight(new Flight("SB908", "Frankfurt"));
        queue.addFlight(new Flight("TZ098", "Doha"));
        queue.addFlight(new Flight("MY561", "Melbourne"));
        queue.addFlight(new Flight("MX891", "New York"));

        // Now, print the waiting flights
        queue.printWaitingList();

        // And land the first one
        queue.landNext();

        queue.printWaitingList();

        queue.landNext();
        queue.landNext();
        queue.landNext();
        queue.landNext();
        queue.landNext();
    }
}
