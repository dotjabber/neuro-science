package priv.dotjabber.neuroscience.builder;

import priv.dotjabber.neuroscience.elements.InInterface;
import priv.dotjabber.neuroscience.elements.Neuron;
import priv.dotjabber.neuroscience.elements.OutInterface;

public class NeuronBuilder {
	
	public static OutInterface getOutInterface(int[] architecture) {
		int lastLayerSize = architecture[architecture.length - 1];
		return new OutInterface(lastLayerSize);
	}

	public static Neuron[][] getNeurons(int[] architecture) {
		// create layers of neurons;
		Neuron[][] neurons = new Neuron[architecture.length][];
		for(int i = 0; i < architecture.length; i++) {
			
			// create neurons in each layer;
			neurons[i] = new Neuron[architecture[i]];
			for(int j = 0; j < architecture[i]; j++) {
				neurons[i][j] = new Neuron();
			}
		}
		
		return neurons;
	}

	public static InInterface getInInterface(int[] architecture) {
		int firstLayerSize = architecture[0];
		return new InInterface(firstLayerSize);
	}
}
