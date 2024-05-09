package com.hemebiotech;

import com.hemebiotech.analytics.*;
import com.hemebiotech.reader.*;
import com.hemebiotech.writer.*;

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
	 * 		- call execute() method of AnalyticsCounter class
	 */
	public static void main(String args[]) {
		final ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		final ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
		final IAnalyticsCounter analyticsCounter = new AnalyticsCounter(reader,writer);
		analyticsCounter.execute();
	}
}
