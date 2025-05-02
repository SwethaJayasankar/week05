import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

class Product{
	public String productname;
	public int price;
	public Product(String productname,int price) {
		this.productname= productname;this.price=price;
	}
}

public class ObjListToArray {
	public static void main(String[] args) {
		try {
			List<Product> list = new ArrayList<>(Arrays.asList(
					new Product("Milk",10),
					new Product("Pen",5),
					new Product("Orange",60),
					new Product("Bourborn",40)
					));
			ObjectMapper mapper = new ObjectMapper();
			String jsonarray = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
			System.out.println(jsonarray);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
