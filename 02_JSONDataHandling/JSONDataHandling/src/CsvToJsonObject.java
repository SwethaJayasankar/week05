import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CsvToJsonObject {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("cart.csv"));
			ArrayList<Map<String,String>> list = new ArrayList<>();
			String line;
			String[] headerline= br.readLine().split("\\s+");
			while((line = br.readLine())!=null) {
				String[] values = line.split("\\s+");
				Map<String,String> map = new LinkedHashMap<>();
				for (int i = 0; i < headerline.length; i++) {
                    map.put(headerline[i].trim(), values[i].trim());
                }

                list.add(map);
			}
			ObjectMapper mapper = new ObjectMapper();
            String jsonOutput = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
            System.out.println(jsonOutput);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
