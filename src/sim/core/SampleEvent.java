package sim.core;

public class SampleEvent extends SimEvent {

    public SampleEvent(Double runTime, Integer simPriority, Manager simMngr, String name) {
        super(runTime, simPriority, simMngr, name);
    }

    @Override
    public void stateChange() {

        AdditionalSampleEvent additionalSampleEvent = new AdditionalSampleEvent(runTime + 20.0 + random.nextDouble() * 80.0, random.nextInt(10), simMngr, "Utworzony proces przez SampleEvent:" + random.nextInt());

        System.out.println(runTime + ": " + additionalSampleEvent.toString());

        simMngr.registerEvent(additionalSampleEvent);
    }
}
