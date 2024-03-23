package com.hemebiotech.analytics;

import java.util.Map;
/**
 * Anything that will write symptom data
 * The input is a Map of String key and Integer value that counts the number of occurrence of each symptom 
 * Each key of the Map is the name of the particular symptom
 * 
 */
public interface ISymptomWriter {
	public void writeSymptoms(Map<String,Integer> symptoms);
}
