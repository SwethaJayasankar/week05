import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.Iterator;
import java.util.Map;
public class PrintKeysAndValues {
	public static void main(String args[]) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(new  File("students.json"));
			Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                System.out.println("key : " + field.getKey() + " -- Value :  " + field.getValue());
            }
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
