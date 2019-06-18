package sim.core;

public abstract class SimEvent implements Comparable<SimEvent> {

    public Double runTime;
    public Integer simPriority;
    public Manager simMngr;
    public String name;

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
        if(this.getRunTime() > o.getRunTime()) return 1;
        else if( this.getRunTime() < o.getRunTime()) return -1;
        else return 0;
    }
}
