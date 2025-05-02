import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class DuplicateRecords {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("employee.csv"));
		    HashMap<Integer,String> map = new HashMap<>();
		    String line;
		   br.readLine();
		    while((line=br.readLine())!=null) {
		    	if(map.containsKey(Integer.valueOf(line.split(",")[0]))) {
		    		System.out.println(line);
		    	}else {
		    		map.put(Integer.valueOf(line.split(",")[0]), line);
		    	}
		    }
		    br.close();
			
		    
		}
		catch(IOException e) {
			System.out.println("File Not Found error !");
		}
	}

}
