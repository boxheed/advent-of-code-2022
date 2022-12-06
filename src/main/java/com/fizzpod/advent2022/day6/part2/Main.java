package com.fizzpod.advent2022.day6.part2;

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
            for (int j = 0; j < 14; j++) {
                set.add(buffer[i + j]);
            }
            if (set.size() == 14) {
                System.out.println(i + 14);
                break;
            }
        }
    }

}
