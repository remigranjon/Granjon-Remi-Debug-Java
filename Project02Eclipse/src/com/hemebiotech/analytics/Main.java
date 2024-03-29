package com.hemebiotech.analytics;




/**
 * Program that describes a symptom and count the number of occurrences from data
 * @author Rémi Granjon
 * @version 1.0, 29/03/24
 */
public class Main {
	/**
	 * Main method of the program that will :
	 * 		- create instance of ReadSymptomDataFromFile with a source file called "symptoms.txt" called "reader"
	 * 		- create instance of WriteSymptomData with an output file called "result.out" called "writer"
	 * 		- create an instance of AnalyticsCounter with "reader" and "writer" as parameters called "analyticsCounter"
	 * 		- call methods of "analyticsCounter" in order to :
	 * 			- read data from source file,
	 * 			- count occurrences of each symptoms,
	 * 			- sort symptoms alphabetically,
	 * 			- write symptoms and occurrences on output file
	 */
	public static void main(String args[]) {
		final ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		final ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
		final AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader,writer);
		analyticsCounter.writeSymptoms(
				analyticsCounter.sortSymptoms(
						analyticsCounter.countSymptoms(
								analyticsCounter.getSymptoms()
								)
						)
				);
	}
}
