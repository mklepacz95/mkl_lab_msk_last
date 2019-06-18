package sim;

import sim.core.Manager;
import sim.core.SampleEvent;

public class Application {
    public static void main(String[] args) {
        Manager simManager = Manager.getInstance(0.0,1.0);

        SampleEvent sampleEvent1 = new SampleEvent(1.0, 1, simManager, "nazwa 1" );

        for (int i = 0; i<=10;i++) {
            simManager.registerEvent( new SampleEvent(1.0, 1, simManager, "nazwa " + i ));
        }
        simManager.nextEvent();
    }
}
