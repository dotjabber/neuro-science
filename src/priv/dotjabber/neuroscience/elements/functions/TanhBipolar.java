package priv.dotjabber.neuroscience.elements.functions;

public class TanhBipolar extends Function {
	
	@Override
	public double getValue(double... argument) {
		double beta = argument[0];
		double x = argument[1];
		return (1 - Math.exp(-beta * x)) / (1 + Math.exp(-beta * x));
	}
}
