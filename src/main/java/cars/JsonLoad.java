package cars;

import java.io.FileReader; 
import java.util.Iterator; 
import java.util.Map; 
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;

import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*;

/*
 * contains methods related to reading, parsing and returning JSON file data
 */
public class JsonLoad { 
	
	//reads in the JSON file and calls selectCarsByColour returning a JSONArray of cars with inputted color
	public JSONArray getCarData(String colour) { 
		JSONArray newJsonArray = new JSONArray();
		
		//parsing cars.json
		try {
			FileReader fr = new FileReader("src/main/java/cars/cars.json");
			JSONParser jp = new JSONParser();
			
			try {
				Object obj = jp.parse(fr);
				
				//typecasting obj to JSONObject 
				JSONObject jsonObject = (JSONObject) obj;
				
				//getting all cars into JSONArray
				JSONArray jsonArray = (JSONArray) jsonObject.get("cars"); 
				
				newJsonArray = selectCarsByColour(colour, jsonArray);
			} catch (Exception j) {
				System.out.println("parse error");
			}
			
			
		} catch (IOException e) {
	        System.out.println("File not found");
	    }
		
		return newJsonArray;
		
	}
	
	//returns a JSONArray containing only the cars of the inputted colour
	private JSONArray selectCarsByColour(String colour, JSONArray inputtedJsonArray) {
		JSONArray newJsonArray = new JSONArray();
		
		//checking which cars in array match inputted colour & forms new array of just these
		for(int j=0; j<inputtedJsonArray.size(); j++) {
			
			JSONObject tempObject = ((JSONObject)inputtedJsonArray.get(j));
			
			if(tempObject.get("colour").equals(colour)) {
				newJsonArray.add(tempObject);
			}
		}
		
		return newJsonArray;
	}
} 
