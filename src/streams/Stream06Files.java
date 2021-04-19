package streams;

import java.io.IOException;
import java.nio.file.*;
//import java.nio.file.Path;
import java.util.stream.Stream;

public class Stream06Files {

    public static void main(String[] args) throws IOException {

        Stream<String> satirlar = Files.lines(Path.of("src/streams/mars.txt")); // Path.of()
        satirlar.forEach(System.out::println);

    }
}
