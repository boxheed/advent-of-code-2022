package com.fizzpod.advent2022.day2.part2;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class Main {
    private static final String ROCK = "A";
    private static final String PAPER = "B";
    private static final String SCISSOR = "C";

    private static final String LOOSE = "X";
    private static final String DRAW = "Y";
    private static final String WIN = "Z";

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
            case LOOSE:
                moves[1] = SCISSOR.equals(moves[0]) ? PAPER : ROCK.equals(moves[0]) ? SCISSOR : ROCK;
                break;
            case DRAW:
                moves[1] = moves[0];
                break;
            case WIN:
                moves[1] = SCISSOR.equals(moves[0]) ? ROCK : ROCK.equals(moves[0]) ? PAPER : SCISSOR;
                break;
            }

            switch (moves[1]) {
            case ROCK:
                score += 1;
                score += SCISSOR.equals(moves[0]) ? 6 : ROCK.equals(moves[0]) ? 3 : 0;
                break;
            case PAPER:
                score += 2;
                score += ROCK.equals(moves[0]) ? 6 : PAPER.equals(moves[0]) ? 3 : 0;
                break;
            case SCISSOR:
                score += 3;
                score += PAPER.equals(moves[0]) ? 6 : SCISSOR.equals(moves[0]) ? 3 : 0;
                break;
            }
        }
        System.out.println(score);
    }

}
