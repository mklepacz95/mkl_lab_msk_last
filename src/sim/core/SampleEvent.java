package sim.core;

public class SampleEvent extends SimEvent {

    public SampleEvent(Double runTime, Integer simPriority, Manager simMngr, String name) {
        super(runTime, simPriority, simMngr, name);
    }

    @Override
    public void stateChange() {
        System.out.println("Sample event " + name);
    }
}
