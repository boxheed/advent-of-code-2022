package com.fizzpod.advent2022.day6.part1;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.IOUtils;

public class Main {

    public static void main(String[] args) throws IOException {
        try (InputStream stream = Main.class.getResourceAsStream("data.txt")) {
            List<String> lines = IOUtils.readLines(stream, Charset.forName("UTF-8"));

            process(lines);
        }

    }

    private static void process(List<String> lines) {
        String[] buffer = lines.get(0).split("");

        for (int i = 0; i < buffer.length; i++) {
            Set<String> set = new HashSet<>();
            set.add(buffer[i]);
            set.add(buffer[i + 1]);
            set.add(buffer[i + 2]);
            set.add(buffer[i + 3]);
            if (set.size() == 4) {
                System.out.println(i + 4);
                break;
            }
        }
    }

}
