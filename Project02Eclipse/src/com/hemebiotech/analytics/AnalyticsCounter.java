package com.hemebiotech.analytics;

import java.util.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.hemebiotech.reader.ISymptomReader;
import com.hemebiotech.writer.ISymptomWriter;

/**
 * Class that contains methods that will be used in main in order to :
 * 	- read the list of symptoms
 * 	- count occurrence of each symptom
 * 	- sort symptoms alphabetically
 * 	- write result 
 * "reader" and "writer" attributes are respectively typed from ISymptomReader and ISymptomWriter 
 * @author Rémi Granjon
 * @version 1.0, 29/03/24
 */
public class AnalyticsCounter implements IAnalyticsCounter{
	private final ISymptomReader reader;
	private final ISymptomWriter writer;
	
	/**
	 * Constructor of the class
	 * @param reader	an instance of ISymptomReader that will provide method to read data from source
	 * @param writer	an instance of ISymptomWriter that will provide method to write results
	 */
	public AnalyticsCounter(ISymptomReader reader,ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}
	
	/**
	 * Method that will count occurrences of each symptom name from a list of symptoms name
	 * Starts from an empty HashMap and iterates over the symptoms list,
	 * incrementing the value if a key corresponds 
	 * or adding a new pair of key/value with key the new symptom and value equal to 1   
	 * @param symptoms	a list of String  
	 * @return	a Map of String keys and Integer values from which each value represents the count of occurrence of each key in the input parameter
	 */
	@Override
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
	
	/**
	 * Method that will sort symptoms alphabetically basically creating a new TreeMap from a Map of unsorted symptoms 
	 * @param symptoms	 an unsorted map of String keys and Integer values
	 * @return	an alphabetically sorted map 
	 */
	@Override
	public Map<String,Integer> sortSymptoms(Map<String,Integer> symptoms){
		Map<String, Integer> sortedSymptoms = new TreeMap<>(symptoms);
		return sortedSymptoms;
	}
	

	/**
	 * Method that will execute methods in order to read, count, sort and write results 
	 */
	@Override
	public void execute () {
		writer.writeSymptoms(sortSymptoms(countSymptoms(reader.getSymptoms())));
	}
}
