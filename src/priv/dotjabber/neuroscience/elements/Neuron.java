package priv.dotjabber.neuroscience.elements;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import priv.dotjabber.neuroscience.elements.functions.Activator;

import static priv.dotjabber.neuroscience.elements.utils.NumberUtil.getNewId;
import static priv.dotjabber.neuroscience.elements.utils.NumberUtil.getDefaultId;
import static priv.dotjabber.neuroscience.elements.utils.NumberUtil.getRandDouble;
import static priv.dotjabber.neuroscience.elements.utils.NumberUtil.getRandInt;

public class Neuron {
	private Map<Integer, Synapse> inSynapses;
	private List<Synapse> outSynapses;
	
	private int id;
	private double beta;
	private double bias;
	private int function;
	
	public Neuron() {
		this.inSynapses = new HashMap<>();
		this.outSynapses = new ArrayList<>();
		
		this.id = getNewId();
		this.beta = getRandDouble();
		this.bias = getRandDouble();
		this.function = getRandInt();
	}

	public void process() {
		
		// sum up signals from all synapses;
		double signal = bias;
		for(Synapse synapse : inSynapses.values()) {
			signal += synapse.getSignal();
		}
		
		// generate output signal;
		int fnIndex = function % Activator.values().length;
		signal = Activator.values()[fnIndex].getFunction().getValue(beta, signal);
		
		// send the signal further
		for(Synapse synapse : outSynapses) {
			synapse.setSignal(signal);
		}
	}
	
	public int getId() {
		return id;
	}
	
	public double getBeta() {
		return beta;
	}

	public void setBeta(double beta) {
		this.beta = beta;
	}

	public double getBias() {
		return bias;
	}

	public void setBias(double bias) {
		this.bias = bias;
	}

	public int getFunction() {
		return function;
	}

	public void setFunction(int function) {
		this.function = function;
	}

	public Synapse getInSynapse() {
		Synapse synapse = inSynapses.get(getDefaultId());
		
		if(synapse == null) {
			synapse = new Synapse();
			inSynapses.put(id, synapse);
		}
		
		return synapse;
	}
	
	public Synapse getInSynapse(int id) {
		Synapse synapse = inSynapses.get(id);
		
		if(synapse == null) {
			synapse = new Synapse(this.id);

			inSynapses.put(id, synapse);
		}
		
		return synapse;
	}
	
	public Collection<Synapse> getInSynapses() {
		return inSynapses.values();
	}
	
	public void addOutSynapse(Synapse synapse) {
		outSynapses.add(synapse);
	}
	
	public Collection<Synapse> getOutSynapses() {
		return outSynapses;
	}
}
