package priv.dotjabber.neuroscience.elements.functions;

public class Linear extends Function {
	
	@Override
	public double getValue(double... argument) {
		double beta = argument[0];
		double x = argument[1];
		
		return beta * x;
	}
}
