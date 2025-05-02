import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.File;
import java.io.IOException;

public class ValidateJackson {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode schemaNode = mapper.readTree(new File("studentschema.json"));
            JsonNode dataNode = mapper.readTree(new File("students.json"));

            JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
            JsonSchema schema = factory.getJsonSchema(schemaNode);
            ProcessingReport report = schema.validate(dataNode);

            if (report.isSuccess()) {
                System.out.println("JSON is valid!");
            } else {
                System.out.println("JSON is invalid:");
                System.out.println(report);
            }
        } catch (IOException | ProcessingException e) {
            System.out.println("⚠️ Error reading or validating JSON: " + e.getMessage());
        }
    }
}
