package priv.dotjabber.neuroscience.elements.utils;

import java.util.Random;

public class NumberUtil {
	private static final Random RAND = new Random();
	private static final short DEFAULT_ID = 0;
	private static int id;
	
	public static void reset() {
		id = 0;
	}
	
	public static int getNewId() {
		return ++id;
	}
	
	public static int getDefaultId() {
		return DEFAULT_ID;
	}
	
	public static double getRandDouble() {
		return RAND.nextDouble(); 
	}
	
	public static int getRandInt() {
		int rand = RAND.nextInt(Integer.MAX_VALUE); 
		return (rand == 0) ? 2 : rand;
	}
	
	public static int getRandInt(int max) {
		return RAND.nextInt(max); 
	}
}
