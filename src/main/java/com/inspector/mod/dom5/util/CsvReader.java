package com.inspector.mod.dom5.util;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CsvReader {

    private static final String TAB = "\t";

    public List<String[]> processInputFile(String inputFilePath) {
        List<String[]> elements = null;
        try {
            InputStream inputFS = Thread.currentThread().getContextClassLoader().getResourceAsStream(inputFilePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
            elements = br.lines().map(line -> line.split(TAB)).collect(Collectors.toList());
            br.close();
        } catch (IOException e) {
            System.out.println("unable to read file " + inputFilePath);
        }
        return elements;
    }

    public static Map<String, String> getKeyValuePairs(String[] headers, String[] element) {
        Map<String, String> attributes = new HashMap<>();
        for (int i = 0; i < element.length; i++) {
            if (element[i] != null && element[i].length() > 0) {
                attributes.put(headers[i], element[i]);
            }
        }
        return attributes;
    }
}
