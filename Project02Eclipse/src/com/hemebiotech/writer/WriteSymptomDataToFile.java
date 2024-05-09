package com.hemebiotech.writer;

import java.io.*;
import java.util.Map;

/**
 * Simple brute force implementation
 *
 */
public class WriteSymptomDataToFile implements ISymptomWriter{
	
	private String filepath;
	/**
	 * 
	 * @param filepath a full or partial path to output file with occurrence of each symptom, one per line
	 */
	
	public WriteSymptomDataToFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public void writeSymptoms(Map<String,Integer> symptoms) {
		if (filepath != null) {
			try {
				BufferedWriter writer = new BufferedWriter (new FileWriter(filepath));
				symptoms.forEach((symptom, occurrence) -> {
					try {
						writer.write(symptom+": "+occurrence+"\n");
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
