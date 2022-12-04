package com.fizzpod.advent2022.day3.part1;

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

        for (String line : lines) {
            int mid = line.length() / 2;
            String[] pockets = { line.substring(0, mid), line.substring(mid) };
            Set<String> pocket1 = new HashSet<>();
            pocket1.addAll(Arrays.asList(pockets[0].split("")));
            Set<String> pocket2 = new HashSet<>();
            pocket2.addAll(Arrays.asList(pockets[1].split("")));

            pocket1.retainAll(pocket2);

            Set<Character> letters = new HashSet<>();

            for (String letter : pocket1) {
                score += (int) priorities.get(letter);
            }
        }
        System.out.println(score);
    }

}
