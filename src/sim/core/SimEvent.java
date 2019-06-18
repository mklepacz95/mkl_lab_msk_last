package sim.core;

import java.util.Random;

public abstract class SimEvent implements Comparable<SimEvent> {

    public Double runTime;
    public Integer simPriority;
    public Manager simMngr;
    public String name;
    public Random random = new Random();

    public SimEvent(Double runTime, Integer simPriority, Manager simMngr, String name) {
        this.runTime = runTime;
        this.simPriority = simPriority;
        this.simMngr = simMngr;
        this.name = name;
    }

    public abstract void stateChange();

    public SimEvent(Manager simMngr) {
        if(simMngr != null) {
            simMngr = simMngr;
            simMngr.registerEvent(this);
        }
    }

    public Double getRunTime() {
        return runTime;
    }

    public void setRunTime(Double runTime) {
        this.runTime = runTime;
    }

    @Override
    public int compareTo(SimEvent o) {
        if(Double.compare(this.runTime, o.getRunTime()) == 0 ) {
            return Integer.compare(simPriority, o.simPriority);
        } else return Double.compare(this.runTime, o.getRunTime());
    }

    @Override
    public String toString() {
        return "SimEvent{" +
                "runTime=" + runTime +
                ", simPriority=" + simPriority +
                ", name='" + name + '\'' +
                '}';
    }
}
