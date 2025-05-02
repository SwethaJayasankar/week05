import org.json.JSONObject;

class Car{
	private String name;
	private String color ;
	public Car(String name, String color) {
		this.name = name;
		this.color = color ;
	}
	public String getName() {
		return this.name;
	}
	public String getColor() {
		return this.color;
	}
}
public class CarToJson {
	public static void main(String[] args) {
		Car car = new Car("Waganor", "red");

		JSONObject obj = new JSONObject();
		obj.put("name", car.getName());
		obj.put("color", car.getColor());

		System.out.println(obj.toString());
		
	}

}
