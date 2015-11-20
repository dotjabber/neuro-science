package priv.dotjabber.neuroscience.builder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import priv.dotjabber.neuroscience.Individual;
import priv.dotjabber.neuroscience.elements.Neuron;
import priv.dotjabber.neuroscience.elements.Synapse;
import priv.dotjabber.neuroscience.elements.utils.EncodingUtil;

public class DNABuilder {
	public static final String ARCHITECTURE_FORMAT = "A{0}";
	public static final String NEURON_FORMAT = "N[id:{0};beta:{1};bias:{2};function:{3}]";
	public static final String SYNAPSE_FORMAT = "S[id:{0};neuron:{1};weight:{2}]";
	
	public static final String ARCHITECTURE_REGEX = "A\\[([0-9,]+)\\]";
	public static final String NEURON_REGEX = "N\\[id:([0-9]+);beta:([01]+);bias:([01]+);function:([01]+)\\]";
	public static final String SYNAPSE_REGEX = "S\\[id:([0-9]+);neuron:([0-9]+);weight:([01]+);\\]";
	
	private static Pattern architecturePattern;
	private static Pattern neuronPattern;
	private static Pattern synapsePattern;
	
	static {
		architecturePattern = Pattern.compile(ARCHITECTURE_REGEX);
		neuronPattern = Pattern.compile(NEURON_REGEX);
		synapsePattern = Pattern.compile(SYNAPSE_REGEX);
	}
	
	/**
	 * 
	 * @param individual
	 * @param stream
	 * @throws FileNotFoundException 
	 */
	private static void writeSynapsesDNA(Individual individual, String individualId) throws FileNotFoundException {
		PrintStream stream = new PrintStream(new File(individualId + "_synapses"));
		
		for(int i = 0; i < individual.getNeurons().length; i++) {
			for(int j = 0; j < individual.getNeurons()[i].length; j++) {
				Neuron neuron = individual.getNeurons()[i][j];
				
				for(Synapse synapse : neuron.getInSynapses()) {
					String synapseDNA = MessageFormat.format(
						SYNAPSE_FORMAT, 
						String.valueOf(synapse.getId()), 
						String.valueOf(synapse.getParentId()), 
						EncodingUtil.encodeDouble(synapse.getWeight())
					);
					
					stream.println(synapseDNA);
				}
			}
		}
		
		stream.close();
	}

	/**
	 * 
	 * @param individualId
	 * @throws FileNotFoundException 
	 */
	private static void readSynapsesDNA(Individual individual, String individualId) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(individualId + "_synapses"));
		
		for(int i = 0; i < individual.getNeurons().length; i++) {
			for(int j = 0; j < individual.getNeurons()[i].length; j++) {
				Neuron neuron = individual.getNeurons()[i][j];
				
				for(Synapse synapse : neuron.getInSynapses()) {
					String synapseDNA = scanner.nextLine();
					
					Matcher matcher = synapsePattern.matcher(synapseDNA);
					matcher.find();
					
					int synapseId = EncodingUtil.decodeInt(matcher.group(1));
					int parentId = EncodingUtil.decodeInt(matcher.group(2));
					double weight = EncodingUtil.decodeDouble(matcher.group(3));
					
					if(synapse.getId() == synapseId && synapse.getParentId() == parentId) {
						synapse.setWeight(weight);
					}
				}
			}
		}
		
		scanner.close();
	}
	
	/**
	 * 
	 * @param individual
	 * @param stream
	 * @throws FileNotFoundException 
	 */
	private static void writeNeuronsDNA(Individual individual, String individualId) throws FileNotFoundException {
		PrintStream stream = new PrintStream(new File(individualId + "_neurons"));
		
		for(int i = 0; i < individual.getNeurons().length; i++) {
			for(int j = 0; j < individual.getNeurons()[i].length; j++) {
				Neuron neuron = individual.getNeurons()[i][j];
				
				String neuronDNA = MessageFormat.format(
					NEURON_FORMAT, 
					String.valueOf(neuron.getId()), 
					EncodingUtil.encodeDouble(neuron.getBeta()),
					EncodingUtil.encodeDouble(neuron.getBias()),
					EncodingUtil.encodeInt(neuron.getFunction())
				);
				
				stream.println(neuronDNA);
			}
		}
		
		stream.close();
	}
	
	/**
	 * 
	 * @param individual
	 * @throws FileNotFoundException 
	 */
	private static void readNeuronsDNA(Individual individual, String individualId) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(individualId + "_neurons"));

		for(int i = 0; i < individual.getNeurons().length; i++) {
			for(int j = 0; j < individual.getNeurons()[i].length; j++) {
				Neuron neuron = individual.getNeurons()[i][j];
				
				String neuronDNA = scanner.nextLine();
				
				Matcher matcher = neuronPattern.matcher(neuronDNA);
				matcher.find();
				
				int neuronId = EncodingUtil.decodeInt(matcher.group(1));
				double beta = EncodingUtil.decodeDouble(matcher.group(2));
				double bias = EncodingUtil.decodeDouble(matcher.group(3));
				int function = EncodingUtil.decodeInt(matcher.group(4));
				
				if(neuronId == neuron.getId()) {
					neuron.setBeta(beta);
					neuron.setBias(bias);
					neuron.setFunction(function);
				}
			}
		}
		
		scanner.close();
	}
	
	/**
	 * 
	 * @param individual
	 * @param individualId
	 * @throws FileNotFoundException
	 */
	private static void writeArchitectureDNA(Individual individual, String individualId) throws FileNotFoundException {
		PrintStream stream = new PrintStream(new File(individualId + "_architecture"));
		
		String architectureDNA = MessageFormat.format(
			ARCHITECTURE_FORMAT, 
			Arrays.toString(individual.getArchitecture()).replace(" ", "")
		);
		
		stream.println(architectureDNA);
		stream.close();
	}
	
	
	/**
	 * 
	 * @param individualId
	 * @return
	 * @throws FileNotFoundException
	 */
	private static Individual readArchitectureDNA(String individualId) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(individualId + "_architecture"));
		
		String architectureDNA = scanner.nextLine();
		scanner.close();
		
		Matcher matcher = architecturePattern.matcher(architectureDNA);
		matcher.find();
		
		int[] architecture = Arrays.stream(matcher.group(1).split(",")).mapToInt(Integer::parseInt).toArray();
		return new Individual(architecture);
	}
	
	/**
	 * 
	 * @param individual
	 * @param individualId
	 * @throws FileNotFoundException
	 */
	public static void writeIndividualDNA(Individual individual, String individualId) throws FileNotFoundException {
		writeArchitectureDNA(individual, individualId);
		writeNeuronsDNA(individual, individualId);
		writeSynapsesDNA(individual, individualId);
	}
	
	/**
	 * 
	 * @param individual
	 * @param individualId
	 * @throws FileNotFoundException
	 */
	public static Individual readIndividualDNA(String individualId) throws FileNotFoundException {
		Individual individual = readArchitectureDNA(individualId);
		readNeuronsDNA(individual, individualId);
		readSynapsesDNA(individual, individualId);
		
		return individual;
	}
}
