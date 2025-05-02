import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;

public class ExtractNameMail {
	public static void main(String[] args) {
		try {
			String content = new String(Files.readAllBytes(Paths.get("employee.json")));
			JSONObject obj = new JSONObject(content);
			System.out.println("Name : "+ obj.getString("name")+"\nEmail : "+ obj.getString("email"));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
