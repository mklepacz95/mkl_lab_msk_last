package sim.core;

import java.util.PriorityQueue;

public class SimCalendar {

    private PriorityQueue<SimEvent> events = new PriorityQueue<>();


    public SimCalendar() {}

    public void addEvent(SimEvent event) {
        events.add(event);
    }

    public void removeEvent(SimEvent event) {
        events.remove(event);
    }

    public SimEvent getFirstEvent() {
        return events.peek();
    }

    public Integer getSize() {
        return events.size();
    }

}
