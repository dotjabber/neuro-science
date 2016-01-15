package priv.dotjabber.neuroscience.elements.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileUtil {
	public static String read(String path) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded);
	}
	
	public static void write(String content, String path) throws IOException {
		Files.write(Paths.get(path), content.getBytes(), StandardOpenOption.CREATE_NEW);
	}
}
