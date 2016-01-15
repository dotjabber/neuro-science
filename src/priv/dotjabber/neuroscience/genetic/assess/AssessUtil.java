package priv.dotjabber.neuroscience.genetic.assess;

import java.util.Collection;

import priv.dotjabber.neuroscience.Individual;
import priv.dotjabber.neuroscience.elements.Neuron;
import priv.dotjabber.neuroscience.elements.Synapse;

public class AssessUtil {
	public static double assessWeight(Individual individual) {
		double totalWeight = 0;

		for(Neuron[] layer : individual.getNeurons()) {
			for(Neuron neuron : layer) {
				Collection<Synapse> synapses = neuron.getOutSynapses();
				
				for(Synapse synapse : synapses) {
					totalWeight += synapse.getWeight();
				}
			}
		}

		return totalWeight;
	}
	
	public static double assessError(Individual individual, double[][] questions, double[][] answers) {
		double totalError = 0;

		for(int i = 0; i < questions.length; i++) {
			double[] output = individual.process(questions[i]);
			
			for(int j = 0; j < output.length; j++) {
				totalError += Math.abs(output[j]) - Math.abs(answers[i][j]);
			}
		}
		
		return totalError;
	}
}
