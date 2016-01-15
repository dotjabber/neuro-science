package priv.dotjabber.neuroscience.genetic;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import priv.dotjabber.neuroscience.Individual;
import priv.dotjabber.neuroscience.builder.DNABuilder;
import priv.dotjabber.neuroscience.elements.Neuron;
import priv.dotjabber.neuroscience.elements.Synapse;

public class BirthControl {
	private List<String> currentEpoch;
	private List<String> nextEpoch; 
	private int[] architecture;
	
	public BirthControl(int[] architecture) {
		this.architecture = architecture;
		
		currentEpoch = new ArrayList<>();
		nextEpoch = new ArrayList<>();
	}
	
	public boolean create(String id) {
		try {
			DNABuilder.writeIndividualDNA(new Individual(architecture), id);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return DNABuilder.exists(id);
	}
	
	public boolean remove(String id) {
		DNABuilder.remove(id);
		return !DNABuilder.exists(id);
	}
	
	public boolean breed(String id1, String id2, String id3) {
		return false;
	}
	
	public boolean mutate(String id) {
		return false;
	}
	
	public void advance() {
		currentEpoch = nextEpoch;
		nextEpoch.clear();
	}
}
