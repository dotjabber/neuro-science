package priv.dotjabber.neuroscience;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import priv.dotjabber.neuroscience.builder.DNABuilder;
import priv.dotjabber.neuroscience.elements.utils.PrintUtil;
import priv.dotjabber.neuroscience.genetic.BirthControl;
import priv.dotjabber.neuroscience.genetic.assess.AssessUtil;

public class Main {

//	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
//		int[] in = new int[] { 32, 64, 32 };
//		
//		double[][] questions = { {0, 0, 0}, {0, 0, 1}, {0, 1, 0}, {0, 1, 1}, {1, 0, 0}, {1, 0, 1}, {1, 1, 0}, {1, 1, 1} };
//		double[][] answers = { {0, 0, 0}, {0, 0, 1}, {0, 1, 0}, {0, 1, 1}, {1, 0, 0}, {1, 0, 1}, {1, 1, 0}, {1, 1, 1} };
//		
//
//		Individual individual = new Individual(in);
//		DNABuilder.writeIndividualDNA(individual, "test");
//		
//		individual = DNABuilder.readIndividualDNA("test");
//		DNABuilder.writeIndividualDNA(individual, "test2");
//		
//		double[] out = individual.process(new double[] { 0.0 });
//		PrintUtil.print(System.out, out);
//		
//		out = individual.process(new double[] { 1.0 });
//		PrintUtil.print(System.out, out);
//		
//		out = individual.process(new double[] { 1.0 });
//		PrintUtil.print(System.out, out);
//		
//		out = individual.process(new double[] { 0.0 });
//		PrintUtil.print(System.out, out);
//		
//		System.out.println(AssessUtil.assessWeight(individual));
//		System.out.println(AssessUtil.assessError(individual, questions, answers));
//	}
}
