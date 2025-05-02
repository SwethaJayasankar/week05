import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListWithoutGenerics {
	public static void main(String[] args) {
		@SuppressWarnings("unchecked")
		ArrayList list = new ArrayList(Arrays.asList(2,34,5,67,8,90));
		System.out.println(list);
		
		
	}

}
