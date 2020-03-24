package com.samplewebapp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class UserValidationService {
	
	//validates credentials are correct using users.json in the webApp.data folder
	public static boolean validateUser(String username, String password)
		throws IOException, FileNotFoundException {
		JSONObject jo = null;
		try {
			jo = (JSONObject) (new JSONParser().parse(new FileReader("src/main/webapp/data/users.json")));
		} catch(ParseException e) {
			throw new RuntimeException("failed to parse users.json");
		}
        JSONArray ja = (JSONArray) jo.get("users");
        Iterator<Object> itr = ja.iterator();
        JSONObject user = null;
        while (itr.hasNext()) {
            user = (JSONObject) itr.next();
            if (user.get("username").equals(username)) {
            	return user.get("password").equals(password);
            }
        }
        
        return false;
    }
}
