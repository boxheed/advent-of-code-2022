package com.fizzpod.advent2022.day4.part2;

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
        int count = 0;

        for (String line : lines) {
            String[] pairs = line.split(",");

            String[] range1 = pairs[0].split("-");
            Set<Integer> assignments1 = new HashSet<>();
            for (int i = Integer.valueOf(range1[0]); i <= Integer.valueOf(range1[1]); i++) {
                assignments1.add(i);
            }

            String[] range2 = pairs[1].split("-");
            Set<Integer> assignments2 = new HashSet<>();
            for (int i = Integer.valueOf(range2[0]); i <= Integer.valueOf(range2[1]); i++) {
                assignments2.add(i);
            }
            Set<Integer> merged = new HashSet<>();
            merged.addAll(assignments1);
            merged.addAll(assignments2);

            if (merged.size() != assignments1.size() + assignments2.size()) {
                count++;
            }
        }
        System.out.println(count);
    }

}
