package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Anything that will count and sort symptoms 
 * 
 * @author Rémi Granjon
 * @version 1.1, 09/05/24
 */
public interface IAnalyticsCounter {
    
    /**
	 * Method that will count occurrences of each symptom name from a list of symptoms name.
	 * @param symptoms	a list of String  
	 * @return	a Map of String keys and Integer values from which each value represents the count of occurrence of each key in the input parameter
	 */
    Map<String,Integer> countSymptoms(List<String> symptoms);


    /**
	 * Method that will sort symptoms alphabetically.
	 * @param symptoms	 an unsorted map of String keys and Integer values
	 * @return	an alphabetically sorted map 
	 */
    Map<String,Integer> sortSymptoms(Map<String,Integer> symptoms);


    /**
	 * Method that will execute methods in order to read, count, sort and write results 
	 */
    void execute();
}
