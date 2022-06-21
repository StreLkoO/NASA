import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonToObjectParser {
    private static JsonToObjectParser instance;
    private final ObjectMapper mapper;

    private JsonToObjectParser() {
        mapper = new ObjectMapper();
    }

    public static JsonToObjectParser get() {
        if (instance == null) {
            instance = new JsonToObjectParser();
        }
        return instance;
    }

    public NasaResponse convert(String json) {
        NasaResponse nasaResponse = null;
        try {
            nasaResponse = mapper.readValue(json, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return nasaResponse;
    }

}
