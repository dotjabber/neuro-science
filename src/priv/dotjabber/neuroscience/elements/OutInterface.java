package priv.dotjabber.neuroscience.elements;

import java.util.ArrayList;
import java.util.List;

public class OutInterface {
	private List<Synapse> inSynapses;
	private int interfaceSize;
	
	public OutInterface(int size) {
		inSynapses = new ArrayList<Synapse>();
		interfaceSize = size;
	}

	public double[] pop() {
		double[] result = new double[interfaceSize];
		for(int i = 0; i < interfaceSize; i++) {
			result[i] = inSynapses.get(i).getSignal();
		}

		return result;
	}

	public Synapse getInSynapse() {
		Synapse synapse = new Synapse();
		inSynapses.add(synapse);
		return synapse;
	}
}
