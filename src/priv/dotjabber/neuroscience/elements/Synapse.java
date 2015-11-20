package priv.dotjabber.neuroscience.elements;

import static priv.dotjabber.neuroscience.elements.utils.NumberUtil.getNewId;
import static priv.dotjabber.neuroscience.elements.utils.NumberUtil.getDefaultId;
import static priv.dotjabber.neuroscience.elements.utils.NumberUtil.getRandDouble;

public class Synapse {
	private double signal;
	
	private int id;
	private int parentId;
	private double weight;
	
	public Synapse() {
		this(getDefaultId());
		this.weight = getRandDouble();
	}
	
	public Synapse(int parentId) {
		this.parentId = parentId;
		
		this.id = getNewId();
		this.weight = getRandDouble();
	}
	
	public double getSignal() {
		return signal * weight;
	}

	public void setSignal(double signal) {
		this.signal = signal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
}
