package priv.dotjabber.neuroscience.genetic;

import java.io.FileNotFoundException;
import java.util.Comparator;

import priv.dotjabber.neuroscience.Individual;
import priv.dotjabber.neuroscience.builder.DNABuilder;
import priv.dotjabber.neuroscience.genetic.assess.AssessUtil;

public class IndividualComparator implements Comparator<String> {
	private double[][] questions;
	private double[][] answers;
	
	public IndividualComparator(double[][] questions, double[][] answers) {
		this.questions = questions;
		this.answers = answers;
	}

	@Override
	public int compare(String id1, String id2) {
		Individual ind1 = null;
		Individual ind2 = null;
		
		try {
			ind1 = DNABuilder.readIndividualDNA(id1);
			ind2 = DNABuilder.readIndividualDNA(id2);
			
		} catch (FileNotFoundException e) { 
			throw new NullPointerException(e.getMessage());
		}
		
		double score1 = AssessUtil.assessError(ind1, questions, answers) + AssessUtil.assessWeight(ind1);
		double score2 = AssessUtil.assessError(ind2, questions, answers) + AssessUtil.assessWeight(ind2);
		
		return score1 < score2 ? -1 : score1 > score2 ? 1 : 0;
	}
}
