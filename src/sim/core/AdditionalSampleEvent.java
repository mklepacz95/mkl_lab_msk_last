package sim.core;

import java.util.Random;

public class AdditionalSampleEvent extends SimEvent  {
    public AdditionalSampleEvent(Double runTime, Integer simPriority, Manager simMngr, String name) {
        super(runTime, simPriority, simMngr, name);
    }

    @Override
    public void stateChange() {
        int i = 0;
        SimEvent e = null;
        //if(i%3 == 0)  e = new AdditionalSampleEvent(runTime + 20.0 + random.nextDouble() * 80.0, random.nextInt(10), simMngr, "Utworzony proces przez AdditionalSampleEvent:" + random.nextInt());
        e = new SampleEvent(runTime + 20.0 + random.nextDouble() * 80.0, random.nextInt(10), simMngr, "Utworzony proces przez AdditionalSampleEvent:" + random.nextInt());
        System.out.println(runTime + ": " + e.toString());

        simMngr.registerEvent(e);

    }
}
