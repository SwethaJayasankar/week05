import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;
import org.json.XML;

public class JsonToXml {
	public static void main(String[] args) {
		try {
			
			String content = new String(Files.readAllBytes(Paths.get("students.json")));
			JSONObject obj = new JSONObject(content);
			String xmlstring = XML.toString(obj);
			System.out.println("XML FORMAT : " );
			System.out.println(xmlstring);
		}
		catch(Exception e ) {
			System.out.println(e.getMessage());
		}
	}

}
