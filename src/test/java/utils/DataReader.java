package utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
    public static Map<String, List<HashMap<String, String>>> readJson(String filePath) throws IOException {
        File file = new File(filePath);
        String jsonContent = FileUtils.readFileToString(file, StandardCharsets.UTF_8);

        ObjectMapper mapper = new ObjectMapper();
        Map<String, List<HashMap<String, String>>> data = mapper.readValue(jsonContent, new TypeReference<Map<String, List<HashMap<String, String>>>>() {});

        return data;
    }
}
