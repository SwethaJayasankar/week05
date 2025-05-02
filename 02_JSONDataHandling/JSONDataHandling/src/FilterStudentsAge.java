import com.fasterxml.jackson.databind.JsonNode;
import java.io.*;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FilterStudentsAge {
	public static void main(String[] args)  {
		try {
			ObjectMapper obj = new ObjectMapper();
			JsonNode  node = obj.readTree(new File("studentsage.json"));
			if(node.isArray()) {
				for(JsonNode i : node) {
					if(i.get("age").asInt()>25) {
						System.out.println(i.toPrettyString());
						
					}
				}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
