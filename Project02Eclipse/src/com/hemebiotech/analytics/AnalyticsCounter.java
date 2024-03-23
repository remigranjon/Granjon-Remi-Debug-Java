package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private final ISymptomReader reader;
	private final ISymptomWriter writer;
	private static int headacheCount = 0;	
	private static int rashCount = 0;		
	private static int pupilCount = 0;		
	
	public AnalyticsCounter(ISymptomReader reader,ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}
	
	public List<String> getSymptoms(){
		return reader.GetSymptoms();
	}
	
	public Map<String,Integer> countSymptoms(List<String> symptoms){
		Map<String,Integer> results = new HashMap<String,Integer>();
		symptoms.forEach(symptom -> {
			if (results.containsKey(symptom)) {
				results.put(symptom, results.get(symptom)+1);
			} else {
				results.put(symptom, 1);
			}
		});
		return results;
	}
	
	public Map<String,Integer> sortSymptoms(Map<String,Integer> symptoms){
		Map<String, Integer> sortedSymptoms = new TreeMap<>(symptoms);
		return sortedSymptoms;
	}
	
	public void writeSymptoms(Map<String,Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
	
	
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0;	
		int headCount = 0;	// counts headaches
		while (line != null) {
			i++;	
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
