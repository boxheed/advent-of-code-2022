package com.fizzpod.advent2022.day1.part2;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class Main {

    public static void main(String[] args) throws IOException {
        try (InputStream stream = Main.class.getResourceAsStream("data.txt")) {
            List<String> lines = IOUtils.readLines(stream, Charset.forName("UTF-8"));

            process(lines);
        }

    }

    private static void process(List<String> lines) {
        List<Integer> calories = new ArrayList<>();
        int currentCalories = 0;
        for (String line : lines) {
            if ("".equals(line)) {
                calories.add(currentCalories);
                currentCalories = 0;
            } else {
                currentCalories = currentCalories + Integer.valueOf(line);
            }
        }
        Collections.sort(calories, Collections.reverseOrder());

        System.out.println(calories.get(0) + calories.get(1) + calories.get(2));
    }

}
