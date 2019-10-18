package com.inspector.mod.dom5.gamedata;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TextReader {

    public Map<String, String> loadDescriptions(String relativePath) {
        Map<String, String> elementDescriptions = new HashMap<>();
        try (
                Stream<Path> paths = Files.walk(Paths.get(relativePath))) {
            paths
                    .filter(Files::isRegularFile)
                    .forEach(path -> {
                        elementDescriptions.put(path.getFileName().toString().replace(".txt", ""), readContents(path));
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return elementDescriptions;
    }

    private String readContents(Path path) {
        try {
            return Files.lines(path).collect(Collectors.joining());
        } catch (IOException e) {
            System.out.println("unable to read file " + path);
        }
        return "";
    }

}
