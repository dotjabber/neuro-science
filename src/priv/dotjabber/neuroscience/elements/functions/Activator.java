package priv.dotjabber.neuroscience.elements.functions;

public enum Activator {
	TANHB(new TanhBipolar()),
	LINR(new Linear());
	
	private Function function;
	private Activator(Function function) {
		this.function = function;
	}
	
	public Function getFunction() {
		return function;
	}
}
