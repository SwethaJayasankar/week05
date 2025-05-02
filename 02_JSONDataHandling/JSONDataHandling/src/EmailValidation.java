import java.io.File;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

public class EmailValidation{
	public static void main(String[] args) {
		try {
			 ObjectMapper mapper = new ObjectMapper();
	         JsonNode schemaNode = mapper.readTree(new File("mailschema.json"));
	            JsonNode dataNode = mapper.readTree(new File("mail.json"));

	            JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
	            JsonSchema schema = factory.getJsonSchema(schemaNode);
	            ProcessingReport report = schema.validate(dataNode);

	            if (report.isSuccess()) {
	                System.out.println("mail is valid!");
	            } else {
	                System.out.println("mail is invalid:");
	                System.out.println(report);
	            }
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}