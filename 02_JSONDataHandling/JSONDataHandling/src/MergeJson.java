import java.util.Iterator;

import org.json.JSONObject;

public class MergeJson {
	public static void main(String[] args) {
		JSONObject obj1 = new JSONObject();
		obj1.put("Name", "Priya");
		obj1.put("Age", 27);
		JSONObject obj2 = new JSONObject();
		obj2.put("Salary", 60000);
		obj2.put("Department", "Sales");
		Iterator<String> i = obj2.keys();
		while(i.hasNext()) {
			String key = i.next();
			obj1.put(key, obj2.get(key));
		}
		System.out.println("Merged json : " + obj1.toString());
		
			
	}

}
