package sim;

import sim.core.Manager;
import sim.core.SampleEvent;

public class Application {
    public static void main(String[] args) {
        Manager simManager = Manager.getInstance(0.0,1.0);
        simManager.setEndSimTime(4000);
        SampleEvent sampleEvent = new SampleEvent(0.0,1,simManager,"Event from main");
        simManager.registerEvent(sampleEvent);
        simManager.startSimulation();
    }
}
