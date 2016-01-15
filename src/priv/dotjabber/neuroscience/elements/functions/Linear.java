package priv.dotjabber.neuroscience.elements.functions;

public class Linear extends Function {
	
	@Override
	public double getValue(double... argument) {
		double beta = argument[0];
		double x = argument[1];
		
		double value = beta * x;
		return (Math.abs(value) > 1) ? value / Math.abs(value) : value;
	}
}
