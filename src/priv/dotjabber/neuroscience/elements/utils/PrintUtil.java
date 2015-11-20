package priv.dotjabber.neuroscience.elements.utils;

import java.io.PrintStream;

public class PrintUtil {
	private static final String PRT_PREFIX = "[ "; 
	private static final String PRT_SEPARATOR = ", "; 
	private static final String PRT_SUFFIX = " ]"; 
	
	public static void print(PrintStream stream, double[] data) {
		StringBuilder builder = new StringBuilder();
		builder.append(PRT_PREFIX);
		
		for(int i = 0; i < data.length; i++) {
			builder.append(String.valueOf(data[i]));
			
			if(i != data.length - 1) {
				builder.append(PRT_SEPARATOR);
			}
		}
		builder.append(PRT_SUFFIX);
		
		stream.println(builder.toString());
	}
	
	public static void print(PrintStream stream, int[] data) {
		StringBuilder builder = new StringBuilder();
		builder.append(PRT_PREFIX);
		
		for(int i = 0; i < data.length; i++) {
			builder.append(String.valueOf(data[i]));
			
			if(i != data.length - 1) {
				builder.append(PRT_SEPARATOR);
			}
		}
		builder.append(PRT_SUFFIX);
		
		stream.println(builder.toString());
	}
}
