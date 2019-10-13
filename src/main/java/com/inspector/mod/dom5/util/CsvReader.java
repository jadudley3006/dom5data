package com.inspector.mod.dom5.util;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
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
}
