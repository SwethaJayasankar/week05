package advancedproblems;

import java.lang.reflect.Field;

class Product{
	String itemName;
	int price;
	public Product(String name,int price) {
		this.itemName = name;
		this.price = price;
	}
	
}
public class ConvertToJson {
	public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder();
        json.append("{");

        Field[] fields = obj.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true); 
            try {
                String name = field.getName();
                Object value = field.get(obj);

                json.append("\"").append(name).append("\": ");

                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }
                if (i < fields.length - 1) {
                    json.append(", ");
                }
            } catch (IllegalAccessException e) {
                json.append("\"").append(field.getName()).append("\": \"ERROR\"");
            }
        }

        json.append("}");
        return json.toString();
	}
	public static void main(String[] args) {
		try {
			Product p = new Product("Milk",10);
			String json = toJson(p);
	        System.out.println(json);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

