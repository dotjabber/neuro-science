package priv.dotjabber.neuroscience;

import priv.dotjabber.neuroscience.builder.NeuronBuilder;
import priv.dotjabber.neuroscience.elements.InInterface;
import priv.dotjabber.neuroscience.elements.Neuron;
import priv.dotjabber.neuroscience.elements.OutInterface;

public class Individual {
	private int[] architecture;
	private InInterface in;
	private Neuron[][] neurons;
	private OutInterface out;

	public Individual(int[] architecture) {
		this.architecture = architecture;

		// create in - interface
		in = NeuronBuilder.getInInterface(architecture);
		
		// create neurons (layer by layer);
		neurons = NeuronBuilder.getNeurons(architecture);

		// create out - interface;
		out = NeuronBuilder.getOutInterface(architecture);
		
		// link neurons together (by layer)
		for(int i = 0; i < architecture.length - 1; i++) {
			for(int j = 0; j < architecture[i]; j++) {
				
				// in-depth connections
				for(int m = i + 1; m < architecture.length - 1; m++) {
					for(int k = 0; k < architecture[m]; k++) {
						Neuron thisNeuron = neurons[i][j];
						Neuron nextNeuron = neurons[m][k];
						
						thisNeuron.addOutSynapse(nextNeuron.getInSynapse(thisNeuron.getId()));
					}
				}
			}
		}
		
		// link last neuron layer to the interface;
		int lastLayerIndex = architecture.length - 1;
		for(Neuron neuron : neurons[lastLayerIndex]) {
			neuron.addOutSynapse(out.getInSynapse());
		}
		
		// link first neuron layer to the interface;
		for(Neuron neuron : neurons[0]) {
			in.addOutSynapse(neuron.getInSynapse());
		}
	}
	
	public double[] process(double[] signal) {

		// push the signal through the in-interface;
		in.push(signal);
		
		// compute signal layer by layer;
		for(int i = 0; i < neurons.length; i++) {
			
			// compute signal neuron by neuron in given layer;
			for(int j = 0; j < neurons[i].length; j++) {
				neurons[i][j].process();
			}
		}
		
		// decode that bastard;
		return out.pop();
	}
	
	public int[] getArchitecture() {
		return architecture;
	}

	public void setArchitecture(int[] architecture) {
		this.architecture = architecture;
	}

	public Neuron[][] getNeurons() {
		return neurons;
	}

	public void setNeurons(Neuron[][] neurons) {
		this.neurons = neurons;
	}
}
