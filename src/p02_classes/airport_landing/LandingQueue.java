package p02_classes.airport_landing;

public class LandingQueue {
    private LandingQueueNode head;
    private LandingQueueNode tail;

    public LandingQueue() {
        head = null;
        tail = null;
    }

    public void addFlight(Flight flight) {
        LandingQueueNode element = new LandingQueueNode(flight);
        if(head == null) {
            head = element;
            tail = element;
        }
        else {
            tail.setNext(element);
            tail = element;
        }
    }

    public void printWaitingList() {
        LandingQueueNode iterator = head;
        System.out.println("LANDING REQUESTS");
        while(iterator != null) {
            System.out.println(iterator.getFlight());
            iterator = iterator.getNext();
        }
        System.out.println("================");
    }

    public void landNext() {
        if(head == null) {
            System.out.println("No flight in queue");
        }
        else {
            System.out.println("Announcement: " + head.getFlight() + " landing");
            head = head.getNext();
            if(head == null) {
                tail = null;
            }
        }
    }
}
