/*
 * File:FlightPlanner.java
 * -----------------------
 * Reads in a file of cities and their corresponding flights,
 * and allows the user to plan a flight route.
 */

import acm.program.*;
import java.util.*;
import java.io.*;
import acm.util.*;

public class FlightPlanner extends ConsoleProgram{
	public void run(){
		println("Welcome to Flight Planner!");
		readFlightData("flights.txt");
		
		println("Here's a list of all the cities in our database.");
		printCityList(cities);
		String startCity=readLine("Enter a starting city: ");
		ArrayList<String> route=new ArrayList<String>();
		route.add(startCity);
		String currentCity=startCity;
		while(true){
			String nextCity=getNextCity(currentCity);
			route.add(nextCity);
			if(nextCity.equals(startCity)){
				break;
			}
			currentCity=nextCity;
		}
		printRoute(route);
	}
	
	/** Ask user for the name of the next city in the route */
	private String getNextCity(String city){
		ArrayList<String> destinations=getDestinations(city);
		String nextCity=null;
		while(true){
			println("From "+city+" you can fly directly to:");
			printCityList(destinations);
			nextCity=readLine("Where do you to go from "+city+" ? ");
			if(destinations.contains(nextCity)){
				break;
			}
			println("You can't get to that city by a direct flight.");
		}
		return nextCity;
	}
	
	/**
	* Given a starting city, looks up the destinations from that
	* city in the HashMap of flights, and return an array list of
	* the destinations that are available.
	*/
	private ArrayList<String> getDestinations(String fromCity){
		return flights.get(fromCity);
	}
		
	/**
	* Reads in the city information from the given file storing the
	* information in both the ArrayList of cities and the HashMap of
	* flights.
	*/
	private void readFlightData(String filename){
		try{
			BufferedReader rd=new BufferedReader(new FileReader(filename));
			while(true){
				String line=rd.readLine();
				if(line==null) break;
				if(line.length()!=0){
					readFlightEntry(line);
				}
			}
			rd.close();
		}catch(IOException ex){
			throw new ErrorException(ex);
		}
	}
	
	/**
	* Reads a single flight entry from the line passed as an argument,
	* which should be in the form
	*
	* fromCity -> toCity
	*
	* Each new city is added to the ArrayList cities, and each new
	* flight is recorded by adding a new destination city to the
	* ArrayList stored in the HashMap flights under the key for the
	* starting city.
	*/
	private void readFlightEntry(String line){
		int arrow=line.indexOf("->");
		if(arrow==-1){
			throw new ErrorException("Illegal flight Entry:"+line);
		}
		String fromCity=line.substring(0,arrow).trim();
		String toCity=line.substring(arrow+2).trim();
		defineCity(fromCity);
		defineCity(toCity);
		getDestinations(fromCity).add(toCity);
	}
	
	/**
	* Defines a city if it has not already been defined. Defining
	* a city consists of entering it in the cities array and
	* entering an empty ArrayList in the flights table to show
	* that it has no destinations yet.
	*/
	private void defineCity(String city){
		if(!cities.contains(city)){
			cities.add(city);
			flights.put(city, new ArrayList<String>());
		}
	}
	
	/**
	* Prints a list of cities from the array list. Each city name is
	* indented by a space.
	*/
	private void printCityList(ArrayList<String> cityList){
		for(int i=0;i<cityList.size();i++){
			String city=cityList.get(i);
			println(city);
		}
	}
	
	/**
	* Given a list of city names, prints out the flight
	* route, with a " -> " between each pair of cities
	*/
	private void printRoute(ArrayList<String> route){
		println("The route you have chosen is: ");
		for(int i=0;i<route.size();i++){
			if(i>0){
				print(" -> ");
			}
			print(route.get(i));
		}
		println();
	}
	
	/*Private instance variables*/
	private ArrayList<String> cities=new ArrayList<String>();
	private HashMap<String,ArrayList<String>> flights=new HashMap<String,ArrayList<String>>();
}
