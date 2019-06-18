package sim.core;
import java.util.LinkedList;

public class Manager {	
	private double startSimTime = 0.0;
	private double stopSimTime = Double.MAX_VALUE;
	private double currentSimTime = startSimTime;
	private double timeStep = 1.0;
	private static Manager simMngr; // Singleton
	private boolean simulationStarted = false;
	// Lista workerów, którzy są skłądowymi kroku symulacji 
	private LinkedList<SimStep> simStepWorkers = new LinkedList<>();

	private SimCalendar simCalendar = new SimCalendar();
	
	public static Manager getInstance(double startSimTime, double timeStep) {
		if (simMngr == null) {
			simMngr = new Manager(startSimTime, timeStep);
		}
		return simMngr;
	}
	
	private Manager(double startSimTime, double timeStep) {
		if (startSimTime>0.0) 
			this.startSimTime = startSimTime;		
			this.timeStep = timeStep;
	}

	public void registerSimStep(SimStep step) {
		if (step!=null)
			simStepWorkers.add(step);
	}
	
	public final double simTime() {
		return currentSimTime;
	}
	
	public final void stopSimulation() {
		simulationStarted = false;
	}

	public final void startSimulation() {
		simulationStarted = true;
		// DO WYKONANIA NA LABORATORIUM
		//...
		//runStebByStep();
		nextEvent();
	}
	
	public void setEndSimTime(double endSimTime) {
		this.stopSimTime = endSimTime;
	}
	
	private final void runStebByStep() {
		// DO WYKONANIA NA LABORATORIUM
		//...
		for (double i = simMngr.startSimTime; i <= simMngr.stopSimTime; i = i+timeStep) {
			simStepWorkers.get(0).stateChange();
			currentSimTime += timeStep;
		}
	}

	public void nextEvent() {
		//obsluga koljench zdarzen z kalendarza
		//ustalenie currentSimTime wg runTime
		while(currentSimTime < stopSimTime) {
			SimEvent simEvent = simCalendar.getFirstEvent();
			if(simEvent != null) {
                simEvent.stateChange();
                currentSimTime = simEvent.getRunTime();
                unregisterEvent(simEvent);
            }
		}
	}

	public void registerEvent(SimEvent event) {
		if(event != null) {
			simCalendar.addEvent(event);
		}
	}

	public void unregisterEvent(SimEvent event) {
		if(event != null) {
			simCalendar.removeEvent(event);
		}
	}

}
