package priv.dotjabber.neuroscience;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;

import priv.dotjabber.neuroscience.builder.DNABuilder;
import priv.dotjabber.neuroscience.elements.utils.PrintUtil;

public class Main {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		int[] in = new int[] { 32, 64, 32 };

		Individual individual = new Individual(in);
		DNABuilder.writeIndividualDNA(individual, "test");
		
		individual = DNABuilder.readIndividualDNA("test");
		DNABuilder.writeIndividualDNA(individual, "test2");
		
		int[] out = individual.process(new int[] { 0 });
		PrintUtil.print(System.out, out);
		
		out = individual.process(new int[] { 1 });
		PrintUtil.print(System.out, out);
		
		out = individual.process(new int[] { 1 });
		PrintUtil.print(System.out, out);
		
		out = individual.process(new int[] { 0 });
		PrintUtil.print(System.out, out);
	}
}
