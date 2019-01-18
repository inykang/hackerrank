package pe.inykang.stream;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class WordCountEx {
    @Test
    public void countWords() throws IOException {
        Path path = Paths.get("src/main/resources/book.txt");
        Map<String, Integer> wordCount = Files.lines(path)
                .flatMap(line -> Arrays.stream(line.trim().split(" ")))
                .map(word ->
                        word.replaceAll("[^a-zA-Z]", "")
                                .toLowerCase()
                                .trim()
                )
                .filter(word -> word.length() > 0)
                .map(word -> new AbstractMap.SimpleEntry<>(word, 1))
                .sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
                .reduce(new LinkedHashMap<>(), (acc, entry) -> {
                            acc.put(
                                    entry.getKey(),
                                    acc.compute(entry.getKey(), (k, v) -> v == null ? 1 : v + 1)
                            );
                            return acc;
                        },
                        (m1, m2) -> m1
                );

        wordCount.forEach((k, v) -> System.out.println(String.format("%s ==>> %d", k, v)));
    }

    @Test
    public void countWordsBetter() throws IOException {
        Path path = Paths.get("src/main/resources/book.txt");
        Map<String, Integer> wordCount = Files.lines(path)
                .flatMap(line -> Arrays.stream(line.trim().split("s")))
                .map(word ->
                        word.replaceAll("[^a-zA-Z]", "")
                                .toLowerCase()
                                .trim()
                )
                .filter(word -> word.length() > 0)
                .map(word -> new AbstractMap.SimpleEntry<>(word, 1))
                .collect(
                        toMap(e -> e.getKey(), e -> e.getValue(), (v1, v2) -> v1 + v2)
                );

        wordCount.forEach((k, v) -> System.out.println(String.format("%s ==>> %d", k, v)));
    }

    @Test
    public void countWordsBest() throws IOException {
        Path path = Paths.get("src/main/resources/book.txt");
        Map<String, Long> wordCount = Files.lines(path)
                .flatMap(line -> Arrays.stream(line.trim().split("\\s")))
                .map(word ->
                        word.replaceAll("[^a-zA-Z]", "")
                                .toLowerCase()
                                .trim()
                )
                .filter(word -> word.length() > 0)
                .map(word -> new AbstractMap.SimpleEntry<>(word, 1))
                .collect(Collectors.groupingBy(
                        AbstractMap.SimpleEntry::getKey, Collectors.counting())
                );

        wordCount.forEach((k, v) -> System.out.println(String.format("%s ==>> %d", k, v)));

    }

}