package com.assignment;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Path("/")
public class GetController {
	@SuppressWarnings("unchecked")
	@GET
	@Path("/getdata")
	@Produces(MediaType.APPLICATION_JSON)
	public List getTrackInJSON() {
		//JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        JSONArray dataList = null;
        List listdata = new ArrayList();
        ClassLoader classLoader = getClass().getClassLoader();
        System.out.println(classLoader.getResource("data.json"));
        try (FileReader reader = new FileReader(classLoader.getResource("data.json").getFile()))
        {
            //Read JSON file
             Object obj = jsonParser.parse(reader);
             dataList = (JSONArray) obj;
             dataList.forEach(item -> {
            	 listdata.add(item);
             });
             
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		
        return listdata;
	}
	
}
