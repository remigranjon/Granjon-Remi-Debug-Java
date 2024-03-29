package com.hemebiotech.analytics;

import java.util.Map;
/**
 * Anything that will write symptoms count
 * The input is a Map of String key and Integer value that counts the number of occurrence of each symptom 
 * Each key of the Map is the name of the particular symptom
 * @author Rémi Granjon
 * @version 1.0, 29/03/24
 */
public interface ISymptomWriter {
	
	/**
	 * Method that will write a map of String keys and Integer values on a medium
	 * @param symptoms a map of String keys and Integer values
	 */
	public void writeSymptoms(Map<String,Integer> symptoms);
}
