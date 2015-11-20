package priv.dotjabber.neuroscience.elements.utils;

import java.nio.ByteBuffer;

public class EncodingUtil {

	public static String encodeInt(int data) {
		String binString = String.format("%0" + Integer.SIZE + "d", 0) + 
				Integer.toBinaryString(data);
		
		return binString.substring(binString.length() - Integer.SIZE);
	}
	
	public static String encodeDouble(double data) {
		String binString = String.format("%0" + Double.SIZE + "d", 0) + 
				Long.toBinaryString(Double.doubleToRawLongBits(data));
		
		return binString.substring(binString.length() - Double.SIZE);
	}
	
	public static int decodeInt(String data) {
		return ByteBuffer.wrap(data.getBytes()).getInt();
	}
	
	public static double decodeDouble(String data) {
		return ByteBuffer.wrap(data.getBytes()).getDouble();
	}
	
	public static double[] encode(int[] data) {
		double[] output = new double[data.length * Integer.SIZE];
		
		for(int i = 0; i < data.length; i++) {
			String binary = encodeInt(data[i]);

			for(int j = 0; j < binary.length(); j++) {
				int index = (i + 1) * Integer.SIZE - 1 - j;
				
				output[index] = (binary.charAt(j) == '0') ? 0 : 1;
			}
		}

		return output;
	}
	
	public static int[] decode(double[] data) {
		int[] output = new int[data.length / Integer.SIZE];
		
		for(int i = 0; i < output.length; i++) {
			char[] binary = new char[Integer.SIZE];
			
			for(int j = 0; j < Integer.SIZE; j++) {
				int index = (i + 1) * Integer.SIZE - j - 1;
				binary[j] = (data[index] > 0.5) ? '1' : '0';
			}
			
			output[i] = decodeInt(String.valueOf(binary));
		}
		
		return output;
	}
}
