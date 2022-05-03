package com.UtilityFiles;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class TestDataReader {

    //convert json file to json string

    public List<HashMap<String,String>> readJsonFile() {
        List<HashMap<String, String>> reservationData = null;
        try {
            String jsoncontent = FileUtils.readFileToString(new File("src/main/java/com/TestDataFiles/Reservationdetails.json"), StandardCharsets.UTF_8);
            ObjectMapper mapper = new ObjectMapper();
            reservationData = mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String, String>>>() {
            });
        } catch (Exception e) {
            System.out.println("Message :" + e.getMessage());
        }
        return reservationData;
    }
}
