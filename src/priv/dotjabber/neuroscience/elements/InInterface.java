package priv.dotjabber.neuroscience.elements;

import java.util.ArrayList;
import java.util.List;

public class InInterface {
	private List<Synapse> synapses;
	
	public InInterface(int firstLayerSize) {
		synapses = new ArrayList<Synapse>();
	}

	public void push(double[] signal) {
		if(signal.length == synapses.size()) {
			
			for(int i = 0; i < signal.length; i++) {
				synapses.get(i).setSignal(signal[i]);
			}
		}
	}

	public void addOutSynapse(Synapse inSynapse) {
		synapses.add(inSynapse);
	}

}
