import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.Iterator;
import java.util.Map.Entry;

import org.json.JSONObject;

public class MergeTwoJsonFilesToObj {
	public static void main(String[] args) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			JSONObject obj = new JSONObject();
			JsonNode node1 = mapper.readTree(new File("students.json"));
			JsonNode node2 = mapper.readTree(new File("students1.json"));
			Iterator<Entry<String, JsonNode>> s1 = node1.fields();
			while(s1.hasNext()) {
				Entry<String,JsonNode> s = s1.next();
				obj.put(s.getKey(), mapper.treeToValue(s.getValue(), Object.class));
			}
			Iterator<Entry<String, JsonNode>> s2 = node2.fields();
			while(s2.hasNext()) {
				Entry<String,JsonNode> s = s2.next();
				obj.put(s.getKey(),mapper.treeToValue(s.getValue(), Object.class));
			}
			System.out.println(obj.toString());
		}
		
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
