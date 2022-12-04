package com.fizzpod.advent2022.day3.part2;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
        int score = 0;
        Map<String, Integer> priorities = new LinkedHashMap<>();
        for (int i = 0; i < 26; i++) {
            char val = (char) (i + (int) 'a');
            priorities.put(String.valueOf(val), i + 1);
        }
        for (int i = 0; i < 26; i++) {
            char val = (char) (i + (int) 'A');
            priorities.put(String.valueOf(val), i + 27);
        }

        while (lines.size() > 0) {
            Set<String> sack1 = new HashSet<>();
            sack1.addAll(Arrays.asList(lines.remove(0).split("")));
            Set<String> sack2 = new HashSet<>();
            sack2.addAll(Arrays.asList(lines.remove(0).split("")));
            Set<String> sack3 = new HashSet<>();
            sack3.addAll(Arrays.asList(lines.remove(0).split("")));

            sack1.retainAll(sack2);
            sack1.retainAll(sack3);
            for (String letter : sack1) {
                score += (int) priorities.get(letter);
            }
        }
        System.out.println(score);
    }

}
