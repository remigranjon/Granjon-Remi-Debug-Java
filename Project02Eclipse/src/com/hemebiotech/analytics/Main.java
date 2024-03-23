package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
	public static void main(String args[]) throws Exception {
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
