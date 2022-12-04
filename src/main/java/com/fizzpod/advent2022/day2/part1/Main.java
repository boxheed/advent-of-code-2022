package com.fizzpod.advent2022.day2.part1;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class Main {
    private static final String ELF_ROCK = "A";
    private static final String ELF_PAPER = "B";
    private static final String ELF_SCISSOR = "C";

    private static final String MY_ROCK = "X";
    private static final String MY_PAPER = "Y";
    private static final String MY_SCISSOR = "Z";

    public static void main(String[] args) throws IOException {
        try (InputStream stream = Main.class.getResourceAsStream("data.txt")) {
            List<String> lines = IOUtils.readLines(stream, Charset.forName("UTF-8"));

            process(lines);
        }

    }

    private static void process(List<String> lines) {
        int score = 0;
        for (String line : lines) {
            String[] moves = line.split(" ");

            switch (moves[1]) {
            case MY_ROCK:
                score += 1;
                score += ELF_SCISSOR.equals(moves[0]) ? 6 : ELF_ROCK.equals(moves[0]) ? 3 : 0;
                break;
            case MY_PAPER:
                score += 2;
                score += ELF_ROCK.equals(moves[0]) ? 6 : ELF_PAPER.equals(moves[0]) ? 3 : 0;
                break;
            case MY_SCISSOR:
                score += 3;
                score += ELF_PAPER.equals(moves[0]) ? 6 : ELF_SCISSOR.equals(moves[0]) ? 3 : 0;
                break;
            }
        }
        System.out.println(score);
    }

}
